const jwt = require("jsonwebtoken");

const Auth = async (req, res, next) => {
    try {
        const header = req.headers.authorization;

        // Token missing
        if (!header) {
            return res.status(401).json({ message: "Token missing" });
        }

        // Extract token from header (e.g. "Bearer <token>" or "<token>")
        const token = header.startsWith("Bearer ") ? header.split(" ")[1] : header;

        if (!token) {
            return res.status(401).json({ message: "Token missing" });
        }

        // Verify token
        const decoded = jwt.verify(token, process.env.JWT_KEY);
        req.user = decoded;

        next();
    } catch (error) {
        return res.status(401).json({ message: "Invalid or expired token" });
    }
};

module.exports = { Auth };
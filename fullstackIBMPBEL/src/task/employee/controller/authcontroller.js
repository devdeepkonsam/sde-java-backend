const User = require("../models/user.model");
const bcrypt = require("bcrypt");
const jwt = require("jsonwebtoken");

// Register a new user
const register = async (req, res) => {
    try {
        const { username, email, password } = req.body;

        if (!username || !email || !password) {
            return res.status(400).json({ message: "Username, email, and password are required" });
        }

        // Check if user already exists with email or username
        const existingUser = await User.findOne({ 
            $or: [{ email }, { username }] 
        });

        if (existingUser) {
            return res.status(400).json({ message: "User with this email or username already exists" });
        }

        // Hash password
        const hashedPassword = await bcrypt.hash(password, 10);

        // Create new user
        const newUser = new User({
            username,
            email,
            password: hashedPassword
        });

        await newUser.save();
        return res.status(201).json({ 
            message: "User registered successfully",
            user: {
                id: newUser._id,
                username: newUser.username,
                email: newUser.email
            }
        });
    } catch (error) {
        return res.status(500).json({ message: "Internal server error: " + error.message });
    }
};

// Login user and return JWT
const login = async (req, res) => {
    try {
        const { email, password } = req.body;

        if (!email || !password) {
            return res.status(400).json({ message: "Email and password are required" });
        }

        // Check if user exists
        const user = await User.findOne({ email });
        if (!user) {
            return res.status(400).json({ message: "User does not exist" });
        }

        // Verify password
        const isMatch = await bcrypt.compare(password, user.password);
        if (!isMatch) {
            return res.status(400).json({ message: "Invalid credentials" });
        }

        // Generate JWT Token
        const token = jwt.sign(
            { id: user._id, email: user.email, username: user.username },
            process.env.JWT_KEY || "employee_jwt_secret_key_2026",
            { expiresIn: "24h" }
        );

        return res.status(200).json({
            message: "Login successful",
            token,
            user: {
                id: user._id,
                username: user.username,
                email: user.email
            }
        });
    } catch (error) {
        return res.status(500).json({ message: "Internal server error: " + error.message });
    }
};

// Get current user profile
const getProfile = async (req, res) => {
    try {
        const user = await User.findById(req.user.id).select("-password");
        if (!user) {
            return res.status(404).json({ message: "User not found" });
        }
        return res.status(200).json({ message: "Profile fetched successfully", user });
    } catch (error) {
        return res.status(500).json({ message: "Internal server error: " + error.message });
    }
};

// Authentication Middleware to verify token
const Auth = async (req, res, next) => {
    try {
        const header = req.headers.authorization;

        // Token missing
        if (!header) {
            return res.status(401).json({ message: "Access denied. Token missing." });
        }

        // Extract token from header (e.g. "Bearer <token>" or "<token>")
        const token = header.startsWith("Bearer ") ? header.split(" ")[1] : header;

        if (!token) {
            return res.status(401).json({ message: "Access denied. Token missing." });
        }

        // Verify token
        const decoded = jwt.verify(token, process.env.JWT_KEY || "employee_jwt_secret_key_2026");
        req.user = decoded;

        next();
    } catch (error) {
        return res.status(401).json({ message: "Invalid or expired token" });
    }
};

module.exports = { register, login, getProfile, Auth };
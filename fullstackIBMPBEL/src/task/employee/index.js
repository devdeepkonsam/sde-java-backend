require("dotenv").config();
const express = require("express");
const mongoose = require("mongoose");
const cors = require("cors");

const authRoutes = require("./routes/auth.routes");
const employeeRoutes = require("./routes/employee.routes");

const app = express();
const PORT = process.env.PORT || 3000;

// Middleware
app.use(cors());
app.use(express.json());

// Request logger middleware
function logger(req, res, next) {
    console.log(`[${new Date().toISOString()}] ${req.method} ${req.originalUrl}`);
    next();
}
app.use(logger);

// Database connection
mongoose.connect(process.env.MONGODB)
.then(() => { 
    console.log("Connected to MongoDB");
}).catch((err) => { 
    console.error("Error connecting to MongoDB:", err); 
});

// Routes
app.use("/auth", authRoutes);
app.use("/api/auth", authRoutes);
app.use("/employees", employeeRoutes);
app.use("/api/employees", employeeRoutes);

// Health check / root route
app.get("/", (req, res) => {
    res.json({ message: "Employee Management API is running" });
});

// 404 Route handler
app.use((req, res) => {
    res.status(404).json({ message: "Route not found" });
});

// Global error handler
app.use((err, req, res, next) => {
    console.error("Unhandled error:", err);
    res.status(500).json({ message: "Internal server error", error: err.message });
});

app.listen(PORT, () => {
    console.log(`Server is running on port ${PORT}`);
});
const express = require("express");
const { register, login, getProfile, Auth } = require("../controller/authcontroller");

const router = express.Router();

// Register new user
router.post("/register", register);

// Login user
router.post("/login", login);

// Get current authenticated user profile
router.get("/profile", Auth, getProfile);

module.exports = router;

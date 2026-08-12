const express = require("express");
const { register, login} = require("../controller/user.controller");
//const { register, login, getProfile } = require("../controller/user.controller");
//const { Auth } = require("../middleware/auth.middleware");

const router = express.Router();

router.post("/register", register);
router.post("/login", login);
//router.get("/profile", Auth, getProfile);

module.exports = router;
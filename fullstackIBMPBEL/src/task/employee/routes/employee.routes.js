const express = require("express");
const {
    getEmployee,
    getEmployeeById,
    addEmployee,
    updateEmployee,
    deleteEmployee
} = require("../controller/employee.controller");
const { Auth } = require("../controller/authcontroller");

const router = express.Router();

// Get all employees
router.get("/", getEmployee);

// Get single employee by employeeID
router.get("/:employeeID", getEmployeeById);

// Add new employee (Protected - requires valid JWT token)
router.post("/", Auth, addEmployee);

// Update employee (Protected - requires valid JWT token)
router.put("/:employeeID", Auth, updateEmployee);

// Delete employee (Protected - requires valid JWT token)
router.delete("/:employeeID", Auth, deleteEmployee);

module.exports = router;
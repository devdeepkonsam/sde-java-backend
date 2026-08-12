const employee = require("../models/employee.model");

// Get all employees details (with user info populated)
const getEmployee = async (req, res) => {
    try {
        const employees = await employee.find().populate("user", "username email");
        res.status(200).json(employees);
    } catch (error) {
        res.status(500).json({ message: error.message });
    }
};

// Get single employee by employeeID
const getEmployeeById = async (req, res) => {
    try {
        const empId = Number(req.params.employeeID);
        const singleEmployee = await employee.findOne({ employeeID: empId }).populate("user", "username email");
        if (!singleEmployee) {
            return res.status(404).json({ message: "Employee not found" });
        }
        res.status(200).json(singleEmployee);
    } catch (error) {
        res.status(500).json({ message: error.message });
    }
};

// Add new employee details
const addEmployee = async (req, res) => {
    try {
        const { employeeID, name, age, designation, salary, experience, joiningDate } = req.body;

        // Check if employeeID already exists
        const existing = await employee.findOne({ employeeID: Number(employeeID) });
        if (existing) {
            return res.status(400).json({ message: `Employee with ID ${employeeID} already exists` });
        }

        // Determine user ID from authenticated token or req.body
        const userId = req.user ? req.user.id : req.body.user;
        if (!userId) {
            return res.status(400).json({ message: "User reference is required" });
        }

        const newEmployee = new employee({
            employeeID,
            name,
            age,
            designation,
            salary,
            experience,
            joiningDate,
            user: userId
        });

        const saved = await newEmployee.save();
        const populated = await employee.findById(saved._id).populate("user", "username email");
        res.status(201).json(populated);
    } catch (err) {
        res.status(500).json({ message: err.message });
    }
};

// Updating an employee detail
const updateEmployee = async (req, res) => {
    try {
        const empId = Number(req.params.employeeID);
        const updated = await employee.findOneAndUpdate(
            { employeeID: empId },
            req.body,
            { new: true }
        ).populate("user", "username email");

        if (!updated) {
            return res.status(404).json({ message: "Employee not found" });
        }
        res.status(200).json(updated);
    } catch (error) {
        res.status(500).json({ message: error.message });
    }
};

// Deleting an employee
const deleteEmployee = async (req, res) => {
    try {
        const empId = Number(req.params.employeeID);
        const deleted = await employee.findOneAndDelete({ employeeID: empId });
        if (!deleted) {
            return res.status(404).json({ message: "Employee not found" });
        }
        res.status(200).json({ message: "Employee deleted successfully", employee: deleted });
    } catch (error) {
        res.status(500).json({ message: error.message });
    }
};

module.exports = {
    getEmployee,
    getEmployeeById,
    addEmployee,
    updateEmployee,
    deleteEmployee
};
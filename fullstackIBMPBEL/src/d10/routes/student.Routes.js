const express = require("express");
const { getStudent, addStudent, updateStudent, deleteStudent } = require("../controller/student.Controller");


const router = express.Router();

// GET all students
router.get("/", getStudent);

// POST new student
router.post("/", addStudent);

// PUT - update student
router.put("/:id", updateStudent);


// DELETE student
router.delete("/:id", deleteStudent );

module.exports = router;
const express = require("express");

const router = express.Router();

const Students = require("../model/student.model")

router.get("/", async(req,res)=>{
    try {
        const student = await Students.find();
        res.status(200).json(student)
    } catch (error) {
        res.status(400).json({message: error.message})
    }
})


module.exports = router;
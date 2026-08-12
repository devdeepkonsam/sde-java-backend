const mongoose = require("mongoose");

const employeeSchema = new mongoose.Schema({
    employeeID: {
        type : Number,
        required: true,
        unique: true
    },
    name: {
        type: String,
        required: true
    },
    age : {
        type: Number,
        required: true
    },
    designation: {
        type: String,
        required: true
    },
    salary: {
        type: Number,
        required: true
    },
    experience: {
        type: Number,
        required: true
    },
    joiningDate: {
        type : Date,
        required: true
    },
    user: {
        type: mongoose.Schema.Types.ObjectId,
        ref: "User",
        required: true
    }
}, { timestamps: true });

module.exports = mongoose.model("Employee", employeeSchema);
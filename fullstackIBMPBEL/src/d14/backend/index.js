const express = require("express");
const mongoose = require("mongoose");
const studentRoutes = require("./routes/student.routes");
const cors = require("cors");

const app = express();

app.use(cors());
app.use(express.json());


mongoose.connect("mongodb+srv://devdeepkonsam:aogwf9TEFoJlGgLB@cluster.wujoryb.mongodb.net/")
    .then(() => {
        console.log("Database Connected")
    }).catch((error) => {
        console.log(error)
    })

app.use("/api/students", studentRoutes)

app.listen(5000, () => {
    console.log("Server running on port 5000")
})
const express = require("express");
const mongoose = require("mongoose")
const app = express();
const studentRoutes = require("./routes/student.routes");

app.use(express.json());

mongoose.connect("mongodb+srv://devdeepkonsam:aogwf9TEFoJlGgLB@cluster.wujoryb.mongodb.net/adtu").then(() =>{
    console.log("Connected to MongoDB");
}).catch((err) => {
    console.error("Error connecting to MongoDB:", err);
});


function logger(req, res, next) {
    console.log("Request method: ", req.method);
    console.log("Request URL: ", req.url);
    next();
}

app.use(logger);


app.use("/student", studentRoutes);

app.listen(2800, () => {
    console.log("server on port 2800");
})
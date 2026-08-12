//what is jwt-auth? ->Json web token
//Authentication
//AUTHORIZATION


const express = require("express");
const mongoose = require("mongoose");
require("dotenv").config();
const router = require("./routes/user.route");


const app = express();

//default middleware
app.use(express.json());
// function logger(req, res, next) {
//     console.log(`${req.method} ${req.url}`);
// }

//BUILDING CONNECTION WITH DB
mongoose.connect(process.env.MONGODB)
.then(() =>{ 
    console.log("Connected to MongoDB");
}).catch((err) => { 
    console.error("Error connecting to MongoDB:", err); 
});


app.use("/api/auth", router);
// app.use(logger);


//CREATING THE PORT WITH THE SERVER
app.listen(process.env.PORT, () => {
    console.log(`Server is running on port ${process.env.PORT}`);
})

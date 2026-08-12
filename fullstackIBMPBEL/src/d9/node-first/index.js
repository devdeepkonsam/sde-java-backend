// console.log("hello,world........")

const exprees = require("express");

const app = exprees();

//Rest API
// GET - retrieve data
// POST - create data
// PUT - update data
// DELETE - delete data

app.get("/", (req, res) => {
    res.send("Hello Up Guys");
})
app.get("/home", (req, res) => {
    res.send("HOME");
})
app.get("/about", (req, res) => {
    res.send("ABOUT");
})
app.get("/contact", (req, res) => {
    res.send("CONTACT");
})

app.listen(3000, () => {
    console.log("Server is running on port 3000");
})
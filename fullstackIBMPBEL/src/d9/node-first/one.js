const express = require("express");

const app = express();

app.use(express.json());

let student = [
    {id : 1, name : "dev" , course : "B.tech"},
    {id : 2, name : "rohan", course : "BBA"},
    {id : 3, name : "sachin", course : "MBA"},
];


app.get('/student' , (req,res) => {
    res.json(student);
})


app.post('/student' , (req,res) => {
    student.push(req.body);
    res.json({message : "Student added successfully"});
})



app.put('/student/:id' , (req,res) => {
    const id = Number(req.params.id);
    const index = student.findIndex(s => Number(s.id) === id);
    if (index !== -1) {
        student[index] = { ...student[index], ...req.body, id: student[index].id };
        res.json({ message: "Student updated successfully", student: student[index] });
    } else {
        res.status(404).json({ message: "Student not found" });
    }
})

app.patch('/student/:id' , (req,res) => {
    const id = Number(req.params.id);
    const index = student.findIndex(s => Number(s.id) === id);
    if (index !== -1) {
        student[index] = { ...student[index], ...req.body };
        res.json({ message: "Student updated successfully", student: student[index] });
    } else {
        res.status(404).json({ message: "Student not found" });
    }
})

app.delete('/student/:id' , (req,res) => {
    const id = Number(req.params.id);
    const index = student.findIndex(s => Number(s.id) === id);
    if (index !== -1) {
        student.splice(index, 1);
        res.json({ message: "Student deleted successfully" });
    } else {
        res.status(404).json({ message: "Student not found" });
    }
});


app.listen(2000,() =>{
    console.log(`Server is running on port 2000`)
})
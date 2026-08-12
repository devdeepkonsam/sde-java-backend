
const User = require("../model/user.model");
const bcrypt = require("bcrypt");
const jwt = require("jsonwebtoken");

//register
const register = async(req, res) => {
    try{
        const {name, email, password} = req.body;
        const existing_user = await User.findOne({email});
        if(existing_user) {
            return res.status(400).json({message: "User already exists"});
        }
        //encrypt password
        const encrypt_pass = await bcrypt.hash(password, 10);

        const new_user = new User({name, email, password: encrypt_pass});
        await new_user.save();
        return res.status(201).json({message: "User registered successfully"});
    } catch(error) {
        return res.status(500).json({message: "Internal server error"});
    }
}

const login = async(req, res) => {
    try{
        const {email,password} = req.body;
        const existing_user = await User.findOne({email});
        if(!existing_user){
            return res.status(400).json({message: "User does not exist"});
        } 
        const is_Match = await bcrypt.compare(password, existing_user.password);
        if(!is_Match){
            return res.status(400).json({message: "Invalid credentials"});
        } 
        //token
        const token = jwt.sign({id: existing_user.id},process.env.JWT_KEY, {expiresIn: "1h"});
        return res.status(200).json({message: "Login successful", token});


    } catch (error) {
        return res.status(500).json({message: "Internal server error"});
    }
}

module.exports = {register, login};


// const getProfile = async (req, res) => {
//     try {
//         const user = await User.findById(req.user.id).select("-password");
//         if (!user) {
//             return res.status(404).json({ message: "User not found" });
//         }
//         return res.status(200).json({ message: "Profile fetched successfully", user });
//     } catch (error) {
//         return res.status(500).json({ message: "Internal server error" });
//     }
// };

// module.exports = { register, login, getProfile };


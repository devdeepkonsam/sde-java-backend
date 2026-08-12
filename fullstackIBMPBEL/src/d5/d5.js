
//what is object in js and how we can creat one;
// var person = {
//     name: "delta",
//     age: 20,
//     city: "guwahati",
//     }





// var aadhaar = {
//     name: "Konsam Devdeep",
//     age: 22,
//     city: "guwahati",
//     aadharNumber: 782700001111,
//     address: "guwahati, assam"
// }


// console.log(aadhaar.name);
// console.log(aadhaar["age"]);



//bracket notation why not dot notation 
//dot notation is used when we know the property name in advance
//bracket notation is used when we don't know the property name in advance










const menu = {
  burger: 150,
  pizza: 350,
  pasta: 250
};

console.log(menu.burger);
console.log(menu["pizza"]);

let item = "pasta";
console.log(menu[item]);

menu.burger = 180;
menu["pizza"] = 400;

let drink = "coke";
menu[drink] = 60; 

delete menu.fries;
delete menu["coke"];
console.log(menu);

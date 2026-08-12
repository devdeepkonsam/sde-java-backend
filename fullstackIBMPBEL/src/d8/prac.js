//string
const str = "1,1,0,0,1,1,0,1,1,1,0,0";
//string to arr using split
const arr = str.split(",");
//sorting method 
// arr.sort();
arr.sort((a,b) => b-a);

console.log(arr);
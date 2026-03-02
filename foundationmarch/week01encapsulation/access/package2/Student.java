package access.package2;

import access.package1.Teacher;

public class Student {
    void main(){
        Teacher obj = new Teacher();
        obj.name = "MARKUS";
        obj.subject = "Oops";
        //obj.age = 1; here i cannot access the private class from different package because it is private
        //obj.salary = 200000; here i cannot access the default class from different package because it is default: package private

        
        //obj.degree = "PHD CSE"; here i cannot access the protected class as it falls under different package non-subclass
        obj.setAge(31); // here i can access the private class using the public method : setter method
        IO.print(obj.getAge()); // here i can access the private class using the public method : getter method


    }
}

@SuppressWarnings("unused")

class Assistant extends Teacher{ //SUBCLASS OF DIFFERENT PACKAGE CLASS
    //here i can access the public variable from parent class 
    //here i can access the protected varialbe 
    //but cannot access the private and default variable
    void display(){
        System.out.println(this.name + this.getAge() + this.subject + this.degree);

    }
}

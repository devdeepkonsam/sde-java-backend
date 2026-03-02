package access.package1;

public class  Teacher {
    public String name;
    public String subject;
    private int age; //the private variable can only be accessed within the class and cannot be accessed outside the class
    int salary; //the default variable can be accessed within the package but cannot be accesses outside the package
    protected String degree;// the protected variable can be access in same package,different package - subclass

    public void setAge(int age) { //setter method to set the value of private variable
        this.age = age;
    }

    public int getAge(){ //getter method to get the value of private variable
        return this.age;
    }

}

@SuppressWarnings("unused")
class Assistant extends Teacher{ //SUBCLASS OF SAME PACKAGE
    // here i can access the public and default variable from parent class but cannot access the private variable
    void display(){
        System.out.println(this.name + this.subject + this.salary + this.degree);
    }
    
}



package access.package1;

public class Main {
    void main(){
        Teacher obj = new Teacher();
        obj.name = "DANIEL";
        obj.subject = "CN";
        //obj.age = 1; here i cannot access the private age variable from same package because it is private
        obj.setAge(31);
        obj.salary = 200000; //here i can access the default salary variable from same package as it is default: package private
        obj.degree = "PHD CSE";
    }
}

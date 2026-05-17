package foundationmarch.week04modernjava;

public class Test /*implements Learning */{
    void main() {
        Learning learning = new Learning() {
            @Override
            public void display(String name){
                System.out.println("Learning"+ name);
            }
        };
        learning.display("java");


        Learning learning1 = (name)->{
            System.out.println("Learning "+name);
        };
        learning1.display("java");
        // Test test = new Test();
        // test.display("java");

        numTwo num = (a,b)->{return a+b;};
        System.out.println(num.cal(10, 20));

    }

    //after implementing the interface we need to override the method of the interface
    /*public void display(String name){
        System.out.println("Learning "+name);
    }*/

}
@FunctionalInterface
interface numTwo{
    int cal(int a, int b);
}


package foundationmarch.week04modernjava;
import java.util.function.*;

//functional interface and lambda expression
public class Learning1 {

    public static void main(String[] args){
        lambdaExample();
        System.out.println("+=======================================+");
        typeOfFunctionalInterface();
    }

    //Functional Interface
    //having only 1 abstract and many static,defualt and object class method
    @FunctionalInterface
    interface Learning {
        void display(String name);

        default String displayAge(String fname, String lname){
            return fname.concat(lname);
        }

        static int returnAge(int number){
            return 2026-number;
        }

        @Override
        public String toString();
    }

    @FunctionalInterface
    interface TwoNum {
        int cal(int a, int b);
    }

    static void lambdaExample() {
        //old way annonymous class
        @SuppressWarnings("Convert2Lambda")
        Learning learner = new Learning() {
            @Override
            public void display(String name) {
                System.out.println("Learner Name: "+name);
            }
        };
        learner.display("DELTA");
        
        //Lambda Way
        Learning learner2 = (name) -> {
            System.out.println("Learner Name: "+name);
        };
        learner2.display("DEVDEEP");

        TwoNum add = (a,b)->{
            return a+b;
        };
        System.out.println(add.cal(10,20));

    }
    
    public static void typeOfFunctionalInterface(){
        //Consumer : void accept(T t); accept input and return nothing
        Consumer<Integer> consumer = (anything) -> {
            System.out.println("Ur Number is " + anything);
        };

        //Supplier : T get(); accept nothing and return something
        Supplier<String> supplier = () -> {
            return "Hello Supplier!";
        };

        //Function : R apply(T t); accept input and return output
        Function<Integer,String> functional = (number) -> {
            String num = number.toString();
            return num;
        };

        //Predicate : Boolean test(T t): accept input and return boolean
        Predicate<Integer> predicate = (num) -> {
            return num%2 == 0;
        };

        //Test
        //1
        consumer.accept(10);
        //2
        System.out.println(supplier.get());
        //3 
        System.out.println(functional.apply(10));
        //4
        System.out.println(predicate.test(10));

        
    };
}



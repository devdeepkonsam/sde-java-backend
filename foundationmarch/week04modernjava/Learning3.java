package foundationmarch.week04modernjava;


public class Learning3 {
    public static void main(String[] args) {
        method();
        try {
            method2(10);
        } catch (Exception e) {
            System.out.println("Exception :" + e.getMessage());
        }
    }

    
    @SuppressWarnings("UseSpecificCatch")
    private static void method() {
        try { 
            //code that may throw an exception
            int parsInt = Integer.parseInt("DELTA");
            System.out.println(parsInt);
        } catch (NumberFormatException | NullPointerException | ArrayIndexOutOfBoundsException e) {
            //catch the exception and handle it , it can be multiple
            System.out.println("Exception :" + e.getMessage());
        } finally{ 
            //code that alaways get executed, regardless of an exception occurs or not
            System.out.println("This will always get executed");
        }
    }

    private static void method2(int age) throws Exception { 
        //throws is used to declare that this method may throw an exceptiion,
        // the coder who calls this method must handdle the exception, either with try-catch or by declaring throws in their method signature
        if(age < 18) {
            //throw is used to actually throw an exception when a certain condition is met
            //message is optional, but it can provide more information about the exception
            throw new Exception("Age must be 18 or above");
        } else {
            System.out.println("You are eligible to vote");
        }
    }
     
}
//for ExceptionHandlling
//checked: compiler tells you to handle it before compilation succeeds, usually with try-catch or throws
//unchecked: code compiles, but it can fail at runtime and "boom" you get an error
//both can happen while running the code; the difference is that checked exceptions must be handled first

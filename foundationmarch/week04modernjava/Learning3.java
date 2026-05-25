package foundationmarch.week04modernjava;

//for ExceptionHandlling

import java.io.BufferedReader;
import java.io.FileReader;

//both can happen while running the code; the difference is that checked exceptions must be handled first

public class Learning3 {
    public static void main(String[] args) throws AgeException {
        //if a method throws a checked exception, you must either handle it with try-catch or declare that your method also throws it
        method();
        method2();
        method3(17); //this will throw an exception beccause age is 17
        //after that no code will be executed because the exception is not handle
        //it just declares that it throws the exception
    }

    
    @SuppressWarnings("UseSpecificCatch")
    private static void method() {
        //unchecked exception, we dont need to declare throws, but we can still handle it with try-catch if we want to prevent the program from crashing
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
    
    private static void method2(){
        //trywithresource is a try block that automatically closes the resource after the block is executed
        try (BufferedReader br = new BufferedReader(new FileReader("example.txt"))){
            String line;
            while((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            System.out.println("Exception :" + e.getMessage());
        }
    }

    private static void method3(int age) throws AgeException { 
        //for runtime exception we dont need to delare throws
        //throws is used to declare that this method may throw an exceptiion,
        // the coder who calls this method must handdle the exception, either with try-catch or by declaring throws in their method signature
        if(age < 18) {
            //throw is used to actually throw an exception when a certain condition is met
            //message is optional, but it can provide more information about the exception
            //throw new Exception("Age must be 18 or above");
            throw new AgeException("Age must be 18 or above", new RuntimeException());
        } else {
            System.out.println("You are eligible to vote");
        }
    }


}

//custom exception
class AgeException extends Exception {
    //we create a custom exception by extending an existing exception class

    public AgeException(String message){
        super(message);
    }
    //here it take a message and a cause which is the original exception that caused this exception
    public AgeException(String message, Throwable cause) {
        super(message,cause);
    }
}


package foundationmarch.week04modernjava;


public class Learning3 {
    public static void main(String[] args) {
        method();
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
     
}
//for ExceptionHandlling
//checked: compiler tells you to handle it before compilation succeeds, usually with try-catch or throws
//unchecked: code compiles, but it can fail at runtime and "boom" you get an error
//both can happen while running the code; the difference is that checked exceptions must be handled first

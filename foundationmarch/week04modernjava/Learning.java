package foundationmarch.week04modernjava;

@FunctionalInterface
public interface Learning {
    void display(String name);

    static void show(){
        System.out.println("learning java");
    }

    default void print(String name){
        System.out.println("hello "+name);
    }

    String toString();
}

class Testing implements Learning {
    public void display(String name){
        System.out.println("Learning "+name);
    }
}
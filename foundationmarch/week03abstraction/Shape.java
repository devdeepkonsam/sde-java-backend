public abstract class Shape {
    private final String name;

    protected Shape(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract double area();

    public void printDetails() {
        System.out.println(name + " area = " + area());
    }
}
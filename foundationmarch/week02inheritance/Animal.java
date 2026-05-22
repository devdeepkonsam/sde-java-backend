public class Animal {
    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public void eat() {
        System.out.println(name + " is eating");
    }

    public void makeSound() {
        System.out.println(name + " makes a sound");
    }

    public String getName() {
        return name;
    }
}
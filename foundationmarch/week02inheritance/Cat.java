public class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " meows");
    }

    public void climb() {
        System.out.println(name + " climbs the tree");
    }
}
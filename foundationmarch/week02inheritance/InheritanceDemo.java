public class InheritanceDemo {
    public static void main(String[] args) {
        Animal genericAnimal = new Animal("Animal");
        Dog dog = new Dog("Buddy");
        Cat cat = new Cat("Misty");

        genericAnimal.eat();
        genericAnimal.makeSound();

        dog.eat();
        dog.makeSound();
        dog.fetch();

        cat.eat();
        cat.makeSound();
        cat.climb();

        Animal upcastedDog = new Dog("Rocky");
        upcastedDog.makeSound();
    }
}
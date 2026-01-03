public class AnimalHierarchy {

    //interface for Sound Behavior
    interface SoundBehavior {
        void makeSound();
    }

    //sound implementation
    static class BarkSound implements SoundBehavior {
        @Override
        public void makeSound() {
            System.out.println("Bark Bark");
        }
    }

    static class MeowSound implements SoundBehavior {
        @Override
        public void makeSound() {
            System.out.println("Meow Meow");
        }
    }

    static class ChirpSound implements SoundBehavior {
        @Override
        public void makeSound() {
            System.out.println("Chirp Chirp");
        }
    }

    //abstract superclass 
    static abstract class Animal {

        //Encapsulation
        private final String name;
        private final int age;

    
        private final SoundBehavior soundBehavior;

        
        protected Animal(String name, int age, SoundBehavior soundBehavior) {
            this.name = name;
            this.age = age;
            this.soundBehavior = soundBehavior;
        }

        //critical method bark final 
        public final void performSound() {
            System.out.print(name + " says: ");
            soundBehavior.makeSound();
        }

        // common behavior
        public void displayInfo() {
            System.out.println("Name: " + name + ", Age: " + age);
        }
    }

    //concrete sub class
    static class Dog extends Animal {
        public Dog(String name, int age) {
            super(name, age, new BarkSound());
        }
    }

    static class Cat extends Animal {
        public Cat(String name, int age) {
            super(name, age, new MeowSound());
        }
    }

    static class Bird extends Animal {
        public Bird(String name, int age) {
            super(name, age, new ChirpSound());
        }
    }

    //Polymorphism
    public static void main(String[] args) {

        Animal a1 = new Dog("Tommy", 3);
        Animal a2 = new Cat("Kitty", 2);
        Animal a3 = new Bird("Tweety", 1);

        a1.displayInfo();
        a1.performSound();

        a2.displayInfo();
        a2.performSound();

        a3.displayInfo();
        a3.performSound();
    }
}

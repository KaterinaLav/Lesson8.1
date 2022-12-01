package Lesson6;

public class Main {
    public static void main(String[] args) {

            Animal animal = new Animal("CatsCategory");
            Cat cat = new Cat("Барсик", 200, false);
            animal.animalInfo();
            cat.animalInfo();
            cat.catInfo();

            Animal danimal = new Animal("Dogs");
            Dog dog = new Dog("Шарик", 500, 10);
            danimal.animalInfo();
            dog.animalInfo();
            dog.dogInfo();

        }
    }
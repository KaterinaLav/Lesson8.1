package Lesson6;

public class Animal {
    public String name;
    public int run;

    public Animal() {
    }

    public Animal(String name) {
        this.name = name;
    }

    public void animalInfo() {
        System.out.println();

    }
}

class Cat extends Animal {

    protected boolean sweem;

    public Cat(String name, int run, boolean sweem) {
        this.name = name;
        this.run = run;
        this.sweem = sweem;

    }

    public void catInfo() {
        System.out.println("Животное - " + name + ": " + "Бег: " + run + " метров," + "Плавает:" + " " + sweem + " ");
    }
}

class Dog extends Animal {

    public double jump;
    public int sweem;

    //konstruktor

    public Dog(String name, int run, int sweem) {
        this.name = name;
        this.run = run;
        this.sweem = sweem;
    }
    public void dogInfo() {
        System.out.println("Животное - " + name + ": " + "Бег: " + run + " метров," + "Плавает:" + " " + sweem + " " );
    }
}
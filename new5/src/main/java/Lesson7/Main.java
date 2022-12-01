package Lesson7;

public class Main {
    public static
    void main(String[] args) {
        Cat[] cats = {new Cat("Тихон", 50), new Cat("Васька", 50), new Cat("Пушок", 25), new Cat("Черныш", 5), new Cat("Мурзик", 1)};
// здесь вводим наполнение миски и программа автоматический определит какой из котов сможет наесться а какой нет.
        Food plate = new Food(80);

        for (Cat cat : cats) {
            cat.eat(plate);
            cat.info();
        }
    }
}

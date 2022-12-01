package Lesson5;

public class MainClass {
    public static void main(String[] args) {
        Employee[] employeeArray = new Employee[5];
        employeeArray[0] = new Employee("Лаврик Евген Серг", "Java Developer", "java1@mail.ru", "89379992", 1000, 45);
        employeeArray[1] = new Employee("Лаврик Кэт Алекс", "Teamlead", "teamdlead@mail.ru", "89378763", 2000, 44);
        employeeArray[2] = new Employee("Лаврик Мих Евген", "QA-Engineer", "qa1@mail.ru", "8379958", 3000, 37);
        employeeArray[3] = new Employee("Лаврик Влад Евген", "Java Developer", "java2@mail.ru", "8937654784", 4000, 35);
        employeeArray[4] = new Employee("Лаврик Конст Евген", "QA-Engineer", "qa2@mail.ru", "89379963", 5000, 33);

        for (int i = 0; i < employeeArray.length; i++) {
            if (employeeArray[i].getAge() > 40) {
                employeeArray[i].print();
            }
        }
    }
}
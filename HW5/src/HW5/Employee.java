package HW5;

public class Employee {

    private String surname;
    private String name;
    private String midleName;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;

    public Employee(String surname, String name, String midleName, String position, String email, String phone, int salary, int age) {

        this.surname = surname;
        this.name = name;
        this.midleName = midleName;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    String getSurname() {
        return surname;
    }

    String getname() {
        return name;
    }

    String midleName() {
        return midleName;
    }

    String position() {
        return position;
    }

    String email() {
        return email;
    }

    String phone() {
        return phone;
    }

    int salary() {
        return salary;
    }

    int age() {
        return age;
    }

    String getEmployeeInfo() {
        return this.surname + " " +
               this.name + " " +
               this.midleName + ", Должность: " +
               this.position + ", Адрес: " +
               this.email + ", Телефон: " +
               this.phone + ", Зарплата: " +
               this.salary + ", Возраст: " +
               this.age + " ";
    }

}

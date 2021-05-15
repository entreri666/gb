package HW5;

public class HW5 {

    public static void main(String[] args) {

        Employee[] company = {

                new Employee("Иванов", "Иван", "Иванович", "Администратор", "ivanov@company.ru", "8(234)56789", 50000, 41),
                new Employee("Петров", "Петр", "Петрович", "Инжененр", "petrov@company.ru", "8(231)23489", 70000, 35),
                new Employee("Андреев", "Андрей", "Андреевич", "Инжененр", "andreev@company.ru", "8(234)9536", 55000, 25),
                new Employee("Сергеев", "Сергей", "Сергеевич", "Инжененр", "sergeev@company.ru", "8(234)32587", 62000, 43),
                new Employee("Григорьев", "Григорий", "Григорьевич", "Директор", "grigorev@company.ru", "8(234)36954", 100000, 50),

        };

        getAllEmployeeInfo(company);
        System.out.println("***********");
        getOldEmployeeInfo(company, 40);
    }

        private static void getAllEmployeeInfo(Employee[] company) {
            System.out.println("Список сотрудников:");
            for (int i = 0; i < company.length; i++)
                System.out.println((i + 1) + " " + company[i].getEmployeeInfo());
        }

        private static void getOldEmployeeInfo(Employee[] company, int age) {
            System.out.println("Сотрудники старше 40 лет:");
            for (int i = 0; i < company.length; i++)
                if(company[i].age() > age) {
                    System.out.println((i + 1) + " " + company[i].getEmployeeInfo());
                }

        }

    }
package HW6;

public class HW6 {

    public static void main(String[] args) {

        String WinEvent = " Win";
        String LossEvent = " Fail";
        String event;
        String eventResult;


        Cat cat1 = new Cat("Васька", 150, 10);
        Cat cat2 = new Cat("Кузя", 301, 6);
        Cat cat3 = new Cat("Рыжик", 150, 15);
        Dog dog1 = new Dog("Рекс", 290, 200);
        Dog dog2 = new Dog("Рик", 350, 100);
        Dog dog3 = new Dog("Мухтар", 500, 300);

        Animal[] animals = {cat1, cat2, cat3, dog1, dog2, dog3};

        int needToRunLenght = 300;
        int needToSwimLenght = 150;

        for (int i = 0; i < animals.length; i++) {
            String AnimalName = animals[i].getType() + " " + animals[i].getName() + " Может ";

            event = "пробежать на " + animals[i].getMaxRun() + "м. Необходимо пробежать:";
            eventResult = animals[i].run(needToRunLenght) ? WinEvent : LossEvent;
            result(AnimalName, event, needToRunLenght, eventResult);

            int swimResult = animals[i].swim(needToSwimLenght);
            event = "проплыть на" + animals[i].getmaxSwim() + "м. Необходимо проплыть:";
            eventResult = (swimResult == Animal.swimOk) ? WinEvent : LossEvent;

            if (swimResult == Animal.swimNone)
                eventResult = " Коты не умеют плавать";
            result(AnimalName, event, needToSwimLenght, eventResult);
        }
        System.out.println("Всего животных: " + Animal.countAnimals + " Собак: " + Dog.countDog + " Котов: " + Cat.countCat);

    }

    private static void result(String animalName, String event, int eventLenght, String eventResult) {
        System.out.println(animalName + event + eventLenght + eventResult);

    }
}

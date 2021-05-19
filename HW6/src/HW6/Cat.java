package HW6;

public class Cat extends Animal{

    public static int countCat = 0;

    Cat(String name, int maxRun, int maxSwim){
        super("Кот", name, maxRun, maxSwim);
        ++countCat;
    }
    @Override
    public int swim(int distance) {
        return Animal.swimNone;
    }
}

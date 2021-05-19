package HW6;

public class Dog extends Animal {

    public static int countDog = 0;

    Dog(String name, int maxRun, int maxSwim){
        super("Собака", name, maxRun, maxSwim);
        ++countDog;
    }
}

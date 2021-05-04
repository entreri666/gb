package homework_2;

public class homework_2 {

    public static void main(String[] args) {

        if (checkSumm(5, 2)) {
            System.out.println("true");
        } else {
            System.out.println("false");
            }

        if (positiveNum(-2)) {
            System.out.println("положительное число");
        } else {
            System.out.println("отрицательное число");
        }

        if (Num(-5)) {
            System.out.println("false");
        } else {
            System.out.println("true");
        }
        cycle("java", 5);

        if(leapYear(2020)){
            System.out.println("true");
        } else {
            System.out.println("false");
    }
    }



    public static boolean checkSumm(int a, int b) {

        return (a + b >= 10 && a + b <= 20);
    }

    public static boolean positiveNum(int a) {

        return (a >= 0);
    }

    public static boolean Num(int a) {

        return (a >= 0);
    }

    public static void cycle(String string, int a) {
        for (int i = 0; i < a; i++)
        System.out.println((i+1) + " " + string);
    }

    public static boolean leapYear(int year){
        return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0);
    }

}

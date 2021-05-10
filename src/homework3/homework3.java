package homework3;


import java.util.Arrays;

public class homework3 {

    public static void main(String[] args) {

        invert();
        System.out.println("*******");
        fill();
        System.out.println("*******");
        change();
        System.out.println("*******");
        diagonal;


        }
    public static void invert() {
        int[] array = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                array[i] = 0;
            } else {
                array[i] = 1;
        }
            System.out.println(array[i] + "");
        }
    }

    public static void fill() {
         int[] fillArr = new int[100];
         for (int i = 0; i < fillArr.length; i++) {
             fillArr[i] = i + 1;
        }
         System.out.println(Arrays.toString(fillArr));
    }

    public static void change() {
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] = array[i] * 2;
            }
            System.out.println(array[i] + "");
        }
}
    int[][] arrayDiagonal = new int[5][5]
    public static void diagonal(int [][] arr){
        for (int i = 0; i < arr.length; i++){
            arr[i][i] = 1;
            arr[i][arr.length - 1 - i] = 1;
        }
        System.out.println(arrayDiagonal);
    }



}
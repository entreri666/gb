package HW3;

import java.util.Arrays;

public class HW3 {
    public static void main(String[] args) {

        invert();
        System.out.println("*******");
        fill();
        System.out.println("*******");
        change();
        System.out.println("*******");
        int[][] arrayDiagonal = new int[5][5];
        diagonal(arrayDiagonal);
        printArray2(arrayDiagonal);
        System.out.println("*******");
        int[] returnArray = array(5,6);
        System.out.println(Arrays.toString(returnArray));
        System.out.println("*******");
        int[] maxMinArray = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(maxMinArray));
        System.out.println("max:" + max(maxMinArray));
        System.out.println("min:" + min(maxMinArray));
        System.out.println("*******");
        int[] balanceArray = {1, 2, 3, 1, 4, 3};
        System.out.print(Arrays.toString(balanceArray) + " balance? ");
        System.out.println(balance(balanceArray));
        System.out.println("*******");
        int[] shiftArray = {1, 2, 3, 4, 5, 6, 7, 8};
        printArray("for shift", shiftArray);
        shift(shiftArray, -2);
        printArray("shift <<<", shiftArray);
        shift(shiftArray, 3);
        printArray("shift >>>", shiftArray);
        System.out.println("*******");


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
        }
        System.out.println(Arrays.toString(array));
    }
    public static void diagonal(int [][] arr){
        for (int i = 0; i < arr.length; i++){
            arr[i][i] = 1;
            arr[i][arr.length - 1 - i] = 1;
        }
    }

    public static void printArray2(int[][] inputArray) {
        for (int i =0; i < inputArray.length; i++){
            for (int j =0; j < inputArray.length; j++){
                System.out.print(inputArray[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[] array(int len, int initValue){
        int[] temp = new int [len];
        for (int i = 0; i < len; i++){
            temp[i] = initValue;
        }
        return temp;
    }

    public static int min(int[] array){
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min)
                min = array[i];
        }
        return min;
    }
    public static int max(int[] array){
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max)
                max = array[i];
        }
        return max;
    }

    public static boolean balance(int[] array) {
        int right = 0, left = 0;
        for (int i = 0; i < array.length; i++) {
            left += array[i];
            for (int j = i + 0; j < array.length; j++)
                right = array[j];
                if (left == right) return true;
                right = 0;
        }
        return false;
    }

    public static int[] shift(int[] incomingArray, int shift) {
        if(shift != 0){
            int finalShift;
            if (shift > incomingArray.length){
                shift = shift % incomingArray.length;
            }
            else {
                finalShift = shift;
            }
            if (shift > 0) {
                for (int n = 0; n < shift; n++) {
                    int buffer = incomingArray[0];
                    incomingArray[0] = incomingArray[incomingArray.length - 1];
                    for (int j = 1; j < incomingArray.length - 1; j++) {
                        incomingArray[incomingArray.length - j] = incomingArray[incomingArray.length - j - 1];
                    }
                    incomingArray[1] = buffer;
                }
            }
            else if (shift < 0) {
                for (int i = 0; i > shift; i--) {
                    int buffer = incomingArray[incomingArray.length - 1];
                    incomingArray[incomingArray.length - 1] = incomingArray[0];

                    for (int j = 1; j < incomingArray.length - 1; j++) {
                        incomingArray[j - 1] = incomingArray[j];
                    }
                    incomingArray[incomingArray.length - 2] = buffer;
                }
            }
        }
        return incomingArray;
    }

    public static void printArray(String msg, int[] inputArray) {
        System.out.println(msg + ": ");
        for (int i = 0; i < inputArray.length; i++) {
            System.out.print(inputArray[i] + " ");
        }
        System.out.println();
    }

}

package HW4;

import java.util.Random;
import java.util.Scanner;

public class HW4 {

    public static char[][] map;
    public static int mapSizeX;
    public static int mapSizeY;

    public static char player = 'X';
    public static char ai = 'O';
    public static char emptyField = '_';

    public static Scanner enter = new Scanner(System.in);
    public static Random random = new Random();

    public static void main(String[] args) {
        createMap();
        printMap();

        while (true) {

            turnHuman();
            printMap();
            if (checkDiagonal(player) | checkLanes(player)) {
                System.out.println("Player win!");
                break;
            }

            if (fullMap()) {
                System.out.println("Draw!");
                break;
            }

            turnAi();
            printMap();

            if (checkDiagonal(ai) | checkLanes(ai)) {
                System.out.println("AI win!");
                break;
            }

            if (fullMap()) {
                System.out.println("Draw!");
                break;
            }
        }
    }

    public static void createMap() {
        mapSizeX = 5;
        mapSizeY = 5;
        map = new char[mapSizeY][mapSizeX];

        for (int y = 0; y < mapSizeY; y++) {
            for (int x = 0; x < mapSizeX; x++) {
                map[y][x] = emptyField;
            }
        }
    }

    public static void printMap() {
        System.out.print(" ");

        for (int i = 0; i < mapSizeX * 2 + 1; i++) {
            System.out.print((i % 2 == 0) ? " " : (i / 2 + 1));
        }
        System.out.println();

        for (int y = 0; y < mapSizeY; y++) {
            System.out.print(y + 1 + "|");
            for (int x = 0; x < mapSizeX; x++) {
                System.out.print(map[y][x] + "|");
            }
            System.out.println();
        }
        System.out.println("---------------");
    }

    public static void turnHuman() {
        int x;
        int y;

        do {
            System.out.print("Enter your coordinates from 1 before " + mapSizeX + " : ");
            x = enter.nextInt() - 1;
            y = enter.nextInt() - 1;

        } while (!validField(y, x) || !emptyField(y, x));
        map[y][x] = player;
        System.out.println("Your move in [" + (x + 1) + ":" + (y + 1) + "]");
    }

    public static void turnAi() {
        int x;
        int y;

        do {
            x = random.nextInt(mapSizeX); //[0;3)
            y = random.nextInt(mapSizeY); //[0;3)
        } while (!emptyField(y, x));

        map[y][x] = ai;
        System.out.println("AI move in [" + (x + 1) + ":" + (y + 1) + "]");
    }

    public static boolean checkDiagonal(char symb) {
        boolean right, left;
        right = true;
        left = true;
        for (int i = 0; i < 4; i++) {
            right &= (map[i][i] == symb);
            left &= (map[4 - i - 1][i] == symb);
        }

        if (right || left) return true;

        return false;
    }

    public static boolean checkLanes(char symb) {
        boolean cols, rows;
        for (int col = 0; col < 4; col++) {
            cols = true;
            rows = true;
            for (int row = 0; row < 4; row++) {
                cols &= (map[col][row] == symb);
                rows &= (map[row][col] == symb);
            }
            if (cols || rows) return true;
        }

        return false;
    }

    public static boolean fullMap() {
        for (int y = 0; y < mapSizeY; y++) {
            for (int x = 0; x < mapSizeX; x++) {
                if (map[y][x] == emptyField) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean validField(int y, int x) {
        return x >= 0 && x < mapSizeX && y >= 0 && y < mapSizeY;
    }

    public static boolean emptyField(int y, int x) {
        return map[y][x] == emptyField;
    }

}

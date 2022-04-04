package gb.HomeWorkApp4;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static int size = 5;
    public static int winLine = 4;
    public static char[][] map;
    public static  final  char dot_X = 'x';
    public static final char dot_O = 'O';
    public static final int emptu = '*';
    public static Scanner cr = new Scanner(System.in);
    public static Random random = new Random();

    public static void main(String[] args) {
        Map1();
        Map();
        while (true) {
            human();
            Map();
            if (win(dot_X)) {
                System.out.println("Победил человек");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            IA();
            Map();
            if (win(dot_O)) {
                System.out.println("Победил Искуственный Интеллект");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра закончена");
    }


    public static void Map() {
        System.out.print("+" + "|");
        for (int i = 0; i < size; i++) {
            System.out.print(i + 1 + "|");

        }
        System.out.println();
        for (int i = 0; i < size; i++) {
            System.out.print((i + 1) + "|");
            for (int j = 0; j < size; j++) {
                System.out.print(map[i][j] + "|");

            }
            System.out.println();
        }
    }

    public static void Map1() {
        map = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                map[i][j] = emptu;

            }

        }

    }

    public static boolean IA() {
        int x, y;
        do {
            x = random.nextInt(size);
            y = random.nextInt(size);
        } while (!isCellValid(x, y));
        System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y +
                1));
        map[y][x] = dot_O;
        return false;
    }

    public static boolean human() {
        int x, y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = cr.nextInt() - 1;
            y = cr.nextInt() - 1;
        } while (!isCellValid(x, y));
        map[y][x] =  dot_X;
        return false;
    }

    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= size || y < 0 || y >= size) return false;
        if (map[y][x] == emptu) return true;
        return false;
    }

    public static boolean win(char sum) {
     boolean x,y;
     for (int i=0;i<size;i++){
         x=true;
         y=true;
         for (int j=0; j<size;j++){
             x &=(map[i][j]==sum);
             y &=(map[j][i]==sum);
         }
         if(x || y) return true;
     }

     return false;
    }

    public static boolean isMapFull() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (map[i][j] == emptu) return false;
            }
        }
        return true;
    }
}
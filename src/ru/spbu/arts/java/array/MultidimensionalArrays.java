package ru.spbu.arts.java.array;

import java.util.Arrays;

public class MultidimensionalArrays {
    public static void main(String[] args) {
        int[][] a = new int[][]{{10, 20, 30}, {4, 3}, {100}};
        printTable(a);
        printTableAligned(a);

        a = new int[][]{
                {10, 1, 1_000_000, 44, 4244},
                {111, 432, 44},
                {5, 27, 1, 33, 123523, 6}
        };
        printTable(a);
        printTableAligned(a);

        a = new int[][]{{},{},{1}};
        printTable(a);
        printTableAligned(a);

        a = new int[][]{{-10},{10, 9389}, {438932, 9, 93, 12, 4, 5}};
        printTable(a);
        printTableAligned(a);

        char[][] c = createTable(20, '.');
        printTable(c);
        char[][] u = createTable(5, '0');
        printTable(u);

        System.out.println("============ Заполним строки: ==========");
        fillFirstAndLastLines(c, '#');
        printTable(c);
        fillFirstAndLastLines(u, '!');
        printTable(u);

        System.out.println("============ Заполним столбцы: =========");
        fillFirstAndLastColumns(c, '#');
        printTable(c);
        fillFirstAndLastColumns(u, '@');
        printTable(u);

    }

    private static void printTable(int[][] a) {
        for (int[] x: a) {
            for (int i = 0; i < x.length; i++) {
                if (i != 0)
                    System.out.print(" ");
                System.out.print(x[i]);
            }
            System.out.print("\n");
        }
    }

    private static void printTableAligned(int[][] a) {
        int maxColumns = 0;
        for (int[] x : a) {
            if (x.length > maxColumns)
                maxColumns = x.length;
        }
        String[][] aStr = new String[a.length][maxColumns];
        int[] maxDigitsInCol = new int[maxColumns];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                aStr[i][j] = Integer.toString(a[i][j]);
                if (aStr[i][j].length() > maxDigitsInCol[j])
                    maxDigitsInCol[j] = aStr[i][j].length();
            }
        }
        for (int i = 0; i < aStr.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (j != 0)
                    System.out.print("  ");
                for (int k = aStr[i][j].length(); k < maxDigitsInCol[j]; k++)
                    System.out.print(" ");
                System.out.print(aStr[i][j]);
            }
            System.out.print("\n");
        }
    }

    private static char[][] createTable(int n, char c) {
        char[][] a = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = c;
            }
        }
        return a;
    }

    private static void printTable(char[][] a) {
        for (char[] x : a) {
            for (int j = 0; j < x.length; j++) {
                if (j != 0)
                    System.out.print(" ");
                System.out.print(x[j]);
            }
            System.out.print("\n");
        }
    }

    private static void fillFirstAndLastLines(char[][] a, char c) {
        Arrays.fill(a[0], c);
        Arrays.fill(a[a.length - 1], c);
    }

    private static void fillFirstAndLastColumns(char[][] a, char c) {
        for (int i = 0; i < a.length; i++) {
            a[i][0] = c;
            a[i][a.length - 1] = c;     // assuming a is always square
        }
    }

}

package ru.spbu.arts.java.array;

import java.util.Arrays;

public class ArrayTasks {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(even(6)));
        System.out.println(Arrays.toString(even(2)));
        System.out.println(Arrays.toString(even(0)));

        System.out.println(allSimilar(new int[]{0}));
        System.out.println(allSimilar(new int[]{}));
        System.out.println(allSimilar(new int[]{0, 0, 0}));
        System.out.println(allSimilar(new int[]{1, 3, 2}));
        System.out.println(allSimilar(new int[]{1, 1, 1, 10}));

        System.out.println(hasSimilar(new int[]{0}));
        System.out.println(hasSimilar(new int[]{1, 3, 2, 4}));
        System.out.println(hasSimilar(new int[]{1, 1}));
        System.out.println(hasSimilar(new int[]{4, 3, 2, 4}));
        System.out.println(hasSimilar(new int[]{4, 4, 2}));

        System.out.println(mean(new int[]{2, 3}));
        System.out.println(mean(new int[]{1, 1, 1, 1}));
        System.out.println(mean(new int[]{2, 4, 6}));
        System.out.println(mean(new int[]{2, 6, 9, 4}));

        int[] a = {10, 20, 30, 40};
        for (int i = 0; i < 4; i++) {
            shift(a);
            System.out.println(Arrays.toString(a));
        }
        a = new int[]{};
        System.out.println(Arrays.toString(a));

        System.out.println(Arrays.toString(copyShift(a)));
        a = new int[]{1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(copyShift(a)));
        System.out.println(Arrays.toString(a));
        a = new int[]{0};
        System.out.println(Arrays.toString(copyShift(a)));
    }

    private static int[] even(int n) {
        int[] a = new int[n];
        for (int i = 0, j = 2; i < n; i++, j += 2)
            a[i] = j;
        return a;
    }

    private static boolean allSimilar(int[] a) {
        if (a.length > 1) {
            int refVal = a[0];
            for (int x : a) {
                if (x != refVal) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean hasSimilar(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (i != j && a[i] == a[j])
                    return true;
            }
        }
        return false;
    }

    private static double mean(int[] a) {
        double sum = 0;
        int count = 0;
        for (int x : a) {
            sum += x;
            count++;
        }
        return sum / count;
    }

    private static void shift(int[] a) {
        if (a.length == 0)
            return;
        int curVal = a[0];
        a[0] = a[a.length - 1];
        for (int i = 1; i < a.length; i++) {
            int temp = a[i];
            a[i] = curVal;
            curVal = temp;
        }
    }

    private static int[] copyShift(int[] a) {
        int[] newArr = new int[a.length];
        if (a.length == 0)
            return newArr;
        newArr[0] = a[a.length - 1];
        System.arraycopy(a, 0, newArr, 1, a.length - 1);
        return newArr;
    }

}

package ru.spbu.arts.java.intro;

public class IntroTaskSameDigits {
    public static void main(String[] args) {
        System.out.println(isSameDigits(7));
        System.out.println(isSameDigits(77));
        System.out.println(isSameDigits(707));
        System.out.println(isSameDigits(65));
        System.out.println(isSameDigits(99000));
    }

    private static boolean isSameDigits(int x) {
        return x % 10 == x % 100 / 10;
    }
}

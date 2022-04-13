package ru.spbu.arts.java.intro;

public class IntroTaskLeap {
    public static void main(String[] args) {
        System.out.println(isLeap(1600));
        System.out.println(isLeap(1700));
        System.out.println(isLeap(1804));
        System.out.println(isLeap(1960));
        System.out.println(isLeap(2019));
    }

    private static boolean isLeap(int x) {
        return x % 400 == 0 || !(x % 100 == 0) && x % 4 == 0;
    }
}

package ru.spbu.arts.java.intro;

public class IntroTaskQuadraticEquation {
    public static void main(String[] args) {
        System.out.println(solveQuadraticEquation(0, 0,0)); // бесконечно решений
        System.out.println(solveQuadraticEquation(0, 1, 4)); // x = -4
        System.out.println(solveQuadraticEquation(0, 0, 4)); // нет решений
        System.out.println(solveQuadraticEquation(0, 3, 2)); // -0.67
        System.out.println(solveQuadraticEquation(1, 3, 2)); // x1 = -2, x2 = -1
        System.out.println(solveQuadraticEquation(1, 3, 5)); // нет решений
        System.out.println(solveQuadraticEquation(-4, 4, -1)); // x = 0.5
        System.out.println(solveQuadraticEquation(-4, 4, 1)); // x1 = - 0.21, x2 = 1.21

    }

    private static String solveQuadraticEquation(int a, int b, int c) {
        if (a == 0) {
            if (b == 0) {
                if (c == 0) {
                    return "решений бесконечно много";
                }
                else {
                    return "решений нет";
                }
            }
            double x = -1 * (double) c / b;
            return "одно решение x = " + String.format("%.2f",x);
        }
        int d = b * b - (4 * a * c);
        if (d == 0) {
            double x = -1 * (double) b / (2 * a);
            return "одно решение x = " + String.format("%.2f",x);
        }
        else if (d < 0) {
            return "решений нет";
        }
        double x1 = (-1 * b + Math.sqrt(d)) / (2 * a);
        double x2 = (-1 * b - Math.sqrt(d)) / (2 * a);
        double xMin = Math.min(x1, x2);
        double xMax = Math.max(x1, x2);
        return "два решения x1 = " + String.format("%.2f",xMin) + ", x2 = " + String.format("%.2f",xMax);
    }
}

package ru.spbu.arts.java.javafx.figures;

public class MandelbrotFractal implements Fractal {
    public static int N = 160;
    public static int R = 1100;

    @Override
    public double paint(double x, double y) {
        double zx = 0;
        double zy = 0;

        for (int step = 1; step <= N; step++) {
             double newZx = (zx * zx) - (zy * zy) + x;
             double newZy = (2 * zy * zx) + y;
             zx = newZx;
             zy = newZy;
             if (Math.sqrt(zx * zx + zy * zy) > R) {
                return (double)step / N;
             }
        }
        return 0.73;
    }
}

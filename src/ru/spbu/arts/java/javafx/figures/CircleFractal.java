package ru.spbu.arts.java.javafx.figures;

public class CircleFractal implements Fractal {
    @Override
    public double paint(double x, double y) {
        if (x * x + y * y <= 1)
            return 1;
        else
            return 0.5;
    }
}
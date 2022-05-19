package ru.spbu.arts.java.javafx.figures;

import javafx.scene.paint.Color;

public class GrayscalePalette implements Palette {

    @Override
    public Color getColor(double c) {
        return Color.gray(c);
    }
}

package ru.spbu.arts.java.javafx.figures;

import javafx.scene.paint.Color;

public class HSBPalette implements Palette {
    @Override
    public Color getColor(double c) {
        //Saturation is adjusted to avoid hurting user's eyes
        return Color.hsb(c * 360, 0.6, 1);
    }
}

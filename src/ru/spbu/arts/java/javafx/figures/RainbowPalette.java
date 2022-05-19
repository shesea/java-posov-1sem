package ru.spbu.arts.java.javafx.figures;

import javafx.scene.paint.Color;
import ru.spbu.arts.java.javafx.images.WavelengthToRgb;

public class RainbowPalette implements Palette {

    @Override
    public Color getColor(double c) {
        return WavelengthToRgb.convert((c * 370) + 380);
    }
}

package ru.spbu.arts.java.javafx.images;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Images extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Very cool images");

        Parent parent = initInterface();
        primaryStage.setScene(new Scene(parent));
        primaryStage.show();
    }

    private Parent initInterface() {
        WritableImage pic1 = new WritableImage(100, 100);
        PixelWriter pixelWriter1 = pic1.getPixelWriter();
        for (int x = 0; x < 100; x++) {
            for (int y = 0; y < 100; y++)
                pixelWriter1.setColor(x, y, Color.rgb(215, 195, 235));
        }
        ImageView viewer1 = new ImageView(pic1);

        WritableImage pic2 = new WritableImage(256, 256);
        PixelWriter pixelWriter2 = pic2.getPixelWriter();
        for (int x = 0; x < 256; x++) {
            for (int y = 0; y < 256; y++)
                pixelWriter2.setColor(x, y, Color.rgb(123, x, y));
        }
        ImageView viewer2 = new ImageView(pic2);

        WritableImage pic3 = new WritableImage(360, 100);
        PixelWriter pixelWriter3 = pic3.getPixelWriter();
        for (int x = 0; x < 360; x++) {
            for (int y = 0; y < 100; y++)
                pixelWriter3.setColor(x, y, Color.hsb(x, (double) y/100, 0.5));
        }
        ImageView viewer3 = new ImageView(pic3);

        WritableImage pic4 = new WritableImage(100, 100);
        PixelWriter pixelWriter4 = pic4.getPixelWriter();
        for (int x = 0; x < 100; x++){
            for (int y = 0; y < 100; y++) {
                if (x >= 25 && x <= 75 && y >= 25 && y <= 75)
                    pixelWriter4.setColor(x, y, Color.BLACK);
                else
                    pixelWriter4.setColor(x, y, Color.WHITE);
            }
        }
        ImageView viewer4 = new ImageView(pic4);

        WritableImage pic5 = new WritableImage(100, 100);
        PixelWriter pixelWriter5 = pic5.getPixelWriter();
        for (int x = 0; x < 100; x++) {
            for (int y = 0; y < 100; y++) {
                if ((x - 50) * (x - 50) + (y - 50) * (y - 50) < 50 * 50)
                    pixelWriter5.setColor(x, y, Color.BLACK);
                else
                    pixelWriter5.setColor(x, y, Color.WHITE);
            }
        }
        ImageView viewer5 = new ImageView(pic5);

        WritableImage pic6 = new WritableImage(360, 100);
        PixelWriter pixelWriter6 = pic6.getPixelWriter();
        for (int x = 0; x < 360; x++) {
            for (int y = 0; y < 100; y++)
                pixelWriter6.setColor(x, y, LCH.colorFromLCH(50, y, x));
        }
        ImageView viewer6 = new ImageView(pic6);

        WritableImage pic7 = new WritableImage(750 - 380 + 1, 100);
        PixelWriter pixelWriter7 = pic7.getPixelWriter();
        for (int x = 380; x <= 750; x++) {
            for (int y = 0; y < 100; y++)
                pixelWriter7.setColor(750 - x, y, WavelengthToRgb.convert(x));
        }
        ImageView viewer7 = new ImageView(pic7);

        return new FlowPane(
                viewer1,
                viewer2,
                viewer3,
                viewer4,
                viewer5,
                viewer6,
                viewer7
        );
    }
}
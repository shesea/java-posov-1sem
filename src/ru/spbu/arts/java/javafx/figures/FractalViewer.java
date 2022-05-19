package ru.spbu.arts.java.javafx.figures;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class FractalViewer extends Application {

    //final - неизменяемое значение, public static final поля принято
    //называть заглавными буквами с подчеркиваниями между слов
    //см. Math.PI, Integer.MAX_VALUE - наибольше значение в типе int
    public final static int W = 600;
    public final static int H = 500;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Просмотр фигур");

        Pane root = initInterface();
        primaryStage.setScene(new Scene(root));

        primaryStage.show();
    }

    private Pane initInterface() {
        WritableImage img = new WritableImage(W, H);
        Display display = new Display(-2.5, 1.8, 4 / 600.0);
        Fractal f = new MandelbrotFractal();
        Palette p = new HSBPalette();
        display.paint(img, f, p);

        ImageView imageView = new ImageView(img);
        return new Pane(imageView);
    }
}
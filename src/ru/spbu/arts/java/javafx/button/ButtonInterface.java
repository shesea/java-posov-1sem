package ru.spbu.arts.java.javafx.button;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class ButtonInterface extends Application {
    private int pressCount = 0;
    private GridPane panel0;
    private Button button;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Button that don't want to be pressed");

        Parent parent = initInterface();
        initInteraction();

        primaryStage.setScene(new Scene(parent));
        primaryStage.show();

    }

    private Parent initInterface() {
        panel0 = new GridPane();
        button = new Button("Don't press this button.");

        panel0.setAlignment(Pos.CENTER);
        button.setStyle("-fx-font-size: 16");
        button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        panel0.add(button, 0, 0);

        ColumnConstraints c1 = new ColumnConstraints();
        c1.setHgrow(Priority.ALWAYS);
        c1.setMinWidth(300);
        panel0.getColumnConstraints().add(c1);

        RowConstraints r1 = new RowConstraints();
        r1.setVgrow(Priority.ALWAYS);
        r1.setMinHeight(300);
        panel0.getRowConstraints().add(r1);

        return panel0;
    }

    private void initInteraction() {
        button.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            if (pressCount == 0)
                button.setText("Please don't press here anymore.");
            if (pressCount == 1)
                button.setText("This is the last time I ask: don't press it.");
            if (pressCount == 2)
                button.setText("Why would you do that??");
            if (pressCount == 3)
                button.setText("You had only one job. \nAnd yet you've failed.");
            if (pressCount == 4)
                button.setText("What did I do to deserve this?!");
            if (pressCount == 5) {
                Image image = new Image("file:images/cat.jpg", 300, 300, false, false);
                panel0.add(new ImageView(image), 0, 0);
                button.setVisible(false);
                button.setManaged(false);
            }
            pressCount++;
        });
    }
}

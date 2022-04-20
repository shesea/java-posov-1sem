package ru.spbu.arts.java.javafx.circle;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class InteractiveCircle extends Application {
    private Pane circlePane;
    private Circle circle;

    private Slider radiusSlider;
    private ColorPicker circleColor;
    private ColorPicker backgroundColor;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Interactive Circle");

        Parent parent = initInterface();
        primaryStage.setScene(new Scene(parent));
        initInteraction();
        primaryStage.show();
    }

    private Parent initInterface() {
        HBox mainPanel = new HBox();
        mainPanel.setMinSize(500, 250);

        circlePane = new Pane();
        Label sliderText = new Label("Radius");
        radiusSlider = new Slider();
        Label circleText = new Label("Color of the circle");
        circleColor = new ColorPicker(Color.rgb(159, 199, 199));
        Label backgroundText = new Label("Color of the background");
        backgroundColor = new ColorPicker(Color.rgb(217, 230, 165));
        circle = new Circle(150, 100, 40);

        VBox sidePanel = new VBox(
                sliderText, radiusSlider, circleText, circleColor, backgroundText, backgroundColor
        );
        sidePanel.setSpacing(10);
        sidePanel.setPadding(new Insets(20, 10, 10, 20));

        circlePane.getChildren().addAll(circle);
        mainPanel.getChildren().addAll(sidePanel, circlePane);

        sidePanel.setPrefWidth(200);
        HBox.setHgrow(circlePane, Priority.ALWAYS);

        return mainPanel;
    }

    private void initInteraction() {
        circleRadiusBind();
        circleCenterBind();
        colorBind();
    }

    private void circleRadiusBind() {
        //radius depends on the slider value
        circle.radiusProperty().bind(
                radiusSlider.valueProperty()
        );


        //max value of the radius depends on the current pane size
        radiusSlider.maxProperty().bind(Bindings.createDoubleBinding(
                () -> {
                    var min = circlePane.getWidth();
                    if (circlePane.getHeight() < min)
                        min = circlePane.getHeight();
                    return min / 2;
                },
                circlePane.widthProperty(), circlePane.heightProperty()
        ));
    }

    private void circleCenterBind() {
        //x-coordinate of the circle center equals a half of the pane width
        circle.centerXProperty().bind(Bindings.createDoubleBinding(
                () -> circlePane.getWidth() / 2,
                circlePane.widthProperty()
        ));

        //y-coordinate of the circle center equals a half of the pane height
        circle.centerYProperty().bind(Bindings.createDoubleBinding(
                () -> circlePane.getHeight() / 2,
                circlePane.heightProperty()
        ));
    }

    private void colorBind() {
        //circle color is determined by color picker
        circle.fillProperty().bind(
                circleColor.valueProperty()
        );

        //background color is determined by color picker
        circlePane.backgroundProperty().bind(Bindings.createObjectBinding(
                () -> new Background(new BackgroundFill(
                        backgroundColor.getValue(), CornerRadii.EMPTY, Insets.EMPTY
                )),
                backgroundColor.valueProperty()
        ));
    }
}

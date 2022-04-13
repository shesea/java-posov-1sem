package ru.spbu.arts.java.javafx.messenger;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Messenger extends Application {
    private GridPane panel0;
    private Button sendButton;
    private TextArea textArea;
    private TextField textField;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Cool messenger");

        Parent parent = initInterface();
        initInteraction();

        primaryStage.setScene(new Scene(parent));
        primaryStage.show();
    }

    private Parent initInterface() {
        panel0 = new GridPane();

        textArea = new TextArea();
        textField = new TextField();
        sendButton = new Button("Send");
        Label contactsLabel = new Label("Contacts");
        ListView<String> contactsList = new ListView<>();

        textArea.setEditable(false);
        contactsList.setItems(FXCollections.observableArrayList("Mom<3", "Brother<3"));

        sendButton.setMaxWidth(Double.MAX_VALUE);
        sendButton.setMaxHeight(Double.MAX_VALUE);
        textField.setMaxHeight(Double.MAX_VALUE);

        panel0.add(textArea, 0, 0, 2, 2);
        panel0.add(textField, 0, 2);
        panel0.add(sendButton, 1, 2);
        panel0.add(contactsLabel, 2, 0);
        panel0.add(contactsList, 2, 1, 1, 2);

        setConstraints();

        return panel0;
    }

    private void setConstraints() {
        ColumnConstraints c1 = new ColumnConstraints();
        c1.setHgrow(Priority.ALWAYS);
        ColumnConstraints c2 = new ColumnConstraints();
        c2.setMinWidth(90);
        c2.setPrefWidth(100);
        ColumnConstraints c3 = new ColumnConstraints();
        c3.setPrefWidth(200);

        panel0.getColumnConstraints().addAll(c1, c2, c3);

        RowConstraints r1 = new RowConstraints();
        r1.setPrefHeight(30);
        RowConstraints r2 = new RowConstraints();
        r2.setVgrow(Priority.ALWAYS);
        RowConstraints r3 = new RowConstraints();
        r3.setPrefHeight(80);
        r3.setMaxHeight(80);

        panel0.getRowConstraints().addAll(r1, r2, r3);
    }

    private void initInteraction() {
        sendButton.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            if (!textField.getText().isEmpty())
                textArea.appendText(textField.getText() + "\n");
            textField.clear();
        });
    }
}

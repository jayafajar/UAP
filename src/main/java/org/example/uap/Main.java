package org.example.uap;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        org.example.uap.GUI gui = new org.example.uap.GUI();
        gui.start(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}

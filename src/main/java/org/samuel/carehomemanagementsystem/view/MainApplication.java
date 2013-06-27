package org.samuel.carehomemanagementsystem.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MainApplication extends Application{
    
    @Override
    public void start(Stage stage) throws Exception {
        RootPane root = new RootPane();
        root.getStyleClass().add(".root");
        Scene scene = new Scene(root, 800, 600, Color.WHITE);
        scene.getStylesheets().add("applicationLayoutStyle.css");
        stage.setScene(scene);
        stage.show();
        
    }
    
    public static void main(String[] args){
        Application.launch(args);
    }

}

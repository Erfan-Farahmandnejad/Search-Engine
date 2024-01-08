package com.example.searchengine;
import com.example.searchengine.MapImplementation.UnsortedTableMap;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.FileNotFoundException;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 600);
        scene.getStylesheets().add(getClass().getResource("anchorPane.css").toExternalForm());
        stage.initStyle(StageStyle.TRANSPARENT);
        scene.setFill(Color.TRANSPARENT);
        stage.setTitle("SearchEngine");
        stage.setScene(scene);
        stage.show();

        try {
            MainController.map=MainController.fileOperations.ReadAndFillMap();
        } catch (IOException e) {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error while reading the files!!");
            alert.setContentText(e.getMessage());
            alert.getDialogPane().getStylesheets().add(getClass().getResource("Alerts.css").toExternalForm());
            alert.setHeight(300);
            alert.setWidth(300);
            alert.initStyle(StageStyle.TRANSPARENT);
            alert.show();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
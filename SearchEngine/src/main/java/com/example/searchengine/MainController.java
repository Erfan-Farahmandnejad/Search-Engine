package com.example.searchengine;

import com.example.searchengine.MapImplementation.UnsortedTableMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController  {

    public static FileOperations fileOperations=new FileOperations();

    public static UnsortedTableMap<String,String>map=new UnsortedTableMap<String,String>();

    @FXML
    private ImageView Img_BackGround;

    @FXML
    private ImageView Img_Search;

    @FXML
    private AnchorPane ap_Main;

    @FXML
    private Button btn_Search;

    @FXML
    private TextField txt_consol;


    @FXML
    void search(ActionEvent event){
        String result;
        try {
            result=fileOperations.queryPerformer(txt_consol.getText(),map);
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("result of search");
            alert.setContentText(result);
            alert.getDialogPane().getStylesheets().add(getClass().getResource("Alerts.css").toExternalForm());
            alert.setHeight(300);
            alert.setWidth(300);
            alert.initStyle(StageStyle.TRANSPARENT);
            alert.show();
        }
        catch (IllegalStateException e)
        {
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            //alert.setTitle("");
            alert.setContentText(e.getMessage());
            alert.getDialogPane().getStylesheets().add(getClass().getResource("Alerts.css").toExternalForm());
            alert.setHeight(300);
            alert.setWidth(300);
            alert.initStyle(StageStyle.TRANSPARENT);
            alert.show();
        }
    }

}

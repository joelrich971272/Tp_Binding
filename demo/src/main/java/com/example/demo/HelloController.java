package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    public Label labelResultat;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        TextField textFieldEquation = new TextField() ;
        Label labelResultat = new Label() ;
        textFieldEquation.textProperty().addListener(event -> System.out.println("modif du texte"));
        labelResultat.setText(textFieldEquation.getText());
    }

    public void onHelloButtonClick(ActionEvent actionEvent) {
        labelResultat.setText("You have clicked");
        System.out.println(actionEvent.getSource());
        System.out.println(actionEvent.getEventType());
    }
}
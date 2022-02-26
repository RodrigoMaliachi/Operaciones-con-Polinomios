package com.uady.operacionesconpolinomios;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.controlsfx.control.action.Action;

public class ingresoPolinomiosController {
    @FXML
    private TextField TextField1;


    public void onButtonClick(ActionEvent actionEvent) {
        System.out.println(TextField1.getText());

    }
}
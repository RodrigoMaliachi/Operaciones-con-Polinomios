package com.uady.operacionesconpolinomios;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

import java.io.IOException;

public class MenuController {

    @FXML private BorderPane borderPane;
    @FXML private Button polinomiosView;
    @FXML private Button escalarView;

    public void changeView(ActionEvent e) throws IOException {

        String buttonId = ((Button) e.getSource()).getId();

        if ( buttonId.equals( borderPane.getId() ))
            return;

        String file;

        if ( e.getSource().equals(polinomiosView) )
            file = Menu.POLINOMIOS_VIEW_FXML;
        else if ( e.getSource().equals(escalarView) )
            file = Menu.ESCALAR_VIEW_FXML;
        else
            return;

        FXMLLoader loader = new FXMLLoader(getClass().getResource(file));
        HBox view = loader.load();

        borderPane.setCenter(view);
    }
}

package com.uady.operacionesconpolinomios;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class Menu extends Application {

    public static final String MENU_FXML = "menu.fxml";
    public static final String POLINOMIOS_VIEW_FXML = "polinomios_view.fxml";
    public static final String ESCALAR_VIEW_FXML = "escalar_view.fxml";

    public static void main(String[] args) {
        Menu.launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource(MENU_FXML));
        BorderPane border = loader.load();

        loader = new FXMLLoader(getClass().getResource(POLINOMIOS_VIEW_FXML));
        HBox view = loader.load();

        border.setCenter(view);

        Scene scene = new Scene(border);
        stage.setScene(scene);
        stage.setTitle("Operaciones con Polinomios");
        stage.show();
    }
}
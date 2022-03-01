package com.uady.operacionesconpolinomios;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Menu extends Application {

    public static final String MENU_FXML = "menu.fxml";
    public static final String ESCALAR_VIEW_FXML = "escalar_view.fxml";

    @FXML
    private BorderPane borderPane;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {

        URL menu = getClass().getResource(MENU_FXML);
        URL escalar = getClass().getResource(ESCALAR_VIEW_FXML);

        if (menu != null && escalar != null) {
            BorderPane border = FXMLLoader.load(menu);
            VBox escalarBox = FXMLLoader.load(escalar);
            border.setRight(escalarBox);
            Scene scene = new Scene(border);
            stage.setScene(scene);
            stage.show();
        }
    }

    public void changeToEscalarView() throws IOException {
        FXMLLoader loader = new FXMLLoader(Menu.class.getResource("escalar_view.fxml"));
        Scene scene = new Scene(loader.load());
        borderPane.setCenter(scene.getRoot());

        loader = new FXMLLoader(Menu.class.getResource("escalar_buttons_box.fxml"));
        scene = new Scene(loader.load());
        borderPane.setRight(scene.getRoot());

        ((Stage) borderPane.getScene().getWindow()).show();
    }

    public void changeToPolinomiosView() throws IOException {
        FXMLLoader loader = new FXMLLoader(Menu.class.getResource("polinomios_view.fxml"));
        Scene scene = new Scene(loader.load());
        borderPane.setCenter(scene.getRoot());
    }
}

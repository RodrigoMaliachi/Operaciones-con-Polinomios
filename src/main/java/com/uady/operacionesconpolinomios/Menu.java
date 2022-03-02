package com.uady.operacionesconpolinomios;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class Menu extends Application {

    public static final String MENU_FXML = "menu.fxml";
    public static final String POLINOMIOS_VIEW_FXML = "polinomios_view.fxml";
    public static final String POLINOMIOS_BUTTONS_BOX_FXML = "polinomios_buttons_box.fxml";
    public static final String ESCALAR_VIEW_FXML = "escalar_view.fxml";
    public static final String ESCALAR_BUTTONS_BOX_FXML = "escalar_buttons_box.fxml";

    @FXML
    private BorderPane borderPane;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {

        URL menu = getClass().getResource(MENU_FXML);
        URL polinomiosView = getClass().getResource(POLINOMIOS_VIEW_FXML);
        URL polinomiosButtons = getClass().getResource(POLINOMIOS_BUTTONS_BOX_FXML);

        if (menu != null && polinomiosView != null && polinomiosButtons != null) {
            BorderPane border = FXMLLoader.load(menu);
            VBox view = FXMLLoader.load(polinomiosView);
            VBox buttons = FXMLLoader.load(polinomiosButtons);

            border.setCenter(view);
            border.setRight(buttons);

            Scene scene = new Scene(border);
            stage.setScene(scene);
            stage.setTitle("Operaciones con Polinomios");
            stage.show();
        }
    }

    public void changeToEscalarView() throws IOException {

        URL escalarView = getClass().getResource(ESCALAR_VIEW_FXML);
        URL escalarButtons = getClass().getResource(ESCALAR_BUTTONS_BOX_FXML);

        if ( escalarView != null && escalarButtons != null ) {
            VBox view = FXMLLoader.load(escalarView);
            VBox buttons = FXMLLoader.load(escalarButtons);

            borderPane.setCenter(view);
            borderPane.setRight(buttons);
        }
    }

    public void changeToPolinomiosView() throws IOException {
        URL polinomiosView = getClass().getResource(POLINOMIOS_VIEW_FXML);
        URL polinomiosButtons = getClass().getResource(POLINOMIOS_BUTTONS_BOX_FXML);

        if ( polinomiosView != null && polinomiosButtons != null ) {
            VBox view = FXMLLoader.load(polinomiosView);
            VBox buttons = FXMLLoader.load(polinomiosButtons);

            borderPane.setCenter(view);
            borderPane.setRight(buttons);
        }
    }
}

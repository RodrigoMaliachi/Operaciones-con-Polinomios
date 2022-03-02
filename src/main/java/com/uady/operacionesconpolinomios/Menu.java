package com.uady.operacionesconpolinomios;

import javafx.application.Application;
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
    public static final String POLINOMIOS_BUTTONS_BOX_FXML = "polinomios_buttons_box.fxml";
    public static final String ESCALAR_VIEW_FXML = "escalar_view.fxml";
    public static final String ESCALAR_BUTTONS_BOX_FXML = "escalar_buttons_box.fxml";

    @FXML
    private BorderPane borderPane;

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource(MENU_FXML));
        BorderPane border = loader.load();

        loader = new FXMLLoader(this.getClass().getResource(POLINOMIOS_VIEW_FXML));
        VBox view = loader.load();

        Object controller = loader.getController();

        loader = new FXMLLoader(this.getClass().getResource(POLINOMIOS_BUTTONS_BOX_FXML));
        loader.setController(controller);
        VBox buttons = loader.load();

        border.setCenter(view);
        border.setRight(buttons);

        setPolinomiosButtons(buttons.getChildren().stream().toList(), (PolinomiosController) controller);

        Scene scene = new Scene(border);
        stage.setScene(scene);
        stage.setTitle("Operaciones con Polinomios");
        stage.show();
    }

    public void changeToEscalarView() throws IOException {

        if (borderPane.getCenter().getId().equals("escalarView"))
            return;

        changeCenterAndRight(ESCALAR_VIEW_FXML, ESCALAR_BUTTONS_BOX_FXML);
    }

    public void changeToPolinomiosView() throws IOException {

        if (borderPane.getCenter().getId().equals("polinomiosView"))
            return;

        changeCenterAndRight(POLINOMIOS_VIEW_FXML, POLINOMIOS_BUTTONS_BOX_FXML);
    }

    private void changeCenterAndRight(String center, String  right) throws IOException {

        if (borderPane.getChildren().size() > 1)
            borderPane.getChildren().remove(1,3);

        FXMLLoader loader;
        loader = new FXMLLoader(this.getClass().getResource(center));
        VBox view = loader.load();

        Object controller = loader.getController();

        loader = new FXMLLoader(this.getClass().getResource(right));
        loader.setController(controller);
        VBox buttons = loader.load();

        borderPane.setCenter(view);
        borderPane.setRight(buttons);

        if ( controller instanceof PolinomiosController)
            setPolinomiosButtons(buttons.getChildren().stream().toList(), (PolinomiosController) controller);
    }

    private void setPolinomiosButtons(List<Node> buttons, PolinomiosController controller) {
        for (Node b : buttons) {
            ((Button) b).setOnAction(controller::onButtonClick);
        }
    }
}

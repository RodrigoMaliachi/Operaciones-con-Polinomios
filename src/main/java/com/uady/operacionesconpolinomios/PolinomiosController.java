package com.uady.operacionesconpolinomios;

import Modelo.ListaDoble;
import Modelo.Polinomio;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class PolinomiosController {
    private ListaDoble lista = new ListaDoble();
    private ListaDoble listaDos = new ListaDoble();
    private Polinomio pol1 = new Polinomio();

    @FXML
    private TextField x6;

    @FXML
    private TextField x5;

    @FXML
    private TextField x4;

    @FXML
    private TextField x3;

    @FXML
    private TextField x2;

    @FXML
    private TextField x1;

    @FXML
    private TextField x0;

    @FXML
    private TextField y6;

    @FXML
    private TextField y5;

    @FXML
    private TextField y4;

    @FXML
    private TextField y3;

    @FXML
    private TextField y2;

    @FXML
    private TextField y1;

    @FXML
    private TextField y0;

    public void onButtonClick(ActionEvent actionEvent) {
        pol1.sumarPolinomios(lista, listaDos,7);

    }



}
package com.uady.operacionesconpolinomios;

import Modelo.ListaDoble;
import Modelo.Polinomio;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.controlsfx.control.action.Action;

public class ingresoPolinomiosController {
    private ListaDoble lista = new ListaDoble();
    private ListaDoble listaDos = new ListaDoble();
    private Polinomio pol1 = new Polinomio();

    @FXML
    private TextField TextField1;

    @FXML
    private TextField TextField2;

    @FXML
    private TextField TextField3;

    @FXML
    private TextField TextField4;

    @FXML
    private TextField TextField5;

    @FXML
    private TextField TextField6;

    @FXML
    private TextField TextField7;

    @FXML
    private TextField TextField8;

    @FXML
    private TextField TextField9;

    @FXML
    private TextField TextField10;

    @FXML
    private TextField TextField11;

    @FXML
    private TextField TextField12;

    @FXML
    private TextField TextField13;

    @FXML
    private TextField TextField14;

    public void guardarPoli(ActionEvent actionEvent){
        lista.insertaInicio(new Polinomio(Integer.parseInt(TextField1.getText()),6));
        lista.insertaInicio(new Polinomio(Integer.parseInt(TextField2.getText()),5));
        lista.insertaInicio(new Polinomio(Integer.parseInt(TextField3.getText()),4));
        lista.insertaInicio(new Polinomio(Integer.parseInt(TextField4.getText()),3));
        lista.insertaInicio(new Polinomio(Integer.parseInt(TextField5.getText()),2));
        lista.insertaInicio(new Polinomio(Integer.parseInt(TextField6.getText()),1));
        lista.insertaInicio(new Polinomio(Integer.parseInt(TextField7.getText()),0));

        listaDos.insertaInicio(new Polinomio(Integer.parseInt(TextField8.getText()),6));
        listaDos.insertaInicio(new Polinomio(Integer.parseInt(TextField9.getText()),5));
        listaDos.insertaInicio(new Polinomio(Integer.parseInt(TextField10.getText()),4));
        listaDos.insertaInicio(new Polinomio(Integer.parseInt(TextField11.getText()),3));
        listaDos.insertaInicio(new Polinomio(Integer.parseInt(TextField12.getText()),2));
        listaDos.insertaInicio(new Polinomio(Integer.parseInt(TextField13.getText()),1));
        listaDos.insertaInicio(new Polinomio(Integer.parseInt(TextField14.getText()),0));
    }

    public void onButtonClick(ActionEvent actionEvent) {
        pol1.sumarPolinomios(lista, listaDos,7);

    }

    public void botonResta(ActionEvent actionEvent) {
        pol1.restarPolinomios(lista, listaDos,7);

    }

    public void botonMultiplicar(ActionEvent actionEvent) {
        pol1.multiplicarPolinomios(lista, listaDos);

    }

    public void botonEscalar(ActionEvent actionEvent) {
        pol1.multiplicarEscalarPolinomios(lista, 7);

    }


}
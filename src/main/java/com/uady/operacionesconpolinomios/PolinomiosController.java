package com.uady.operacionesconpolinomios;

import Modelo.ListaDoble;
import Modelo.Polinomio;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.scilab.forge.jlatexmath.TeXConstants;
import org.scilab.forge.jlatexmath.TeXFormula;

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

    public void guardarPoli(ActionEvent actionEvent){
        lista.insertaInicio(new Polinomio(Integer.parseInt(x6.getText()),6));
        lista.insertaInicio(new Polinomio(Integer.parseInt(x5.getText()),5));
        lista.insertaInicio(new Polinomio(Integer.parseInt(x4.getText()),4));
        lista.insertaInicio(new Polinomio(Integer.parseInt(x3.getText()),3));
        lista.insertaInicio(new Polinomio(Integer.parseInt(x2.getText()),2));
        lista.insertaInicio(new Polinomio(Integer.parseInt(x1.getText()),1));
        lista.insertaInicio(new Polinomio(Integer.parseInt(x0.getText()),0));

        listaDos.insertaInicio(new Polinomio(Integer.parseInt(y6.getText()),6));
        listaDos.insertaInicio(new Polinomio(Integer.parseInt(y5.getText()),5));
        listaDos.insertaInicio(new Polinomio(Integer.parseInt(y4.getText()),4));
        listaDos.insertaInicio(new Polinomio(Integer.parseInt(y3.getText()),3));
        listaDos.insertaInicio(new Polinomio(Integer.parseInt(y2.getText()),2));
        listaDos.insertaInicio(new Polinomio(Integer.parseInt(y1.getText()),1));
        listaDos.insertaInicio(new Polinomio(Integer.parseInt(y0.getText()),0));
    }

    public void onButtonClick(ActionEvent actionEvent){
        ListaDoble listaDoble = pol1.sumarPolinomios(lista, listaDos,7);
        TeXFormula formula = new TeXFormula();
        formula.createPNG(TeXConstants.STYLE_DISPLAY,200,"Example.png", java.awt.Color.WHITE, java.awt.Color.BLACK);
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

    public void botonLimpiar(ActionEvent actionEvent) {
       for(int i=0; i< lista.getCantidadElementos(); i++) {
           lista.eliminaInicio();
       }

        for(int i=0; i< listaDos.getCantidadElementos(); i++) {
            listaDos.eliminaInicio();
        }

        x1.setText("0");
        x2.setText("0");
        x3.setText("0");
        x4.setText("0");
        x5.setText("0");
        x6.setText("0");
        x0.setText("0");
        y1.setText("0");
        y2.setText("0");
        y3.setText("0");
        y4.setText("0");
        y5.setText("0");
        y6.setText("0");
        y0.setText("0");

    }
}
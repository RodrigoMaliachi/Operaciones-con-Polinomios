package com.uady.operacionesconpolinomios;

import Modelo.Polinomio;
import Modelo.Termino;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.embed.swing.SwingFXUtils;
import org.scilab.forge.jlatexmath.TeXConstants;
import org.scilab.forge.jlatexmath.TeXFormula;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PolinomiosController {
    public VBox polinomiosView;
    private final Polinomio ecuacionX = new Polinomio( null );
    private final Polinomio ecuacionY = new Polinomio( null );

    //Polinomio 1
    @FXML private TextField x6;
    @FXML private TextField x5;
    @FXML private TextField x4;
    @FXML private TextField x3;
    @FXML private TextField x2;
    @FXML private TextField x1;
    @FXML private TextField x0;

    //Polinomio 2
    @FXML private TextField y6;
    @FXML private TextField y5;
    @FXML private TextField y4;
    @FXML private TextField y3;
    @FXML private TextField y2;
    @FXML private TextField y1;
    @FXML private TextField y0;

    @FXML private ImageView result;

    public void guardarPolinomio(){

        String[] coeficientesX = {
                x6.getText(),
                x5.getText(),
                x4.getText(),
                x3.getText(),
                x2.getText(),
                x1.getText(),
                x0.getText()
        };

        String[] coeficientesY = {
                y6.getText(),
                y5.getText(),
                y4.getText(),
                y3.getText(),
                y2.getText(),
                y1.getText(),
                y0.getText()
        };

        copiarCoeficientes(coeficientesX, ecuacionX );
        copiarCoeficientes(coeficientesY, ecuacionY );
    }

    private void copiarCoeficientes(String[] coeficientes, Polinomio polinomio) {
        for (int i = 0; i < coeficientes.length; i++) {
            String s = coeficientes[i];

            int coeficiente = Integer.parseInt( s.isBlank() ? "0" : s );

            polinomio.insertarTermino( new Termino( coeficiente, 6 - i ) );
        }
    }

    public void onButtonClick(ActionEvent actionEvent){

        ecuacionX.setMayor( null );
        ecuacionY.setMayor( null );
        guardarPolinomio();

        TeXFormula formula = new TeXFormula( Polinomio.sumarPolinomios( ecuacionX, ecuacionY ).toString() );
        BufferedImage image = (BufferedImage) formula.createBufferedImage(TeXConstants.STYLE_DISPLAY,200, Color.BLACK, Color.WHITE);
        result.setImage(SwingFXUtils.toFXImage(image, null));
    }

    public void botonResta(ActionEvent actionEvent) {

        ecuacionX.setMayor( null );
        ecuacionY.setMayor( null );
        guardarPolinomio();

        TeXFormula formula = new TeXFormula( Polinomio.restarPolinomios( ecuacionX, ecuacionY ).toString() );
        BufferedImage image = (BufferedImage) formula.createBufferedImage(TeXConstants.STYLE_DISPLAY,200, Color.BLACK, Color.WHITE);
        result.setImage(SwingFXUtils.toFXImage(image, null));
    }

    public void botonMultiplicar(ActionEvent actionEvent) {

        ecuacionX.setMayor( null );
        ecuacionY.setMayor( null );
        guardarPolinomio();

        TeXFormula formula = new TeXFormula( Polinomio.multiplicarPolinomios( ecuacionX, ecuacionY ).toString() );
        BufferedImage image = (BufferedImage) formula.createBufferedImage(TeXConstants.STYLE_DISPLAY,200, Color.BLACK, Color.WHITE);
        result.setImage(SwingFXUtils.toFXImage(image, null));
    }

    public void botonLimpiar(ActionEvent actionEvent) {

        x1.setText("");
        x2.setText("");
        x3.setText("");
        x4.setText("");
        x5.setText("");
        x6.setText("");
        x0.setText("");
        y1.setText("");
        y2.setText("");
        y3.setText("");
        y4.setText("");
        y5.setText("");
        y6.setText("");
        y0.setText("");
        result.setImage(null);

    }
}
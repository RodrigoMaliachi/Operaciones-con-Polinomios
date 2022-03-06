package com.uady.operacionesconpolinomios;

import Modelo.Polinomio;
import Modelo.Termino;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import org.scilab.forge.jlatexmath.TeXConstants;
import org.scilab.forge.jlatexmath.TeXFormula;

import java.awt.*;
import java.awt.image.BufferedImage;

public class EscalarController {
    @FXML private TextField x6;
    @FXML private TextField x5;
    @FXML private TextField x4;
    @FXML private TextField x3;
    @FXML private TextField x2;
    @FXML private TextField x1;
    @FXML private TextField x0;
    @FXML private TextField escalar;
    @FXML private ImageView result;
    @FXML public VBox escalarView;

    private final Polinomio polinomio = new Polinomio( null );
    private int esc;

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

        esc = Integer.parseInt(escalar.getText());

        copiarCoeficientes(coeficientesX, polinomio);

    }

    private void copiarCoeficientes(String[] coeficientes, Polinomio polinomio) {
        for (int i = 0; i < coeficientes.length; i++) {
            String s = coeficientes[i];

            int coeficiente = Integer.parseInt( s.isBlank() ? "0" : s );

            polinomio.insertarTermino( new Termino( coeficiente, 6 - i ) );
        }
    }

    @FXML
    private void botonMultiplicarEscalar(ActionEvent actionEvent) {

        polinomio.setMayor( null );
        guardarPolinomio();
        polinomio.multiplicarPorEscalar( esc );

        TeXFormula formula = new TeXFormula( polinomio.toString() );
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
        escalar.setText("");

        result.setImage(null);
    }
}

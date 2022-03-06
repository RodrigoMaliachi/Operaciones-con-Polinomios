package com.uady.operacionesconpolinomios;

import Modelo.ListaDoble;
import Modelo.Polinomio;
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

    public VBox escalarView;
    private ListaDoble lista = new ListaDoble();
    private Polinomio pol1 = new Polinomio();
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

        copiarCoeficientes(coeficientesX, lista);

    }

    private void copiarCoeficientes(String[] coeficientes, ListaDoble lista) {
        for (int i = 0; i < coeficientes.length; i++) {
            String s = coeficientes[i];

            int coeficiente = Integer.parseInt( s.isBlank() ? "0" : s );

            lista.insertarInicio(new Polinomio( coeficiente, 6-i ));
        }
    }

    @FXML
    private void botonMultiplicarEscalar(ActionEvent actionEvent){
        guardarPolinomio();
        ListaDoble resultado = pol1.multiplicarEscalarPolinomios(lista, esc);
        TeXFormula formula = new TeXFormula(resultado.imprimir());
        BufferedImage image = (BufferedImage) formula.createBufferedImage(TeXConstants.STYLE_DISPLAY,200, Color.BLACK, Color.WHITE);
        result.setImage(SwingFXUtils.toFXImage(image, null));
    }

    public void botonLimpiar(ActionEvent actionEvent) {
        for(int i=0; i< lista.getCantidadElementos(); i++) {
            lista.eliminarInicio();
        }

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

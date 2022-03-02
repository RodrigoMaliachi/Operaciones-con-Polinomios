package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Jonatan, Natali, Rodrigro, Angélica
 */

public class Polinomio {
    private int coeficiente;
    private int exponente;

    public Polinomio(){
        this.coeficiente=0;
        this.exponente=0;
    }

    public Polinomio(int coeficiente, int exponente){
        this.coeficiente = coeficiente;
        this.exponente = exponente;
    }

    public int getCoeficiente() {
        return coeficiente;
    }

    public void setCoeficiente(int coeficiente) {
        this.coeficiente = coeficiente;
    }

    public int getExponente() {
        return exponente;
    }

    public void setExponente(int exponente) {
        this.exponente = exponente;
    }
    
    @Override
    public String toString(){
        if(exponente == 0){
            return coeficiente+"";
        }else{
            return coeficiente+"x^{"+exponente+"}";
        }
        
    }

    public ListaDoble sumarPolinomios(ListaDoble polinomioUno, ListaDoble polinomioDos,int n){
        int [] coeficientePolinomioUno = new int [n];
        int [] coeficientePolinomioDos = new int [n];
        ListaDoble auxLista = new ListaDoble();
        
        for(int i= 0; i<n ;i++){
            coeficientePolinomioDos[i] = 0;
            coeficientePolinomioUno[i] = 0;
        }
        
        NodoDoble actual = polinomioUno.inicio;
        while(actual != null){
            coeficientePolinomioUno[actual.getDato().getExponente()] = actual.getDato().getCoeficiente();
            actual = actual.siguiente;
        }
        actual = polinomioDos.inicio;
        while(actual != null){
            coeficientePolinomioDos[actual.getDato().getExponente()] = actual.getDato().getCoeficiente();
            actual = actual.siguiente;
        }
        
        for(int i= 0; i<n ;i++){
            int acumulador;
            acumulador = coeficientePolinomioDos[i] + coeficientePolinomioUno[i];
            if(acumulador != 0){
                auxLista.insertaInicio(new Polinomio(acumulador,i));
            }
        }

        return auxLista.imprimir();
    }

    public ListaDoble restarPolinomios(ListaDoble polinomioUno, ListaDoble polinomioDos,int n){
        int [] coeficientePolinomioUno = new int [n];
        int [] coeficientePolinomioDos = new int [n];
        ListaDoble auxLista = new ListaDoble();

        for(int i= 0; i<n ;i++){
            coeficientePolinomioDos[i] = 0;
            coeficientePolinomioUno[i] = 0;
        }

        NodoDoble actual = polinomioUno.inicio;
        while(actual != null){
            coeficientePolinomioUno[actual.getDato().getExponente()] = actual.getDato().getCoeficiente();
            actual = actual.siguiente;
        }
        actual = polinomioDos.inicio;
        while(actual != null){
            coeficientePolinomioDos[actual.getDato().getExponente()] = actual.getDato().getCoeficiente();
            actual = actual.siguiente;
        }

        for(int i= 0; i<n ;i++){
            int acumulador;
            acumulador = -1*(coeficientePolinomioDos[i]) + coeficientePolinomioUno[i];
            if(acumulador != 0){
                auxLista.insertaInicio(new Polinomio(acumulador,i));
            }
        }

        auxLista.imprimir();
        return auxLista;
    }

    public void multiplicarPolinomios(ListaDoble polinomioUno, ListaDoble polinomioDos){
        NodoDoble poliUno, poliDos;
        ListaDoble pol1 = new ListaDoble();
        
        poliUno = polinomioUno.inicio;
        while(poliUno != null){
            poliDos = polinomioDos.inicio;
            while(poliDos != null){
                int coeficien = poliUno.getDato().getCoeficiente()*poliDos.getDato().getCoeficiente();
                int exponen = poliUno.getDato().getExponente()+poliDos.getDato().getExponente();
                pol1.insertaInicio(new Polinomio(coeficien,exponen));
                poliDos = poliDos.siguiente;
            }
            poliUno = poliUno.siguiente;
        }
        pol1.ordenarLista();
        pol1.imprimir();
        System.out.println("\nSimplificado-------------------------------");
        SimplificarPolinomio(pol1,13);
    }

    public void multiplicarEscalarPolinomios(ListaDoble polinomioUno, int escalar){
        NodoDoble poliUno;
        ListaDoble pol1 = new ListaDoble();

        poliUno = polinomioUno.inicio;
        while(poliUno != null){
              int coeficien = poliUno.getDato().getCoeficiente()*escalar;
              int exponen = poliUno.getDato().getExponente();
              pol1.insertaInicio(new Polinomio(coeficien,exponen));
            poliUno = poliUno.siguiente;
        }
        pol1.imprimir();

    }

    
    public void SimplificarPolinomio(ListaDoble polinomioUno,int n){
         NodoDoble poliUno;
         ListaDoble pol1 = new ListaDoble();
         int [] coeficientePolUno = new int [n];
         
         for(int i= 0; i<n ;i++){
            coeficientePolUno[i] = 0;
         }
         
        poliUno = polinomioUno.inicio;
        while(poliUno != null){
            coeficientePolUno[poliUno.getDato().getExponente()] = coeficientePolUno[poliUno.getDato().getExponente()] + poliUno.getDato().getCoeficiente();
            poliUno = poliUno.siguiente;
        }
        
        for(int i= 0; i<n ;i++){
            if(coeficientePolUno[i] != 0){
                pol1.insertaInicio(new Polinomio(coeficientePolUno[i],i));
            }
        }  
         
         pol1.imprimir();
    }
    
    public boolean verificar(ListaDoble polinomioUno,int x){
        boolean ver = false;
        NodoDoble actual = polinomioUno.inicio;
        while(actual != null){
            if(actual.getDato().exponente == x){
                ver = true;
                actual = null;
            }else{
                actual = actual.getSiguiente();
            }
        }
        return ver;
    }

}
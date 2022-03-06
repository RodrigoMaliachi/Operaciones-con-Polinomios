package Modelo;

@SuppressWarnings( "unused" )
public class Termino extends NodoDoble implements Comparable<Termino> {
    protected int coeficiente;
    protected int exponente;
    protected Termino siguiente;
    protected Termino anterior;

    public Termino(){}

    public Termino( Termino siguiente, Termino anterior ) {
        this.siguiente = siguiente;
        this.anterior = anterior;
    }

    public Termino( int coeficiente, int exponente ) {
        this.coeficiente = coeficiente;
        this.exponente = exponente;
    }

    public boolean tieneSiguiente() {
        return siguiente != null;
    }

    public int getCoeficiente() {
        return coeficiente;
    }

    public void setCoeficiente( int coeficiente ) {
        this.coeficiente = coeficiente;
    }

    public int getExponente() {
        return exponente;
    }

    public void setExponente( int exponente ) {
        this.exponente = exponente;
    }

    @Override
    public Termino getSiguiente() {
        return siguiente;
    }

    public void setSiguiente( Termino siguiente ) {
        this.siguiente = siguiente;
    }

    @Override
    public Termino getAnterior() {
        return anterior;
    }

    public void setAnterior( Termino anterior ) {
        this.anterior = anterior;
    }

    public void copyValues( Termino termino ) {
        coeficiente = termino.coeficiente;
        exponente = termino.exponente;
        siguiente = termino.siguiente;
        anterior = termino.anterior;
    }

    @Override
    public int compareTo( Termino o ) {
        return exponente - o.exponente;
    }
}

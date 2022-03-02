package Modelo;

/**
 *
 * @author Jonatan, Natali, Rodrigro, Angélica
 */
public class Nodo {
    protected Polinomio dato;
    protected Nodo siguiente;
    
    public Nodo(){}
    
    public Nodo(Polinomio dato){
        this(dato, null);
    }
    
    public Nodo(Polinomio dato,Nodo siguiente){
        this.dato = dato;
        this.siguiente = siguiente;
    }

    public Polinomio getDato(){
        return dato;
    }
    
    public void setDato(Polinomio dato){
        this.dato = dato;
    }
    
    public Nodo getSiguiente(){
        return siguiente;
    }
    
    public void setSiguiente(Nodo siguiente){
        this.siguiente = siguiente;
    }
    
}

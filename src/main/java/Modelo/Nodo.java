package Modelo;

/**
 *
 * @author Jonatan, Natali, Rodrigro, Angélica
 */
public class Nodo {
    protected Polinomio dato;
    protected Nodo siguiente;
    
    public Nodo(){
        
    }
    
    public Nodo(Polinomio dato){
        this.dato = dato;
        this.siguiente = null;
    }
    
    public Nodo(Polinomio dato,Nodo siguiente){
        this.dato = dato;
        this.siguiente = siguiente;
    }
    
    public Polinomio getDato(){
        return this.dato;
    }
    
    public void setDato(Polinomio dato){
        this.dato = dato;
    }
    
    public Nodo getSiguiente(){
        return this.siguiente;
    }
    
    public void setSiguiente(Nodo siguiente){
        this.siguiente = siguiente;
    }
    
}

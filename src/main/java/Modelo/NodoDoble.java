package Modelo;

/**
 *
 * @author Jonatan, Natali, Rodrigro, Angélica
 */
public class NodoDoble extends Nodo {
    protected NodoDoble siguiente;
    protected NodoDoble anterior;
    
    public NodoDoble(Polinomio dato, NodoDoble siguiente, NodoDoble anteiror){
        this.dato = dato;
        this.siguiente = siguiente;
        this.anterior = anterior;
    }
    
    public NodoDoble(Polinomio dato){
        this.dato = dato;
        this.siguiente = null;
        this.anterior = null;
    }
    
    public NodoDoble(){
        
    }

    public NodoDoble getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoDoble siguiente) {
        this.siguiente = siguiente;
    }

    public NodoDoble getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoDoble anterior) {
        this.anterior = anterior;
    }
    
}

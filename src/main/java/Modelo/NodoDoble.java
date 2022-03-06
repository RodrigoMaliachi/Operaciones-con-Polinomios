package Modelo;

/**
 *
 * @author Jonatan, Natali, Rodrigro, Angélica
 */
@SuppressWarnings( "unused" )
public class NodoDoble extends Nodo {
    protected NodoDoble siguiente;
    protected NodoDoble anterior;

    public NodoDoble(){ this(null);}

    public NodoDoble(Object dato){
        this(dato, null, null);
    }

    public NodoDoble(Object dato, NodoDoble siguiente, NodoDoble anterior){
        this.dato = dato;
        this.siguiente = siguiente;
        this.anterior = anterior;
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

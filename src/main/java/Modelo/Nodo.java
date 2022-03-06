package Modelo;

/**
 *
 * @author Jonatan, Natali, Rodrigro, Angélica
 */
@SuppressWarnings( "unused" )
public class Nodo {
    protected Object dato;
    protected Nodo siguiente;
    
    public Nodo(){}
    
    public Nodo(Object dato){
        this(dato, null);
    }
    
    public Nodo(Object dato,Nodo siguiente){
        this.dato = dato;
        this.siguiente = siguiente;
    }

    public Object getDato(){
        return dato;
    }
    
    public void setDato(Object dato){
        this.dato = dato;
    }
    
    public Nodo getSiguiente(){
        return siguiente;
    }
    
    public void setSiguiente(Nodo siguiente){
        this.siguiente = siguiente;
    }
    
}

package Modelo;

/**
 *
 * @author Jonatan, Natali, Rodrigro, Angélica
 */
@SuppressWarnings( "unused" )
public abstract class ListaD extends Lista {
    protected NodoDoble inicio;
    protected NodoDoble ultimo;
    
    @Override
    public boolean vacio(){
        return inicio == null;
    }
    
    @Override
    public String imprimir(){
        StringBuilder impresion = new StringBuilder();
        Nodo actual = inicio;
        while(actual != null){
            if (actual == ultimo)
                impresion.append(actual.getDato());
            else
                impresion.append(actual.getDato()).append(" -> ");

            actual = actual.getSiguiente();
        }
        return impresion.toString();
    }
    
    
    public void imprimirAlReves(){
        NodoDoble actual = ultimo;
        while (actual!=null){
            if (actual == inicio)
                System.out.println(actual.getDato());
            else
                System.out.println(actual.getDato()+" -> ");

            actual = actual.getAnterior();
        }
    }

    @Override
    public NodoDoble getInicio() {
        return inicio;
    }

    public void setInicio( NodoDoble inicio ) {
        this.inicio = inicio;
    }

    public NodoDoble getUltimo() {
        return ultimo;
    }

    public void setUltimo( NodoDoble ultimo ) {
        this.ultimo = ultimo;
    }
}
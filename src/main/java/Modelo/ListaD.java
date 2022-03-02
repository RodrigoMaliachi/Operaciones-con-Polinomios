package Modelo;

/**
 *
 * @author Jonatan, Natali, Rodrigro, Angélica
 */
public abstract class ListaD extends Listaa{
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
                impresion.append(actual.getDato()).append("+");

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
                System.out.println(actual.getDato()+"->");

            actual = actual.getAnterior();
        }
    }
    
}

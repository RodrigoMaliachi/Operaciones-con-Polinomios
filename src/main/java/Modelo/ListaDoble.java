package Modelo;

/**
 *
 * @author Jonatan, Natali, Rodrigro, Angélica
 */
@SuppressWarnings( "unused" )
public class ListaDoble extends ListaD{
    
    protected int longitud;
    
    @Override
    public void insertarInicio(Object dato) {
        if (vacio())
            inicio = ultimo = new NodoDoble(dato);
        else {
            NodoDoble nuevo = new NodoDoble(dato,inicio,null);
            inicio.setAnterior(nuevo);
            inicio = nuevo;
        }
        longitud++;
    }

    @Override
    public void insertarFinal(Object dato) {
        if (vacio())
            inicio = ultimo = new NodoDoble(dato);
        else {
            NodoDoble nuevo = new NodoDoble(dato,null,ultimo);
            ultimo.setSiguiente(nuevo);
            ultimo = nuevo;
        }
        longitud++;
    }
    
    public void insertaAntes(Object dato, int posicion){

        if ( posicion < 0 || posicion >= longitud )
            return;

        if ( posicion == 0 ) {
            insertarInicio( dato );
            return;
        }

        NodoDoble actual = inicio.siguiente;

        while ( --posicion > 0 )
            actual = actual.siguiente;

        if ( actual != null ) {
            NodoDoble anterior = actual.anterior;
            anterior.siguiente = new NodoDoble( dato, actual, anterior );
            actual.anterior = anterior.siguiente;
            longitud++;
        }
    }
    
    public void insertarDespues(Object dato, int posicion){

        if ( posicion < 0 || posicion >= longitud )
            return;

        if ( posicion == longitud - 1 ) {
            insertarFinal( dato );
            return;
        }

        NodoDoble actual = inicio;

        while ( posicion-- > 0 )
            actual = actual.siguiente;

        if ( actual != null ) {
            NodoDoble siguiente = actual.siguiente;
            siguiente.anterior = new NodoDoble( dato, siguiente, actual );
            actual.siguiente = siguiente.anterior;
            longitud++;
        }
    }
    
    @Override
    public Object eliminarInicio() {

        if ( vacio() ) {
            System.out.println( "La lista está vacía" );
            return null;
        }

        Object eliminado = inicio.getDato();

        if ( inicio == ultimo )
             inicio = ultimo = null;
        else {
             inicio = inicio.siguiente;
             inicio.anterior = null;
        }

        longitud--;

        return eliminado;
    }

    @Override
    public Object eliminarFinal() {

         if ( vacio() ) {
             System.out.println( "La lista está vacía" );
             return null;
         }

         Object eliminado = inicio.getDato();

         if ( inicio == ultimo )
             inicio = ultimo = null;
         else {
             ultimo = ultimo.anterior;
             ultimo.siguiente = null;
         }

         longitud--;

         return eliminado;
    }

    public int getLongitud() {
        return longitud;
    }
}
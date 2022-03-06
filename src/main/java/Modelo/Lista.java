package Modelo;

/**
 *
 * @author Jonatan, Natali, Rodrigro, Angélica
 */
@SuppressWarnings( "unused" )
public abstract class Lista {
    protected Nodo inicio;
    protected String nombre;
    
    public Lista(){
        this("lista");
    }
    
    public Lista( String nombre){
        this( null, nombre );
    }

    public Lista( Nodo inicio ){
        this.inicio = inicio;
        nombre = "Lista";
    }

    public Lista( Nodo inicio, String nombre ) {
        this.inicio = inicio;
        this.nombre = nombre;
    }

    public boolean vacio(){
        return inicio == null;
    }
    
    public String imprimir(){
        StringBuilder impresion = new StringBuilder();
        Nodo actual = inicio;
        while (actual != null){
            if (actual.siguiente == null)
                impresion.append(actual.getDato());
            else
                impresion.append(actual.getDato()).append(" -> ");

            actual = actual.getSiguiente();
        }
        return impresion.toString();
    }
    
    public abstract void insertarInicio(Object dato);
    public abstract void insertarFinal (Object dato);
    public abstract Object eliminarInicio();
    public abstract Object eliminarFinal();
    
    public Nodo getInicio(){
        return this.inicio;
    }
    
    public void setInicio(Nodo inicio){
        this.inicio = inicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}

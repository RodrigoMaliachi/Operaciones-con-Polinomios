package Modelo;

/**
 *
 * @author Jonatan, Natali, Rodrigro, Angélica
 */
public abstract class Listaa {
    protected Nodo inicio;
    protected Nodo ultimo;
    protected String nombre;
    
    public Listaa(){
        this("lista");
    }
    
    public Listaa(String nombre){
        this.nombre = nombre;
        this.inicio = this.ultimo = null;
    }
    
    public boolean vacio(){
        return inicio == null;
    }
    //
    public String imprimir(){
        StringBuilder impresion = new StringBuilder();
        Nodo actual = inicio;
        while (actual != null){
            if (actual == ultimo)
                impresion.append(actual.getDato());
            else
                impresion.append(actual.getDato()).append("+");

            actual = actual.getSiguiente();
        }
        return impresion.toString();
    }
    
    public abstract void insertarInicio(Polinomio dato);
    public abstract void insertarFinal (Polinomio dato);
    public abstract Object eliminarInicio();
    public abstract Object eliminarFinal();
    public abstract void ordenarLista();
    
    public Nodo getInicio(){
        return this.inicio;
    }
    
    public void setInicio(Nodo inicio){
        this.inicio = inicio;
    }

    public Nodo getUltimo() {
        return ultimo;
    }

    public void setUltimo(Nodo ultimo) {
        this.ultimo = ultimo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}

package Modelo;

/**
 *
 * @author Jonatan, Natali, Rodrigro, Angélica
 */
public abstract class Listaa {
    protected  Nodo inicio;
    protected  Nodo ultimo;
    protected String nombre;
    
    public Listaa(){
        //this.nombre = lista;
        this("lista");
    }
    
    public Listaa(String nombre){
        this.nombre = nombre;
        this.inicio = this.ultimo = null;
    }
    
    public boolean vacio(){
        return inicio == null;
    }
    
    public void imprimir(){
        Nodo actual = inicio;
        while(actual != null){
            if(actual==ultimo){
                System.out.println(actual.getDato());
            }else{
                System.out.print(actual.getDato()+"->"); 
            }
            actual = actual.getSiguiente();
        }
    }
    
    public abstract void insertaInicio (Polinomio dato);
    public abstract void insertarFinal (Polinomio dato);
    public abstract Object eliminaInicio();
    public abstract Object eliminaFinal();
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

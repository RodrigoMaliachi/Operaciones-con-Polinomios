package Modelo;

/**
 *
 * @author Jonatan, Natali, Rodrigro, Angélica
 */
public class ListaDoble extends ListaD{
    private int cantidadElementos;

    
    //knffjnwefew
    public int getCantidadElementos() {
        return cantidadElementos;
    }

    public void setCantidadElementos(int cantidadElementos) {
        this.cantidadElementos = cantidadElementos;
    }
    
    @Override
    public void insertaInicio(Polinomio dato) {
        if(vacio()){
            inicio = ultimo = new NodoDoble(dato);
            cantidadElementos++;
        }else{
            NodoDoble nuevo = new NodoDoble(dato,inicio,null);
            inicio.setAnterior(nuevo);
            inicio = nuevo;
            cantidadElementos++;
        }
    }

    @Override
    public void insertarFinal(Polinomio dato) {
        if(vacio()){
            inicio = ultimo = new NodoDoble(dato);
        }else{
            NodoDoble nuevo = new NodoDoble(dato,null,ultimo);
            ultimo.setSiguiente(nuevo);
            ultimo = nuevo;
        }
    }
    
    public void InsertaAntes(Polinomio dato, int posicion){
        NodoDoble actual = inicio;
        int i=0;
        while(actual != null && i != posicion){
            actual = actual.siguiente;
            i++;
        }
        NodoDoble nuevo = new NodoDoble(dato,actual,actual.getAnterior());
        NodoDoble tempo = actual.getAnterior();
        actual.anterior = nuevo;
        tempo.setSiguiente(nuevo);
    }
    
    public void InsertaDespues(Polinomio dato,int posicion){
        NodoDoble actual = inicio;
        int i=0;
        while(actual != null && i != posicion){ 
            actual = actual.siguiente;
            i++;
        }
        NodoDoble nuevo = new NodoDoble(dato,actual.siguiente,actual);
        NodoDoble tempo = actual.siguiente;
        actual.siguiente = nuevo;
        tempo.setAnterior(nuevo);
    }
    
    @Override
    public Object eliminaInicio() {
        Object eliminado = null;
        if(vacio()){
             System.out.println("La lista está vacía");
         }else{
             if(inicio == ultimo){
                 eliminado = inicio.getDato();
                 inicio = ultimo = null;
             }else{
                 eliminado = inicio.getDato();
                 inicio = inicio.getSiguiente();
                 inicio.setAnterior(null);
             }
         }
        return eliminado;
    }

    @Override
    public Object eliminaFinal() {
         Object eliminado = null;
         if(vacio()){
             System.out.println("La lista está vacía");
         }else{
             if(inicio == ultimo){
                 eliminado = inicio.getDato();
                 inicio = ultimo = null;
             }else{
                 eliminado = ultimo.getDato();
                 ultimo = ultimo.getAnterior();
                 ultimo.setSiguiente(null);
             }
         }
         return eliminado;
    }
    
    @Override
    public void ordenarLista() {
        Polinomio auxDato;
        if(vacio()){
            System.out.println("La lista está vacía");
        }else{
            if(inicio == ultimo){
                System.out.println("La lista está ordenada");
            }else{
                NodoDoble actual = inicio;
                while(actual != null){
                    NodoDoble p = actual.getSiguiente();
                    while(p != null){
                        if(actual.getDato().getExponente() < p.getDato().getExponente()){
                            auxDato = p.getDato();
                            p.setDato(actual.getDato());
                            actual.setDato(auxDato);
                        }
                        p = p.siguiente;
                    }
                    actual = actual.siguiente;
                }
            }
        }
    }
    
    public static void main(String[] args){
        ListaDoble lista = new ListaDoble();
        lista.insertaInicio(new Polinomio(6,2));
        lista.insertaInicio(new Polinomio(9,4));
        lista.insertaInicio(new Polinomio(-3,5));
        lista.insertaInicio(new Polinomio(2,6));
        lista.insertaInicio(new Polinomio(4,1));
        lista.insertaInicio(new Polinomio(15,0));
        lista.insertaInicio(new Polinomio(-25,3));
        lista.ordenarLista();

        ListaDoble lista2 = new ListaDoble();
        lista2.insertaInicio(new Polinomio(3,2));
        lista2.insertaInicio(new Polinomio(2,6));
        lista2.insertaInicio(new Polinomio(4,3));
        lista2.insertaInicio(new Polinomio(4,5));
        lista2.insertaInicio(new Polinomio(4,0));
        lista2.insertaInicio(new Polinomio(9,1));
        lista2.insertaInicio(new Polinomio(10,4));
        lista2.ordenarLista();
        System.out.println("pol1-----------------------------------");
        lista.imprimir();
        System.out.println("\nPol2-----------------------------------");
        lista2.imprimir();
        System.out.println("\nSuma-----------------------------------");
        Polinomio pol1 = new Polinomio();
        pol1.sumarPolinomios(lista, lista2,7);
        System.out.println("\nMultiplicacion-----------------------------------");
        pol1.multiplicarPolinomios(lista, lista2);
        
        
    }


    
}

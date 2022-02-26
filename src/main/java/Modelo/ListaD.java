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
    public void imprimir(){
        //Inicio hacia adelante
        super.setInicio(inicio);
        super.imprimir();
    }
    
    
    public void imprimirAlReves(){
        NodoDoble actual = ultimo;
        while(actual!=null){
            if(actual == inicio){
                System.out.println(actual.getDato());
            }else{
                System.out.println(actual.getDato()+"->");
            }
            actual = actual.getAnterior();
        }
    }
    
}

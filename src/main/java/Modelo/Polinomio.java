package Modelo;

/**
 *
 * @author Jonatan, Natali, Rodrigro, Angélica
 */
@SuppressWarnings( "unused" )
public class Polinomio extends ListaDoble {
    private Termino mayor;

    public Polinomio( Termino mayor ) {
        this.mayor = mayor;
    }

    public void insertarTermino( Termino termino ) {

        if ( termino.coeficiente == 0 )
            return;

        if ( vacio() ) {
            mayor = termino;
            return;
        }

        Termino actual = mayor;
        Termino anterior = null;

        while ( actual != null && actual.exponente > termino.exponente ) {
            anterior = actual;
            actual = actual.siguiente;
        }

        if ( actual != null ) {
            if ( actual.exponente == termino.exponente )
                actual.coeficiente = termino.coeficiente;
            else {
                termino.siguiente = actual;
                actual.anterior = termino;

                if ( anterior != null ) {
                    termino.anterior = anterior;
                    anterior.siguiente = termino;
                }
            }
        } else if ( anterior != null ){
            anterior.siguiente = termino;
        }
    }

    @Override
    public boolean vacio() {
        return mayor == null;
    }

    @Override
    public String toString() {

        StringBuilder s = new StringBuilder();

        Termino actual = mayor;

        do {

            if ( actual.coeficiente == 0 ) {
                actual = actual.siguiente;
                continue;
            }

            if ( actual.coeficiente < 0 || actual == mayor )
                s.append( actual.coeficiente );
            else
                s.append( "+" ).append( actual.coeficiente );

            if ( actual.exponente > 0 )
                s.append( "x" );

            if ( actual.exponente > 1 )
                s.append( "^" ).append( actual.exponente );

            actual = actual.siguiente;
        } while ( actual != null );

        return s.toString();
    }

    public void sumarPolinomio( Polinomio polinomio) {
        mayor = sumarPolinomios( this, polinomio ).mayor;
    }

    public void restarPolinomio( Polinomio polinomio ) {
        mayor = restarPolinomios( this, polinomio ).mayor;
    }

    public void multiplicarPorPolinomio( Polinomio polinomio ) {
        mayor = multiplicarPolinomios( this, polinomio ).mayor;
    }

    public void multiplicarPorEscalar( int escalar ) {
        mayor = multiplicarPolinomioPorEscalar( this, escalar ).mayor;
    }

    public static Polinomio sumarPolinomios( Polinomio ecuacion1, Polinomio ecuacion2 ) {

        Termino termino1 = ecuacion1.mayor;
        Termino termino2 = ecuacion2.mayor;

        Termino actual = new Termino();
        Polinomio resultado = new Polinomio( actual );

        while ( termino1 != null && termino2 != null ) {

            int compare = termino1.compareTo( termino2 );

            if ( compare == 0 ) {

                actual.coeficiente = termino1.coeficiente + termino2.coeficiente;
                actual.exponente = termino1.exponente;

                termino1 = termino1.siguiente;
                termino2 = termino2.siguiente;

            } else if ( compare > 0 ) {

                actual.coeficiente = termino1.coeficiente;
                actual.exponente = termino1.exponente;

                termino1 = termino1.siguiente;

            } else {

                actual.coeficiente = termino2.coeficiente;
                actual.exponente = termino2.exponente;

                termino2 = termino2.siguiente;

            }

            actual.siguiente = new Termino( null, actual );
            actual = actual.siguiente;

        }

        if ( termino1 != null )
            actual.copyValues( termino1 );
        else if ( termino2 != null )
            actual.copyValues( termino2 );
        else {
            Termino temp = actual.anterior;
            temp.siguiente = null;
        }

        System.out.println( resultado );
        return resultado;
    }

    public static Polinomio restarPolinomios( Polinomio ecuacion1, Polinomio ecuacion2 ) {
        return sumarPolinomios( ecuacion1, multiplicarPolinomioPorEscalar( ecuacion2, -1 ) );
    }

    public static Polinomio multiplicarPolinomios( Polinomio ecuacion1, Polinomio ecuacion2 ) {

        Polinomio resultado = new Polinomio( null );

        Termino actual1 = ecuacion1.mayor;
        Termino actual2 = ecuacion2.mayor;

        while ( actual1 != null && actual2 != null) {

            Termino termino = new Termino();
            Polinomio sumando = new Polinomio( termino );

            while ( actual2 != null ) {
                
                termino.coeficiente = actual1.coeficiente * actual2.coeficiente;
                termino.exponente = actual1.exponente + actual2.exponente;

                actual2 = actual2.siguiente;

                termino.siguiente = new Termino( null, termino);
                termino = termino.siguiente;

            }

            resultado.sumarPolinomio( sumando );

            actual1 = actual1.siguiente;
            actual2 = ecuacion2.mayor;
        }

        return resultado;
    }
//w
    public static Polinomio multiplicarPolinomioPorEscalar( Polinomio polinomio, int escalar ) {

        Termino actual = polinomio.mayor;

        while ( actual != null ) {
            actual.coeficiente *= escalar;
            actual = ( actual.siguiente );
        }

        return polinomio;
    }

    public Termino getMayor() {
        return mayor;
    }

    public void setMayor( Termino mayor ) {
        this.mayor = mayor;
    }
}
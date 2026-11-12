// Practica en clase

public class Cotizador{
public static void main (String []args) {

    int precioCliente1 = 12899;
String cliente1 = "Robbie Valentino";
char clasificacionCliente1 = 'E' ;

double tasaAnual = 0.15;

double plazoCliente1 = 21.0 / 12;

double interes = (precioCliente1 * (tasaAnual) * plazoCliente1);

double total = precioCliente1 + interes;

double  mensualidad = total / 21;
System.err.println( "Hola," + cliente1 );
System.err.println("Tú clasificación es " + clasificacionCliente1);
System.err.println("Tú total a pagar es:" + total);
System.err.println("Tus mensualidades son de:" + mensualidad);

}
}
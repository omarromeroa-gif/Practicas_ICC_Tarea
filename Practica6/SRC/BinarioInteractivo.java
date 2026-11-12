import java.util.Scanner;

public class BinarioInteractivo {
    public static void main(String[] args) {

        // Scanner que permite meter datos del usuario
        Scanner entrada = new Scanner(System.in);

        // variable para guardar la respuesta 
        char respuesta;

        // Ayuda a que vuelva a empezar si el usuario escribe s o S
  do {
        String binario = "";
      int numero = 0;

     boolean numeroInvalido = true;

   // Agregamos un while para que el usuario ingrese un numero valido
      while (numeroInvalido) {

       System.out.print("Convertir a Binario \n Ingresa un número entero: ");
            if (entrada.hasNextInt()) {
                numero = entrada.nextInt();
            // verificamos si el numero es mayor o igual a cero
             if (numero >= 0) {
             numeroInvalido = false;
        // si cumple la condicion se sale del while
             } else {
                        System.out.println("El número no puede ser negativo");
                    }
                } else {
         // si no es un numero entero se le pide al usuario que ingrese un numero
          entrada.next();
            System.out.println("Eso no es un número entero");
                }
            }

            // guardamos el numero original para poder imprimirlo al final
            int original = numero;

            // si el numero es 0 el binario es 0
            if (numero == 0) {
                binario = "0";
            }

            while (numero > 0) {
                int residuo = numero % 2;
                binario = residuo + binario;
                numero = numero / 2;
            }
            System.out.println("El número " + original + " en binario es: " + binario);

            // preguntamos si quiere convertir otro numero
            System.out.print("Quieres convertir otro número? (s/S para continuar): ");
            respuesta = entrada.next().charAt(0);

        } while (respuesta == 's' || respuesta == 'S');

        System.out.println("Chao Bambino");
    }
}
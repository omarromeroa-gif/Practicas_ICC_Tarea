import java.util.Scanner;

public class CabanaDelMisterio {
    public static void main(String[] args) {

        // Scanner que permite meter datos del usuario
        Scanner entrada = new Scanner(System.in);

        // Datos cliente
        String nombreCliente;
        char clasificacionCliente = 'E';
        String tipoCliente = "Estándar";

        // Datos prestamo
        double precio = 0;
        double tasaAnual = 0;
        int plazoMeses = 0;

        // Variable para volver a pedir los datos hasta que sean validos
        boolean datoInvalido;

        System.out.println("\n¿¿ Registro de clientes de La Cabaña del Misterio ??\n");

        // Nombre del cliente
        System.out.print("Ingresa el nombre completo del cliente: ");
        nombreCliente = entrada.nextLine();

        // Validación del tipo de cliente
        datoInvalido = true;
        while (datoInvalido) {
            System.out.print("Ingresa el tipo de cliente (P, E o R): ");
            char letra = entrada.next().charAt(0);
            if (letra == 'P' || letra == 'E' || letra == 'R') {
                clasificacionCliente = letra;
                datoInvalido = false;
            } else {
                System.out.println("Error: El tipo de cliente debe ser P= Preferente, E= Estándar o R= Riesgoso  .");
            }
        }

        // Validación del capital
        datoInvalido = true;
        while (datoInvalido) {
            System.out.print("Ingresa el capital del préstamo: ");
            if (entrada.hasNextDouble()) {
                precio = entrada.nextDouble();
                if (precio > 0) {
                    datoInvalido = false;
                } else {
                    System.out.println("Error: El capital debe ser mayor a cero.");
                }
            } else {
                entrada.next();
                System.out.println("Error: El capital debe ser un número.");
            }
        }

        // Validación de la tasa anual
        datoInvalido = true;
        while (datoInvalido) {
            System.out.print("Ingresa la tasa anual base: ");
            if (entrada.hasNextDouble()) {
                tasaAnual = entrada.nextDouble();
                if (tasaAnual >= 0) {
                    datoInvalido = false;
                } else {
                    System.out.println("Error: La tasa no puede ser negativa.");
                }
            } else {
                entrada.next();
                System.out.println("Error: La tasa debe ser un número.");
            }
        }

        // Validación del plazo
        datoInvalido = true;
        while (datoInvalido) {
            System.out.print("Ingresa el plazo en meses: ");
            if (entrada.hasNextInt()) {
                plazoMeses = entrada.nextInt();
                if (plazoMeses > 0) {
                    datoInvalido = false;
                } else {
                    System.out.println("Error: El plazo debe ser mayor a cero.");
                }
            } else {
                entrada.next();
                System.out.println("Error: El plazo debe ser un número entero.");
            }
        }

        // Ajuste de la tasa según la clasificación del cliente
        if (clasificacionCliente == 'P') {
            tasaAnual -= 2;
            tipoCliente = "Preferente";
        } else if (clasificacionCliente == 'R') {
            tasaAnual += 3;
            tipoCliente = "Riesgoso";
        }

        // Contadores del menú
        int operaciones = 0;
        int errores = 0;
        boolean seguir = true;
        String motivo = "";

        // While del menú, se repite hasta que el programa termine
        while (seguir) {

            System.out.println("\n$$ Sistema de prestamos de la Cabaña del misterio $$");
            System.out.println("> Las operaciones disponibles son");
            System.out.println("1) Cotizar con interes simple.");
            System.out.println("2) Cotizar con interes compuesto.");
            System.out.println("3) Comparar interes simple y compuesto.");
            System.out.println("4) Cambiar el capital del prestamo.");
            System.out.println("0) Salir.");
            System.out.print("> Por favor, elige una opción: ");

            if (entrada.hasNextInt()) {
                int opcion = entrada.nextInt();

                if (opcion == 0) {
                    motivo = "El usuario eligió la opción 0";
                    seguir = false;

                } else if (opcion == 1) {
                    // Cálculo Interés Simple
                    double plazoAnios = plazoMeses / 12.0;
                    double interes = precio * (tasaAnual / 100) * plazoAnios;
                    double totalAPagar = precio + interes;

                    System.out.println("\n### Opción 1 : Cotización de interés simple ###");
                    System.out.printf("- Nombre : %s%n", nombreCliente);
                    System.out.printf("- Tipo de cliente : %s%n", tipoCliente);
                    System.out.printf("- Capital del préstamo : %.2f%n", precio);
                    System.out.printf("- Tasa anual : %.2f%n", tasaAnual);
                    System.out.printf("- Plazo en meses : %d%n", plazoMeses);
                    System.out.printf("> Interés simple = %.2f%n", interes);
                    System.out.printf("> Total a pagar = %.2f%n", totalAPagar);
                    operaciones++;

                } else if (opcion == 2) {
                    // Cálculo Interés Compuesto
                    double tasaMensual = (tasaAnual / 100) / 12.0;
                    double precioCompuesto = precio;

                    System.out.println("\n### Opción 2 : Cotización de interés compuesto ###");
                    System.out.printf("- Nombre : %s%n", nombreCliente);
                    System.out.printf("- Tipo de cliente : %s%n", tipoCliente);
                    System.out.printf("- Capital del préstamo : %.2f%n", precio);
                    System.out.printf("- Tasa anual : %.2f%n", tasaAnual);
                    System.out.printf("- Plazo en meses : %d%n", plazoMeses);
                    for (int m = 1; m <= plazoMeses; m++) {
                        precioCompuesto = precioCompuesto * (1 + tasaMensual);
                        System.out.printf("> Mes %d = %.2f%n", m, precioCompuesto);
                    }
                    double interesCompuesto = precioCompuesto - precio;
                    System.out.printf("> Interés compuesto = %.2f%n", interesCompuesto);
                    System.out.printf("> Total a pagar = %.2f%n", precioCompuesto);
                    operaciones++;

                } else if (opcion == 3) {
                    // Se calculan los dos intereses para compararlos
                    double plazoAnios = plazoMeses / 12.0;
                    double interes = precio * (tasaAnual / 100) * plazoAnios;

                    double tasaMensual = (tasaAnual / 100) / 12.0;
                    double precioCompuesto = precio;
                    for (int m = 1; m <= plazoMeses; m++) {
                        precioCompuesto = precioCompuesto * (1 + tasaMensual);
                    }
                    double interesCompuesto = precioCompuesto - precio;

                    System.out.println("\n### Opción 3 : Comparación de intereses ###");
                    System.out.printf("> Interés simple = %.2f%n", interes);
                    System.out.printf("> Interés compuesto = %.2f%n", interesCompuesto);
                    if (interesCompuesto > interes) {
                        System.out.printf("> La diferencia entre ellos es de %.2f%n", interesCompuesto - interes);
                        System.out.println("> El interés compuesto es mayor.");
                    } else if (interes > interesCompuesto) {
                        System.out.printf("> La diferencia entre ellos es de %.2f%n", interes - interesCompuesto);
                        System.out.println("> El interés simple es mayor.");
                    } else {
                        System.out.println("> Los dos intereses son iguales.");
                    }
                    operaciones++;

                } else if (opcion == 4) {
                    // Misma validación del capital que en el registro
                    datoInvalido = true;
                    while (datoInvalido) {
                        System.out.print("Ingresa el nuevo capital del préstamo: ");
                        if (entrada.hasNextDouble()) {
                            precio = entrada.nextDouble();
                            if (precio > 0) {
                                datoInvalido = false;
                            } else {
                                System.out.println("Error: El capital debe ser mayor a cero.");
                            }
                        } else {
                            entrada.next();
                            System.out.println("Error: El capital debe ser un número.");
                        }
                    }
                    System.out.printf("El nuevo capital es $%.2f%n", precio);
                    operaciones++;

                } else {
                    // Es un número pero no está en el menú
                    errores++;
                    System.out.println("Esa opción no está en el menú.");
                }

            } else {
                // No escribió un número
                entrada.next();
                errores++;
                System.out.println("Eso no es un número.");
            }

            // Se revisan los límites, si el usuario no eligió salir
            if (seguir) {
                if (operaciones == 5) {
                    System.out.println("\nSe alcanzó el límite de operaciones.");
                    motivo = "Se alcanzó el límite de 5 operaciones";
                    seguir = false;
                } else if (errores == 3) {
                    System.out.println("\nSe alcanzó el límite de errores.");
                    motivo = "Se alcanzó el límite de 3 errores";
                    seguir = false;
                }
            }
        }

        // Resumen
        System.out.println("\n--- Resumen ---");
        System.out.printf("Cliente: %s%n", nombreCliente);
        System.out.printf("Operaciones efectivas: %d%n", operaciones);
        System.out.printf("Errores en el menú: %d%n", errores);
        System.out.printf("Capital final: $%.2f%n", precio);
        System.out.printf("Motivo de término: %s%n", motivo);
        System.out.println("Chao Bambino");
    }
}
public class CotizadorPines {
    public static void main(String[] args) {

        // Datos cliente
        String nombreCliente = "Robbie Valentino";
        char clasificacionCliente = 'E'; // 'P' = Preferente, 'E' = Estándar, 'R' = Riesgoso

        // Validación del tipo de cliente
        if (clasificacionCliente != 'E' && clasificacionCliente != 'P' && clasificacionCliente != 'R') {
            System.out.println("Error: Tipo de cliente inválido. Ingrese P, E o R.");
            return;
        }

        // Datos prestamo
        double precio = 12899.0;
        double precioCompuesto = precio;
        double tasaAnual = 15.0;
        int plazoMeses = 21;

        // Ajuste de la tasa según la clasificación del cliente
        if (clasificacionCliente == 'P') {
            tasaAnual -= 2;
        } else if (clasificacionCliente == 'R') {
            tasaAnual += 3;
        }

        // Calculo Interés Simple
        double plazoAnios = plazoMeses / 12.0;

        // Validación de datos de entrada positivos
        boolean condicion = (plazoMeses > 0) && (precio > 0) && (tasaAnual > 0);

        double interes = precio * (tasaAnual / 100) * plazoAnios;
        double totalAPagar = precio + interes;

        // --- Impresión del reporte ---
        System.out.println("\n+++++ Cotizador de La Cabaña del Misterio +++++\n");
        System.out.println("--- Datos del cliente ---");
        System.out.printf("Cliente: %s%n", nombreCliente);
        System.out.printf("Clasificacion: %c%n", clasificacionCliente);
        System.out.println();

        if (condicion) {
            // Conversión a tasa 
            double tasaMensual = (tasaAnual / 100) / 12.0;

            // Cálculos de Interés Compuesto 
            for (int m = 1; m <= plazoMeses; m++) {
                precioCompuesto = precioCompuesto * (1 + tasaMensual);
                System.out.printf("En el mes %d se tiene un saldo de $%.2f %n", m, precioCompuesto);
            }

            // Cálculo directo del Interés 
            double saldoFinal = precio * Math.pow((1 + tasaMensual), plazoMeses);
            double interesCompuesto = precioCompuesto - precio;

            // Cotización
            System.out.printf("%nTasa aplicada = %.0f%% %nPréstamo = $%.2f %nMeses de pago = %d%n", tasaAnual, precio,
                    plazoMeses);
            System.out.printf(
                    "Interés simple = $%.2f %nTotal con interés simple = $%.2f %nInterés Compuesto = $%.2f%n", interes,
                    totalAPagar, interesCompuesto);
            System.out.printf("Total con interés compuesto = $%.2f%n", saldoFinal);
            System.out.println();
        } else {
            System.out.println("Error: Por favor inserte valores válidos mayores a cero.");
        }
    }
}
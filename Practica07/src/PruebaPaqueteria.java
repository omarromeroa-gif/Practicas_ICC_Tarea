/**
 * Programa de prueba para verificar el correcto funcionamiento de las clases
 * {@link Paquete} y {@link CotizadorEnvio}.
 * 
 * @author Omar Romero Arzate
 * @version 1.0
 */
public class PruebaPaqueteria {

    /**
     * Punto de entrada del programa. Ejecuta los casos de prueba de las
     * clases Paquete y CotizadorEnvio, y las pruebas de la propuesta personal.
     * 
     * @param args Argumentos de linea de comandos (no se utilizan).
     */
    public static void main(String[] args) {
        System.out.println("======================================================");
        System.out.println("  PRUEBAS DEL SISTEMA DE ENVIOS POSTALES (PRACTICA 7) ");
        System.out.println("======================================================\n");

        // Caso 1: el peso fisico domina
        System.out.println("--- Caso 1: Paquete pequeno estandar ---");
        Paquete p1 = new Paquete("PK-001", 3.5, 20, 15, 10, 800.0);
        mostrarDetallePaquete(p1);
        System.out.println("Es valido?: " + CotizadorEnvio.esPaqueteValido(p1));
        System.out.printf("Costo de envio cotizado: $%.2f (Esperado: $120.00)\n", CotizadorEnvio.cotizarEnvio(p1));
        System.out.println("Requiere seguro?: " + CotizadorEnvio.requiereSeguro(p1));
        System.out.println();

        // Caso 2: el peso volumetrico domina
        System.out.println("--- Caso 2: Paquete voluminoso (volumen predomina) ---");
        Paquete p2 = new Paquete("PK-002", 2.0, 50, 40, 50, 1500.0);
        mostrarDetallePaquete(p2);
        if (CotizadorEnvio.esPaqueteValido(p2)) {
            System.out.printf("Peso volumetrico calculado: %.2f kg\n", p2.calculaPesoVolumetrico());
            System.out.printf("Peso cobrable final: %.2f kg\n", p2.obtenerPesoCobrable());
        }
        System.out.printf("Costo de envio cotizado: $%.2f (Esperado: $425.00)\n", CotizadorEnvio.cotizarEnvio(p2));
        System.out.println("Requiere seguro?: " + CotizadorEnvio.requiereSeguro(p2));
        System.out.println();

        // Caso 3: seguro por valor declarado
        System.out.println("--- Caso 3: Paquete de alto valor monetario ---");
        Paquete p3 = new Paquete("PK-003", 4.0, 30, 25, 20, 6500.0);
        mostrarDetallePaquete(p3);
        System.out.printf("Costo de envio: $%.2f\n", CotizadorEnvio.cotizarEnvio(p3));
        System.out.println("Requiere seguro?: " + CotizadorEnvio.requiereSeguro(p3) + " (Esperado: true)");
        System.out.println();

        // Caso 4: seguro por dimensiones
        System.out.println("--- Caso 4: Paquete sobredimensionado ---");
        Paquete p4 = new Paquete("PK-004", 5.0, 70, 30, 20, 1200.0);
        mostrarDetallePaquete(p4);
        System.out.println("Requiere seguro?: " + CotizadorEnvio.requiereSeguro(p4) + " (Esperado: true por dimensiones)");
        System.out.println();

        // Caso 5: referencia nula
        System.out.println("--- Caso 5: Validacion de referencia nula (null) ---");
        Paquete pNulo = null;
        System.out.println("Es valido un paquete null?: " + CotizadorEnvio.esPaqueteValido(pNulo) + " (Esperado: false)");
        System.out.printf("Cotizacion de un paquete null: $%.2f (Esperado: -1.00)\n", CotizadorEnvio.cotizarEnvio(pNulo));
        System.out.println("Requiere seguro un paquete null?: " + CotizadorEnvio.requiereSeguro(pNulo) + " (Esperado: false)");
        System.out.println();

        System.out.println("======================================================");
        System.out.println("        PRUEBAS DE TU PROPUESTA PERSONAL              ");
        System.out.println("======================================================");

        // 6A: 50 + 0.02 * 800 = 66; total 120 + 66 = 186
        System.out.println("--- 6A: Paquete fragil de valor medio ---");
        Paquete p6 = new Paquete("PK-006", 3.5, 20, 15, 10, 800.0);
        p6.setFragil(true);
        mostrarDetallePaquete(p6);
        System.out.printf("Importe por fragilidad: $%.2f (Esperado: $66.00)\n", p6.calcularImporteFragil());
        System.out.printf("Total a pagar (envio + fragilidad): $%.2f (Esperado: $186.00)\n",
                CotizadorEnvio.cotizarEnvio(p6) + p6.calcularImporteFragil());
        System.out.println();

        // 6B: sin fragilidad no hay importe extra
        System.out.println("--- 6B: El mismo paquete, no fragil ---");
        Paquete p7 = new Paquete("PK-007", 3.5, 20, 15, 10, 800.0);
        System.out.println("Es fragil?: " + p7.esFragil());
        System.out.printf("Importe por fragilidad: $%.2f (Esperado: $0.00)\n", p7.calcularImporteFragil());
        System.out.printf("Total a pagar: $%.2f (Esperado: $120.00)\n",
                CotizadorEnvio.cotizarEnvio(p7) + p7.calcularImporteFragil());
        System.out.println();

        // 6C: 50 + 0.02 * 6500 = 180; total 120 + 180 = 300
        System.out.println("--- 6C: Paquete fragil de alto valor ---");
        Paquete p8 = new Paquete("PK-008", 4.0, 30, 25, 20, 6500.0);
        p8.setFragil(true);
        System.out.printf("Importe por fragilidad: $%.2f (Esperado: $180.00)\n", p8.calcularImporteFragil());
        System.out.printf("Total a pagar: $%.2f (Esperado: $300.00)\n",
                CotizadorEnvio.cotizarEnvio(p8) + p8.calcularImporteFragil());
        System.out.println();

        // 6D: valor 0, solo la cuota fija
        System.out.println("--- 6D: Paquete fragil sin valor declarado ---");
        Paquete p9 = new Paquete();
        p9.setFragil(true);
        System.out.printf("Importe por fragilidad: $%.2f (Esperado: $50.00, solo la cuota fija)\n",
                p9.calcularImporteFragil());
        System.out.println();

        // 6E: el importe se recalcula al cambiar el valor
        System.out.println("--- 6E: El importe se recalcula al cambiar el valor declarado ---");
        System.out.printf("Antes (valor $800.00): $%.2f (Esperado: $66.00)\n", p6.calcularImporteFragil());
        p6.setValorDeclarado(2000.0);
        System.out.printf("Despues (valor $2000.00): $%.2f (Esperado: $90.00)\n", p6.calcularImporteFragil());
        System.out.println();

        System.out.println("======================================================");
        System.out.println("      PRUEBAS EXTRA: VALIDACIONES DE LA CLASE         ");
        System.out.println("======================================================");

        // Extra 1: el constructor por defecto es valido (no es lo mismo que null)
        System.out.println("--- Extra 1: Constructor por defecto ---");
        Paquete pDefecto = new Paquete();
        mostrarDetallePaquete(pDefecto);
        System.out.println("Es valido?: " + CotizadorEnvio.esPaqueteValido(pDefecto) + " (Esperado: true)");
        System.out.printf("Costo de envio: $%.2f (Esperado: $120.00)\n", CotizadorEnvio.cotizarEnvio(pDefecto));
        System.out.println();

        // Extra 2: datos invalidos se sustituyen por valores de respaldo
        System.out.println("--- Extra 2: Constructor con datos invalidos ---");
        Paquete pInvalido = new Paquete(null, -5.0, 0, -10, 20, -100.0);
        mostrarDetallePaquete(pInvalido);
        System.out.println("(Esperado: SIN-CODIGO, 1.0 kg, 1x1x20 cm, valor $0.00)");
        System.out.println();

        // Extra 3: un setter ignora el dato invalido
        System.out.println("--- Extra 3: Setter con dato invalido ---");
        Paquete pSetter = new Paquete("PK-009", 3.0, 10, 10, 10, 500.0);
        pSetter.setLargo(-4);
        System.out.println("Largo despues de setLargo(-4): " + pSetter.getLargo() + " (Esperado: 10.0)");
        pSetter.setLargo(25);
        System.out.println("Largo despues de setLargo(25): " + pSetter.getLargo() + " (Esperado: 25.0)");
        System.out.println();

        // Extra 4: 60x50x40 cm = 24 kg volumetricos; 300 + 25 * (24 - 15) = 525
        System.out.println("--- Extra 4: Tarifa para mas de 15 kg ---");
        Paquete pPesado = new Paquete("PK-010", 1.0, 60, 50, 40, 900.0);
        System.out.printf("Peso cobrable: %.2f kg\n", pPesado.obtenerPesoCobrable());
        System.out.printf("Costo de envio: $%.2f (Esperado: $525.00)\n", CotizadorEnvio.cotizarEnvio(pPesado));
        System.out.println();
    }

    /**
     * Metodo auxiliar para imprimir en consola los datos basicos de un paquete.
     * Utiliza los metodos de acceso (getters) implementados en la clase Paquete.
     * 
     * @param p Paquete a imprimir.
     */
    private static void mostrarDetallePaquete(Paquete p) {
        if (!CotizadorEnvio.esPaqueteValido(p)) {
            System.out.println("  [Paquete no valido o no instanciado]");
            return;
        }
        System.out.println("  Codigo de rastreo: " + p.getCodigoRastreo());
        System.out.println("  Peso fisico: " + p.getPesoKg() + " kg");
        System.out.println("  Dimensiones (largo x ancho x alto): "
                + p.getLargo() + " x " + p.getAncho() + " x " + p.getAlto() + " cm");
        System.out.println("  Valor declarado: $" + p.getValorDeclarado());
    }
}

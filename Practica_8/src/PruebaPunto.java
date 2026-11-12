/**
 * Programa de prueba automatizado para verificar el correcto funcionamiento
 * de todos los metodos de la clase Punto.
 * 
 * @author ICC 2027-1
 * @version 1.0
 */
public class PruebaPunto {

    private static int pruebasExitosas = 0;
    private static int totalPruebas = 0;

    public static void main(String[] args) {
        System.out.println("================================================================================");
        System.out.println("  ICC 2027-1 | VERIFICACION AUTOMATIZADA: CLASE PUNTO (MINI-LAB 8)");
        System.out.println("================================================================================\n");

        // ---------------------------------------------------------------------
        // 1. Constructores y Getters
        // ---------------------------------------------------------------------
        System.out.println(">>> 1. PROBANDO CONSTRUCTORES Y GETTERS:");
        Punto pOrigen = new Punto();
        verificar("Constructor por omision inicializa en (0.0, 0.0)", 
                  pOrigen.getX() == 0.0 && pOrigen.getY() == 0.0,
                  "Esperado: (0.0, 0.0), Obtenido: " + pOrigen);

        Punto p1 = new Punto(3.0, 4.0);
        verificar("Constructor con parametros inicializa en (3.0, 4.0)",
                  p1.getX() == 3.0 && p1.getY() == 4.0,
                  "Esperado: (3.0, 4.0), Obtenido: " + p1);

        // ---------------------------------------------------------------------
        // 2. Setters y Modificacion
        // ---------------------------------------------------------------------
        System.out.println("\n>>> 2. PROBANDO SETTERS:");
        Punto pMod = new Punto();
        pMod.setX(10.5);
        pMod.setY(-2.5);
        verificar("Setters modifican correctamente las coordenadas",
                  pMod.getX() == 10.5 && pMod.getY() == -2.5,
                  "Esperado: (10.5, -2.5), Obtenido: " + pMod);

        // ---------------------------------------------------------------------
        // 3. Desplazamiento
        // ---------------------------------------------------------------------
        System.out.println("\n>>> 3. PROBANDO METODO DESPLAZAR:");
        Punto pDesp = new Punto(2.0, 3.0);
        pDesp.desplazar(1.5, -1.0);
        verificar("desplazar(1.5, -1.0) actualiza a (3.5, 2.0)",
                  Math.abs(pDesp.getX() - 3.5) < 1e-9 && Math.abs(pDesp.getY() - 2.0) < 1e-9,
                  "Esperado: (3.5, 2.0), Obtenido: " + pDesp);

        // ---------------------------------------------------------------------
        // 4. Distancia Euclidiana
        // ---------------------------------------------------------------------
        System.out.println("\n>>> 4. PROBANDO DISTANCIA EUCLIDIANA:");
        // Triangulo rectangulo 3-4-5 respecto al origen
        double distOrigenP1 = pOrigen.distancia(p1);
        verificar("Distancia de (0.0, 0.0) a (3.0, 4.0) es 5.0",
                  Math.abs(distOrigenP1 - 5.0) < 1e-9,
                  "Esperado: 5.0, Obtenido: " + distOrigenP1);

        Punto pA = new Punto(1.0, 2.0);
        Punto pB = new Punto(4.0, 6.0);
        double distAB = pA.distancia(pB);
        verificar("Distancia de (1.0, 2.0) a (4.0, 6.0) es 5.0",
                  Math.abs(distAB - 5.0) < 1e-9,
                  "Esperado: 5.0, Obtenido: " + distAB);

        verificar("Distancia con referencia null regresa -1.0",
                  pA.distancia(null) == -1.0,
                  "Esperado: -1.0, Obtenido: " + pA.distancia(null));

        // ---------------------------------------------------------------------
        // 5. Punto Medio (Creacion y Retorno de Objetos)
        // ---------------------------------------------------------------------
        System.out.println("\n>>> 5. PROBANDO PUNTO MEDIO (OBJETO RETORNADO):");
        Punto medio = pA.puntoMedio(pB);
        verificar("Punto medio entre (1.0, 2.0) y (4.0, 6.0) es (2.5, 4.0)",
                  medio != null && Math.abs(medio.getX() - 2.5) < 1e-9 && Math.abs(medio.getY() - 4.0) < 1e-9,
                  "Esperado: (2.5, 4.0), Obtenido: " + medio);

        verificar("Punto medio con null regresa null",
                  pA.puntoMedio(null) == null,
                  "Esperado: null, Obtenido: " + pA.puntoMedio(null));

        // ---------------------------------------------------------------------
        // 6. Cuadrantes
        // ---------------------------------------------------------------------
        System.out.println("\n>>> 6. PROBANDO DETERMINACION DE CUADRANTES:");
        Punto c1 = new Punto(5.0, 8.0);    // Cuadrante I
        Punto c2 = new Punto(-3.0, 4.0);   // Cuadrante II
        Punto c3 = new Punto(-2.0, -7.0);  // Cuadrante III
        Punto c4 = new Punto(6.0, -1.0);   // Cuadrante IV
        Punto cEje = new Punto(0.0, 5.0);  // Eje Y
        Punto cOrg = new Punto(0.0, 0.0);  // Origen

        verificar("Cuadrante de (5.0, 8.0) es I", c1.cuadrante() == 1, "Obtenido: " + c1.cuadrante());
        verificar("Cuadrante de (-3.0, 4.0) es II", c2.cuadrante() == 2, "Obtenido: " + c2.cuadrante());
        verificar("Cuadrante de (-2.0, -7.0) es III", c3.cuadrante() == 3, "Obtenido: " + c3.cuadrante());
        verificar("Cuadrante de (6.0, -1.0) es IV", c4.cuadrante() == 4, "Obtenido: " + c4.cuadrante());
        verificar("Cuadrante de (0.0, 5.0) en eje es 0", cEje.cuadrante() == 0, "Obtenido: " + cEje.cuadrante());
        verificar("Cuadrante del origen (0.0, 0.0) es 0", cOrg.cuadrante() == 0, "Obtenido: " + cOrg.cuadrante());

        // ---------------------------------------------------------------------
        // 7. Representacion Textual (toString)
        // ---------------------------------------------------------------------
        System.out.println("\n>>> 7. PROBANDO METODO toString():");
        verificar("toString() de (3.0, 4.0) devuelve \"(3.0, 4.0)\"",
                  "(3.0, 4.0)".equals(p1.toString()),
                  "Esperado: \"(3.0, 4.0)\", Obtenido: \"" + p1.toString() + "\"");

        // ---------------------------------------------------------------------
        // 8. Igualdad de Puntos (equals)
        // ---------------------------------------------------------------------
        System.out.println("\n>>> 8. PROBANDO METODO EQUALS (IDENTIDAD VS CONTENIDO):");
        Punto pEq1 = new Punto(3.0, 4.0);
        Punto pEq2 = new Punto(3.0, 4.0);
        Punto pDistinto = new Punto(3.0, 4.1);

        verificar("p1.equals(new Punto(3.0, 4.0)) retorna true",
                  pEq1.equals(pEq2),
                  "Esperado: true, Obtenido: " + pEq1.equals(pEq2));

        verificar("p1.equals(new Punto(3.0, 4.1)) retorna false",
                  !pEq1.equals(pDistinto),
                  "Esperado: false, Obtenido: " + pEq1.equals(pDistinto));

        verificar("p1.equals(null) retorna false de forma segura",
                  !pEq1.equals(null),
                  "Esperado: false, Obtenido: " + pEq1.equals(null));

        // ---------------------------------------------------------------------
        // 9. Alineacion / Colinealidad (Reto: Tres Puntos)
        // ---------------------------------------------------------------------
        System.out.println("\n>>> 9. PROBANDO COLINEALIDAD (RETO: TRES PUNTOS EN UNA RECTA):");
        Punto r1 = new Punto(1.0, 1.0);
        Punto r2 = new Punto(2.0, 2.0);
        Punto r3 = new Punto(5.0, 5.0);
        Punto rNo = new Punto(5.0, 6.0);

        verificar("(1,1), (2,2) y (5,5) estan alineados",
                  r1.estanAlineados(r2, r3),
                  "Esperado: true, Obtenido: " + r1.estanAlineados(r2, r3));

        verificar("(1,1), (2,2) y (5,6) NO estan alineados",
                  !r1.estanAlineados(r2, rNo),
                  "Esperado: false, Obtenido: " + r1.estanAlineados(r2, rNo));

        // ---------------------------------------------------------------------
        // Resumen
        // ---------------------------------------------------------------------
        System.out.println("\n================================================================================");
        System.out.println("  RESUMEN DE PRUEBAS: " + pruebasExitosas + " / " + totalPruebas + " pruebas superadas con exito.");
        if (pruebasExitosas == totalPruebas) {
            System.out.println("  ¡FELICIDADES! Todos los metodos de la clase Punto funcionan correctamente.");
        } else {
            System.out.println("  ATENCION: Revisa los metodos que marcaron [FALLO] antes de entregar tu practica.");
        }
        System.out.println("================================================================================\n");
    }

    private static void verificar(String descripcion, boolean condicion, String detalle) {
        totalPruebas++;
        if (condicion) {
            pruebasExitosas++;
            System.out.printf("  [OK] %s\n", descripcion);
        } else {
            System.out.printf("  [FALLO] %s (%s)\n", descripcion, detalle);
        }
    }
}

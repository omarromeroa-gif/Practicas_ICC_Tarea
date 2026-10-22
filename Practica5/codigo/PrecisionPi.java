public class PrecisionPi {
    public static void main(String[] args) {
    
        // Tolerancia o error que aceptamos
        double margenError = 0.001; 
        
        // Variables para llevar las cuentas
        int cDardosLanzados = 0; 
        int contadorDentro = 0;   
        double valorPi = 0.0;
        
    
        // El ciclo mientras el error sea mayor o igual al margen permitido
        while (diferenciaError >= margenError) {
            // Generamos coordenadas aleatorias (x, y)
            double posX = Math.random();
            double posY = Math.random();
            
            // Formula para calcular la distancia al centro
            double distanciaAlCentro = (posX * posX) + (posY * posY);

            // Condición si cae dentro
            if (distanciaAlCentro <= 1.0) {
                contadorDentro++; 
            }

            // Actualizamos el contador de dardos
            cDardosLanzados++;

            // Recalculamos Pi y la diferencia del error en cada vuelta
            valorPi = 4.0 * contadorDentro / cDardosLanzados;
            diferenciaError = Math.abs(Math.PI - valorPi);
        }

        // Imprimimos la cantidad de dardos que se necesitaron
        System.out.println("Dardos necesarios: " + cDardosLanzados);
        
        // Imprimimos la aproximación calculada de la forma sencilla
        System.out.println("Aproximación de pi: " + valorPi);
    }
}


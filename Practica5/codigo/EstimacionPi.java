public class EstimacionPi {
    public static void main(String[] args) {
        
        // Cantidad de Dardos Totales
        int cDardosTotales = 1000000; 
        // Cantidad de Dardos Lanzados
        int cDardosLanzados = 0; 
        // Cantidad de Dardos que cayeron dentro
        int contadorDentro = 0;   
        
        // Condición
        while (cDardosLanzados < cDardosTotales) {
            // Generamos coordenadas aleatorias (x, y)
            double posX = Math.random();
            double posY = Math.random();
            
            // Fórmula para calcular la distancia al centro
            double distanciaAlCentro = (posX * posX) + (posY * posY);

            // Condición si cae dentro del cuarto de círculo
            if (distanciaAlCentro <= 1.0) {
                contadorDentro++; 
            }

            // Actualizamos el contador en cada vuelta
            cDardosLanzados++;
        }
        
        // Calculamos el valor de Pi
        double valorPi = 4.0 * contadorDentro / cDardosTotales;

        // Imprimimos el resultado de la forma sencilla
        System.out.println("Aproximación de pi: " + valorPi);
    }
}

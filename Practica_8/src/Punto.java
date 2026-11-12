/**
 * Modela un punto en el plano cartesiano bidimensional (2D).
 * 
 * @author [Omar Romero Arzate]
 * @version 1.1
 */
public class Punto {

    // Practica 8 (Mini-Lab): Metodos, Mensajes y Objetos como Parametros.

    // ATRIBUTOS PRIVADOS

    /** Coordenada horizontal (abscisa). */
    private double x;

    /** Coordenada vertical (ordenada). */
    private double y;

    // CONSTRUCTORES

    /**
     * Inicializa el punto exactamente en el origen de coordenadas (0.0, 0.0).
     */
    public Punto() {
        // Constructor por omision / defecto.
        this.x = 0.0;
        this.y = 0.0;
    }

    /**
     * Inicializa el punto en las coordenadas cartesianas especificadas.
     * Recuerda utilizar 'this' para desambiguar el atributo del parametro.
     * 
     * @param x Coordenada en el eje X.
     * @param y Coordenada en el eje Y.
     */
    public Punto(double x, double y) {
        // Constructor con parametros.
        // 'this.x' es el atributo del objeto; 'x' es el parametro.
        this.x = x;
        this.y = y;
    }

    // METODOS DE CONSULTA Y ASIGNACION (GETTERS Y SETTERS)
    // =========================================================================

    /**
     * Regresa la coordenada X del punto.
     * 
     * @return La abscisa del punto.
     */
    public double getX() {
        return this.x;
    }

    /**
     * Regresa la coordenada Y del punto.
     * 
     * @return La ordenada del punto.
     */
    public double getY() {
        return this.y;
    }

    /**
     * Modifica la coordenada X del punto.
     * 
     * @param x El nuevo valor de la abscisa.
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Modifica la coordenada Y del punto.
     * 
     * @param y El nuevo valor de la ordenada.
     */
    public void setY(double y) {
        this.y = y;
    }

    // METODOS CALCULADORES [ OPERACIONES GEOMETRICAS ]
    // =========================================================================

    /**
     * Desplaza el punto sumando desplazamientos (deltas) a sus coordenadas
     * actuales.
     * 
     * @param deltaX Desplazamiento horizontal.
     * @param deltaY Desplazamiento vertical.
     */
    public void desplazar(double deltaX, double deltaY) {
        this.x += deltaX;
        this.y += deltaY;
    }

    /**
     * Calcula la distancia euclidiana entre este punto y otro punto recibido.
     * Formula: sqrt((x2 - x1)^2 + (y2 - y1)^2)
     * 
     * @param otroPunto El punto destino respecto al cual se calculara la distancia.
     * @return La distancia euclidiana entre ambos puntos. Si 'otroPunto' es null,
     *         regresa -1.0.
     */
    public double distancia(Punto otroPunto) {
        if (otroPunto == null) {
            return -1.0;
        }
        // (x1, y1) = este punto (this); (x2, y2) = el punto recibido.
        double dx = otroPunto.getX() - this.x;
        double dy = otroPunto.getY() - this.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    /**
     * Calcula y retorna el punto medio entre este punto y otro punto recibido.
     * Formula de coordenadas medias: xm = (x1 + x2) / 2, ym = (y1 + y2) / 2.
     * 
     * @param otro El otro punto para calcular el punto medio.
     * @return Una nueva instancia de Punto situada en las coordenadas medias. Si
     *         'otro' es null, regresa null.
     */
    public Punto puntoMedio(Punto otro) {
        if (otro == null) {
            return null;
        }
        double xm = (this.x + otro.getX()) / 2.0;
        double ym = (this.y + otro.getY()) / 2.0;
        return new Punto(xm, ym);
    }

    /**
     * Determina el cuadrante del plano cartesiano en el que se ubica el punto.
     * 
     * @return 1 (I Cuadrante: x &gt; 0, y &gt; 0),
     *         2 (II Cuadrante: x &lt; 0, y &gt; 0),
     *         3 (III Cuadrante: x &lt; 0, y &lt; 0),
     *         4 (IV Cuadrante: x &gt; 0, y &lt; 0),
     *         o 0 si se ubica sobre alguno de los ejes o en el origen.
     */
    public int cuadrante() {
        if (this.x > 0 && this.y > 0) {
            return 1;
        } else if (this.x < 0 && this.y > 0) {
            return 2;
        } else if (this.x < 0 && this.y < 0) {
            return 3;
        } else if (this.x > 0 && this.y < 0) {
            return 4;
        } else {
            // Sobre el eje X, el eje Y o en el origen.
            return 0;
        }
    }

    /**
     * Determina si este punto y otros dos puntos recibidos son colineales
     * (es decir, si los tres puntos pasan sobre la misma linea recta).
     * 
     * @param p2 Segundo punto a evaluar.
     * @param p3 Tercer punto a evaluar.
     * @return true si los tres puntos estan alineados; false en caso contrario (o
     *         si alguno es null).
     */
    public boolean estanAlineados(Punto p2, Punto p3) {
        if (p2 == null || p3 == null) {
            return false;
        }
        // Producto cruz 2D (sin divisiones, evita pendientes verticales):
        // delta = (x2 - x1)(y3 - y1) - (y2 - y1)(x3 - x1)
        double delta = (p2.getX() - this.x) * (p3.getY() - this.y)
                - (p2.getY() - this.y) * (p3.getX() - this.x);
        return Math.abs(delta) < 1e-9;
    }

    /**
     * Representacion textual del punto en formato estandar de par ordenado: (x, y).
     * 
     * @return Cadena con el formato "(x, y)".
     */
    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }

    /**
     * Compara si este punto es equivalente a otro objeto recibido.
     * Dos puntos se consideran iguales si la distancia entre ellos o la diferencia
     * absoluta
     * de sus coordenadas es menor a una tolerancia pequena (ej. 1e-6).
     * 
     * @param obj El objeto a comparar.
     * @return true si el objeto es un Punto con coordenadas equivalentes; false en
     *         caso contrario.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Punto)) {
            return false;
        }
        Punto otro = (Punto) obj;
        final double TOLERANCIA = 1e-6;
        return Math.abs(this.x - otro.getX()) < TOLERANCIA
                && Math.abs(this.y - otro.getY()) < TOLERANCIA;
    }
}

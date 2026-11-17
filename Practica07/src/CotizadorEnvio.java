/**
 * Clase de utileria o servicio que contiene las reglas de negocio para
 * cotizar costos de envio y determinar requerimientos de seguro.
 * 
 * Al no modelar un objeto con estado interno persistente, sus metodos se declaran
 * como estaticos (static) y operan sobre los objetos {@link Paquete} recibidos por parametro.
 * 
 * @author Adrian Lopez Mendez
 * @version 1.0
 */
public class CotizadorEnvio {

    /**
     * Evalua si una referencia recibida corresponde a un paquete valido para operar.
     * 
     * @param p Objeto paquete a inspeccionar.
     * @return true si la referencia no es nula y cumple con las condiciones minimas
     *         para considerarse valido; false en caso contrario.
     */
    public static boolean esPaqueteValido(Paquete p) {
        // si p es null, && corta la evaluacion y no se consulta nada mas
        return p != null
                && p.getCodigoRastreo() != null
                && p.getCodigoRastreo().length() > 0
                && p.getPesoKg() > 0
                && p.getLargo() > 0
                && p.getAncho() > 0
                && p.getAlto() > 0
                && p.getValorDeclarado() >= 0;
    }

    /**
     * Calcula la tarifa base de envio de acuerdo a los rangos de peso cobrable:
     * <ul>
     *   <li>Hasta 5 kg: cuota fija de $120.00.</li>
     *   <li>Mas de 5 kg y hasta 15 kg: $120.00 mas $18.00 por cada kg que exceda los 5 kg.</li>
     *   <li>Mas de 15 kg: $300.00 mas $25.00 por cada kg que exceda los 15 kg.</li>
     * </ul>
     * 
     * @param p El paquete cuya tarifa se calculara.
     * @return El importe total del envio en pesos, o -1.0 si el paquete no es valido.
     */
    public static double cotizarEnvio(Paquete p) {
        if (!esPaqueteValido(p)) {
            return -1.0;
        }

        double pesoCobrable = p.obtenerPesoCobrable();

        if (pesoCobrable <= 5) {
            return 120.0;
        } else if (pesoCobrable <= 15) {
            return 120.0 + 18.0 * (pesoCobrable - 5);
        } else {
            // 300 es lo que cuesta llegar a 15 kg
            return 300.0 + 25.0 * (pesoCobrable - 15);
        }
    }

    /**
     * Determina si el paquete requiere poliza de seguro obligatorio.
     * Esto ocurre si el paquete es valido y cumple al menos una de las siguientes condiciones:
     * <ul>
     *   <li>Su valor declarado supera $3,000.00 pesos.</li>
     *   <li>Es sobredimensionado: alguna de sus aristas excede los 60 cm o la suma
     *       de sus tres dimensiones supera los 150 cm.</li>
     * </ul>
     * 
     * @param p El paquete a evaluar.
     * @return true si el paquete amerita contratacion de seguro obligatorio; false en caso contrario.
     */
    public static boolean requiereSeguro(Paquete p) {
        if (!esPaqueteValido(p)) {
            return false;
        }

        boolean altoValor = p.getValorDeclarado() > 3000.0;

        boolean aristaLarga = p.getLargo() > 60.0
                || p.getAncho() > 60.0
                || p.getAlto() > 60.0;

        boolean sumaExcesiva = (p.getLargo() + p.getAncho() + p.getAlto()) > 150.0;

        return altoValor || aristaLarga || sumaExcesiva;
    }
}

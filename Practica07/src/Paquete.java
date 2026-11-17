/**
 * Clase que modela un paquete para una empresa de envios postales y paqueteria.
 * Permite registrar sus dimensiones espaciales, peso fisico y valor declarado,
 * asi como calcular su peso volumetrico y determinar el peso cobrable final.
 * Incluye ademas el importe extra por manejo de paquetes fragiles.
 * 
 * @author Omar Romero Arzate
 * @version 1.0
 */
public class Paquete {

    private String codigoRastreo;
    private double pesoKg;
    private double largo;   // cm
    private double ancho;   // cm
    private double alto;    // cm
    private double valorDeclarado;
    private boolean fragil;

    /**
     * Constructor por defecto. Crea un paquete unitario y valido: codigo
     * "SIN-CODIGO", 1 kg de peso, dimensiones de 1 cm por lado, valor
     * declarado de $0.00 y no fragil.
     */
    public Paquete() {
        this.codigoRastreo = "SIN-CODIGO";
        this.pesoKg = 1.0;
        this.largo = 1.0;
        this.ancho = 1.0;
        this.alto = 1.0;
        this.valorDeclarado = 0.0;
        this.fragil = false;
    }

    /**
     * Constructor con parametros. Si un dato no es valido se sustituye por
     * un valor de respaldo para que el paquete siempre quede valido:
     * <ul>
     *   <li>Codigo nulo o vacio: "SIN-CODIGO".</li>
     *   <li>Peso menor o igual a 0: 1.0 kg.</li>
     *   <li>Largo, ancho o alto menores o iguales a 0: 1 cm.</li>
     *   <li>Valor declarado negativo: $0.00.</li>
     * </ul>
     * El paquete se crea como no fragil; usa {@link #setFragil(boolean)}
     * para cambiarlo.
     * 
     * @param codigoRastreo Codigo de rastreo alfanumerico del paquete.
     * @param pesoKg Peso fisico del paquete en kilogramos.
     * @param largo Largo del paquete en centimetros.
     * @param ancho Ancho del paquete en centimetros.
     * @param alto Alto del paquete en centimetros.
     * @param valorDeclarado Valor monetario declarado del contenido, en pesos.
     */
    public Paquete(String codigoRastreo, double pesoKg,
                   double largo, double ancho, double alto,
                   double valorDeclarado) {
        if (codigoRastreo != null && codigoRastreo.length() > 0) {
            this.codigoRastreo = codigoRastreo;
        } else {
            this.codigoRastreo = "SIN-CODIGO";
        }

        if (pesoKg > 0) {
            this.pesoKg = pesoKg;
        } else {
            this.pesoKg = 1.0;
        }

        if (largo > 0) {
            this.largo = largo;
        } else {
            this.largo = 1.0;
        }

        if (ancho > 0) {
            this.ancho = ancho;
        } else {
            this.ancho = 1.0;
        }

        if (alto > 0) {
            this.alto = alto;
        } else {
            this.alto = 1.0;
        }

        if (valorDeclarado >= 0) {
            this.valorDeclarado = valorDeclarado;
        } else {
            this.valorDeclarado = 0.0;
        }

        this.fragil = false;
    }

    /**
     * Consulta el codigo de rastreo del paquete.
     * 
     * @return El codigo de rastreo.
     */
    public String getCodigoRastreo() {
        return this.codigoRastreo;
    }

    /**
     * Consulta el peso fisico del paquete.
     * 
     * @return El peso fisico en kilogramos.
     */
    public double getPesoKg() {
        return this.pesoKg;
    }

    /**
     * Consulta el largo del paquete.
     * 
     * @return El largo en centimetros.
     */
    public double getLargo() {
        return this.largo;
    }

    /**
     * Consulta el ancho del paquete.
     * 
     * @return El ancho en centimetros.
     */
    public double getAncho() {
        return this.ancho;
    }

    /**
     * Consulta el alto del paquete.
     * 
     * @return El alto en centimetros.
     */
    public double getAlto() {
        return this.alto;
    }

    /**
     * Consulta el valor declarado del contenido.
     * 
     * @return El valor declarado en pesos.
     */
    public double getValorDeclarado() {
        return this.valorDeclarado;
    }

    /**
     * Consulta si el paquete es fragil.
     * 
     * @return true si el paquete es fragil; false en caso contrario.
     */
    public boolean esFragil() {
        return this.fragil;
    }

    /**
     * Modifica el codigo de rastreo; ignora un codigo nulo o vacio.
     * 
     * @param codigoRastreo El nuevo codigo de rastreo.
     */
    public void setCodigoRastreo(String codigoRastreo) {
        if (codigoRastreo != null && codigoRastreo.length() > 0) {
            this.codigoRastreo = codigoRastreo;
        }
    }

    /**
     * Modifica el peso fisico; ignora valores menores o iguales a 0.
     * 
     * @param pesoKg El nuevo peso fisico en kilogramos.
     */
    public void setPesoKg(double pesoKg) {
        if (pesoKg > 0) {
            this.pesoKg = pesoKg;
        }
    }

    /**
     * Modifica el largo; ignora valores menores o iguales a 0.
     * 
     * @param largo El nuevo largo en centimetros.
     */
    public void setLargo(double largo) {
        if (largo > 0) {
            this.largo = largo;
        }
    }

    /**
     * Modifica el ancho; ignora valores menores o iguales a 0.
     * 
     * @param ancho El nuevo ancho en centimetros.
     */
    public void setAncho(double ancho) {
        if (ancho > 0) {
            this.ancho = ancho;
        }
    }

    /**
     * Modifica el alto; ignora valores menores o iguales a 0.
     * 
     * @param alto El nuevo alto en centimetros.
     */
    public void setAlto(double alto) {
        if (alto > 0) {
            this.alto = alto;
        }
    }

    /**
     * Modifica el valor declarado; ignora valores negativos.
     * 
     * @param valorDeclarado El nuevo valor declarado en pesos.
     */
    public void setValorDeclarado(double valorDeclarado) {
        if (valorDeclarado >= 0) {
            this.valorDeclarado = valorDeclarado;
        }
    }

    /**
     * Indica si el paquete es fragil.
     * 
     * @param fragil true si el paquete es fragil; false si no lo es.
     */
    public void setFragil(boolean fragil) {
        this.fragil = fragil;
    }

    /**
     * Calcula el peso volumetrico del paquete segun el estandar comercial (IATA):
     * (largo * ancho * alto) / 5000.
     * 
     * @return El peso volumetrico equivalente en kilogramos.
     */
    public double calculaPesoVolumetrico() {
        return (this.largo * this.ancho * this.alto) / 5000.0;
    }

    /**
     * Determina el peso cobrable final para efectos de tarificacion postal,
     * el cual corresponde al valor maximo entre el peso fisico y el volumetrico.
     * 
     * @return El mayor entre el peso real y el peso volumetrico.
     */
    public double obtenerPesoCobrable() {
        double pesoVolumetrico = this.calculaPesoVolumetrico();
        if (pesoVolumetrico > this.pesoKg) {
            return pesoVolumetrico;
        } else {
            return this.pesoKg;
        }
    }

    /**
     * Calcula el importe extra por manejo de paquete fragil: una cuota fija de
     * $50.00 mas el 2% del valor declarado. Si el paquete no es fragil el
     * importe es $0.00. No se guarda en un atributo; se calcula cada vez con
     * el valor declarado actual.
     * 
     * @return El importe extra por fragilidad en pesos; 0.0 si el paquete no
     *         es fragil.
     */
    public double calcularImporteFragil() {
        if (!this.fragil) {
            return 0.0;
        }
        double cuotaFija = 50.0;
        double porcentajeDelValor = 0.02;
        return cuotaFija + porcentajeDelValor * this.valorDeclarado;
    }
}

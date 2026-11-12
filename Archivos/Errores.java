public class Errores {

    public static void main(String[] args) {

        System.out.println("=== Ficha de compra ===");
        System.out.println("Producto: laptop para la carrera");
        System.out.println("Precio con descuento:" + ( 15000 - 3000 ));
        System.out.println("Plazo en anios: " + ( 18 / 12));
        System.out.println("Pago mensual: " + (15000 - 3000 / 18.0));
        System.out.println("Folio en binario: " + Integer.toBinaryString("26"));
        System.out.println("Clave descifrada: " + Integer.parseInt("124", 8));
        System.out.println("Fin de la ficha");
        
    }
}
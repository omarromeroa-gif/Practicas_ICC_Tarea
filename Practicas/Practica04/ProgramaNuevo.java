public class ProgramaNuevo{	
	public static void main(String[] args) {

	// Guarda el nombre del producto
	String producto = "Laptop para la carrera";
// Guarda el precio base y desc de la laptop
	int precio = 15000;
	int descuento = 3000;

//Permite que puedas utilizar decimales para tu plazo a Meses/Años
	double meses = 18.0;

	 // Imprime los 4 datos de la compra en una sola instrucción 
       System.out.printf("- Producto : %s%n- Precio con descuento : %d%n- Plazo de pago en anios : %.1f%n- Pago mensual : %.2f%n", producto, (precio - descuento), meses, (double)(precio - descuento) / meses);
	
	System.out.println("=== Fin de la ficha ===");
	
	}
}
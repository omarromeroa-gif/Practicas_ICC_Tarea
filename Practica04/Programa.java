public class Programa{	
	public static void main(String[] args) {

	// Guarda el nombre del producto
	String producto = "Laptop para la carrera";
// Guarda el precio base y desc de la laptop
	int precio = 15000;
	int descuento = 3000;

//Permite que puedas utilizar decimales para tu plazo a Meses/Años
	double meses = 18.0;

// Imprime el encabezado
	System.out.println("=== Ficha de compra ===");

// Muestra el producto y su precio
	System.out.println("- Producto : " + producto);	

//Te da el precio ya con el Desc agregado
	System.out.println("- Precio con descuento : " + (precio - descuento));

//Muestra cuanto vas a ser el plazo
	System.out.println("- Plazo de pago en anios : " + (meses / 12.0));

//Muestra tu pago mensual
	System.out.println("- Pago mensual : " + ((precio - descuento) / meses));

//Imprime el cierre
	System.out.println("=== Fin de la ficha ===");

	}
}
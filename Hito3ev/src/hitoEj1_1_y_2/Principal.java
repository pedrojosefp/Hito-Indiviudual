package hitoEj1_1_y_2;

public class Principal {

	public static void main(String[] args) {
		
		Hombre elHombre = new Hombre("Luis", 40, "gris");
		System.out.println(elHombre.toString());
		elHombre.acelerar(); // Acelerar 10 km/hora.
		elHombre.acelerar(25); // Acelera 25 km/hora.
		System.out.println(elHombre.toString());

	}

}

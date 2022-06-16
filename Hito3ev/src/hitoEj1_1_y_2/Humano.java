package hitoEj1_1_y_2;

public class Humano {
	private String nombre;
	private int edad;
	public Humano(String nombre, int edad) {
		this.nombre = nombre;
		this.edad = edad;
	}
	
	@Override
	public String toString() {
	return this.nombre + " - " + this.edad;
	}
}

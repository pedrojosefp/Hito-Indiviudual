package hitoEj1_1_y_2;

public class Mujer extends Humano {
	private String colorU;
	private int velocidad;
	public Mujer(String nombre, int edad, String colorU) {
		super(nombre, edad);
		this.colorU = colorU;
	}
	@Override
	public String toString() {
		return "Hombre: " + super.toString() +
			" Color de uñas " + this.colorU + "]";

	}
	
	public void acelerar(int cuanto) {
		this.velocidad = this.velocidad + cuanto;
		}
		public void acelerar() {
		this.velocidad = this.velocidad + 10;
		}	
}

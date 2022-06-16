package hitoEj1_1_y_2;

public class Hombre extends Humano {
	private String colorP;
	private int velocidad;
	public Hombre(String nombre, int edad, String colorP) {
		super(nombre, edad);
		this.colorP = colorP;
	}
	@Override
	public String toString() {
		return "Hombre: " + super.toString() +
			" Color de pelo " + this.colorP + " que corre a la velocidad "+this.velocidad+ "]";

	}
	
	public void acelerar(int cuanto) {
		this.velocidad = this.velocidad + cuanto;
		}
		public void acelerar() {
		this.velocidad = this.velocidad + 10;
		}
		
		
}

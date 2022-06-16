package hitoEj1_3;

public class Cuadrado {
	private int lado1;
	private int lado2;
	private int lado3;
	private int lado4;
	
	public Cuadrado(int lado1, int lado2, int lado3, int lado4) {
		this.lado1 = lado1;
		this.lado2 = lado2;
		this.lado3 = lado3;
		this.lado4 = lado4;
	}
	@Override
	public String toString() {
		return "Cuadrado [" + lado1 + ", " + lado2 + ", " + lado3 + ", " + lado4 + "] ";
	}
	
	public String verTipo() {
		if (this.lado1==this.lado3||this.lado2==this.lado4) {
			return this.toString() + " Rectangulo";	
		}else {
			return this.toString() + " Cuadrado";
			
		}
			
	}
	
}

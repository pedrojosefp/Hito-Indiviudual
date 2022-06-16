package hitoEj1_3;

import java.util.ArrayList;

public class Principal {
	public static void main(String[] args) {
		ArrayList<Cuadrado> cuadr = new ArrayList<Cuadrado>();
		
                	// Añadimos dos elementos a la lista
		cuadr.add(new Cuadrado(1, 2, 1, 2));
		cuadr.add(new Cuadrado(1, 1, 1, 1));
		
		
		// cuadr.size() nos devuelve el número total de elementos guardados.
		System.out.println("Nº de elementos guardados: " + cuadr.size());
		System.out.println("Accediendo a la posición 1");
                	// trians.get(1) nos devuelve el elemento que ocupa la posición 1, 
// es decir, el segundo elemento, ya que el primer elemento es el 0.
		System.out.println(cuadr.get(1).verTipo());
		
		System.out.println("Recorriendo todos los elementos");
		for (int i=0; i<cuadr.size(); i++) {
			System.out.println(cuadr.get(i).verTipo()); 
		}
	}
}


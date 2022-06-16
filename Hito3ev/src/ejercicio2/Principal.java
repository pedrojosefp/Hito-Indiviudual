package ejercicio2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Principal {

	public static void main(String[] args) throws FileNotFoundException {
		File fichero = new File("textoHito.txt");
		Scanner lector = new Scanner(fichero);
		Scanner lectorTeclado = new Scanner(System.in);
		System.out.println("Introduce tu nombre:");
		String letra = lectorTeclado.nextLine();
		
		float puntos = 0;
		
		while (lector.hasNextLine()) {
			String linea = lector.nextLine();
			Scanner lectorLinea = new Scanner(linea);
			lectorLinea.useDelimiter(";");

			String campo1 = lectorLinea.next();
			String campo2 = lectorLinea.next();
			String campo3 = lectorLinea.next();
			String campo4 = lectorLinea.next();
			
			String campo5 = "";
			if (lectorLinea.hasNext()) 
				campo5 = lectorLinea.next();
			
				System.out.println(campo1);
				System.out.println(campo2);
				System.out.println(campo3);
				System.out.println(campo4);	
				if (lectorTeclado.nextLine().equals(campo5)) {
					puntos++;
				}else {
					puntos=puntos-0.5f;
				}
					
				System.out.println("Respuesta: "+campo5);
				System.out.println("--------------------------------");
				
								
			}
		
		System.out.println(letra + " tu puntuaje es: " + puntos);
		
		lector.close();
	}
}

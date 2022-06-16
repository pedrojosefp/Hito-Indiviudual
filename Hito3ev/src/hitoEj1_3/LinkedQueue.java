package hitoEj1_3;

import java.util.LinkedList;
import java.util.Queue;

public class LinkedQueue {
	
	public static void main(String[] args) {
		
		Queue queue = new LinkedList<String>() ;
			queue.add("Hola");
			queue.add("Hasta pronto");
			queue.add("Adios");
			System.out.println("Esto se ha añadido"+ queue);
			String value = (String) queue.remove();
			System.out.println("Esto se ha borrado "+ value);
			
		
	}
	
 
} 


package hitoEj1_3;

public class LinkedStack {

  class Node {
    Object elem;
    Node Siguiente;

    public Node(Object o) {
      elem = o;
      Siguiente = null;
    }
  }

  Node finalizado;
  int tamaño;

  public LinkedStack() {
    finalizado = null;
    tamaño = 0;
  }

  public void push(Object o) {
    Node nuevoNodo = new Node(o);
    if (finalizado == null)
      finalizado = nuevoNodo;
    else {
      nuevoNodo.Siguiente = finalizado;
      finalizado = nuevoNodo;
    }
    tamaño++;
  }; // inserta un objeto en la pila

  public Object pop() {
    if (finalizado == null)
      return null;
    ;
    Object o = finalizado.elem;
    finalizado = finalizado.Siguiente;
    tamaño--;
    return o;
  }//obtienes el objeto de la pila

  public boolean isEmpty() {

    return (tamaño == 0);
  }

  public int size() {

    return tamaño;
  }

  public Object end() {

    if (finalizado == null)
      return null;
    else
      return finalizado.elem;
  }

} 
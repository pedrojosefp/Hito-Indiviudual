
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
  int tama�o;

  public LinkedStack() {
    finalizado = null;
    tama�o = 0;
  }

  public void push(Object o) {
    Node nuevoNodo = new Node(o);
    if (finalizado == null)
      finalizado = nuevoNodo;
    else {
      nuevoNodo.Siguiente = finalizado;
      finalizado = nuevoNodo;
    }
    tama�o++;
  }; // inserta un objeto en la pila

  public Object pop() {
    if (finalizado == null)
      return null;
    ;
    Object o = finalizado.elem;
    finalizado = finalizado.Siguiente;
    tama�o--;
    return o;
  }//obtienes el objeto de la pila

  public boolean isEmpty() {

    return (tama�o == 0);
  }

  public int size() {

    return tama�o;
  }

  public Object end() {

    if (finalizado == null)
      return null;
    else
      return finalizado.elem;
  }

} 
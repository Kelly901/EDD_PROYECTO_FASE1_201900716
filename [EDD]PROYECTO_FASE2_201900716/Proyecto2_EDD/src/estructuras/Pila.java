/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras;

/**
 *
 * @author Kelly
 */
public class Pila {
         NodoPila cima;

    public Pila() {

        this.cima = null;

    }

    public boolean PilaVacia() {
        return this.cima == null;

    }

    public void push(Object nodoArbol) {
//String dato = null;
        //el nuevo nodo
        NodoPila nuevo = new NodoPila(nodoArbol);
        //el siguiente del nuevo nodo apuntara a la cima actual
        nuevo.setSiguiente(this.cima);
        //La cima cambia y se convierte en el nuevo nodo.
        this.cima = nuevo;

//        if (this.PilaVacia() == true) {
//
//            System.out.println("La pila esta vacia");
//
//        }
    }

    public Object pop() {
      Object nodo = null;
        if (PilaVacia() == true) {

            System.out.println("La pila esta vacia");

        } else {
            nodo = this.cima.getNodo();
            this.cima = this.cima.getSiguiente();

        }
        return nodo;

    }

    public void mostrar() {
        NodoPila temp = this.cima;

//        while (temp != null) {
//
//            System.out.println(temp.getNodo().getNumero());
//            System.out.println(temp.getNodo().getNumero());
//            System.out.println(temp.getNodo().getHijo_right().getNumero());
//            //this.pop();
//            temp = temp.getSiguiente();
//
//        }
    }
}

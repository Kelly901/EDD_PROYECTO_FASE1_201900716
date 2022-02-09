/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1_edd;

/**
 *
 * @author Kelly
 */
public class PilaImagenes {

    private NodoPilaI cima;

    public PilaImagenes() {

        this.cima = null;

    }

    public boolean PilaVacia() {
        return this.cima == null;

    }

    public void push(int id_cliente, String nombre_cliente, int img_color, int img_bw) {

        //el nuevo nodo
        NodoPilaI nuevo = new NodoPilaI(id_cliente, nombre_cliente, img_color, img_bw);
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

    public void pop() {
        if (PilaVacia() == true) {

            System.out.println("La pila esta vacia");

        } else {
            this.cima = this.cima.getSiguiente();

        }

    }

    public void mostrarPila() {
        NodoPilaI temp = this.cima;

        while (temp != null) {

            System.out.println(temp.getNombre_cliente());
            System.out.println(temp.getImg_bw());
            System.out.println(temp.getImg_color());
            //this.pop();

            temp = temp.getSiguiente();

        }

    }

///
}

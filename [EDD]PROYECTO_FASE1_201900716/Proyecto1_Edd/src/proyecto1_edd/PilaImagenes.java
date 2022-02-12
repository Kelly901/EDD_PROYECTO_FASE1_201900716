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

    public void retornarImagen(String nombreCliente) {
        NodoPilaI temp = this.cima;
        //Cliente cliente = null;

        while (temp != null) {
            if (temp.getNombre_cliente().equals(nombreCliente)) {
                if (temp.getImg_color() == 2) {
                    //cliente = new Cliente(temp.getId_cliente(), temp.getNombre_cliente(), temp.getImg_color(), temp.getImg_bw(), temp.getImg_color() + temp.getImg_bw());
                    CargaMasiva.impresora_c.encolar(temp.getId_cliente(), temp.getNombre_cliente(), temp.getImg_color());
                    this.pop();
                } else {
                    if (temp.getImg_bw() == 1) {
                        System.out.println("imagen blanco y negros");
                        //cliente = new Cliente(temp.getId_cliente(), temp.getNombre_cliente(), temp.getImg_color(), temp.getImg_bw(), temp.getImg_color() + temp.getImg_bw());
                        CargaMasiva.impresora_bw.encolar(temp.getId_cliente(), temp.getNombre_cliente(), temp.getImg_bw());

                        this.pop();
                    }

                }
//                this.pop();
            }

            temp = temp.getSiguiente();

        }
        //return cliente;
    }

    public void mostrarPila() {
        NodoPilaI temp = this.cima;

        while (temp != null) {

            System.out.println(temp.getNombre_cliente());
            System.out.println("color: " + temp.getImg_color());
            System.out.println("bw " + temp.getImg_bw());

            //this.pop();
            temp = temp.getSiguiente();

        }

    }

///
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1_edd;

/**
 *
 * @author Kelly
 */
public class ListaTop5Color {

    NodoAtendidos cabeza;
    public int tamaño = 0;

    public ListaTop5Color() {

        this.cabeza = null;

    }

//Orden descendente por medio de los colores
    public void ordenarLista(Cliente cliente) {

        NodoAtendidos nuevo = new NodoAtendidos(cliente);

        if (this.cabeza == null) {
            this.cabeza = nuevo;
        } else if (nuevo.getCliente().getImg_color2() > this.cabeza.getCliente().getImg_color2()) {
            nuevo.setSiguiente(this.cabeza);
            this.cabeza = nuevo;

        } else {

            NodoAtendidos aux = this.cabeza;
            while (aux.getSiguiente() != null) {
                if (nuevo.getCliente().getImg_color2() > aux.getSiguiente().getCliente().getImg_color2()) {
                    nuevo.setSiguiente(aux.getSiguiente());
                    aux.setSiguiente(nuevo);
                    break;
                }
                aux = aux.getSiguiente();
            }
            if (aux.getSiguiente() == null) {
                aux.setSiguiente(nuevo);
            }
        }

    }

    public void mostraLista() {
        NodoAtendidos temp = this.cabeza;
        System.out.println(">>>>>>>>>>>>>>>Top 5 de clientes como la mayor cantidad de imagenes a color");

//        while (temp != null) {
        for (int i = 0; i < 5; i++) {
       
                System.out.println("____________________________________________");

                System.out.println("Nombre:" + temp.getCliente().getNombre_cliente());
                System.out.println("imagenes a color" + temp.getCliente().getImg_color2());

            

            temp = temp.getSiguiente();
        }
//            System.out.println("____________________________________________");
//           
//            System.out.println("Nombre:" + temp.getCliente().getNombre_cliente());
//            System.out.println("imagenes a color" + temp.getCliente().getImg_color2());
//
//            temp = temp.getSiguiente();
//        }
    }

}

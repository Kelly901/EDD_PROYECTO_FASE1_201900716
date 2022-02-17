/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1_edd;

/**
 *
 * @author Kelly
 */
public class Top5Bw {

    NodoAtendidos cabeza;
    public int tamaño = 0;

    public Top5Bw() {

        this.cabeza = null;

    }

//Orden ascendente por medio de los colores
    public void ordenarLista(Cliente cliente) {

        NodoAtendidos nuevo = new NodoAtendidos(cliente);

        if (this.cabeza == null) {
            this.cabeza = nuevo;
        } else if (nuevo.getCliente().getImg_bw2() < this.cabeza.getCliente().getImg_bw2()) {
            nuevo.setSiguiente(this.cabeza);
            this.cabeza = nuevo;

        } else {

            NodoAtendidos aux = this.cabeza;
            while (aux.getSiguiente() != null) {
                if (nuevo.getCliente().getImg_bw2() < aux.getSiguiente().getCliente().getImg_bw2()) {
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
        System.out.println(">>>>>>>>>>>>>>>Top 5 de clientes como la mayor cantidad de imagenes Bw");
        for (int i = 0; i < 5; i++) {

            if (temp.getCliente().getImg_bw2() != 0) {
                System.out.println("____________________________________________");

                System.out.println("Nombre: " + temp.getCliente().getNombre_cliente());
                System.out.println("imagenes a BW: " + temp.getCliente().getImg_bw2());

            } else {
                i = i -1;
            }
            if (temp.getSiguiente()==null) {
                break;
            }

            temp = temp.getSiguiente();
        }
    }

}

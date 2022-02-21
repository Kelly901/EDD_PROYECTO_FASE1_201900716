/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1_edd;

/**
 *
 * @author Kelly
 */
public class ListaAtendidos {

    NodoAtendidos cabeza;
    public int tamaño = 0;

    public ListaAtendidos() {

        this.cabeza = null;

    }

    public void insertar(Cliente cliente) {
        NodoAtendidos nuevo = new NodoAtendidos(cliente);
        this.tamaño += 1;
        if (this.cabeza == null) {
            this.cabeza = nuevo;

        } else {
            NodoAtendidos auxiliar = this.cabeza;
            while (auxiliar.getSiguiente() != null) {
                auxiliar = auxiliar.getSiguiente();

            }
            auxiliar.setSiguiente(nuevo);

        }

    }

    public boolean listaVacia() {
        return this.cabeza == null;
    }

    public void buscarCliente(int id) {

        NodoAtendidos temp = this.cabeza;
        while (temp != null) {
            if (temp.getCliente().getId_cliente() == id) {
                System.out.println(">>>>>>>>>>>>>>>>>>>");
                System.out.println("Nombre: "+temp.getCliente().getNombre_cliente());
                System.out.println("Img Color: " + temp.getCliente().getImg_color2());
                System.out.println("Img Bw: " + temp.getCliente().getImg_bw2());
                System.out.println("Total de imagenes: " + temp.getCliente().getTotalImagenes());
                System.out.println("Pasos: " + temp.getCliente().getPasos());
            } else {
                System.out.println("No se encontro el cliente con ese id");
            }

            temp = temp.getSiguiente();
        }

    }

    public void mostraLista() {
        NodoAtendidos temp = this.cabeza;

        while (temp != null) {
            System.out.println("_________________________________________________");
            System.out.println("Nombre: " + temp.getCliente().getNombre_cliente());
            System.out.println("Ventanilla: " + temp.getCliente().getVentanilla());
            System.out.println("Pasos:" + temp.getCliente().getPasos());
            System.out.println("Total de imagenes " + temp.getCliente().getTotalImagenes());

            temp = temp.getSiguiente();
        }
    }
}

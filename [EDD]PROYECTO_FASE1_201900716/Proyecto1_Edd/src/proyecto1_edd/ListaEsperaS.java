/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1_edd;

/**
 *
 * @author Kelly
 */
public class ListaEsperaS {

    NodoListaE cabeza;

    public ListaEsperaS() {

        this.cabeza = null;

    }

    public void insertar(Cliente cliente) {
        NodoListaE nuevo = new NodoListaE(cliente);
        if (this.cabeza == null) {
            this.cabeza = nuevo;

        } else {
            NodoListaE auxiliar = this.cabeza;
            while (auxiliar.getSiguiente() != null) {
                auxiliar = auxiliar.getSiguiente();

            }
            auxiliar.setSiguiente(nuevo);

        }

    }

    public boolean listaVacia() {
        return this.cabeza == null;
    }

    public void mostraLista() {
        NodoListaE temp = this.cabeza;

        while (temp != null) {
            System.out.println("Img Color: " + temp.getCliente().getImg_color());
            System.out.println("Img Bw: " + temp.getCliente().getImg_bw());
            temp = temp.getSiguiente();
        }
    }

}

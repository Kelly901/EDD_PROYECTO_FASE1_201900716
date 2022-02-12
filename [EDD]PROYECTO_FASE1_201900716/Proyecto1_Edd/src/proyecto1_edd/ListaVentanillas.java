/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1_edd;

/**
 *
 * @author Kelly
 */
public class ListaVentanillas {

    NodoVentanilla cabeza;

    public ListaVentanillas() {

        this.cabeza = null;

    }

    public void insertar(PilaImagenes pila, String ventanilla, Cliente cliente) {

        NodoVentanilla nuevo = new NodoVentanilla(pila, ventanilla, cliente);

        if (this.cabeza == null) {

            this.cabeza = nuevo;

        } else {

            NodoVentanilla auxiliar = this.cabeza;

            while (auxiliar.getSiguiente() != null) {

                auxiliar = auxiliar.getSiguiente();

            }
            auxiliar.setSiguiente(nuevo);

        }

    }

    public void mostrarLista() {

        NodoVentanilla temp = this.cabeza;

        while (temp != null) {
            System.out.println("_____________________\n");
            System.out.println("Nombre:" + temp.getVentanillas());
            if (temp.getCliente() != null) {

               temp.getCliente().mostrarCliente();

            }
            temp.getPila().mostrarPila();

            temp = temp.getSiguiente();

        }

    }
///

    public String devolverPila() {
        NodoVentanilla temp = this.cabeza;
        String pila = null;
        while (temp != null) {

            //this.pop();
            if (temp.getPila().PilaVacia() == true) {
                pila = temp.getVentanillas();
                //System.out.println("ventanillas vacia:" + temp.getVentanillas());
                temp = null;
                break;

            }
//
            temp = temp.getSiguiente();

        }
        return pila;
    }

}

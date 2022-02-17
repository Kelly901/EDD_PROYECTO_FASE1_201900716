/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1_edd;

/**
 *
 * @author Kelly
 */
public class ClienteConMasPasos {

    NodoAtendidos cabeza;
    public int tamaño = 0;

    public ClienteConMasPasos() {

        this.cabeza = null;

    }

//Orden descendente por medio de los colores
    public void ordenarLista(Cliente cliente) {

        NodoAtendidos nuevo = new NodoAtendidos(cliente);

        if (this.cabeza == null) {
            this.cabeza = nuevo;
        } else if (nuevo.getCliente().getPasos() > this.cabeza.getCliente().getPasos()) {
            nuevo.setSiguiente(this.cabeza);
            this.cabeza = nuevo;

        } else {

            NodoAtendidos aux = this.cabeza;
            while (aux.getSiguiente() != null) {
                if (nuevo.getCliente().getPasos() > aux.getSiguiente().getCliente().getPasos()) {
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
        System.out.println(">>>>>>>>>>>>>>>Cliente com mayor cantidad de pasos<<<<<<<<<<<<<<<<<<<<<<");

        System.out.println("____________________________________________");

        System.out.println("Nombre:" + temp.getCliente().getNombre_cliente());
        System.out.println("Pasos" + temp.getCliente().getPasos());

    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1_edd;

/**
 *
 * @author Kelly
 */
public class ListaCircular {

    NodoCircular primero;
    NodoCircular ultimo;

    public ListaCircular() {

        this.primero = null;
        this.ultimo = null;
    }

    public void insertar(ListaEsperaS lista, Cliente cliente) {

        NodoCircular nuevo = new NodoCircular(lista, cliente);

        if (this.primero == null) {

            this.primero = nuevo;
            this.ultimo = nuevo;
            this.primero.setSiguiente(this.ultimo);
            this.primero.setAnterior(this.ultimo);
            this.ultimo.setSiguiente(this.primero);
            this.ultimo.setAnterior(this.primero);

        } else {
            this.primero.setAnterior(nuevo);
            nuevo.setAnterior(this.primero);
            this.ultimo.setSiguiente(nuevo);
            nuevo.setAnterior(this.ultimo);
            nuevo.setSiguiente(this.primero);
            this.ultimo = nuevo;

        }

    }

    public void mostrar() {
        System.out.println(".----");
        NodoCircular aux = this.primero;
        while (aux.getSiguiente() != this.primero) {
            System.out.println("______________r_");
            System.out.println("LIsta");
            System.out.println(aux.getCliente().getNombre_cliente());
            aux = aux.getSiguiente();

        }
        System.out.println(aux.getCliente().getNombre_cliente());
        System.out.println("LIsta");
        aux.getLista().mostraLista();
        System.out.println(">>>>>><F<<<<<<<<<<<");

    }

}

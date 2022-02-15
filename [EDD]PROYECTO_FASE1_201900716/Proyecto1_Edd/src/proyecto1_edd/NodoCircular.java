/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1_edd;

/**
 *
 * @author Kelly
 */
public class NodoCircular {

    private ListaEsperaS lista;
    private Cliente cliente;
    private NodoCircular siguiente;
    private NodoCircular anterior;

    public NodoCircular(ListaEsperaS lista, Cliente cliente) {
        this.lista = lista;
        this.cliente = cliente;
        this.siguiente = null;
        this.anterior = null;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public NodoCircular getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoCircular siguiente) {
        this.siguiente = siguiente;
    }

    public NodoCircular getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoCircular anterior) {
        this.anterior = anterior;
    }

    public ListaEsperaS getLista() {
        return lista;
    }

    public void setLista(ListaEsperaS lista) {
        this.lista = lista;
    }
}

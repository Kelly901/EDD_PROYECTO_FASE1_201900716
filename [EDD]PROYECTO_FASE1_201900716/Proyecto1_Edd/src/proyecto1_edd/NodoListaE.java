/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1_edd;

/**
 *
 * @author Kelly
 */
public class NodoListaE {

    private Cliente cliente;
    private NodoListaE siguiente;

    public NodoListaE(Cliente cliente) {
        this.cliente = cliente;
        this.siguiente = null;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public NodoListaE getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoListaE siguiente) {
        this.siguiente = siguiente;
    }

}

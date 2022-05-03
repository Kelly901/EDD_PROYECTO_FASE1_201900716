/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *
 * @author herre
 */
public class Nodo_lista {
    
    private Clientes cliente;
    private Nodo_lista siguiente;

    public Nodo_lista(Clientes cliente) {
        this.cliente = cliente;
        
        this.siguiente=null;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public Nodo_lista getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo_lista siguiente) {
        this.siguiente = siguiente;
    }
    
    
}

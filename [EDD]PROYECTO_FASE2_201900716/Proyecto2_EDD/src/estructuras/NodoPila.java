/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras;

/**
 *
 * @author Kelly
 */
public class NodoPila {
     int dato;
    private Object nodo;
    private NodoPila siguiente;

    public NodoPila(Object nodo) {
        this.nodo = nodo;
        this.siguiente = null;
    }

    public Object getNodo() {
        return nodo;
    }

    public void setNodo(Object nodo) {
        this.nodo = nodo;
    }

    public NodoPila getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoPila siguiente) {
        this.siguiente = siguiente;
    }

}

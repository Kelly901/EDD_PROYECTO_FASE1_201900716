/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras;

/**
 *
 * @author Kelly
 */
public class NodoCircular {

    private String nombre;
    private Lista_de_album lista;
    private NodoCircular siguiente;
    private NodoCircular anterior;

    public NodoCircular(String nombre, Lista_de_album lista) {
        this.lista = lista;
        this.nombre = nombre;

        this.siguiente = null;
        this.anterior = null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public Lista_de_album getLista() {
        return lista;
    }

    public void setLista(Lista_de_album lista) {
        this.lista = lista;
    }
}

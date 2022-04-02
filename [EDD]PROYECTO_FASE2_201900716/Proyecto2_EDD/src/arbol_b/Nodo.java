/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arbol_b;

/**
 *
 * @author Kelly
 */
public class Nodo {
    private long id;
    private Nodo anterior;
    private Nodo siguiente;
    private Pagina right;
    private Pagina left;

    public Nodo(long id) {
        this.id = id;
        this.anterior = this.siguiente = null;
        this.left = this.right = null;
    }

    public Nodo(long id, Pagina izquierda, Pagina derecha) {
        this.id = id;
        this.anterior = this.siguiente = null;
        this.left = izquierda;
        this.right = derecha;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Nodo getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public Pagina getRight() {
        return right;
    }

    public void setRight(Pagina right) {
        this.right = right;
    }

    public Pagina getLeft() {
        return left;
    }

    public void setLeft(Pagina left) {
        this.left = left;
    }
}

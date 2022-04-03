/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arbol_b;

import estructuras.Arbol_avl;
import estructuras.Arbol_binario;

/**
 *
 * @author Kelly
 */
public class Nodo {

    private long id;
    private String nombre_cliente;
    private String password;
    private Arbol_binario arbol_binario;
    private Arbol_avl arbolAvl;

    private Nodo anterior;
    private Nodo siguiente;
    private Pagina right;
    private Pagina left;

    public Nodo(long id, String nombre_cliente, String pasword, Arbol_binario arbol_binario, Arbol_avl arbolAvl) {
        this.id = id;
        this.nombre_cliente = nombre_cliente;
        this.password = pasword;
        this.arbol_binario = arbol_binario;
        this.arbolAvl = arbolAvl;
        this.anterior = this.siguiente = null;
        this.left = this.right = null;
    }

    public Nodo(long id, String nombre_cliente, String pasword, Arbol_binario arbol_binario, Arbol_avl arbolAvl, Pagina izquierda, Pagina derecha) {
        this.id = id;
        this.nombre_cliente = nombre_cliente;
        this.password = pasword;
        this.arbol_binario = arbol_binario;
        this.arbolAvl = arbolAvl;
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

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Arbol_binario getArbol_binario() {
        return arbol_binario;
    }

    public void setArbol_binario(Arbol_binario arbol_binario) {
        this.arbol_binario = arbol_binario;
    }

    public Arbol_avl getArbolAvl() {
        return arbolAvl;
    }

    public void setArbolAvl(Arbol_avl arbolAvl) {
        this.arbolAvl = arbolAvl;
    }

}

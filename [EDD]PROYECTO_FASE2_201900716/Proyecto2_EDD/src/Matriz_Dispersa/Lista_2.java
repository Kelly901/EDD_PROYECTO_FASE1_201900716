/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Matriz_Dispersa;

/**
 *
 * @author Kelly
 */
public class Lista_2 {

    public NodoListaDentro primero;
    public int tamanio;

    public Lista_2() {
        this.primero = null;
        this.tamanio = 0;
    }

    public void add(Nodo n) {
        NodoListaDentro nodo = new NodoListaDentro(n, tamanio);
        tamanio++;
        if (this.primero == null) {
            this.primero = nodo;

        } else {
            NodoListaDentro aux = this.primero;
            while (aux.siguiente != null) {
                aux = aux.siguiente;
            }
            aux.siguiente = nodo;
        }
    }

    public Nodo get(int id) {
        NodoListaDentro aux = this.primero;
        while (aux != null) {
            if (aux.id == id) {
                return aux.contenido;
            }
            aux = aux.siguiente;
        }
        return null;
    }

    public int size() {
        return this.tamanio;
    }

}

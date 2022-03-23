/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Matriz_Dispersa;

/**
 *
 * @author Kelly
 */
public class ListaEnlazada {
     public NodoLista_Enlazada primero;
    public int tamanio;

    public ListaEnlazada() {
        this.primero = null;
    }

    public void add(Lista_2 lista) {
        NodoLista_Enlazada nodo = new NodoLista_Enlazada(lista, tamanio);
        tamanio++;
        if (this.primero == null) {
            this.primero = nodo;
        } else {
            NodoLista_Enlazada aux = this.primero;
            while (aux.siguiente != null) {
                aux = aux.siguiente;
            }
            aux.siguiente = nodo;
        }
    }

    public Lista_2 get(int id) {
        NodoLista_Enlazada aux = this.primero;
        while (aux != null) {
            if (aux.id == id) {
                return aux.lista;
            }
            aux = aux.siguiente;
        }
        return null;
    }

    public int size() {
        return this.tamanio;
    }
}

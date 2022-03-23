/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras;

/**
 *
 * @author Kelly
 */
public class ListaAvl {
     public Nodo_Lista_Avl primero;
    public int tamanio;

    public ListaAvl() {
        this.primero = null;
        this.tamanio = 0;
    }

    public void add(NodeAvl n) {
        Nodo_Lista_Avl nodo = new Nodo_Lista_Avl(n, tamanio);
        tamanio++;
        if (this.primero == null) {
            this.primero = nodo;

        } else {
            Nodo_Lista_Avl aux = this.primero;
            while (aux.siguiente != null) {
                aux = aux.siguiente;
            }
            aux.siguiente = nodo;
        }
    }

    public NodeAvl get(int id) {
        Nodo_Lista_Avl aux = this.primero;
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

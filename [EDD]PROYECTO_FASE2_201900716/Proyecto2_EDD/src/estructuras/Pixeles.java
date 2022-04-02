/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras;

/**
 *
 * @author Kelly
 */
public class Pixeles {
 public NodoPixeles primero;
    public int tamanio;

    public Pixeles() {
        this.primero = null;
        this.tamanio = 0;
    }

    public void add(int fila, int columna, String color) {
        NodoPixeles nodo = new NodoPixeles(fila, columna, color);
        tamanio++;
        if (this.primero == null) {
            this.primero = nodo;

        } else {
            NodoPixeles aux = this.primero;
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nodo);
        }
    }

   

    public int size() {
        return this.tamanio;
    }
   
}

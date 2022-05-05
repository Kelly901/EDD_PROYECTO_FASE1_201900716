/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *
 * @author herre
 */
public class Lista2 {

   public NodoLista2 raiz;
   
    public void insertar(Object ob) {
        NodoLista2 nuevo = new NodoLista2(ob);

        if (this.raiz == null) {
            raiz = nuevo;
        } else {

            NodoLista2 temp = this.raiz;

            while (temp.siguiente != null) {
                temp = temp.siguiente;
            }
            temp.siguiente = nuevo;
        }

    }

    public int size() {
        int tamaño = 0;
        NodoLista2 auxiliar = this.raiz;

        while (auxiliar.siguiente != null) {
            tamaño++;
            auxiliar = auxiliar.siguiente;

        }
        return tamaño;
    }

    public boolean getDato(int vertice) {
        NodoLista2 temp = this.raiz;

        while (temp != null) {

            Vertice v = (Vertice) temp.objeto;
            if (v.numVertice == vertice) {
                return true;
            }
            temp = temp.siguiente;
        }
        return false;
    }

}

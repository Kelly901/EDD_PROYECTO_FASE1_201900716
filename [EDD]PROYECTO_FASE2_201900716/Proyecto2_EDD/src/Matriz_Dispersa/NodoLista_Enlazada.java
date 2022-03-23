/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Matriz_Dispersa;

/**
 *
 * @author Kelly
 */
public class NodoLista_Enlazada {
    
    public NodoLista_Enlazada siguiente;
    public Lista_2 lista;
    public int id;

    public NodoLista_Enlazada(Lista_2 lista, int id) {
        this.siguiente = null;
        this.lista = lista;
        this.id = id;
    }
}

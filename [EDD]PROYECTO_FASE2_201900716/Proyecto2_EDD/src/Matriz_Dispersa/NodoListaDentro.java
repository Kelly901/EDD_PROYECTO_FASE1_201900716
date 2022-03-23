/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Matriz_Dispersa;

/**
 *
 * @author Kelly
 */
public class NodoListaDentro {
     public Nodo contenido;
    public NodoListaDentro siguiente;
    public int id;

    public NodoListaDentro(Nodo contenido, int id) {
        this.contenido = contenido;
        this.id = id;
        this.siguiente = null;
    }

}

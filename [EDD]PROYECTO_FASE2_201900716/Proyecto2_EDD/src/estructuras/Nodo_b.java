/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras;

/**
 *
 * @author Kelly
 */
public class Nodo_b {

    long dpi;
    String nombre;
    String password;
    Nodo_b anterior;
    Nodo_b siguiente;
    Rama derecha;
    Rama izquierda;

    public Nodo_b(long dpi, String nombre, String password) {

        this.dpi = dpi;
        this.nombre = nombre;
        this.password = password;
        this.anterior = null;
        this.siguiente = null;
        this.derecha = null;
        this.izquierda = null;

    }

}

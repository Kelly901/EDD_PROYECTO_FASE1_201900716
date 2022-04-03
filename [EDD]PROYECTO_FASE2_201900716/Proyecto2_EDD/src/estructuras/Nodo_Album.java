/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras;

/**
 *
 * @author Kelly
 */
public class Nodo_Album {

    private int imagen;
    private Nodo_Album siguiente;

    public Nodo_Album(int imagen) {
        this.imagen = imagen;

        this.siguiente = null;
    }

    public Nodo_Album getSiguiente() {
        return siguiente;

    }

    public void setSiguiente(Nodo_Album siguiente) {
        this.siguiente = siguiente;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras;

/**
 *
 * @author Kelly
 */
public class Nodo_Lista_Avl {

    public NodeAvl contenido;
    public Nodo_Lista_Avl siguiente;
    public int id;

    public Nodo_Lista_Avl(NodeAvl contenido, int id) {
        this.contenido = contenido;
        this.id = id;
        this.siguiente = null;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1_edd;

/**
 *
 * @author Kelly
 */
public class Nodo_impresoraC {

    private int id_cliente;
    private String nombre_cliente;
    private int img_color;

    private Nodo_impresoraC siguiente;

    public Nodo_impresoraC(int id_cliente, String nombre_cliente, int img_color) {
        this.id_cliente = id_cliente;
        this.nombre_cliente = nombre_cliente;
        this.img_color = img_color;
 
        this.siguiente = null;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public int getImg_color() {
        return img_color;
    }

    public void setImg_color(int img_color) {
        this.img_color = img_color;
    }

  

    public Nodo_impresoraC getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo_impresoraC siguiente) {
        this.siguiente = siguiente;
    }

}

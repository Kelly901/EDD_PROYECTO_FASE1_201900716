/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1_edd;

/**
 *
 * @author Kelly
 */
public class Nodo_impresoraBw {

    private int id_cliente;
    private String nombre_cliente;
    private int img_bw;
    private Nodo_impresoraBw siguiente;

    public Nodo_impresoraBw(int id_cliente, String nombre_cliente, int img_bw) {
        this.id_cliente = id_cliente;
        this.nombre_cliente = nombre_cliente;
        this.img_bw = img_bw;
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

    public int getImg_bw() {
        return img_bw;
    }

    public void setImg_bw(int img_bw) {
        this.img_bw = img_bw;
    }

    public Nodo_impresoraBw getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo_impresoraBw siguiente) {
        this.siguiente = siguiente;
    }

}

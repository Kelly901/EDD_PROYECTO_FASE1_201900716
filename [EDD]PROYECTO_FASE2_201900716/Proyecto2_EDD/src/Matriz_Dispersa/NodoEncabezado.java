/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Matriz_Dispersa;

/**
 *
 * @author Kelly
 */
public class NodoEncabezado {

    private int id;
    private NodoEncabezado siguiente;
    private NodoEncabezado anterior;


    public NodoEncabezado(int id) {
        this.id = id;
        this.siguiente = null;
        this.anterior = null;
//Acceso al nodo interno de la matriz
        this.acceso = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public NodoEncabezado getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoEncabezado siguiente) {
        this.siguiente = siguiente;
    }

    public NodoEncabezado getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoEncabezado anterior) {
        this.anterior = anterior;
    }

    public Nodo getAcceso() {
        return acceso;
    }

    public void setAcceso(Nodo acceso) {
        this.acceso = acceso;
    }
    private Nodo acceso;

}

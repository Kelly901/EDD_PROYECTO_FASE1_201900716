/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras;

/**
 *
 * @author Kelly
 */
public class NodoPixeles {

    private int fila;
    private int columna;
    private String color;
    private NodoPixeles siguiente;

    public NodoPixeles(int fila, int columna, String color) {
        this.fila = fila;
        this.columna = columna;
        this.color = color;
    }

    public NodoPixeles getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoPixeles siguiente) {
        this.siguiente = siguiente;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}

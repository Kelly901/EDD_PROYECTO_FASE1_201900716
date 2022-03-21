/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras;

/**
 *
 * @author Kelly
 */
public class NodoMatriz {

    private String dato;
    private int i;
    private int j;
    private NodoMatriz abajo;
    private NodoMatriz arriba;
    private NodoMatriz siguiente;
    private NodoMatriz anterior;

    public NodoMatriz(String dato, int i, int j) {
        this.dato = dato;
        this.i = i;
        this.j = j;
        this.abajo = null;
        this.arriba = null;
        this.anterior = null;
        this.siguiente = null;
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }

    public NodoMatriz getAbajo() {
        return abajo;
    }

    public void setAbajo(NodoMatriz abajo) {
        this.abajo = abajo;
    }

    public NodoMatriz getArriba() {
        return arriba;
    }

    public void setArriba(NodoMatriz arriba) {
        this.arriba = arriba;
    }

    public NodoMatriz getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoMatriz siguiente) {
        this.siguiente = siguiente;
    }

    public NodoMatriz getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoMatriz anterior) {
        this.anterior = anterior;
    }

    public String toString() {
        return "(" +this.getI()+" ,"+this.getJ()+")"+" dato: "+this.getDato();
    }

}

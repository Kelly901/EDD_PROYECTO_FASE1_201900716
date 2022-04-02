/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras;

/**
 *
 * @author Kelly
 */
public class NodoArbolBinario {
     private Capas capas;
    private NodoArbolBinario hijo_left;
    private NodoArbolBinario hijo_right;

    public NodoArbolBinario(Capas capas) {
        this.capas =capas;
        this.hijo_left = this.hijo_right;
       
    }

    public Capas getCapas() {
        return capas;
    }

    public void setCapas(Capas capas) {
        this.capas = capas;
    }

    public NodoArbolBinario getHijo_left() {
        return hijo_left;
    }

    public void setHijo_left(NodoArbolBinario hijo_left) {
        this.hijo_left = hijo_left;
    }

    public NodoArbolBinario getHijo_right() {
        return hijo_right;
    }

    public void setHijo_right(NodoArbolBinario hijo_right) {
        this.hijo_right = hijo_right;
    }
}

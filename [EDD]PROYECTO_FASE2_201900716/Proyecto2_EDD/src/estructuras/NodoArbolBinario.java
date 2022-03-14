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
     private int id;
    private NodoArbolBinario hijo_left;
    private NodoArbolBinario hijo_right;

    public NodoArbolBinario(int id) {
        this.id =id;
        this.hijo_left = this.hijo_right;
       
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

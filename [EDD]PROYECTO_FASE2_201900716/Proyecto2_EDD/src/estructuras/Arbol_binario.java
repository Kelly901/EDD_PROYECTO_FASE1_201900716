/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras;

/**
 *
 * @author Kelly
 */
public class Arbol_binario {

    public NodoArbolBinario raiz;

    public Arbol_binario() {
        this.raiz = null;
    }

    public void agregar(int valor) {
        this.raiz = metodoRecursivo(valor, this.raiz);
    }

//Agregar
    public NodoArbolBinario metodoRecursivo(int valor, NodoArbolBinario raiz) {

        if (raiz == null) {
            NodoArbolBinario nodoArbol = new NodoArbolBinario(valor);
            return nodoArbol;

        } else {
            if (valor < raiz.getId()) {

                raiz.setHijo_left(this.metodoRecursivo(valor, raiz.getHijo_left()));
            } else {
                raiz.setHijo_right(this.metodoRecursivo(valor, raiz.getHijo_right()));
            }
        }
        return raiz;
    }

    public void pre_orden() {
        this.pre_order_recursivo(this.raiz);
    }

    public void pre_order_recursivo(NodoArbolBinario raiz) {
        if (raiz != null) {

            System.out.println("Valor :" + raiz.getId());
            this.pre_order_recursivo(raiz.getHijo_left());
            this.pre_order_recursivo(raiz.getHijo_right());
        }

    }

    public void in_orden() {
        this.in_order_recursivo(this.raiz);
    }

    public void in_order_recursivo(NodoArbolBinario raiz) {
        if (raiz != null) {
            this.in_order_recursivo(raiz.getHijo_left());
            System.out.println("Valor :" + raiz.getId());

            this.in_order_recursivo(raiz.getHijo_right());
        }
    }

    public void post_orden() {
        this.post_order_recursivo(this.raiz);
    }

    public void post_order_recursivo(NodoArbolBinario raiz) {
        if (raiz != null) {
            this.post_order_recursivo(raiz.getHijo_left());

            this.post_order_recursivo(raiz.getHijo_right());
            System.out.println("Valor :" + raiz.getId());
        }
    }
}

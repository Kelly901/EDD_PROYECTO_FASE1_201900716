/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras;

/**
 *
 * @author Kelly
 */
public class NodeAvl {

    private int dato;
    private Arbol_binario arbol_binaro;
    private int altura;
    private NodeAvl izquierdo;
    private NodeAvl derecho;

    public NodeAvl(int dato, Arbol_binario binario) {
        this.arbol_binaro = binario;
        this.dato = dato;
        this.altura = 1;
        this.izquierdo = null;
        this.derecho = null;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public Arbol_binario getArbol_binaro() {
        return arbol_binaro;
    }

    public void setArbol_binaro(Arbol_binario arbol_binaro) {
        this.arbol_binaro = arbol_binaro;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public NodeAvl getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(NodeAvl izquierdo) {
        this.izquierdo = izquierdo;
    }

    public NodeAvl getDerecho() {
        return derecho;
    }

    public void setDerecho(NodeAvl derecho) {
        this.derecho = derecho;
    }

}

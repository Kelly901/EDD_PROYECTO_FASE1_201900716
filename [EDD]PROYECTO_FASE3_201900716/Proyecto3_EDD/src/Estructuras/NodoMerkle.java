/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *
 * @author herre
 */
public class NodoMerkle {
    
    NodoMerkle izuqierdo;
    NodoMerkle derecho;
    String hash;

    public NodoMerkle(NodoMerkle izuqierdo, NodoMerkle derecho, String hash) {
        this.izuqierdo = izuqierdo;
        this.derecho = derecho;
        this.hash = hash;
    }
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras;

import arbol_b.Pagina;

/**
 *
 * @author Kelly
 */
public class Cola_arbol_b {
     NodoCola frente;
   NodoCola fin;

    public Cola_arbol_b() {
        this.frente = null;
        this.fin = null;
    }

  public boolean colaVacia() {

        return this.frente == null;
    }

public void encolar(String padre,Pagina rama,int datos) {

        NodoCola nuevo = new NodoCola(new Atributos_arbolB(padre,rama, datos));
        if (colaVacia()) {
            this.frente = nuevo;

        } else {
            nuevo.setSiguiente(null);
            this.fin.setSiguiente(nuevo);

        }
        this.fin = nuevo;
    }



 public Object desencolar() {
        Object auxiliar = null;
      
        if (!colaVacia()) {
           
            auxiliar = this.frente;
 
            this.frente = this.frente.getSiguiente();


        }

        return auxiliar;

    }
}

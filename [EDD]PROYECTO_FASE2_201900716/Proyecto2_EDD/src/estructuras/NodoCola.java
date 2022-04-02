/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras;

/**
 *
 * @author Kelly
 */
public class NodoCola {

    private Atributos_arbolB atributos;
    private NodoCola siguiente;

    public NodoCola(Atributos_arbolB atributos) {
        this.atributos = atributos;
        this.siguiente = null;
    }

    public NodoCola getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoCola siguiente) {
        this.siguiente = siguiente;
    }

    public Atributos_arbolB getAtributos() {
        return atributos;
    }

    public void setAtributos(Atributos_arbolB atributos) {
        this.atributos = atributos;
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras;

/**
 *
 * @author Kelly
 */
public class Encabezado {
      NodoEncabezado primero;

    public Encabezado(NodoEncabezado primero) {

        this.primero = primero;

    }

    public void setEncabezado(NodoEncabezado nuevo) {

        if (this.primero == null) {
            this.primero = nuevo;
        } else if (nuevo.getId() < this.primero.getId()) {
            nuevo.setSiguiente(this.primero);
            this.primero.setAnterior(nuevo);
            this.primero = nuevo;
        } else {

            NodoEncabezado actual = this.primero;
            while (actual.getSiguiente() != null) {
                if (nuevo.getId() < actual.getSiguiente().getId()) {
                    nuevo.setSiguiente(actual.getSiguiente());
                    actual.getSiguiente().setAnterior(nuevo);
                    nuevo.setAnterior(actual);
                    actual.setSiguiente(nuevo);
                    break;

                }
                actual = actual.getSiguiente();

            }
            if (actual.getSiguiente() == null) {
                actual.setSiguiente(nuevo);
                nuevo.setAnterior(actual);
            }

        }

    }

    public NodoEncabezado getEncabezado(int id) {
        NodoEncabezado actual = this.primero;
        while (actual != null) {
            if (actual.getId() == id) {
                return actual;
            }
            actual = actual.getSiguiente();
        }
        return null;

    }

}

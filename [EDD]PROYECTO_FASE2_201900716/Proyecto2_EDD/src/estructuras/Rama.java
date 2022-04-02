/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras;

/**
 *
 * @author Kelly
 */
public class Rama {

    int contador;
    boolean hoja;
    Nodo_b primero;

    public Rama() {
        this.contador = 0;
        this.hoja = true;
        this.primero = null;
    }

    void insertar(Nodo_b nodo) {

        if (this.primero == null) {
            this.primero = nodo;
            this.contador++;
        } else {
            Nodo_b temp = this.primero;
            do {
                if (nodo.dpi<=temp.dpi ) {
                    this.contador++;
                    if (temp == this.primero) {
                        this.primero.anterior = nodo;
                        this.primero.izquierda = nodo.derecha;
                        this.primero = nodo;
                        break;
                    } else {
                        nodo.anterior = temp.anterior;
                        nodo.siguiente = temp;
                        temp.anterior.siguiente = nodo;
                        temp.anterior.derecha = nodo.izquierda;
                        temp.anterior = nodo;
                        temp.izquierda = nodo.derecha;
                        break;
                    }
                } else if (temp.siguiente == null) {
                    this.contador++;
                    temp.siguiente = nodo;
                    temp.derecha = nodo.izquierda;
                    nodo.anterior = temp;
                    nodo.siguiente = null;
                    break;
                }
                temp = temp.siguiente;
            } while (temp != null);
        }
    }

    public String imprimir() {

        String cadena = "";
        Nodo_b temp = this.primero;

        int cont = 0;
        while (temp != null) {
            Nodo_b temp2 = temp.izquierda.primero;
//            if (cont == 0) {
//                cadena = String.valueOf(temp.cliente.getDpi());
//            } else {
//                cadena += "|" + String.valueOf(temp.cliente.getDpi()) + "|";
//            }

            cont++;
            System.out.println("____" + temp.dpi + "_______");
//            while (temp2 != null) {
//                System.out.println(temp2.valor);
//                temp2 = temp2.siguiente;
//
//            }
            temp = temp.siguiente;

        }

        return cadena;

    }

    public boolean devolverCliente(Nodo_b nodo, String dpi) {

        while (nodo != null) {

            System.out.println("____" + nodo.dpi + "_______");
//            re
            if (nodo.dpi == 0) {
                return true;
            }
            nodo = nodo.siguiente;

        }
        return false;

    }
}

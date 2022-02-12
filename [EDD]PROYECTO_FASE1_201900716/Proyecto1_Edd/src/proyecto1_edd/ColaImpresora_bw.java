/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1_edd;

/**
 *
 * @author Kelly
 */
public class ColaImpresora_bw {

    Nodo_impresoraBw frente;
    Nodo_impresoraBw fin;

    public ColaImpresora_bw(){
        this.frente = null;
        this.fin = null;

    }

    public boolean colaVacia() {

        return this.frente == null;
    }

    public void encolar(int id_cliente, String nombre_cliente, int img_bw) {

        Nodo_impresoraBw nuevo = new Nodo_impresoraBw(id_cliente, nombre_cliente, img_bw);
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

 public void mostrar() {

        Nodo_impresoraBw aux = this.frente;

        while (aux != null) {

            System.out.println(aux.getNombre_cliente()+"-> imagen bw"+aux.getImg_bw());

          
            aux = aux.getSiguiente();
        }

    }

}

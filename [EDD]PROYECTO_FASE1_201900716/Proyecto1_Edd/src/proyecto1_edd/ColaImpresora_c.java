/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1_edd;

/**
 *
 * @author Kelly
 */
public class ColaImpresora_c {
    Nodo_impresoraC frente;
    Nodo_impresoraC fin;

    public ColaImpresora_c() {
        this.frente = null;
        this.fin = null;
    }

  public boolean colaVacia() {

        return this.frente == null;
    }


public void encolar(int id_cliente, String nombre_cliente, int img_color) {

        Nodo_impresoraC nuevo = new Nodo_impresoraC(id_cliente, nombre_cliente, img_color);
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
  public Object devolverCliente() {

        Cliente cliente = null;
        
        if (!colaVacia()) {
     
            cliente=new Cliente(this.frente.getId_cliente(),this.frente.getNombre_cliente(),this.frente.getImg_color(),0,0);

        }

        return cliente;

    }


 public void mostrar() {

        Nodo_impresoraC aux = this.frente;

        while (aux != null) {

            System.out.println(aux.getNombre_cliente()+"-> imagen color"+aux.getImg_color());

          
            aux = aux.getSiguiente();
        }

    }
}

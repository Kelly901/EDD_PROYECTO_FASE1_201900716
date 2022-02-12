/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1_edd;

/**
 *
 * @author Kelly
 */
public class Cola_clientes {

    NodoCola frente;
    NodoCola fin;
    int cont = 0;
    int cont2 = 0;

    public Cola_clientes() {
        this.fin = null;
        this.frente = null;

    }

    public void encolar(int id_cliente, String nombre_cliente, int img_color, int img_bw) {

        NodoCola nuevo = new NodoCola(id_cliente, nombre_cliente, img_color, img_bw);
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
        //System.out.println("descencolar");
        if (!colaVacia()) {
            //System.out.println(this.frente.getNombre_cliente());
            auxiliar = this.frente;
            //auxiliar = this.frente.getNombre_cliente();
//            if (this.frente.getImg_color() <= 0 && this.frente.getImg_bw() <= 0) {

            //System.out.println("Estoy en la cola");
            this.frente = this.frente.getSiguiente();

//            } else {
//                auxiliar = this.frente.getImg_color()+this.frente.getImg_bw();
//                this.cont++;
//                this.cont2++;
//                this.frente.setImg_bw(this.frente.getImg_bw() - this.cont);
//                this.frente.setImg_color(this.frente.getImg_color() - this.cont2);
//                pila.push(this.frente.getId_cliente(), this.frente.getNombre_cliente(), cont, cont2);
//            }
        }

        return auxiliar;

    }

    public Object devolverCliente() {

        Cliente cliente = null;
        
        if (!colaVacia()) {
     
            cliente=new Cliente(frente.getId_cliente(),frente.getNombre_cliente(),this.frente.getImg_color(), this.frente.getImg_bw(),this.frente.getImg_bw()+this.frente.getImg_color());

        }

        return cliente;

    }

//
    public Object mandarImagen(PilaImagenes pila) {
        //PilaImagenes pila = new PilaImagenes();

        System.out.println("entrando a la cola2");
        if (!colaVacia()) {
            
            int cantidad = this.frente.getImg_color() + this.frente.getImg_bw();
            int bw = cantidad - this.frente.getImg_color();

            if (this.frente.getImg_color() > 0) {
                pila.push(this.frente.getId_cliente(), this.frente.getNombre_cliente(), 1, 0);
                System.out.println("cantidad de imagenes" + this.frente.getImg_color());
                this.frente.setImg_color(this.frente.getImg_color() - 1);

            } else {

                if (this.frente.getImg_bw() > 0) {
                    pila.push(this.frente.getId_cliente(), this.frente.getNombre_cliente(), 0, 1);
                    System.out.println("cantidad de imagenes bw " + this.frente.getImg_bw());
                    this.frente.setImg_bw(this.frente.getImg_bw() - 1);
                }

            }
//
//       
        }

        return pila;

    }

//
    public boolean colaVacia() {

        return this.frente == null;
    }

    public void mostrar() {

        NodoCola aux = this.frente;

        while (aux != null) {

            System.out.println(aux.getNombre_cliente());

          
            aux = aux.getSiguiente();
        }

    }
}

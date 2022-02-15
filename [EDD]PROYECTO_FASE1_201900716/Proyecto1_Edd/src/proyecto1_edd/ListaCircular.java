/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1_edd;

/**
 *
 * @author Kelly
 */
public class ListaCircular {
    
    NodoCircular primero;
    NodoCircular ultimo;
    
    public ListaCircular() {
        
        this.primero = null;
        this.ultimo = null;
    }
    
    public void insertar(ListaEsperaS lista, Cliente cliente) {
        
        NodoCircular nuevo = new NodoCircular(lista, cliente);
        
        if (this.primero == null) {
            this.primero = nuevo;
            this.primero.setSiguiente(this.primero);
            nuevo.setAnterior(this.ultimo);
            this.ultimo = nuevo;

//            this.primero = nuevo;
//            this.ultimo = nuevo;
//            this.primero.setSiguiente(this.ultimo);
//            this.primero.setAnterior(this.ultimo);
//            this.ultimo.setSiguiente(this.primero);
//            this.ultimo.setAnterior(this.primero);
        } else {
            
            this.ultimo.setSiguiente(nuevo);
            nuevo.setSiguiente(this.primero);
            nuevo.setAnterior(this.ultimo);
            this.ultimo = nuevo;
            this.primero.setAnterior(this.ultimo);
//            this.primero.setAnterior(nuevo);
//            nuevo.setAnterior(this.primero);
//            this.ultimo.setSiguiente(nuevo);
//            nuevo.setAnterior(this.ultimo);
//            nuevo.setSiguiente(this.primero);
//            this.ultimo = nuevo;

        }
        
    }
//______________________________________
public boolean listaVacia(){
return this.primero==null;

}
//____________________________________________________________________

    public void EliminarCliente(int id) {
        
        NodoCircular actual;
        NodoCircular antetior;
        actual = this.primero;
        antetior = this.ultimo;
        do {
            if (actual.getCliente().getId_cliente() == id) {
                if (actual == this.primero) {
                    this.primero = primero.getSiguiente();
                    this.ultimo.setSiguiente(this.primero);
                    this.primero.setAnterior(this.ultimo);
                } else if (actual == this.ultimo) {
                    this.ultimo = antetior;
                    this.primero.setAnterior(this.ultimo);
                    this.ultimo.setSiguiente(this.primero);
                    
                } else {
                    antetior.setSiguiente(actual.getSiguiente());
                    actual.getSiguiente().setAnterior(antetior);
                }
                
            }
            antetior = actual;
            actual = actual.getSiguiente();
        } while (actual != primero);
    }
//_________________________________________________________________________

    public void mostrar() {
        System.out.println(".----");
        NodoCircular aux = this.primero;
        // System.out.println(aux.getCliente().getNombre_cliente());
        while (aux.getSiguiente() != this.primero) {
            System.out.println("_______________");
            System.out.println("LIsta");
            System.out.println(aux.getCliente().getNombre_cliente());
            aux.getLista().mostraLista();
            aux = aux.getSiguiente();
            
        }
        System.out.println("______________");
        System.out.println(aux.getCliente().getNombre_cliente());
        
        aux.getLista().mostraLista();
        System.out.println("______________");
        System.out.println(">>>>>><F<<<<<<<<<<<");
        
    }
    
}

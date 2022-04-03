/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras;

/**
 *
 * @author Kelly
 */
public class Lista_de_album {
    
    public Nodo_Album primero;
    public int tamanio;
    
    public Lista_de_album() {
        this.primero = null;
    }
    
    public void add(int imagen) {
        Nodo_Album nodo = new Nodo_Album(imagen);
        tamanio++;
        if (this.primero == null) {
            this.primero = nodo;
        } else {
            Nodo_Album aux = this.primero;
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nodo);
        }
    }
    
    public boolean get(int imagen) {
        Nodo_Album aux = this.primero;
        while (aux != null) {
            if (aux.getImagen() == imagen) {
                return true;
            }
            aux = aux.getSiguiente();
        }
        return false;
    }
    
    public int size() {
        return this.tamanio;
    }
    
    public void EliminarDato(int dato) {
        if (get(dato)) {
            
            if (this.primero.getImagen() == dato) {
                this.primero = this.primero.getSiguiente();
                
            } else {
                Nodo_Album aux2 = this.primero;
                while (aux2.getImagen() != dato) {
                    
                    aux2 = aux2.getSiguiente();
                }
                Nodo_Album sig = aux2.getSiguiente().getSiguiente();
                aux2.setSiguiente(sig);
                
            }
        }
        
    }
    
    public void mostrar() {
        
        Nodo_Album temp = this.primero;
        
        while (temp != null) {
            System.out.println("imagen " + temp.getImagen());
            temp = temp.getSiguiente();
        }
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *
 * @author herre
 */
public class Lista_Lugares {
     public NodoLugar primero;
    public int tamanio;
    
    public Lista_Lugares() {
        this.primero = null;
    }
    
    public void add(int id, String departamento, String nombre, String sn_sucursal) {
        
        NodoLugar nuevo = new NodoLugar(id,departamento,nombre,sn_sucursal);
        tamanio++;
        
        if (this.primero == null) {
            
            this.primero = nuevo;
            
        } else {
            NodoLugar aux = this.primero;
            
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nuevo);
        }
    }
}

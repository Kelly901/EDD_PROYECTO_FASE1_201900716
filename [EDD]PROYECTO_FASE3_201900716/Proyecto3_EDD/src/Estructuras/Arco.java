/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *
 * @author herre
 */
public class Arco {
    
    int destino;
    double peso;

    
    public Arco(int destino,double peso){
      this.destino=destino;
      this.peso=peso;
    }
    
    public int getDestino(){
        return destino;
    }
    public boolean equals(Object n){
        
        Arco a= (Arco) n;
        return destino==a.destino;
    }
}

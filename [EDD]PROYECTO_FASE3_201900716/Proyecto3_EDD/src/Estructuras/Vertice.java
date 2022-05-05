/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *
 * @author herre
 */
public class Vertice {
    
    
    String nombre;
   public  int numVertice;
   public  Lista2 arcos;
  //lISTA  lista adyacencia
    public Vertice(int numVertice) {
      this.arcos=new Lista2();
        
        this.numVertice=numVertice;
        
        //new LIsta();
    }
   
  public void addDest(Arco arco){
      System.out.println("arco "+arco.destino);
      this.arcos.insertar(arco);
  }
    
    
}

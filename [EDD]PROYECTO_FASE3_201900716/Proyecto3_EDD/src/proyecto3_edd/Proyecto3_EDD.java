/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto3_edd;

import Estructuras.TablaHash;

/**
 *
 * @author herre
 */
public class Proyecto3_EDD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("d");
        //CargaMasiva.leerArchivo_lugares(CargaMasiva.AbrirArchivo());
        CargaMasiva.leerArchivo_mensajeros(CargaMasiva.AbrirArchivo());

        //CargaMasiva.leerArchivo_Grafo(CargaMasiva.AbrirArchivo());
        //CargaMasiva.leerArchivo_clientes(CargaMasiva.AbrirArchivo());
//        System.out.println("hola");
//TablaHash th= new TablaHash(37);
////        
//
//        System.out.println("______._______");
//th.insertarHash(123456789);
//th.insertarHash(223456789);
//th.insertarHash(323456789);
//    th.insertarHash(423456789);
//    
//    th.mostrar();

       // System.out.println(numeroPrimo(19+2));
////    
    }

    public static int numeroPrimo(int num) {

        int n = num;
    
            
            for (int j = 2; j < num / 2; j++) {
                System.out.println(num % j);
                if (num % j == 0) {
                    System.out.println("true");

                  
                     
                     return numeroPrimo(num+2);
                }

              
            
        }

        return num;

    }

}

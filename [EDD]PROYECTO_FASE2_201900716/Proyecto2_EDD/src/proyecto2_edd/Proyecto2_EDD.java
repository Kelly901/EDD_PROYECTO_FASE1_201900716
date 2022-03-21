/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto2_edd;

import Interfaz.Principal;
import estructuras.Matriz;


/**
 *
 * @author Kelly
 */
public class Proyecto2_EDD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        System.out.println("hola mundo1");
//        Principal principal = new Principal();
//        principal.setVisible(true);
//
//        CargaMasiva.leerArchivo_clientes(CargaMasiva.abrirArchivo());
//        System.out.println("_______________________________");
//        CargaMasiva.leerArchivo_capas(CargaMasiva.abrirArchivo());
//        System.out.println("________________________________");
//        CargaMasiva.leerArchivo_imagenes(CargaMasiva.abrirArchivo());
//        System.out.println("__________________________");
//        CargaMasiva.leerArchivo_album(CargaMasiva.abrirArchivo());

        System.out.println(":::");
Matriz matriz= new Matriz();

matriz.insertar("a", 9, 5);
matriz.insertar("b", 0, 4);
matriz.insertar("c", 8, 9);
matriz.insertar("d", 8, 10);
matriz.insertar("e", 5, 4);
matriz.insertar("f", 5, 9);

//
matriz.imprimir_porColumna();
matriz.imprimir_porFila();

matriz.mostrar();

matriz.crearGrafo("imagen.jpg");

//        
    }
    
}

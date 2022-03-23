/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto2_edd;

import Interfaz.Principal;
import Matriz_Dispersa.Matriz;
import estructuras.Arbol_B;

import estructuras.Arbol_avl;
import estructuras.NodeAvl;
import javafx.scene.Node;

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
//Matriz matriz= new Matriz2();
//
//matriz.insertar("a", 9, 5);
//matriz.insertar("b", 0, 4);
//matriz.insertar("c", 8, 9);
//matriz.insertar("d", 8, 10);
//matriz.insertar("e", 5, 4);
//matriz.insertar("f", 5, 9);
//
////
//matriz.imprimir_porColumna();
//matriz.imprimir_porFila();
//
//matriz.mostrar();
//
//matriz.crearGrafo("imagen.jpg");
//        Matriz matriz = new Matriz();
//
//        matriz.insertar(0, 0, "a", 0);
//        matriz.insertar(1, 1, "b", 1);
//        matriz.insertar(1, 2, "ba", 1);
//        matriz.insertar(2, 5, "ca", 1);
//        matriz.insertar(2, 2, "c", 2);
//        matriz.insertar(3, 3, "d", 3);
//        matriz.insertar(4, 4, "e", 4);
//        matriz.insertar(5, 5, "f", 5);
//        matriz.insertar(6, 6, "g", 6);
//        matriz.insertar(7, 7, "h", 7);
//        matriz.insertar(8, 8, "i", 8);
//
//matriz.crearGrafo("matriz.jpg");

//        for (int i = 0; i < 9; i++) {
//  
        Arbol_avl arbol = new Arbol_avl();
        arbol.insertarI(75);
        arbol.insertarI(40);
        arbol.insertarI(23);
        arbol.insertarI(8);
        arbol.insertarI(6);
        arbol.insertarI(37);
        arbol.insertarI(32);
        arbol.insertarI(45);
        arbol.insertarI(25);
        arbol.insertarI(1);
        arbol.insertarI(88);
        arbol.insertarI(29);
        arbol.insertarI(4);
        arbol.insertarI(11);
        arbol.insertarI(39);
        arbol.insertarI(14);
        arbol.insertarI(66);
        arbol.insertarI(24);
        arbol.insertarI(12);
        arbol.insertarI(7);
        arbol.preorder(arbol.root);

        arbol.crearGrafo("arbolAvl.jpg", "arbolaAvl", arbol.getCodigos(arbol.root));
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto2_edd;

import Interfaz.Principal;

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

        CargaMasiva.leerArchivo_clientes(CargaMasiva.abrirArchivo());
        System.out.println("_______________________________");
        CargaMasiva.leerArchivo_capas(CargaMasiva.abrirArchivo());
        System.out.println("________________________________");
        CargaMasiva.leerArchivo_imagenes(CargaMasiva.abrirArchivo());
        System.out.println("__________________________");
        CargaMasiva.leerArchivo_album(CargaMasiva.abrirArchivo());
        
    }
    
}

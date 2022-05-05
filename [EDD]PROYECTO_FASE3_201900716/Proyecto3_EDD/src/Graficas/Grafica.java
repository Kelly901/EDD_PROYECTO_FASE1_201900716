/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Graficas;

import Estructuras.Datos;
import java.io.FileWriter;
import java.io.PrintWriter;
import proyecto3_edd.CargaMasiva;

/**
 *
 * @author herre
 */
public class Grafica {
    
     public void crearGrafo(String path, String nombreG, String cadena) {
        //String grafo = "digraph grafica{\n rankdir=TB;\n node[shape=record, style=filled,fillcolor=seashell2]\n nodo[lable=\"1\"];};";
        FileWriter fichero = null;
        PrintWriter escritor;

        try {

            fichero = new FileWriter(nombreG + ".dot");
            escritor = new PrintWriter(fichero);
            escritor.print(cadena);

        } catch (Exception e) {
            System.err.println("Error al escribir el archivvo");
        } finally {
            try {
                if (null != fichero) {
                    fichero.close();
                }

            } catch (Exception e2) {
                System.err.println("Error al cerrar el archivo");

            }

        }

        try {
            System.out.println("entro aui");
            Runtime rt = Runtime.getRuntime();
            rt.exec("dot -Tjpg -o " + path + " " + nombreG + ".dot");

            Thread.sleep(500);
        } catch (Exception ex) {

            System.err.println("Error al generar la imagen");
            System.out.println(ex);

        }

    }

    
    public String TablaHash(){
        
        return null;
    }
    
    
     public String tabla() {
        String cadena = "digraph G{\nlabel=\"Tabla Hash\";\nnode[shape=box];\n";
        String conexion = "";
        String nodos = "";
        
        String principal = "";
            Datos tabla[]=CargaMasiva.th.tabla;
            for (int i = 0; i < tabla.length; i++) {
                if (tabla[i]!=null) {
               nodos += "nC" + String.valueOf(i).hashCode() + "[label=\"" + tabla[i].getLlave() + "\"];\n";
 
                }else{
                    nodos += "nC" + String.valueOf(i).hashCode() + "[label=\"" + i + "\"];\n";

                }
                if ((i+1)<tabla.length) {
                  conexion += "nC" + String.valueOf(i).hashCode() + "->nC" + String.valueOf(i+1).hashCode() + ";\n";

                }
         }

        cadena += nodos + "\n";
        cadena += conexion + "\n";
        cadena += "{rank=same;" + principal + "}";
        //cadena += GrafoVentanilla();

        cadena += "\n}";
        return cadena;

    }
}

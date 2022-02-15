/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1_edd;

import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author Kelly
 */
public class Reportes {

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

            Runtime rt = Runtime.getRuntime();
            rt.exec("dot -Tjpg -o " + path + " " + nombreG + ".dot");

            //Thread.sleep(500);
        } catch (Exception ex) {

            System.err.println("Error al generar la imagen");

        }

    }

    public String generarGrafos() {
        String cadena = "digraph G{\nlabel=\"Estado de la cola\";\nnode[shape=box];\n";
//        cadena += "subgraph cluster_1 {\nlabel=\"Estado de la cola\";\n";
        NodoCola temp = CargaMasiva.cola.frente;
        String conexion = "";
        String nodos = "";
        while (temp != null) {

            nodos += "n" + temp.hashCode() + "[label=\"" + temp.getNombre_cliente() + "\nImagen C: " + temp.getImg_color() + "\nImagen bw: " + temp.getImg_bw() + "\"];\n";
            if (temp.getSiguiente() != null) {
                conexion += "n" + temp.getSiguiente().hashCode() + "->n" + temp.hashCode() + ";\n";

            }
            temp = temp.getSiguiente();
        }

        cadena += nodos + "\n";
        cadena += "{rank=same;\n" + conexion + "\n}";
        //cadena += GrafoVentanilla();

        cadena += "\n}";
        return cadena;
    }

    public String GrafoVentanilla() {
        NodoVentanilla temp = CargaMasiva.ventanilla.cabeza;
        String cadena = "digraph G{\nlabel=\"Estado de la cola\";\nnode[shape=box];\n";
//        cadena += "subgraph cluster_2 {\nlabel=\"Ventanas \";\n";
        String conexion = "";
        String nodos = "";

        while (temp != null) {

            nodos += "nV" + temp.hashCode() + "[label=\"" + temp.getVentanillas() + "\"];\n";

            if (temp.getSiguiente() != null) {
                conexion += "nV" + temp.hashCode() + "->nV" + temp.getSiguiente().hashCode() + ";\n";
                if (temp.getPila().cima != null) {
                    conexion += "nV" + temp.hashCode() + "->nP" + temp.getPila().cima.hashCode() + ";\n";
                }

                if (temp.getSiguiente().getPila().cima != null) {
                    conexion += "nV" + temp.getSiguiente().hashCode() + "->nP" + temp.getSiguiente().getPila().cima.hashCode() + ";\n";
                }

            }
            NodoPilaI aux = temp.getPila().cima;
            while (aux != null) {
                //conexion += "nV" + temp.hashCode() + "->nP" + aux.hashCode() + ";\n";
                if (aux.getImg_color() != 0) {
                    System.out.println("entro");
                    nodos += "nP" + aux.hashCode() + "[label=\"IMG C\"];\n";
                    if (aux.getSiguiente() != null) {

                        conexion += "nP" + aux.hashCode() + "->nP" + aux.getSiguiente().hashCode() + ";\n";

                    }
                } else {
                    System.out.println("entro 2");

                    nodos += "nP" + aux.hashCode() + "[label=\"IMG bw\"];\n";
                    if (aux.getSiguiente() != null) {
                        // conexion += "nV" + temp.hashCode() + "->nP" + aux.hashCode() + ";\n";
                        conexion += "nP" + aux.hashCode() + "->nP" + aux.getSiguiente().hashCode() + ";\n";

                    }

                }

                aux = aux.getSiguiente();
            }
            temp = temp.getSiguiente();

        }

        cadena += nodos + "\n";
        cadena += conexion + "\n";
        //cadena += GrafoVentanilla();

        cadena += "\n}";
        return cadena;
    }

    public String generarGrafosImpresoraC() {
        String cadena = "digraph G{\nlabel=\"Cola de impresion a color\";\nnode[shape=box];\n";
//        cadena += "subgraph cluster_1 {\nlabel=\"Estado de la cola\";\n";
        Nodo_impresoraC temp = CargaMasiva.impresora_c.frente;
        String conexion = "";
        String nodos = "";
        while (temp != null) {

            nodos += "n" + temp.hashCode() + "[label=\"" + temp.getNombre_cliente() + "\nIMG C \"];\n";
            if (temp.getSiguiente() != null) {
                conexion += "n" + temp.getSiguiente().hashCode() + "->n" + temp.hashCode() + ";\n";

            }
            temp = temp.getSiguiente();
        }

        cadena += nodos + "\n";
        cadena += "{rank=same;\n" + conexion + "\n}";
        //cadena += GrafoVentanilla();

        cadena += "\n}";
        return cadena;
    }



  public String generarGrafosImpresoraBw() {
        String cadena = "digraph G{\nlabel=\"Cola de impresion BW\";\nnode[shape=box];\n";
//        cadena += "subgraph cluster_1 {\nlabel=\"Estado de la cola\";\n";
        Nodo_impresoraBw temp = CargaMasiva.impresora_bw.frente;
        String conexion = "";
        String nodos = "";
        while (temp != null) {

            nodos += "n" + temp.hashCode() + "[label=\"" + temp.getNombre_cliente() + "\nIMG Bw \"];\n";
            if (temp.getSiguiente() != null) {
                conexion += "n" + temp.getSiguiente().hashCode() + "->n" + temp.hashCode() + ";\n";

            }
            temp = temp.getSiguiente();
        }

        cadena += nodos + "\n";
        cadena += "{rank=same;\n" + conexion + "\n}";
        //cadena += GrafoVentanilla();

        cadena += "\n}";
        return cadena;
    }
}

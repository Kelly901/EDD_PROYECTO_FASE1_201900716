/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Graficas;

import Estructuras.Arco;
import Estructuras.Datos;
import Estructuras.NodoLista2;
import Estructuras.Vertice;
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

    public String tabla() {
        String cadena = "digraph G{\nlabel=\"Tabla Hash\";\nnode[shape=box];\n";
        String conexion = "";
        String nodos = "";

        String principal = "";
        Datos tabla[] = CargaMasiva.th.tabla;
        for (int i = 0; i < tabla.length; i++) {
            if (tabla[i] != null) {
                nodos += "nC" + String.valueOf(i).hashCode() + "[label=\"Key: " + tabla[i].getLlave() + "\nDPI: " + tabla[i].getDpi() + "\"];\n";

            } else {
                nodos += "nC" + String.valueOf(i).hashCode() + "[label=\"Key: " + i + " DPI: null" + "\"];\n";

            }
            if ((i + 1) < tabla.length) {
                conexion += "nC" + String.valueOf(i).hashCode() + "->nC" + String.valueOf(i + 1).hashCode() + ";\n";

            }
        }

        cadena += nodos + "\n";
        cadena += conexion + "\n";
        cadena += "{rank=same;" + principal + "}";
        //cadena += GrafoVentanilla();

        cadena += "\n}";
        return cadena;

    }

    public String TablaHash() {
        String cadena = "digraph G{\nlabel=\"Tabla Hash\";\nnode[shape=box];\n";
        String etiqueta = "";
        Datos tabla[] = CargaMasiva.th.tabla;

        for (int i = 0; i < tabla.length; i++) {

            if (tabla[i] != null) {
                etiqueta += "<TR><TD>Key: " + tabla[i].getLlave() + "</TD><TD> dpi: " + tabla[i].getDpi() + "</TD></TR>";
            } else {
                etiqueta += "<TR><TD>Key: " + i + "</TD><TD> dpi: " + null + "</TD></TR>";

            }
        }
        String cuerpo = "<<TABLE>\n"
                + etiqueta + "\n"
                + "</TABLE>>\n";

        cadena += "a[label=" + cuerpo + "];\n}";
        return cadena;
    }

    public String grafica1() {
        String cadena = "digraph G{\nlabel=\"Tabla Hash\";\n";
       
        NodoLista2 temp = CargaMasiva.lA.dest.raiz;
        String conexion="";
        String nodos = "";
        String principal="";
        while (temp != null) {
            Vertice vertice = (Vertice) temp.objeto;
            NodoLista2 aux = vertice.arcos.raiz;
          nodos += "nC" + vertice.numVertice + "[label=\""+vertice.numVertice + "\"];\n";
          conexion+="nC"+vertice.numVertice+"->";
            while (aux != null) {
                Arco arco = (Arco) aux.objeto;
                
                //nodos += "nd" + arco.destino + "[label=\""+arco.destino + "\"];\n";
                conexion+="nC"+arco.destino+";\n";
                aux = aux.siguiente;
            }
            temp = temp.siguiente;
        }
        cadena+=nodos;
        cadena+=conexion;
        cadena += "\n}";
        return cadena;

    }
    
    
        public String ListaAdyacente() {
        String cadena = "digraph G{\nlabel=\"Tabla Hash\";\nnode[shape=box];\n";
       
        NodoLista2 temp = CargaMasiva.lA.dest.raiz;
        String conexion="";
        String nodos = "";
        String principal="";
        String principales="";
        while (temp != null) {
            Vertice vertice = (Vertice) temp.objeto;
            NodoLista2 aux = vertice.arcos.raiz;
          nodos += "nC" + temp.hashCode() + "[label=\""+vertice.numVertice + "\"];\n";
          principales+="nC"+temp.hashCode()+";";
            if (temp.siguiente!=null) {
              principal+="nC"+temp.hashCode()+"->nC"+temp.siguiente.hashCode()+";\n";

            }

            while (aux != null) {
                Arco arco = (Arco) aux.objeto;
                
                nodos += "nd" + aux.hashCode() + "[label=\""+arco.destino + "\"];\n";
                if (aux==vertice.arcos.raiz) {
                   conexion+="nC"+temp.hashCode()+"->nd"+aux.hashCode()+";\n";
  
                }
                if (aux.siguiente!=null) {
                  conexion+="nd"+aux.hashCode()+"->nd"+aux.siguiente.hashCode()+";\n";

                }
                aux = aux.siguiente;
            }
            temp = temp.siguiente;
        }
        cadena+=nodos;
        
         cadena += "{rank=same;" + principales + "}";
            System.out.println(principales);
            cadena+=principal;
        cadena+=conexion;
        cadena += "\n}";
        return cadena;

    }
    
    
    
}

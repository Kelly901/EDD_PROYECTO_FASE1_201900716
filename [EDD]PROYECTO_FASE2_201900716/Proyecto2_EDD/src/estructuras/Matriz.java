/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras;

import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author Kelly
 */
public class Matriz {

    NodoMatriz raiz;

    public Matriz() {
        raiz = new NodoMatriz("Raiz", -1, -1);
    }

    public NodoMatriz insertar_fila(NodoMatriz nuevo, NodoMatriz cabeceraFila) {
        NodoMatriz actual = cabeceraFila;
        boolean mayor = false;

        while (true) {
            if (actual.getI() > nuevo.getI()) {
                mayor = true;
                break;
            } else if (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            } else {
                break;

            }
        }

        if (mayor) {
            nuevo.setSiguiente(actual);
            nuevo.setAnterior(actual.getAnterior());
            actual.getAnterior().setSiguiente(nuevo);

            actual.setAnterior(nuevo);
        } else {
            actual.setSiguiente(nuevo);
            nuevo.setAnterior(actual);
        }

        return nuevo;
    }

//Se inserta el dato en la columna
    public NodoMatriz insertar_columna(NodoMatriz nuevo, NodoMatriz cabeceraCol) {
        NodoMatriz actual = cabeceraCol;
        boolean mayor = false;

        while (true) {
            if (actual.getJ() > nuevo.getJ()) {
                mayor = true;
                break;
            } else if (actual.getAbajo() != null) {
                actual = actual.getAbajo();
            } else {
                break;
            }
        }

        if (mayor) {
            nuevo.setAbajo(actual);
            nuevo.setArriba(actual.getArriba());
            actual.getArriba().setAbajo(nuevo);
            actual.setArriba(nuevo);
        } else {

            actual.setAbajo(nuevo);
            nuevo.setArriba(actual);
        }

        return nuevo;

    }

    public NodoMatriz buscar_col(int i) {

        NodoMatriz actual = raiz;

        while (actual != null) {
            if (actual.getI() == i) {
                break;
            }
            actual = actual.getSiguiente();
        }

        return actual;
    }

    public NodoMatriz buscar_fil(int j) {

        NodoMatriz actual = raiz;

        while (actual != null) {
            if (actual.getJ() == j) {
                break;
            }
            actual = actual.getSiguiente();
        }

        return actual;
    }

    public NodoMatriz crearCol(int i) {

        return insertar_fila(new NodoMatriz("Column", i, -1), raiz);
    }

    public NodoMatriz crearFil(int j) {

        return insertar_columna(new NodoMatriz("fila", -1, j), raiz);
    }

    public void insertar(String dato, int i, int j) {

        NodoMatriz nuevo = new NodoMatriz(dato, i, j);
        NodoMatriz col = buscar_col(i);
        NodoMatriz fil = buscar_fil(j);

        if (col == null && fil == null) {

            col = crearCol(i);
            fil = crearFil(j);
            nuevo = insertar_fila(nuevo, fil);
            nuevo = insertar_columna(nuevo, col);
        } else if (col != null && fil == null) {
            fil = crearFil(j);
            nuevo = insertar_fila(nuevo, fil);
            nuevo = insertar_columna(nuevo, col);
        } else if (col == null) {
            col = crearCol(i);
            nuevo = insertar_fila(nuevo, fil);
            nuevo = insertar_columna(nuevo, col);
        } else {
            nuevo = insertar_fila(nuevo, fil);
            nuevo = insertar_columna(nuevo, col);
        }

    }

    public void imprimir_porFila() {

        System.out.println("_____Fila______");

        NodoMatriz actual = raiz;

        while (actual != null) {
            System.out.println(actual.getAbajo());
            actual = actual.getSiguiente();
        }
    }

    public void imprimir_porColumna() {

        System.out.println("_____COlumna______");
        NodoMatriz actual = raiz;

        while (actual != null) {
            System.out.println(actual.getSiguiente());
            actual = actual.getAbajo();
        }
    }

    public void mostrar() {
        String cadena = "";
        NodoMatriz actual = raiz;
        while (actual != null) {

            NodoMatriz actual2 = actual;
            while (actual2 != null) {

//                if (!"Column".equals(actual2.getDato()) && !"fila".equals(actual2.getDato())) {
//                    System.out.println(actual2.getDato() + " i:" + actual.getI() + " j:" + actual2.getJ());
//                    cadena += actual2.getDato() + "\n";
//                }

                actual2 = actual2.getAbajo();
            }
            actual = actual.getSiguiente();

        }
        System.out.println("caden__");
        System.out.println(cadena);
    }

//Graficar
    public String retornar() {

        String cadena = "digraph G{\nlabel=\"Carnet\";\nnode[shape=box];\n";
        String conexion = "";
        String nodos = "";
        NodoMatriz actual = this.raiz;
        //  Nodo nodo = null;
       
String conexion2="";
            while (actual != null) {
                nodos += "n" + actual.getSiguiente().hashCode() + "[label=\"" + actual.getSiguiente().getDato() + "\"];\n";

                actual = actual.getAbajo();
            }
            conexion += "{rank=same;" + conexion2 + "}";

          
        
        cadena += nodos + "\n";
        cadena += "\n" + conexion + "\n";
        cadena += "\n}";
        System.out.println(cadena);
        return cadena;
    }
  public  void crearGrafo(String path) {
        //String grafo = "digraph grafica{\n rankdir=TB;\n node[shape=record, style=filled,fillcolor=seashell2]\n nodo[lable=\"1\"];};";
        FileWriter fichero = null;
        PrintWriter escritor;

        try {

            fichero = new FileWriter("aux_grafico.dot");
            escritor = new PrintWriter(fichero);
            escritor.print(retornar());

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
            rt.exec("dot -Tjpg -o " + path + " aux_grafico.dot");

            //Thread.sleep(500);
        } catch (Exception ex) {

            System.err.println("Error al generar la imagen");

        }

    }
}

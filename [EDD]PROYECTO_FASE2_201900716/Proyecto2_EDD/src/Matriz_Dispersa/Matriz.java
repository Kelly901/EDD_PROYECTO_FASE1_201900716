/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Matriz_Dispersa;

import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author Kelly
 */
public class Matriz {

    Encabezado encabezadoFilas;
    Encabezado encabezadoColumnas;

    public Matriz() {
        this.encabezadoColumnas = new Encabezado(null);
        this.encabezadoFilas = new Encabezado(null);
    }

    public void insertar(int fila, int columna, String valor, int cont) {
        Nodo nuevo = new Nodo(fila, columna, valor, cont);

        NodoEncabezado efilas = this.encabezadoFilas.getEncabezado(fila);

        if (efilas == null) {
            efilas = new NodoEncabezado(fila);
            efilas.setAcceso(nuevo);
            this.encabezadoFilas.setEncabezado(efilas);
        } else {

            if (nuevo.getColumna() < efilas.getAcceso().getColumna()) {
                nuevo.setDerecha(efilas.getAcceso());
                efilas.getAcceso().setIzquierda(nuevo);
                efilas.setAcceso(nuevo);

            } else {
                Nodo actual = efilas.getAcceso();
                while (actual.getDerecha() != null) {
                    if (nuevo.getColumna() < actual.getDerecha().getColumna()) {
                        nuevo.setDerecha(actual.getDerecha());
                        actual.getDerecha().setIzquierda(nuevo);
                        nuevo.setIzquierda(actual);
                        actual.setDerecha(nuevo);
                        break;

                    }
                    actual = actual.getDerecha();
                }
                if (actual.getDerecha() == null) {
                    actual.setDerecha(nuevo);
                    nuevo.setIzquierda(actual);
                }

            }

        }
//insercion encabezado por columna

        NodoEncabezado eColumnas = this.encabezadoColumnas.getEncabezado(columna);

        if (eColumnas == null) {
            eColumnas = new NodoEncabezado(columna);
            eColumnas.setAcceso(nuevo);
            this.encabezadoColumnas.setEncabezado(eColumnas);
        } else {
            if (nuevo.getFila() < eColumnas.getAcceso().getFila()) {
                nuevo.setAbajo(eColumnas.getAcceso());
                eColumnas.getAcceso().setArriba(nuevo);
                eColumnas.setAcceso(nuevo);

            } else {
                Nodo actual = eColumnas.getAcceso();
                while (actual.getAbajo() != null) {
                    if (nuevo.getFila() < actual.getAbajo().getFila()) {
                        nuevo.setAbajo(actual.getAbajo());
                        actual.getAbajo().setArriba(nuevo);
                        nuevo.setArriba(actual);
                        actual.setAbajo(nuevo);
                        break;
                    }
                    actual = actual.getAbajo();
                }
                if (actual.getAbajo() == null) {
                    actual.setAbajo(nuevo);
                    nuevo.setArriba(actual);
                }
            }

        }

    }

    public void recorreFilas() {

        NodoEncabezado efila = this.encabezadoFilas.primero;

        System.out.println(">>>>Recorrer por fila<<<<<<<<<<");

        while (efila != null) {
            Nodo actual = efila.getAcceso();

            System.out.println("\nFila " + actual.getFila());
            System.out.println("Columna valor");
            while (actual != null) {
                System.out.println(actual.getColumna() + " id:" + actual.getId() + ". " + actual.getValor());
                actual = actual.getDerecha();
            }

            efila = efila.getSiguiente();
        }
        System.out.println(">>>>>>>fin<<<<<<<");
    }

    public String retornar() {

        String cadena = "digraph G{\nlabel=\"Carnet\";\nnode[shape=box];\n";
        String conexion = "";
        String nodos = "";
        String raiz1 = "";
        NodoEncabezado efila = this.encabezadoFilas.primero;
        NodoEncabezado eCol = this.encabezadoFilas.primero;
        //  Nodo nodo = null;
        String conexion2 = "";
        nodos += "r" + "[label=\"raiz\"];\n";
        conexion += "r" + "-> b" + efila.hashCode() + ";\n";
        raiz1 += "r" + "-> c" + efila.getAcceso().hashCode() + ";\n";
        conexion += "{rank=same;" + raiz1 + "}";
        while (efila != null) {
            Nodo actual = efila.getAcceso();

            nodos += "b" + efila.hashCode() + "[label=\"" + efila.getId() + "\"];\n";
            nodos += "c" + actual.hashCode() + "[label=\"" + efila.getAcceso().getColumna() + "\"];\n";
            if (efila.getSiguiente() != null) {
                conexion += "b" + efila.hashCode() + "-> b" + efila.getSiguiente().hashCode() + ";\n";
                conexion2 += "c" + efila.getAcceso().hashCode() + "-> c" + efila.getSiguiente().getAcceso().hashCode() + ";\n";

            }

            conexion += "c" + efila.getAcceso().hashCode() + "-> n" + efila.getAcceso().hashCode() + ";\n";
            conexion += "b" + efila.hashCode() + "-> n" + efila.getAcceso().hashCode() + ";\n";

            System.out.println("id" + efila.getId());
            System.out.println("col" + actual.getColumna());
            nodos += "n" + efila.getAcceso().hashCode() + "[label=\"" + actual.getValor() + "\"];\n";

            while (actual != null) {

//                if (actual.getDerecha() != null) {
//                    System.out.println("entre en el if");
//                    conexion += "c" + actual.hashCode() + "-> c" + actual.getDerecha().hashCode() + ";\n";
//                }
//                if (actual.getAbajo() != null) {
//                    conexion += "n" + actual.hashCode() + "-> n" + actual.getAbajo().hashCode() + ";\n";
//                    conexion += "n" + actual.hashCode() + "-> n" + actual.getAbajo().hashCode() + ";\n";
//                }
//                if (actual.getArriba() != null) {
//                    conexion += "n" + actual.hashCode() + "-> n" + actual.getArriba().hashCode() + ";\n";
//                }
//
//                if (actual.getDerecha() != null) {
//                    conexion2 += "n" + actual.hashCode() + "-> n" + actual.getDerecha().hashCode() + ";\n";
//                }
//                if (actual.getIzquierda() != null) {
//                    conexion2 += "n" + actual.hashCode() + "-> n" + actual.getIzquierda().hashCode() + ";\n";
//                }
                actual = actual.getDerecha();
            }

            efila = efila.getSiguiente();
        }
        conexion += "{rank=same;" + conexion2 + "}";
        cadena += nodos + "\n";
        cadena += "\n{contraint=false" + conexion + "}\n";
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

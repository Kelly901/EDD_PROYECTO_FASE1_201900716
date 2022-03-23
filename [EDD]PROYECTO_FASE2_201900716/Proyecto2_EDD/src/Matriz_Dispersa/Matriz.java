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
//Este sirve
    public String grafico() {
        String principal = "digraph g{\n label=\"Matriz dispersa\" \n node[shape=box] \n subgraph h{\n";
        principal += "raiz[label=\"Inicio\",group=\"1\"]\nedge[dir=\"both\"]\n\n";
        int grupos;
        String F = "Fila";
        String C = "Columna";
        String N = "Nodo";
        Lista_2 listaFilas = new Lista_2();
        Lista_2 listaColumnas = new Lista_2();

        ListaEnlazada recorridoFilas = new ListaEnlazada();
        ListaEnlazada recorridoColumnas = new ListaEnlazada();

        NodoEncabezado eFila = this.encabezadoFilas.primero;
        NodoEncabezado eColumna = this.encabezadoColumnas.primero;

        while (eFila != null) {
            Nodo actual = eFila.getAcceso();

            listaFilas.add(actual);
//Se agrega a la lista los datos del nodo de la matriz.
//recorriendo por filas
            Lista_2 aux = new Lista_2();

            while (actual != null) {
                aux.add(actual);
                actual = actual.getDerecha();
            }
//Se guarda en otra lista los datos
            recorridoFilas.add(aux);
            eFila = eFila.getSiguiente();
        }
//Recorrido por columnas
        while (eColumna != null) {
            Nodo actual = eColumna.getAcceso();
            listaColumnas.add(actual);
            Lista_2 aux = new Lista_2();

            while (actual != null) {
                aux.add(actual);
                actual = actual.getAbajo();
            }
            recorridoColumnas.add(aux);
            eColumna = eColumna.getSiguiente();
        }

        for (int i = 0; i < listaFilas.size(); i++) {
            String filaAux = F + listaFilas.get(i).getFila();
            principal += filaAux + "[label=\"" + listaFilas.get(i).getFila() + "\",group=\"1\"];\n";
            if (i < listaFilas.size() - 1) {
                principal += F + "" + listaFilas.get(i).getFila() + "->" + F + "" + String.valueOf(listaFilas.get(i + 1).getFila() + ";\n");
            }
///
//RECORRER El contenido de las listas dentro de la lista de filas
            Lista_2 aux = recorridoFilas.get(i);
            principal += F + listaFilas.get(i).getFila() + "->" + N + aux.get(0).getFila() + "_" + aux.get(0).getColumna() + ";\n";
            String rankAux = "{rank=same;" + filaAux + ";";

            for (int j = 0; j < aux.size(); j++) {

                if (j < aux.size() - 1) {
                    principal += N + aux.get(j).getFila() + "_" + aux.get(j).getColumna() + "->" + N + aux.get(j).getFila() + "_" + aux.get(j + 1).getColumna() + ";\n";

                }
                rankAux += N + aux.get(j).getFila() + "_" + aux.get(j).getColumna() + ";";

            }
            principal += rankAux.substring(0, rankAux.length() - 1) + "}\n";

        }

        grupos = 2;
        String rankColumnas = "{rank=same;raiz;";

        for (int i = 0; i < listaColumnas.size(); i++) {
            String columnaAux = C + listaColumnas.get(i).getColumna();
            principal += columnaAux + "[label=\"" + listaColumnas.get(i).getColumna() + "\",group=\"" + grupos + "\"]\n";
            rankColumnas += columnaAux + ";";
//obtener la lista dentro de la lista de columnas.
            Lista_2 aux = recorridoColumnas.get(i);
            principal += columnaAux + "->" + N + aux.get(0).getFila() + "_" + aux.get(0).getColumna() + ";\n";
//_______________________________________

            for (int j = 0; j < aux.size(); j++) {
              principal+=N+aux.get(j).getFila()+"_"+aux.get(j).getColumna()+"[label=\""+aux.get(j).getValor()+"\",group=\""+grupos+"\"]\n";
                if (j < aux.size() - 1) {
                    principal += N + aux.get(j).getFila() + "_" + aux.get(j).getColumna() + "->" + N + aux.get(j + 1).getFila() + "_" + aux.get(j).getColumna() + "\n";
                }
            }
            grupos++;

            if (i < listaColumnas.size() - 1) {
                principal += C + listaColumnas.get(i).getColumna() + "->" + C + listaColumnas.get(i + 1).getColumna() + ";\n";
            }
        }
        principal += rankColumnas.substring(0, rankColumnas.length() - 1) + "}\n";
        principal += "raiz->" + F + listaFilas.get(0).getFila() + ";\n";
        principal += "raiz->" + C + listaColumnas.get(0).getColumna() + ";\n";
        principal += "}\n}";

        return principal;
    }

    public void crearGrafo(String path) {
        //String grafo = "digraph grafica{\n rankdir=TB;\n node[shape=record, style=filled,fillcolor=seashell2]\n nodo[lable=\"1\"];};";
        FileWriter fichero = null;
        PrintWriter escritor;
        System.out.println(grafico());
        try {

            fichero = new FileWriter("aux_grafico.dot");
            escritor = new PrintWriter(fichero);
            escritor.print(grafico());

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

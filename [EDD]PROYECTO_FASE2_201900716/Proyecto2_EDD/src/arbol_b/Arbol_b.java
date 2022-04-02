/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arbol_b;

import estructuras.Cola_arbol_b;
import estructuras.NodoCola;
import estructuras.Pila;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Kelly
 */
public class Arbol_b {

    final int orden = 5;
    public Pagina raiz;

    public Arbol_b() {
        this.raiz = new Pagina();

    }
//metodo insertar

    public void insertar(long id) {
        Nodo nodo = new Nodo(id);
        Nodo objeto = insertar_en_pagina(nodo, raiz);
        if (objeto != null) {
            raiz = new Pagina();
            raiz.insertar(objeto);
            raiz.hoja = false;
        }

    }

    private Nodo insertar_en_pagina(Nodo nodo, Pagina rama) {
        if (rama.hoja) {
            rama.insertar(nodo);
            return (rama.cont == orden) ? dividir(rama) : null;

        } else {
            Nodo temp = rama.primero;
            do {
                if (nodo.getId() == temp.getId()) {
                    return null;
                } else if (nodo.getId() < temp.getId()) {
                    Nodo obj = insertar_en_pagina(nodo, temp.getLeft());
                    return validarDivision(obj, rama);
                } else if (temp.getSiguiente() == null) {
                    Nodo obj = insertar_en_pagina(nodo, temp.getRight());
                    return validarDivision(obj, rama);
                }
                temp = (Nodo) temp.getSiguiente();

            } while (temp != null);
        }
        return null;
    }

    private Nodo validarDivision(Nodo obj, Pagina rama) {

        if (obj instanceof Nodo) {
            rama.insertar((Nodo) obj);
            if (rama.cont == orden) {
                return dividir(rama);
            }
        }
        return null;

    }

    private Nodo dividir(Pagina rama) {

        long valor = -999;
        Nodo temp, nuevo;
        Nodo aux = rama.primero;

        Pagina rDerecha = new Pagina();
        Pagina rIzquierda = new Pagina();

        int contador = 0;
        while (aux != null) {
            contador++;

            if (contador < 3) {
                temp = new Nodo(aux.getId(), aux.getRight(), aux.getLeft());
                rIzquierda.hoja = !(temp.getRight() != null && temp.getLeft() != null);
                rIzquierda.insertar(temp);
            } else if (contador == 3) {
                valor = aux.getId();
            } else {

                temp = new Nodo(aux.getId(), aux.getLeft(), aux.getRight());

                rDerecha.hoja = !(temp.getRight() != null && temp.getLeft() != null);
                rDerecha.insertar(temp);
            }
            aux = aux.getSiguiente();
        }
        nuevo = new Nodo(valor, rIzquierda, rDerecha);
        return nuevo;
    }

   public void crearGrafo(String path, String nombreG, String cadena) {
        System.out.println(cadena);
        //String grafo = "digraph grafica{\n rankdir=TB;\n node[shape=record, style=filled,fillcolor=seashell2]\n nodo[lable=\"1\"];};";
        FileWriter fichero = null;
        PrintWriter escritor;

        try {

            fichero = new FileWriter(nombreG + ".dot");
            escritor = new PrintWriter(fichero);
            escritor.print(cadena);

        } catch (IOException e) {
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
//Estructura principal del gafo

    public String getCodigos(Arbol_b arbol) {

        return "digraph g{\n"
                + "rankdir=TB;\n"
                + "node [shape=record,width=0.5,fontsize=12, fillcolor=seashell2,style=filled];\n"
                + Codigo_grafo(arbol)
                + "}\n";

    }

    public String Codigo_grafo(Arbol_b arbol) {
        Cola_arbol_b cola = new Cola_arbol_b();
        cola.encolar(null, arbol.raiz, 0);

        String cadena = "";
        int c_n = 0;
        while (!cola.colaVacia()) {
            NodoCola aux = (NodoCola) cola.desencolar();
            String padre = aux.getAtributos().padre;
            Pagina pagina = aux.getAtributos().pagina;
            int datos = aux.getAtributos().datos;
//            System.out.println("ddddddddddddd");
            if (padre == null) {
//                System.out.println("DDDDDDdddddddd");
                Nodo primero = pagina.primero;
                int contador = 0;
                String nodo = "Nodo_" + c_n + " [label=\"";
                while (primero != null) {
                    if (primero.getSiguiente() == null) {
                        nodo += "<r" + contador + ">|" + primero.getId() + "|<r" + (contador + 1) + ">";

                        if (primero.getLeft() != null) {
                            cola.encolar("Nodo_" + c_n, primero.getLeft(), contador);

                        }
                        if (primero.getRight() != null) {
                            cola.encolar("Nodo_" + c_n, primero.getRight(), contador + 1);
                        }
                        contador += 2;
                    } else {
                        nodo += "<r" + contador + ">|" + primero.getId() + "|";

                        if (primero.getLeft() != null) {
                            cola.encolar("Nodo_" + c_n, primero.getLeft(), contador);
                        }
                        contador++;
                    }
                    primero = primero.getSiguiente();

                }
                nodo += "\"];\n";
                cadena += nodo;
                c_n++;
                System.out.println("________________________");

            } else {
                Nodo primero = pagina.primero;
                String nodo = "Nodo_" + c_n + "[label=\"";
                int contador = 0;
                while (primero != null) {

                    if (primero.getSiguiente() == null) {
                        nodo += "<r" + contador + ">|" + primero.getId() + "|<r" + (contador + 1) + ">";

                        if (primero.getLeft() != null) {
                            cola.encolar("Nodo_" + c_n, primero.getLeft(), contador);
                        }
                        if (primero.getRight() != null) {
                            cola.encolar("Nodo_" + c_n, primero.getRight(), contador + 1);
                        }
                        contador += 2;
                    } else {
                        nodo += "<r" + contador + ">|" + primero.getId() + "|";
                        if (primero.getLeft() != null) {
                            cola.encolar("Nodo_" + c_n, primero.getLeft(), contador);
                        }
                        contador++;
                    }
                    primero = primero.getSiguiente();
                }
                cadena += padre + ":r" + datos + "->Nodo_" + c_n + ";\n";
                nodo += "\"];\n";
                cadena += nodo;
                c_n++;

            }

        }
        cadena += "\n";

        return cadena;

    }
}

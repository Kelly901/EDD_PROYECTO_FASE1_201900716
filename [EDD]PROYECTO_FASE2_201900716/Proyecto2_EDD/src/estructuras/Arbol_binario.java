/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras;

import Matriz_Dispersa.Matriz;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import proyecto2_edd.CargaMasiva;

/**
 *
 * @author Kelly
 */
public class Arbol_binario {

    public NodoArbolBinario raiz;
    public Capas capa = null;

    public Arbol_binario() {
        this.raiz = null;
    }

    public void agregar(Capas valor) {
        this.raiz = metodoRecursivo(valor, this.raiz);
    }

//Agregar
    public NodoArbolBinario metodoRecursivo(Capas valor, NodoArbolBinario raiz) {

        if (raiz == null) {
            NodoArbolBinario nodoArbol = new NodoArbolBinario(valor);
            return nodoArbol;

        } else {
            if (valor.getId_capa() < raiz.getCapas().getId_capa()) {

                raiz.setHijo_left(this.metodoRecursivo(valor, raiz.getHijo_left()));
            } else {
                raiz.setHijo_right(this.metodoRecursivo(valor, raiz.getHijo_right()));
            }
        }
        return raiz;
    }

    public void pre_orden() {
        this.pre_order_recursivo(this.raiz);
    }
//arbol

    public void pre_order_recursivo(NodoArbolBinario raiz) {
        if (raiz != null) {
            NodoPixeles aux = raiz.getCapas().getPixeles().primero;
            while (aux != null) {
                CargaMasiva.matriz.insertar_(aux.getFila(), aux.getColumna(), aux.getColor(), aux.getFila());

                aux = aux.getSiguiente();
            }
//            System.out.println("Valor :" + raiz.getCapas().getId_capa());
            this.pre_order_recursivo(raiz.getHijo_left());
            this.pre_order_recursivo(raiz.getHijo_right());
        }

    }

    public void in_orden() {
        this.in_order_recursivo(this.raiz);
    }

    public void in_order_recursivo(NodoArbolBinario raiz) {
        if (raiz != null) {
            this.in_order_recursivo(raiz.getHijo_left());
            System.out.println("Valor :" + raiz.getCapas().getId_capa());

            this.in_order_recursivo(raiz.getHijo_right());
        }
    }

    public void post_orden() {
        this.post_order_recursivo(this.raiz);
    }

    public void post_order_recursivo(NodoArbolBinario raiz) {
        if (raiz != null) {
            this.post_order_recursivo(raiz.getHijo_left());

            this.post_order_recursivo(raiz.getHijo_right());
            System.out.println("Valor :" + raiz.getCapas().getId_capa());
        }
    }

//_______________________-
    public void buscar_dato(int dato) {
        this.buscar_dato_(this.raiz, dato);
    }

    public void buscar_dato_(NodoArbolBinario raiz, int dato) {
        if (raiz != null) {
//            NodoPixeles aux = raiz.getCapas().getPixeles().primero;

            if (raiz.getCapas().getId_capa() == dato) {
                System.out.println(raiz.getCapas().getId_capa() + "==" + dato);
                capa = raiz.getCapas();
            }
//            while (aux != null) {
//                //CargaMasiva.matriz.insertar(aux.getFila(), aux.getColumna(), aux.getColor(), aux.getFila());
//                aux = aux.getSiguiente();
//            }
//            System.out.println("Valor :" + raiz.getCapas().getId_capa());
            this.buscar_dato_(raiz.getHijo_left(), dato);
            this.buscar_dato_(raiz.getHijo_right(), dato);
        }

    }
//__________Recorrido por amplitud

    public void recorrido_porAmplitud(NodoArbolBinario raiz) {
        Matriz matrizAux = new Matriz();
        NodoArbolBinario nodo = null;
        Pila pila = new Pila();
        pila.push(raiz);
        String etiqueta = "";
        System.out.println(raiz.getCapas().getId_capa());
        int cont2 = 0;
        while (pila.PilaVacia() == false) {
            nodo = (NodoArbolBinario) pila.pop();

            NodoPixeles aux = raiz.getCapas().getPixeles().primero;
            while (aux != null) {
                matrizAux.insertar_(cont2, cont2, etiqueta, cont2);

                aux = aux.getSiguiente();
            }
//            
            if (nodo.getHijo_left() != null) {
//                
                pila.push(nodo.getHijo_left());

            }
            if (nodo.getHijo_right() != null) {
//             
                pila.push(nodo.getHijo_right());

            }
            cont2 += 1;
        }

    }

//___________________Grafica
    public String graficarArbol(NodoArbolBinario raiz) {

        NodoArbolBinario nodo = null;
        Pila pila = new Pila();
        pila.push(raiz);
        String etiqueta = "";
        System.out.println(raiz.getCapas().getId_capa());
        int cont2 = 0;
        while (pila.PilaVacia() == false) {
            nodo = (NodoArbolBinario) pila.pop();

            etiqueta += "nodo" + nodo.hashCode() + "[label=\"" + nodo.getCapas().getId_capa() + " \"];\n";

            //  System.out.println(nodo.getDato());
            if (nodo.getHijo_left() != null) {
                etiqueta = etiqueta + "nodo" + nodo.hashCode() + "->nodo" + nodo.getHijo_left().hashCode() + "\n";
                pila.push(nodo.getHijo_left());

            }
            if (nodo.getHijo_right() != null) {
                etiqueta = etiqueta + "nodo" + nodo.hashCode() + "->nodo" + nodo.getHijo_right().hashCode() + "\n";
                pila.push(nodo.getHijo_right());

            }
            cont2 += 1;
        }
        //System.out.println("\netiqueta\n"+etiqueta);
        return etiqueta;
    }
////////////////////////////////////////////////////////////////////////////////////////////

    public void crearGrafo(String path, String nombreG, String cadena, String id) {
        //String grafo = "digraph grafica{\n rankdir=TB;\n node[shape=record, style=filled,fillcolor=seashell2]\n nodo[lable=\"1\"];};";
        FileWriter fichero = null;
        PrintWriter escritor;

        try {

            fichero = new FileWriter(nombreG + id + ".dot");
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
            rt.exec("dot -Tjpg -o " + path + " " + nombreG + id + ".dot");

            //Thread.sleep(500);
        } catch (IOException ex) {

            System.err.println("Error al generar la imagen");

        }

    }
//Estructura principal del gafo

    public String getCodigos(NodoArbolBinario raiz, String id) {
        // System.out.println(graficarArbol());
        return "digraph g{\nlabel=\"Id:" + id + "\";\n"
                + "rankdir=TB;\n"
                + "node [shape=oval,width=0.5,fontsize=15, fillcolor=purple,style=filled];\n"
                + graficarArbol(raiz)
                + "}\n";

    }

}

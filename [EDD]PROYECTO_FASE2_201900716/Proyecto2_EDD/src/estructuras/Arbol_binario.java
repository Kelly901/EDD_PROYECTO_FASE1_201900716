/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras;

import Matriz_Dispersa.Matriz;
import Matriz_Dispersa.Nodo;
import Matriz_Dispersa.NodoEncabezado;
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
    public Matriz matriz = null;
    public boolean existeCapa = false;
    public Matriz matrizPreOden = new Matriz();
    public Matriz matrizInOrden = new Matriz();
    public Matriz matrizPost = new Matriz();
    public String recorrido = "";
    public int cont = 0;

    public Arbol_binario() {
        this.raiz = null;
    }

    public void agregar(Capas valor, Matriz matriz) {
        this.raiz = metodoRecursivo(valor, matriz, this.raiz);
    }

//Agregar
    public NodoArbolBinario metodoRecursivo(Capas valor, Matriz matriz, NodoArbolBinario raiz) {

        if (raiz == null) {
            NodoArbolBinario nodoArbol = new NodoArbolBinario(valor, matriz);
            return nodoArbol;

        } else {
            if (valor.getId_capa() < raiz.getCapas().getId_capa()) {

                raiz.setHijo_left(this.metodoRecursivo(valor, matriz, raiz.getHijo_left()));
            } else if (valor.getId_capa() > raiz.getCapas().getId_capa()) {
                raiz.setHijo_right(this.metodoRecursivo(valor, matriz, raiz.getHijo_right()));
            } else {
                System.out.println("repetido");
            }
        }
        return raiz;
    }

//Metodo para agregar las copasa a la lista
//arbol
//Recorrido en preorden para generar las imagenes
    public void pre_orden(NodoArbolBinario raiz, int id) {

        this.pre_order_recursivo(raiz, id);
        matrizPreOden.crearGrafo("MatrizPreOrder.jpg");

    }

    public void pre_order_recursivo(NodoArbolBinario raiz, int id) {
        if (raiz != null) {
            NodoPixeles aux = raiz.getCapas().getPixeles().primero;

            if (cont < id) {
                recorrido += raiz.getCapas().getId_capa() + ",";
                System.out.println("Cantidad de capas" + raiz.getCapas().getId_capa());
                while (aux != null) {
                    matrizPreOden.insertar_(aux.getFila(), aux.getColumna(), aux.getColor(), aux.getFila());

                    aux = aux.getSiguiente();
                }
            }
            cont++;
//            System.out.println("Valor :" + raiz.getCapas().getId_capa());
            this.pre_order_recursivo(raiz.getHijo_left(), id);
            this.pre_order_recursivo(raiz.getHijo_right(), id);
        }

    }
//Recorrer las capa in_orden

    public void in_orden(NodoArbolBinario raiz, int id) {
        this.in_order_recursivo(raiz, id);
        matrizInOrden.crearGrafo("MatrizIn_order.jpg");

    }

    public void in_order_recursivo(NodoArbolBinario raiz, int id) {
        if (raiz != null) {

//____________________________
            this.in_order_recursivo(raiz.getHijo_left(), id);
//___________________________________________
            NodoPixeles aux = raiz.getCapas().getPixeles().primero;

            if (cont < id) {
                recorrido += raiz.getCapas().getId_capa() + ",";
                System.out.println("Cantidad de capas" + raiz.getCapas().getId_capa());
                while (aux != null) {
                    matrizInOrden.insertar_(aux.getFila(), aux.getColumna(), aux.getColor(), aux.getFila());

                    aux = aux.getSiguiente();
                }
            }
            cont++;

//_______________________________________________________________________________________________________
            this.in_order_recursivo(raiz.getHijo_right(), id);
        }
    }
//Recorrer las capas en post_orden

    public void post_orden(NodoArbolBinario raiz, int id) {
        this.post_order_recursivo(raiz, id);
        matrizPost.crearGrafo("Matriz_PostOrder.jpg");

    }

    public void post_order_recursivo(NodoArbolBinario raiz, int id) {
        if (raiz != null) {
            this.post_order_recursivo(raiz.getHijo_left(), id);

            this.post_order_recursivo(raiz.getHijo_right(), id);

            NodoPixeles aux = raiz.getCapas().getPixeles().primero;

            if (cont < id) {
                recorrido += raiz.getCapas().getId_capa() + ",";
                System.out.println("Cantidad de capas" + raiz.getCapas().getId_capa());
                while (aux != null) {
                    matrizPost.insertar_(aux.getFila(), aux.getColumna(), aux.getColor(), aux.getFila());

                    aux = aux.getSiguiente();
                }
            }
            cont++;

        }
    }

//_______________________-
    public void buscar_dato(NodoArbolBinario raiz, int dato) {
        this.buscar_dato_(raiz, dato);
    }

    public void buscar_dato_(NodoArbolBinario raiz, int dato) {
        if (raiz != null) {
//            NodoPixeles aux = raiz.getCapas().getPixeles().primero;

            if (raiz.getCapas().getId_capa() == dato) {
                System.out.println(raiz.getCapas().getId_capa() + "==" + dato);
                capa = raiz.getCapas();
                matriz = raiz.getMatriz();
                existeCapa = true;
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

    public void recorrido_porAmplitud(NodoArbolBinario raiz, int id) {
        Matriz matrizAux = new Matriz();
        NodoArbolBinario nodo = null;
        Pila pila = new Pila();
        pila.push(raiz);
        String etiqueta = "";
        System.out.println("id de la capa" + raiz.getCapas().getId_capa());
        int cont2 = 0;
        while (pila.PilaVacia() == false) {
            nodo = (NodoArbolBinario) pila.pop();

            NodoEncabezado efila = nodo.getMatriz().encabezadoFilas.primero;
            while (efila != null) {
                Nodo actual = efila.getAcceso();
                while (actual != null) {
//                
                    matrizAux.insertar_(actual.getFila(), actual.getColumna(), actual.getValor(), actual.getFila());

                    actual = actual.getDerecha();
                }

                efila = efila.getSiguiente();
            }
            matrizAux.crearGrafo("matriz_Avl" + id + "_" + nodo.getCapas().getId_capa() + ".jpg");

//            
            if (nodo.getHijo_left() != null) {
//                
                pila.push(nodo.getHijo_left());

            }
            if (nodo.getHijo_right() != null) {
//             
                pila.push(nodo.getHijo_right());

            }

        }
//Generar grafo de la matriz

        matrizAux.crearGrafo("matriz_Avl" + id + ".jpg");

        System.out.println("Matriz creada");

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
                + "node [shape=oval,width=0.5,fontsize=15, fillcolor=seashell2,style=filled];\n"
                + graficarArbol(raiz)
                + "}\n";

    }

}

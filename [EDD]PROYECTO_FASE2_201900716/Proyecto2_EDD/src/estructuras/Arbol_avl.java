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
public class Arbol_avl {

    public NodeAvl root;
    ListaAvl listaDeNodos;//lista para guardar los nodos del arbol avl
    ListaAvl listaAuxiliar;//lista auxiliar

    public Arbol_avl() {

        this.root = null; //la raiz del arbol
        this.listaAuxiliar = new ListaAvl();
        this.listaDeNodos = new ListaAvl();

    }
//retornar la altura del arbol

    public int altura(NodeAvl nodo) {
        if (nodo == null) {
            return 0;
        } else {
            return nodo.getAltura();
        }
    }
//
//Retorna el numero mayor de los numeros que recibe como parametro

    public int maximo(int numero1, int numero2) {

        if (numero1 > numero2) {
            return numero1;
        } else {
            return numero2;
        }
    }
//Retorna el nodo mas pequeño a la izquierda

    public NodeAvl minimo(NodeAvl nodo) {
        NodeAvl aux = nodo;
        while (aux.getIzquierdo() != null) {
            aux = aux.getIzquierdo();
        }
        return aux;
    }
//

    public int balance(NodeAvl nodo) {

        if (nodo == null) {
            return 0;
        }
        return this.altura(nodo.getDerecho()) - this.altura(nodo.getIzquierdo());
    }

//Rotar el arbol por la derecha
    public NodeAvl rotar_right(NodeAvl nodo) {

        if (nodo != null) {
            NodeAvl aux = nodo.getIzquierdo();
            nodo.setIzquierdo(aux.getDerecho());
            aux.setDerecho(nodo);
            nodo.setAltura(this.maximo(this.altura(nodo.getIzquierdo()), this.altura(nodo.getDerecho())) + 1);
            aux.setAltura(this.maximo(this.altura(aux.getIzquierdo()), this.altura(aux.getDerecho())) + 1);
            return aux;
        }
        return nodo;
    }

//rotar a la izuqierda
    public NodeAvl rotar_left(NodeAvl nodo) {

        if (nodo != null) {
            NodeAvl aux = nodo.getDerecho();
            nodo.setDerecho(aux.getIzquierdo());
            aux.setIzquierdo(nodo);
            nodo.setAltura(this.maximo(this.altura(nodo.getIzquierdo()), this.altura(nodo.getDerecho())) + 1);

            aux.setAltura(this.maximo(this.altura(aux.getIzquierdo()), this.altura(aux.getDerecho())) + 1);

            return aux;
        }
        return nodo;
    }

    public void insertarI(int numero) {
        NodeAvl nodo = new NodeAvl(numero);
        this.root = this.insertar(this.root, nodo);
    }

    public NodeAvl insertar(NodeAvl raiz, NodeAvl nodo) {

        if (raiz == null) {
            raiz = nodo;
        } else if (nodo.getDato() < raiz.getDato()) {
            raiz.setIzquierdo(this.insertar(raiz.getIzquierdo(), nodo));
        } else if (nodo.getDato() > raiz.getDato()) {
            raiz.setDerecho(this.insertar(raiz.getDerecho(), nodo));
        } else {
//            if (tipo == 1) {
//                // this.listaAuxiliar.add(true);
//                return raiz;
//            }

        }
        raiz.setAltura(this.maximo(this.altura(raiz.getIzquierdo()), this.altura(raiz.getDerecho())) + 1);
        int balance = balance(raiz);

//rotacion a la derecha
        if (balance < -1 && nodo.getDato() < raiz.getIzquierdo().getDato()) {
            return this.rotar_right(raiz);

        }
        if (balance > 1 && nodo.getDato() > raiz.getDerecho().getDato()) {
            return this.rotar_left(raiz);
//rotacion izquierda derecha
        }
        if (balance < -1 && nodo.getDato() > raiz.getIzquierdo().getDato()) {
            raiz.setIzquierdo(this.rotar_left(raiz.getIzquierdo()));

            return this.rotar_right(raiz);
        }

        if (balance > 1 && nodo.getDato() < raiz.getDerecho().getDato()) {
            raiz.setDerecho(this.rotar_right(raiz.getDerecho()));
            return this.rotar_left(raiz);
        }
        return raiz;

    }

    public void preorder(NodeAvl tmp) {
        if (tmp != null) {
            System.out.println(tmp.getDato());
            preorder(tmp.getIzquierdo());
            preorder(tmp.getDerecho());
        }

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
//Estructura principal del gafo

    public String getCodigos(NodeAvl raiz) {

        return "digraph g{\n"
                + "rankdir=TB;\n"
                + "node [shape=record,width=0.5,fontsize=12, fillcolor=seashell2,style=filled];\n"
                + graficarArbol(raiz)
                + "}\n";

    }

    String graficarArbol(NodeAvl raiz) {

        NodeAvl nodo;

        Pila pila = new Pila();

        pila.push(raiz);
        String etiqueta = "";
        String variable = "";
        int cont = 0;

        while (pila.PilaVacia() == false) {
            nodo = (NodeAvl) pila.pop();


          etiqueta += "nodo" + nodo.hashCode() + "[label=\"<C" + cont + "> |" +  nodo.getDato() + "|</C" + (cont+1) + "> \"];\n";

            if (nodo.getIzquierdo() != null) {
                etiqueta = etiqueta + "nodo" + nodo.hashCode() + ":C" + cont + "->nodo" + nodo.getIzquierdo().hashCode() + "\n";
                pila.push(nodo.getIzquierdo());
            }
            if (nodo.getDerecho() != null) {
                etiqueta = etiqueta + "nodo" + nodo.hashCode() + ":C" + (cont + 1) + "->nodo" + nodo.getDerecho().hashCode() + "\n";
                pila.push(nodo.getDerecho());

            }
            cont += 1;
        }

        return etiqueta;

    }
}

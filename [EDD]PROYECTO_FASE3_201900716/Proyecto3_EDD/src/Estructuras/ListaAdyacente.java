/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *
 * @author herre
 */
public class ListaAdyacente {

  public  Lista2 dest;

    public ListaAdyacente() {
        dest = new Lista2();
    }

    public void reccorer(Lista2 caminos) {

        NodoLista2 aux = caminos.raiz;

        while (aux != null) {

            Grafo camino = (Grafo) aux.objeto;
            
            inicio(camino);
            fin(camino);
            aux = aux.siguiente;
        }

    }

    public void inicio(Grafo camino) {
        if (dest.getDato(camino.getInicio())) {

            Arco des = new Arco(camino.getFin(), camino.getPeso());
            agregar(camino.getInicio(), des);

        } else {
            Vertice vertice = new Vertice(camino.getInicio());
            Arco des = new Arco(camino.getFin(), camino.getPeso());
            vertice.addDest(des);
            dest.insertar(vertice);
        }
    }

    public void fin(Grafo camino) {
        if (dest.equals(camino.getFin())) {
            Arco des = new Arco(camino.getInicio(), camino.getPeso());
            agregar(camino.getFin(), des);
        } else {
            Vertice vertice = new Vertice(camino.getFin());
            Arco des = new Arco(camino.getInicio(), camino.getPeso());
            vertice.addDest(des);
            dest.insertar(vertice);
        }

    }

    public void agregar(int numV, Arco a) {

        NodoLista2 temp = this.dest.raiz;

        while (temp != null) {
            Vertice vertice = (Vertice) temp.objeto;

            if (vertice.numVertice == numV) {
                vertice.addDest(a);
            }
            temp = temp.siguiente;
        }
    }

    public void mostrar() {

        NodoLista2 temp = dest.raiz;

        while (temp != null) {

            Vertice vertice = (Vertice) temp.objeto;
            String a = "" + vertice.numVertice+"->";

            NodoLista2 aux = vertice.arcos.raiz;
            while (aux != null) {

                Arco ar = (Arco) aux.objeto;
                
              // a += ar.destino;
//                System.out.println("_______"+ar.destino);
                if (aux.siguiente!=null) {
                     Arco ar2 = (Arco) aux.siguiente.objeto;
                      a +="->"+ar2.destino;
                }
                aux = aux.siguiente;

            }
            System.out.println(a);
            temp = temp.siguiente;

        }

    }
    
    

}

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
public class Lista_Doble {

    public NodoCircular primero;
    public NodoCircular ultimo;

    public Lista_Doble() {

        this.primero = null;
        this.ultimo = null;
    }

    public void insertar(String nombre, Lista_de_album lista) {

        NodoCircular nuevo = new NodoCircular(nombre, lista);

        if (this.primero == null) {
            this.primero = nuevo;
            this.primero.setSiguiente(this.primero);
            nuevo.setAnterior(this.ultimo);
            this.ultimo = nuevo;

//            this.primero = nuevo;
//            this.ultimo = nuevo;
//            this.primero.setSiguiente(this.ultimo);
//            this.primero.setAnterior(this.ultimo);
//            this.ultimo.setSiguiente(this.primero);
//            this.ultimo.setAnterior(this.primero);
        } else {

            this.ultimo.setSiguiente(nuevo);
            nuevo.setSiguiente(this.primero);
            nuevo.setAnterior(this.ultimo);
            this.ultimo = nuevo;
            this.primero.setAnterior(this.ultimo);
//            this.primero.setAnterior(nuevo);
//            nuevo.setAnterior(this.primero);
//            this.ultimo.setSiguiente(nuevo);
//            nuevo.setAnterior(this.ultimo);
//            nuevo.setSiguiente(this.primero);
//            this.ultimo = nuevo;

        }

    }
//______________________________________

    public boolean listaVacia() {
        return this.primero == null;

    }

//Eliminar nodo
    public void eliminarImagen(int dato) {

        NodoCircular temp = this.primero;
        do {
            //Nodo_Album aux = temp.getLista().primero;
            temp.getLista().EliminarDato(dato);
        } while (temp != this.primero);

    }

//____________________________________________________________________
    public void EliminarCliente(String id) {

        NodoCircular actual;
        NodoCircular antetior;
        actual = this.primero;
        antetior = this.ultimo;
        do {
            if (actual.getNombre().equals(id)) {
                if (actual == this.primero) {
                    this.primero = primero.getSiguiente();
                    this.ultimo.setSiguiente(this.primero);
                    this.primero.setAnterior(this.ultimo);
                } else if (actual == this.ultimo) {
                    this.ultimo = antetior;
                    this.primero.setAnterior(this.ultimo);
                    this.ultimo.setSiguiente(this.primero);

                } else {
                    antetior.setSiguiente(actual.getSiguiente());
                    actual.getSiguiente().setAnterior(antetior);
                }

            }
            antetior = actual;
            actual = actual.getSiguiente();
        } while (actual != primero);
    }
//_________________________________________________________________________

    public void mostrar() {
        System.out.println(".----");
        NodoCircular aux = this.primero;
        // System.out.println(aux.getCliente().getNombre_cliente());
        while (aux.getSiguiente() != this.primero) {
            System.out.println("_______________");
            System.out.println("LIsta");
            System.out.println(aux.getNombre());
            aux.getLista().mostrar();
            aux = aux.getSiguiente();

        }
        System.out.println("______________");

        System.out.println(aux.getNombre());
        aux.getLista().mostrar();
        System.out.println("______________");
        System.out.println(">>>>>><F<<<<<<<<<<<");

    }

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

    public String graficaClitesE(NodoCircular nodoC) {
        String cadena = "digraph G{\nlabel=\"Estado de la lista circular \";\nnode[shape=box];\n";
        String conexion = "";
        String nodos = "";
        NodoCircular temp = nodoC;
        String principal = "";
// nodos += "nC"  + "[label=\"" + temp.getSiguiente().getCliente().getNombre_cliente() + "\"];\n";
//  nodos += "nC" + temp.getAnterior().hashCode() + "[label=\"" + temp.getAnterior().getCliente().getNombre_cliente() + "\"];\n";
        do {

            principal += "nC" + temp.hashCode() + ";";

            nodos += "nC" + temp.hashCode() + "[label=\"" + temp.getNombre() + "\"];\n";
            //nodos += "nC" + temp.getSiguiente().hashCode() + "[label=\"" + temp.getSiguiente().getCliente().getNombre_cliente() + "\"];\n";
            //nodos += "nC" + temp.getAnterior().hashCode() + "[label=\"" + temp.getAnterior().getCliente().getNombre_cliente() + "\"];\n";
            if (temp.getSiguiente() != null) {
                conexion += "nC" + temp.hashCode() + "->nC" + temp.getSiguiente().hashCode() + ";\n";
                //conexion += "nC" + temp.getSiguiente().hashCode() + "->nC" + temp.hashCode() + ";\n";
                // conexion += "nC" + temp.getSiguiente().hashCode() + "->nC" + temp.getAnterior().hashCode() + ";\n";
            }
            if (temp.getAnterior() != null) {
                conexion += "nC" + temp.hashCode() + "->nC" + temp.getAnterior().hashCode() + ";\n";
                //conexion += "nC" + temp.getAnterior().hashCode() + "->nC" + temp.hashCode() + ";\n";
                //conexion += "nC" + temp.getAnterior().hashCode() + "->nC" + temp.getSiguiente().hashCode() + ";\n";
            }
//            if (temp==CargaMasiva.listaCicular.primero) {
//                conexion += "nC" + temp.hashCode() + "->nC" + temp.getAnterior()+ ";\n";
//            }

            Nodo_Album aux = temp.getLista().primero;

            while (aux != null) {

                if (aux == temp.getLista().primero) {
                    conexion += "nC" + temp.hashCode() + "->nP" + aux.hashCode() + ";\n";

                }

                System.out.println("entro");
                nodos += "nP" + aux.hashCode() + "[label=\"" + aux.getImagen() + "\"];\n";
                if (aux.getSiguiente() != null) {

                    conexion += "nP" + aux.hashCode() + "->nP" + aux.getSiguiente().hashCode() + ";\n";

                }
                aux = aux.getSiguiente();
            }
            temp = temp.getSiguiente();
        } while (temp != nodoC);

        cadena += nodos + "\n";
        cadena += conexion + "\n";
        cadena += "{rank=same;" + principal + "}";
        //cadena += GrafoVentanilla();

        cadena += "\n}";
        return cadena;

    }
}

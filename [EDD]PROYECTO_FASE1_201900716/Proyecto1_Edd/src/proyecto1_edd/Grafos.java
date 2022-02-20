/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1_edd;

import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author Kelly
 */
public class Grafos {

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

    public String generarGrafos() {
        String cadena = "digraph G{\nlabel=\"Estado de la cola\";\nnode[shape=box];\n";
//        cadena += "subgraph cluster_1 {\nlabel=\"Estado de la cola\";\n";
        NodoCola temp = CargaMasiva.cola.frente;
        String conexion = "";
        String nodos = "";
        while (temp != null) {

            nodos += "n" + temp.hashCode() + "[label=\"" + temp.getNombre_cliente() + "\nImagen C: " + temp.getImg_color() + "\nImagen bw: " + temp.getImg_bw() + "\"];\n";
            if (temp.getSiguiente() != null) {
                conexion += "n" + temp.hashCode() + "->n" + temp.getSiguiente().hashCode() + ";\n";

            }
            temp = temp.getSiguiente();
        }

        cadena += nodos + "\n";
        cadena += "{rank=same;\n" + conexion + "\n}";
        //cadena += GrafoVentanilla();

        cadena += "\n}";
        return cadena;
    }

    public String GrafoVentanilla2() {
        NodoVentanilla temp = CargaMasiva.ventanilla.cabeza;
        String cadena = "digraph G{\nlabel=\"Estado de las ventanillas\";\nnode[shape=box];\n";
//        cadena += "subgraph cluster_2 {\nlabel=\"Ventanas \";\n";
        String conexion = "";
        String nodos = "";

        while (temp != null) {

            nodos += "nV" + temp.hashCode() + "[label=\"" + temp.getVentanillas() + "\"];\n";

            if (temp.getSiguiente() != null) {
                conexion += "nV" + temp.hashCode() + "->nV" + temp.getSiguiente().hashCode() + ";\n";

                if (temp.getPila().PilaVacia() == false) {
                    conexion += "nV" + temp.hashCode() + "->nP" + temp.getPila().cima.hashCode() + ";\n";
                }

                if (temp.getSiguiente().getPila().PilaVacia() == false) {
                    conexion += "nV" + temp.getSiguiente().hashCode() + "->nP" + temp.getSiguiente().getPila().cima.hashCode() + ";\n";
                }
            }
            NodoPilaI aux = temp.getPila().cima;
            while (aux != null) {
                //conexion += "nV" + temp.hashCode() + "->nP" + aux.hashCode() + ";\n";
                if (aux.getImg_color() != 0) {
                    System.out.println("entro");
                    nodos += "nP" + aux.hashCode() + "[label=\"IMG C\"];\n";
                    if (aux.getSiguiente() != null) {

                        conexion += "nP" + aux.hashCode() + "->nP" + aux.getSiguiente().hashCode() + ";\n";

                    }
                } else {
                    System.out.println("entro 2");

                    nodos += "nP" + aux.hashCode() + "[label=\"IMG bw\"];\n";
                    if (aux.getSiguiente() != null) {
                        // conexion += "nV" + temp.hashCode() + "->nP" + aux.hashCode() + ";\n";
                        conexion += "nP" + aux.hashCode() + "->nP" + aux.getSiguiente().hashCode() + ";\n";

                    }

                }

                aux = aux.getSiguiente();
            }
            temp = temp.getSiguiente();

        }

        cadena += nodos + "\n";
        cadena += conexion + "\n";
        //cadena += GrafoVentanilla();

        cadena += "\n}";
        return cadena;
    }

    public String generarGrafosImpresoraC() {
        String cadena = "digraph G{\nlabel=\"Cola de impresion a color\";\nnode[shape=box];\n";
//        cadena += "subgraph cluster_1 {\nlabel=\"Estado de la cola\";\n";
        Nodo_impresoraC temp = CargaMasiva.impresora_c.frente;
        String conexion = "";
        String nodos = "";
        while (temp != null) {

            nodos += "n" + temp.hashCode() + "[label=\"" + temp.getNombre_cliente() + "\nIMG C \"];\n";
            if (temp.getSiguiente() != null) {
                conexion += "n" + temp.hashCode() + "->n" + temp.getSiguiente().hashCode() + ";\n";

            }
            temp = temp.getSiguiente();
        }

        cadena += nodos + "\n";
        cadena += "{rank=same;\n" + conexion + "\n}";
        //cadena += GrafoVentanilla();

        cadena += "\n}";
        return cadena;
    }

    public String generarGrafosImpresoraBw() {
        String cadena = "digraph G{\nlabel=\"Cola de impresion BW\";\nnode[shape=box];\n";
//        cadena += "subgraph cluster_1 {\nlabel=\"Estado de la cola\";\n";
        Nodo_impresoraBw temp = CargaMasiva.impresora_bw.frente;
        String conexion = "";
        String nodos = "";
        while (temp != null) {

            nodos += "n" + temp.hashCode() + "[label=\"" + temp.getNombre_cliente() + "\nIMG Bw \"];\n";
            if (temp.getSiguiente() != null) {
                conexion += "n" + temp.getSiguiente().hashCode() + "->n" + temp.hashCode() + ";\n";

            }
            temp = temp.getSiguiente();
        }

        cadena += nodos + "\n";
        cadena += "{rank=same;\n" + conexion + "\n}";
        //cadena += GrafoVentanilla();

        cadena += "\n}";
        return cadena;
    }

//Copia
    public String GrafoVentanilla1() {
        NodoVentanilla temp = CargaMasiva.ventanilla.cabeza;
        String cadena = "digraph G{\nlabel=\"Estado de las ventanillas\";\nnode[shape=box];\n";
        String ventanilas = "";
//        cadena += "subgraph cluster_2 {\nlabel=\"Ventanas \";\n";
        String conexion = "";
        String nodos = "";

        while (temp != null) {
            String v = "nV" + temp.hashCode();
            ventanilas += v + ";";
            nodos += "nV" + temp.hashCode() + "[label=\"" + temp.getVentanillas() + "\"];\n";

            if (temp.getSiguiente() != null) {
                conexion += v + "->nV" + temp.getSiguiente().hashCode() + ";\n";

            }
            NodoPilaI aux = temp.getPila().cima;
            while (aux != null) {
                if (aux == temp.getPila().cima) {
                    conexion += "nV" + temp.hashCode() + "->nP" + aux.hashCode() + ";\n";
                }

                if (aux.getImg_color() != 0) {
                    //System.out.println("entro");
                    nodos += "nP" + aux.hashCode() + "[label=\"IMG C\"];\n";
                    if (aux.getSiguiente() != null) {

                        conexion += "nP" + aux.hashCode() + "->nP" + aux.getSiguiente().hashCode() + ";\n";

                    }
                } else {
                    //System.out.println("entro 2");

                    nodos += "nP" + aux.hashCode() + "[label=\"IMG bw\"];\n";
                    if (aux.getSiguiente() != null) {
                        // conexion += "nV" + temp.hashCode() + "->nP" + aux.hashCode() + ";\n";
                        conexion += "nP" + aux.hashCode() + "->nP" + aux.getSiguiente().hashCode() + ";\n";

                    }

                }

                aux = aux.getSiguiente();
            }
            temp = temp.getSiguiente();

        }

        cadena += nodos + "\n";
        cadena += conexion + "\n";
        cadena += "{rank=same;" + ventanilas + "}";
        //cadena += "{rank=same;\n" + conexion+ "\n}";
        //cadena += GrafoVentanilla();

        cadena += "\n}";
        return cadena;
    }

    public String graficoClientesAtendidos() {
        String cadena = "digraph G{\nlabel=\"Estado de la lista Clientes atendidos\";\nnode[shape=box];\n";
//        cadena += "subgraph cluster_1 {\nlabel=\"Estado de la cola\";\n";
        NodoAtendidos temp = CargaMasiva.listaAtendidos.cabeza;
        String conexion = "";
        String nodos = "";
        while (temp != null) {

            nodos += "n" + temp.hashCode() + "[label=\"" + temp.getCliente().getNombre_cliente() + "\nTotal de imagenes: " + temp.getCliente().getTotalImagenes() + "\nPasos: " + temp.getCliente().getPasos() + "\"];\n";
            if (temp.getSiguiente() != null) {
                conexion += "n" + temp.hashCode() + "->n" + temp.getSiguiente().hashCode() + ";\n";

            }
            temp = temp.getSiguiente();
        }

        cadena += nodos + "\n";
        cadena += "{rank=same;\n" + conexion + "\n}";
        //cadena += GrafoVentanilla();

        cadena += "\n}";
        return cadena;

    }

    //Esta es la grafica de los clients en espera   
    public String graficaClitesE() {
        String cadena = "digraph G{\nlabel=\"Estado de la lista circular \";\nnode[shape=box];\n";
        String conexion = "";
        String nodos = "";
        NodoCircular temp = CargaMasiva.listaCicular.primero;
        String principal = "";
// nodos += "nC"  + "[label=\"" + temp.getSiguiente().getCliente().getNombre_cliente() + "\"];\n";
//  nodos += "nC" + temp.getAnterior().hashCode() + "[label=\"" + temp.getAnterior().getCliente().getNombre_cliente() + "\"];\n";
        do {

            principal += "nC" + temp.hashCode() + ";";

            nodos += "nC" + temp.hashCode() + "[label=\"" + temp.getCliente().getNombre_cliente() + "\"];\n";
            //nodos += "nC" + temp.getSiguiente().hashCode() + "[label=\"" + temp.getSiguiente().getCliente().getNombre_cliente() + "\"];\n";
            //nodos += "nC" + temp.getAnterior().hashCode() + "[label=\"" + temp.getAnterior().getCliente().getNombre_cliente() + "\"];\n";
            if (temp.getSiguiente() != null ) {
                conexion += "nC" + temp.hashCode() + "->nC" + temp.getSiguiente().hashCode() + ";\n";
                //conexion += "nC" + temp.getSiguiente().hashCode() + "->nC" + temp.hashCode() + ";\n";
                // conexion += "nC" + temp.getSiguiente().hashCode() + "->nC" + temp.getAnterior().hashCode() + ";\n";
            }
            if (temp.getAnterior() != null ) {
                conexion += "nC" + temp.hashCode() + "->nC" + temp.getAnterior().hashCode() + ";\n";
                //conexion += "nC" + temp.getAnterior().hashCode() + "->nC" + temp.hashCode() + ";\n";
                //conexion += "nC" + temp.getAnterior().hashCode() + "->nC" + temp.getSiguiente().hashCode() + ";\n";
            }
//            if (temp==CargaMasiva.listaCicular.primero) {
//                conexion += "nC" + temp.hashCode() + "->nC" + temp.getAnterior()+ ";\n";
//            }
           

            NodoListaE aux = temp.getLista().cabeza;

            while (aux != null) {

                if (aux == temp.getLista().cabeza) {
                    conexion += "nC" + temp.hashCode() + "->nP" + aux.hashCode() + ";\n";

                }

                if (aux.getCliente().getImg_color2() == 2) {
                    System.out.println("entro");
                    nodos += "nP" + aux.hashCode() + "[label=\"IMG C\"];\n";
                    if (aux.getSiguiente() != null) {

                        conexion += "nP" + aux.hashCode() + "->nP" + aux.getSiguiente().hashCode() + ";\n";

                    }
                } else {
                    System.out.println("entro 2");

                    nodos += "nP" + aux.hashCode() + "[label=\"IMG bw\"];\n";
                    if (aux.getSiguiente() != null) {
                        // conexion += "nV" + temp.hashCode() + "->nP" + aux.hashCode() + ";\n";

                        conexion += "nP" + aux.hashCode() + "->nP" + aux.getSiguiente().hashCode() + ";\n";

                    }

                }
                aux = aux.getSiguiente();
            }
            temp = temp.getSiguiente();
        } while (temp != CargaMasiva.listaCicular.primero);

        cadena += nodos + "\n";
        cadena += conexion + "\n";
        cadena += "{rank=same;" + principal + "}";
        //cadena += GrafoVentanilla();

        cadena += "\n}";
        return cadena;

    }
    //

    public String Top5_color() {
        
   
        
        
        String cadena = "digraph G{\nlabel=\"Top5 de clientes con mas imagenes a color\";\nnode[shape=box];\n";
//        cadena += "subgraph cluster_1 {\nlabel=\"Estado de la cola\";\n";
        NodoAtendidos temp = CargaMasiva.listaTop5.cabeza;
        String conexion = "";
        String nodos = "";
        int cont = 1;
        while (temp != null) {

            nodos += "n" + temp.hashCode() + "[label=\"" + temp.getCliente().getId_cliente() + "." + temp.getCliente().getNombre_cliente() + "\nImagen C: " + temp.getCliente().getImg_color2() + "\"];\n";
            if (temp.getSiguiente() != null) {
                if (cont<5) {
                    conexion += "n" + temp.hashCode() + "->n" + temp.getSiguiente().hashCode() + ";\n";
                }
                

                //System.out.println("..." + temp.getSiguiente().getCliente().getNombre_cliente());
            }
            if (cont == 5) {
                break;
            }
            cont += 1;
            temp = temp.getSiguiente();

        }


        cadena += nodos + "\n";
        cadena += "{rank=same;\n" + conexion + "\n}";
        //cadena += GrafoVentanilla();

        cadena += "\n}";
        return cadena;

    }
    
    
    
public String Top5_bw() {
        
        
        
        String cadena = "digraph G{\nlabel=\"Top5 de clientes con menos imagenes a BW\";\nnode[shape=box];\n";
//        cadena += "subgraph cluster_1 {\nlabel=\"Estado de la cola\";\n";
        NodoAtendidos temp = CargaMasiva.listaTop5_bw.cabeza;
        String conexion = "";
        String nodos = "";
        int cont = 1;
        while (temp != null) {

            nodos += "n" + temp.hashCode() + "[label=\"" + temp.getCliente().getId_cliente() + "." + temp.getCliente().getNombre_cliente() + "\nImagen C: " + temp.getCliente().getImg_bw2() + "\"];\n";
            if (temp.getSiguiente() != null) {
                if (cont<5) {
                    conexion += "n" + temp.hashCode() + "->n" + temp.getSiguiente().hashCode() + ";\n";
                }
                

                //System.out.println("..." + temp.getSiguiente().getCliente().getNombre_cliente());
            }
            if (cont == 5) {
                break;
            }
            cont += 1;
            temp = temp.getSiguiente();

        }


        cadena += nodos + "\n";
        cadena += "{rank=same;\n" + conexion + "\n}";
        //cadena += GrafoVentanilla();

        cadena += "\n}";
        return cadena;

    }


//Grafo clieente con mas pasos



}
//{rank=same;nV460141958;nV1163157884;nV1735600054;nV2133927002}
//


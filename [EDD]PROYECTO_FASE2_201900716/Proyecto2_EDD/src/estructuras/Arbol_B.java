/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Kelly
 */
public class Arbol_B {

    public Rama raiz;
    int orden;
    public boolean bandera = false;

    public Arbol_B(int orden) {
        this.orden = orden;
        this.raiz = null;
        this.bandera = false;
    }

//________________________
    public void insertar(long dpi, String nombre, String password) {

        Nodo_b nodo = new Nodo_b(dpi,nombre,password);

        if (this.raiz == null) {
            this.raiz = new Rama();
            this.raiz.insertar(nodo);
            return;
        } else {

            Object temp = this.add(nodo, this.raiz);
            if (temp instanceof Nodo_b) {
                this.raiz = new Rama();
                this.raiz.insertar((Nodo_b) temp);
                this.raiz.hoja = false;
            }
        }
    }

    Object add(Nodo_b nodo, Rama r) {
        Rama rama = (Rama) r;
        if (rama.hoja) {
            rama.insertar(nodo);
            if (rama.contador == this.orden) {
                return this.dividirRama(rama);
            } else {
                return rama;
            }

        } else {
            Nodo_b temp = rama.primero;
            do {
                
                if (nodo.dpi==temp.dpi) {
                    return rama;
                } else if (nodo.dpi<temp.dpi) {
                    Object aux = this.add(nodo, temp.izquierda);
                    if (aux instanceof Nodo_b) {
                        System.out.println(".............entro aqui");
                        rama.insertar((Nodo_b) aux);

                        if (rama.contador == this.orden) {
                            return this.dividirRama(rama);
                        }
                    }
                    return rama;
                } else if (temp.siguiente == null) {
                    Object aux = this.add(nodo, temp.derecha);

                    if (aux instanceof Nodo_b) {
                        rama.insertar((Nodo_b) aux);
                        if (rama.contador == this.orden) {
                            return this.dividirRama(rama);
                        }

                    }

                    return rama;
                }
                temp = temp.siguiente;
            } while (temp != null);
        }
        //Object ramaO=rama;

        Object r1 = rama;
        return r1;
    }

    Nodo_b dividirRama(Rama r) {
        Rama rama = (Rama) r;
        Rama derecha = new Rama();
        Rama izquierda = new Rama();
        Nodo_b medio = null;
        Nodo_b temp = rama.primero;

        int inicio = 1;
        int valorMedio = (this.orden / 2) + 1;
        int fin = this.orden;

        for (int i = 1; i < this.orden + 1; i++, temp = temp.siguiente) {
            // System.out.println("error" + temp.valor);
            Nodo_b nodo = new Nodo_b(temp.dpi,temp.nombre,temp.password);
            nodo.izquierda = temp.izquierda;
            nodo.derecha = temp.derecha;
            if (nodo.derecha != null && nodo.izquierda != null) {
                izquierda.hoja = false;
                derecha.hoja = false;
            }
            if (i >= inicio && i < valorMedio) {
                izquierda.insertar(nodo);

            } else if (i == valorMedio) {
                medio = nodo;
            } else if (i <= fin && i > valorMedio) {
                derecha.insertar(nodo);
            }

        }
        try {
            medio.derecha = derecha;
            medio.izquierda = izquierda;
        } catch (Exception e) {
        }

        return medio;

    }

    public void imprimir() {
        System.out.println("nad");
////        Rama rama = this.raiz;
////        Pila pila = new Pila();
////        pila.push(rama);
////        while (pila.PilaVacia() != false) {
////            rama = (Rama) pila.pop();
////            while (rama != null) {
////                Nodo_b temp = rama.primero;
////                //System.out.println(temp.valor);
////                while (temp != null) {
////                    System.out.println(temp.valor);
////
////                    temp = temp.siguiente;
////                }
////                
////                rama = rama.primero.izquierda;
////            }
////        
////            
////
////        }
    }

 
    public void buscar_cliente(String dpi, Rama rama) {
        Rama pagina = rama;
        Nodo_b primero = pagina.primero;
        while (primero != null) {

            if (primero.siguiente == null) {

                if (primero.dpi==Integer.parseInt(dpi)) {

                    System.out.println("son iguales");

                    this.bandera = true;

                }
                if (primero.izquierda != null) {

                    buscar_cliente(dpi, primero.izquierda);

                } else if (primero.derecha != null) {

                    buscar_cliente(dpi, primero.derecha);
                }
            } else {
                if (primero.dpi==Long.parseLong(dpi)) {
                    System.out.println("ddd");
                    this.bandera = true;

                }

            }

            primero = primero.siguiente;
        }

    }

    public void modificar_clinte(String dpi, String nombre, String password) {
        this.raiz = this.modificar_clinte_(this.raiz, dpi, nombre, password);
    }
//_______________________________________________________________________

    public Rama modificar_clinte_(Rama raiz, String dpi, String nombre, String password) {

        if (raiz != null) {
            Nodo_b primero = raiz.primero;
            while (primero != null) {
                if (Long.parseLong(dpi)<primero.dpi) {
                    //________________izquierdo
                    primero.izquierda = modificar_clinte_(primero.izquierda, dpi, nombre, password);

                } else if (Long.parseLong(dpi)>primero.dpi) {
                    //________________________derecho_______________________
                    primero.derecha = modificar_clinte_(primero.derecha, dpi, nombre, password);
                } else {
                    
                    this.bandera = true;
                   // System.out.println("true");
                }
                primero = primero.siguiente;
            }
            return raiz;
        }
        return raiz;
    }
//_______________________________________________________________________

//    public void crearGrafo(String path, String nombreG, String cadena) {
//        System.out.println(cadena);
//        //String grafo = "digraph grafica{\n rankdir=TB;\n node[shape=record, style=filled,fillcolor=seashell2]\n nodo[lable=\"1\"];};";
//        FileWriter fichero = null;
//        PrintWriter escritor;
//
//        try {
//
//            fichero = new FileWriter(nombreG + ".dot");
//            escritor = new PrintWriter(fichero);
//            escritor.print(cadena);
//
//        } catch (IOException e) {
//            System.err.println("Error al escribir el archivvo");
//        } finally {
//            try {
//                if (null != fichero) {
//                    fichero.close();
//                }
//
//            } catch (Exception e2) {
//                System.err.println("Error al cerrar el archivo");
//
//            }
//
//        }
//
//        try {
//
//            Runtime rt = Runtime.getRuntime();
//            rt.exec("dot -Tjpg -o " + path + " " + nombreG + ".dot");
//
//            //Thread.sleep(500);
//        } catch (Exception ex) {
//
//            System.err.println("Error al generar la imagen");
//
//        }
//
//    }
////Estructura principal del gafo
//
//    public String getCodigos(Arbol_B arbol) {
//
//        return "digraph g{\n"
//                + "rankdir=TB;\n"
//                + "node [shape=record,width=0.5,fontsize=12, fillcolor=seashell2,style=filled];\n"
//                + Codigo_grafo(arbol)
//                + "}\n";
//
//    }
//
//    public String Codigo_grafo(Arbol_B arbol) {
//        Cola_arbol_b cola = new Cola_arbol_b();
//        cola.encolar(null, arbol.raiz, 0);
//
//        String cadena = "";
//        int c_n = 0;
//        while (!cola.colaVacia()) {
//            NodoCola aux = (NodoCola) cola.desencolar();
//            String padre = aux.getAtributos().padre;
//            Rama pagina = aux.getAtributos().pagina;
//            int datos = aux.getAtributos().datos;
////            System.out.println("ddddddddddddd");
//            if (padre == null) {
////                System.out.println("DDDDDDdddddddd");
//                Nodo_b primero = pagina.primero;
//                int contador = 0;
//                String nodo = "Nodo_" + c_n + " [label=\"";
//                while (primero != null) {
//                    if (primero.siguiente == null) {
//                        nodo += "<r" + contador + ">|" + primero.dpi + "|<r" + (contador + 1) + ">";
//
//                        if (primero.izquierda != null) {
//                            cola.encolar("Nodo_" + c_n, primero.izquierda, contador);
//
//                        }
//                        if (primero.derecha != null) {
//                            cola.encolar("Nodo_" + c_n, primero.derecha, contador + 1);
//                        }
//                        contador += 2;
//                    } else {
//                        nodo += "<r" + contador + ">|" + primero.dpi + "|";
//
//                        if (primero.izquierda != null) {
//                            cola.encolar("Nodo_" + c_n, primero.izquierda, contador);
//                        }
//                        contador++;
//                    }
//                    primero = primero.siguiente;
//
//                }
//                nodo += "\"];\n";
//                cadena += nodo;
//                c_n++;
//                System.out.println("________________________");
//
//            } else {
//                Nodo_b primero = pagina.primero;
//                String nodo = "Nodo_" + c_n + "[label=\"";
//                int contador = 0;
//                while (primero != null) {
//
//                    if (primero.siguiente == null) {
//                        nodo += "<r" + contador + ">|" + primero.dpi + "|<r" + (contador + 1) + ">";
//
//                        if (primero.izquierda != null) {
//                            cola.encolar("Nodo_" + c_n, primero.izquierda, contador);
//                        }
//                        if (primero.derecha != null) {
//                            cola.encolar("Nodo_" + c_n, primero.derecha, contador + 1);
//                        }
//                        contador += 2;
//                    } else {
//                        nodo += "<r" + contador + ">|" + primero.dpi + "|";
//                        if (primero.izquierda != null) {
//                            cola.encolar("Nodo_" + c_n, primero.izquierda, contador);
//                        }
//                        contador++;
//                    }
//                    primero = primero.siguiente;
//                }
//                cadena += padre + ":r" + datos + "->Nodo_" + c_n + ";\n";
//                nodo += "\"];\n";
//                cadena += nodo;
//                c_n++;
//
//            }
//
//        }
//        cadena += "\n";
//
//        return cadena;
//
//    }

}

//Clase rama


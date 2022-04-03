/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arbol_b;

import estructuras.Arbol_avl;
import estructuras.Arbol_binario;
import estructuras.Cola_arbol_b;
import estructuras.Lista_Doble;
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
    public boolean bandera = false;
    public Arbol_binario arbol_bin = null;
    public Arbol_avl arbolAvl = null;
public Lista_Doble list_D=null;

    public Arbol_b() {
        this.raiz = new Pagina();

    }
//metodo insertar

    public void insertar(long id, String nombre, String password, Arbol_binario arbol_binario, Arbol_avl arbolAvl, Lista_Doble listaD) {
        Nodo nodo = new Nodo(id, nombre, password, arbol_binario, arbolAvl, listaD);
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
        String nombre = "";
        String password = "";
        Arbol_avl arbolAvl = null;
        Arbol_binario arbol_binario = null;
        Lista_Doble listaD = null;
        Nodo temp, nuevo;
        Nodo aux = rama.primero;

        Pagina rDerecha = new Pagina();
        Pagina rIzquierda = new Pagina();

        int contador = 0;
        while (aux != null) {
            contador++;

            if (contador < 3) {
                temp = new Nodo(aux.getId(), aux.getNombre_cliente(), aux.getPassword(), aux.getArbol_binario(), aux.getArbolAvl(), aux.getRight(), aux.getLeft(), aux.getListaD());
                rIzquierda.hoja = !(temp.getRight() != null && temp.getLeft() != null);
                rIzquierda.insertar(temp);
            } else if (contador == 3) {
                valor = aux.getId();
                nombre = aux.getNombre_cliente();
                password = aux.getPassword();
                arbolAvl = aux.getArbolAvl();
                arbol_binario = aux.getArbol_binario();
                listaD = aux.getListaD();
            } else {

                temp = new Nodo(aux.getId(), aux.getNombre_cliente(), aux.getPassword(), aux.getArbol_binario(), aux.getArbolAvl(), aux.getLeft(), aux.getRight(), aux.getListaD());

                rDerecha.hoja = !(temp.getRight() != null && temp.getLeft() != null);
                rDerecha.insertar(temp);
            }
            aux = aux.getSiguiente();
        }
        nuevo = new Nodo(valor, nombre, password, arbol_binario, arbolAvl, rIzquierda, rDerecha, listaD);
        return nuevo;
    }
//Metodo para buscar cliente

    public void bucar_clinte(Pagina raiz, String dpi, String nombre, String password) {
        this.raiz = this.buscar_clinte_(raiz, dpi, nombre, password);
    }
//_______________________________________________________________________

    public Pagina buscar_clinte_(Pagina raiz, String dpi, String nombre, String password) {

        if (raiz != null) {
            Nodo primero = raiz.primero;
            while (primero != null) {
                if (Long.parseLong(dpi) < primero.getId()) {
                    //________________izquierdo
                    primero.setLeft(buscar_clinte_(primero.getLeft(), dpi, nombre, password));

                } else if (Long.parseLong(dpi) > primero.getId()) {
                    //________________________derecho_______________________
                    primero.setRight(buscar_clinte_(primero.getRight(), dpi, nombre, password));
                } else {
                    if (password.equals(primero.getPassword())) {
                        this.bandera = true;
                    }

                    // System.out.println("true");
                }
                primero = primero.getSiguiente();
            }
            return raiz;
        }
        return raiz;
    }
//Metodo para buscr arbol binario

    public void bucar_binario(Pagina raiz, String dpi) {
        this.raiz = this.buscar_binario_(raiz, dpi);
    }
//_______________________________________________________________________

    public Pagina buscar_binario_(Pagina raiz, String dpi) {

        if (raiz != null) {
            Nodo primero = raiz.primero;
            while (primero != null) {
                if (Long.parseLong(dpi) < primero.getId()) {
                    //________________izquierdo
                    primero.setLeft(buscar_binario_(primero.getLeft(), dpi));

                } else if (Long.parseLong(dpi) > primero.getId()) {
                    //________________________derecho_______________________
                    primero.setRight(buscar_binario_(primero.getRight(), dpi));
                } else {
                    this.arbol_bin = primero.getArbol_binario();

                    System.out.println("true");
                }
                primero = primero.getSiguiente();
            }
            return raiz;
        }
        return raiz;
    }
///

    public void bucar_Avl(Pagina raiz, String dpi) {
        this.raiz = this.buscar_Avl_(raiz, dpi);
    }
//_______________________________________________________________________

    public Pagina buscar_Avl_(Pagina raiz, String dpi) {

        if (raiz != null) {
            Nodo primero = raiz.primero;

            while (primero != null) {
                if (Long.parseLong(dpi) < primero.getId()) {
                    //________________izquierdo
                    primero.setLeft(buscar_Avl_(primero.getLeft(), dpi));

                } else if (Long.parseLong(dpi) > primero.getId()) {
                    //________________________derecho_______________________
                    primero.setRight(buscar_Avl_(primero.getRight(), dpi));
                } else {
                    if (primero.getArbolAvl() == null) {
                        System.out.println("Esta vacio");
                    }
                    this.arbolAvl = primero.getArbolAvl();
                    System.out.println("Si existe");

                }
                primero = primero.getSiguiente();
            }
            return raiz;
        }
        return raiz;
    }

//Bucar lista doble
public void bucar_ListaD(Pagina raiz, String dpi) {
        this.raiz = this.bucar_ListaD_(raiz, dpi);
    }
//_______________________________________________________________________

    public Pagina bucar_ListaD_(Pagina raiz, String dpi) {

        if (raiz != null) {
            Nodo primero = raiz.primero;

            while (primero != null) {
                if (Long.parseLong(dpi) < primero.getId()) {
                    //________________izquierdo
                    primero.setLeft(bucar_ListaD_(primero.getLeft(), dpi));

                } else if (Long.parseLong(dpi) > primero.getId()) {
                    //________________________derecho_______________________
                    primero.setRight(bucar_ListaD_(primero.getRight(), dpi));
                } else {
                    if (primero.getArbolAvl() == null) {
                        System.out.println("Esta vacio");
                    }
                    this.list_D = primero.getListaD();
                    System.out.println("Si existe");

                }
                primero = primero.getSiguiente();
            }
            return raiz;
        }
        return raiz;
    }

//Metodo para modificar cliente

    public void modificar_clinte(Pagina raiz, String dpi, String nombre, String password) {
        this.raiz = this.modificar_clinte_(raiz, dpi, nombre, password);
    }
//_______________________________________________________________________

    public Pagina modificar_clinte_(Pagina raiz, String dpi, String nombre, String password) {

        if (raiz != null) {
            Nodo primero = raiz.primero;
            while (primero != null) {
                if (Long.parseLong(dpi) < primero.getId()) {
                    //________________izquierdo
                    primero.setLeft(modificar_clinte_(primero.getLeft(), dpi, nombre, password));

                } else if (Long.parseLong(dpi) > primero.getId()) {
                    //________________________derecho_______________________
                    primero.setRight(modificar_clinte_(primero.getRight(), dpi, nombre, password));
                } else {

                    this.bandera = true;
                    if ("".equals(nombre)) {
                        primero.setNombre_cliente(primero.getNombre_cliente());
                    } else {
                        primero.setNombre_cliente(nombre);
                    }
                    if ("".equals(password)) {
                        primero.setPassword(primero.getPassword());
                    } else {
                        primero.setPassword(password);
                    }

                    // System.out.println("true");
                }
                primero = primero.getSiguiente();
            }
            return raiz;
        }
        return raiz;
    }

//Agregar arbol binario
    public void AgregarArbolBinario(Pagina raiz, String dpi, Arbol_binario binario) {
        this.raiz = this.AgregarArbolBinario_(raiz, dpi, binario);
    }
//_______________________________________________________________________

    public Pagina AgregarArbolBinario_(Pagina raiz, String dpi, Arbol_binario binario) {

        if (raiz != null) {
            Nodo primero = raiz.primero;
            while (primero != null) {
                if (Long.parseLong(dpi) < primero.getId()) {
                    //________________izquierdo
                    primero.setLeft(AgregarArbolBinario_(primero.getLeft(), dpi, binario));

                } else if (Long.parseLong(dpi) > primero.getId()) {
                    //________________________derecho_______________________
                    primero.setRight(AgregarArbolBinario_(primero.getRight(), dpi, binario));
                } else {

                    this.bandera = true;
                    primero.setArbol_binario(binario);

                    // System.out.println("true");
                }
                primero = primero.getSiguiente();
            }
            return raiz;
        }
        return raiz;
    }

//__________________________
//Agregar arbol binario
    public void AgregarArboAvl(Pagina raiz, String dpi, Arbol_avl avl) {
        this.raiz = this.AgregarArbolAvl_(raiz, dpi, avl);
    }
//_______________________________________________________________________

    public Pagina AgregarArbolAvl_(Pagina raiz, String dpi, Arbol_avl avl) {

        if (raiz != null) {
            Nodo primero = raiz.primero;
            while (primero != null) {
                if (Long.parseLong(dpi) < primero.getId()) {
                    //________________izquierdo
                    primero.setLeft(AgregarArbolAvl_(primero.getLeft(), dpi, avl));

                } else if (Long.parseLong(dpi) > primero.getId()) {
                    //________________________derecho_______________________
                    primero.setRight(AgregarArbolAvl_(primero.getRight(), dpi, avl));
                } else {

                    this.bandera = true;
                    primero.setArbolAvl(avl);

                    // System.out.println("true");
                }
                primero = primero.getSiguiente();
            }
            return raiz;
        }
        return raiz;
    }

//Album
    public void AgregarAlbum(Pagina raiz, String dpi, Lista_Doble doble) {
        this.raiz = this.AgregarAlbum_(raiz, dpi, doble);
    }
//_______________________________________________________________________

    public Pagina AgregarAlbum_(Pagina raiz, String dpi, Lista_Doble doble) {

        if (raiz != null) {
            Nodo primero = raiz.primero;
            while (primero != null) {
                if (Long.parseLong(dpi) < primero.getId()) {
                    //________________izquierdo
                    primero.setLeft(AgregarAlbum_(primero.getLeft(), dpi, doble));

                } else if (Long.parseLong(dpi) > primero.getId()) {
                    //________________________derecho_______________________
                    primero.setRight(AgregarAlbum_(primero.getRight(), dpi, doble));
                } else {

                    this.bandera = true;
                    primero.setListaD(doble);

                    // System.out.println("true");
                }
                primero = primero.getSiguiente();
            }
            return raiz;
        }
        return raiz;
    }

//Metodo para graficar
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
                        nodo += "<r" + contador + ">|" + primero.getId() + "\\n " + primero.getNombre_cliente() + "\\n" + primero.getPassword() + "|<r" + (contador + 1) + ">";

                        if (primero.getLeft() != null) {
                            cola.encolar("Nodo_" + c_n, primero.getLeft(), contador);

                        }
                        if (primero.getRight() != null) {
                            cola.encolar("Nodo_" + c_n, primero.getRight(), contador + 1);
                        }
                        contador += 2;
                    } else {
                        nodo += "<r" + contador + ">|" + +primero.getId() + "\\n " + primero.getNombre_cliente() + "\\n" + primero.getPassword() + "|";

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
                        nodo += "<r" + contador + ">|" + primero.getId() + "\\n" + primero.getNombre_cliente() + "\\n" + primero.getPassword() + "|<r" + (contador + 1) + ">";

                        if (primero.getLeft() != null) {
                            cola.encolar("Nodo_" + c_n, primero.getLeft(), contador);
                        }
                        if (primero.getRight() != null) {
                            cola.encolar("Nodo_" + c_n, primero.getRight(), contador + 1);
                        }
                        contador += 2;
                    } else {
                        nodo += "<r" + contador + ">|" + +primero.getId() + "\\n " + primero.getNombre_cliente() + "\\n" + primero.getPassword() + "|";
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

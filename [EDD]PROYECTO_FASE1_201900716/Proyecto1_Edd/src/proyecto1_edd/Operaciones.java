/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1_edd;

import java.util.Scanner;

/**
 *
 * @author Kelly
 */
public class Operaciones {

    public void crearLista(int nuListas) {

        for (int i = 1; i <= nuListas; i++) {
            String nombreVentanilla = "ventanilla " + String.valueOf(i);
            PilaImagenes pila = new PilaImagenes();
            Cliente cliente = null;
            CargaMasiva.ventanilla.insertar(pila, nombreVentanilla, cliente);

            //String nombreLista = "ventanilla" + String.valueOf(i);
        }
        System.out.println("\n______________Lista_____________________");
        //CargaMasiva.ventanilla.mostrarLista();
//C:\Users\Kelly\Documents\NetBeansProjects\Proyecto1_Edd\clientes_prueba.json

    }

    public void avanzarVentanilla(int pasos) {

        //System.out.println("pasos" + (pasos + 1));
        NodoVentanilla temp = CargaMasiva.ventanilla.cabeza;

        while (temp != null) {
            if (temp.getPila().PilaVacia() && temp.getCliente() == null) {
                Cliente cliente = (Cliente) CargaMasiva.cola.devolverCliente();
                cliente.setVentanilla(temp.getVentanillas());
//
                cliente.contaPasos();

                // cliente.setPasos(cliente.getPasos() + 1);
                temp.setCliente(cliente);
                Cliente cliente2 = (Cliente) CargaMasiva.cola.devolverCliente();
                //System.out.println("cliente" + cliente2.getNombre_cliente());
                System.out.println("El Cliente " + temp.getCliente().getId_cliente() + ". " + temp.getCliente().getNombre_cliente() + " ingresa a la ventanilla " + temp.getVentanillas());
                CargaMasiva.cola.desencolar();

                break;
            }
            temp = temp.getSiguiente();

        }

    }
//Se ingresan las imagenes a su respectiva pila

    public void ingresarImagPilas(int pasos) {

        NodoVentanilla temp = CargaMasiva.ventanilla.cabeza;

        while (temp != null) {

            if (temp.getCliente() != null) {
                if (temp.getCliente().getImg_color() > 0) {
                    temp.getCliente().setImg_color(temp.getCliente().getImg_color() - 1);
//

                    temp.getCliente().contaPasos();
                    //temp.getCliente().setPasos(temp.getCliente().getPasos() + 1);
                    temp.getPila().push(temp.getCliente().getId_cliente(), temp.getCliente().getNombre_cliente(), 2, 0);
                    System.out.println("La " + temp.getVentanillas() + " Recibio una imagen");
                    //System.out.println("Cliente:" + temp.getCliente().getNombre_cliente() + " imgcolor:" + temp.getCliente().getImg_color());
                    // Menu.pasos += 1;
                } else {
                    if (temp.getCliente().getImg_bw() > 0) {
                        temp.getCliente().contaPasos();

                        temp.getCliente().setImg_bw(temp.getCliente().getImg_bw() - 1);
//
                        //temp.getCliente().setPasos(temp.getCliente().getPasos() + 1);
                        temp.getPila().push(temp.getCliente().getId_cliente(), temp.getCliente().getNombre_cliente(), 0, 1);
                        //System.out.println("Cliente:" + temp.getCliente().getNombre_cliente() + " imgbw:" + temp.getCliente().getImg_bw());
                        System.out.println("La " + temp.getVentanillas() + " Recibio una imagen");
                    }
                }

            }

            temp = temp.getSiguiente();

        }

    }

    public void guardarImg_ColasImpresion() {
        NodoVentanilla temp = CargaMasiva.ventanilla.cabeza;
        //Cliente cliente = null;
        String nombre = nombre_cliente();
        while (temp != null) {
            if (temp.getCliente() != null) {

                if (temp.getCliente().getNombre_cliente().equals(nombre)) {
                    if (temp.getCliente().getImg_color() == 0 && temp.getCliente().getImg_bw() == 0) {
                        //cliente = (Cliente) temp.getPila().retornarImagen(temp.getCliente().getNombre_cliente(),2);
                        //temp.getCliente().setPasos(temp.getCliente().getPasos() + 1);

                        temp.getCliente().contaPasos();
                        temp.getPila().retornarImagen(temp.getCliente().getNombre_cliente());
//
                        ListaEsperaS lista = new ListaEsperaS();
                        //lista.insertar(temp.getCliente());
                        CargaMasiva.listaCicular.insertar(lista, temp.getCliente());
                        System.out.println(lista);
                        CargaMasiva.listaCicular.mostrar();
//
//

//
                        CargaMasiva.impresora_c.mostrar();
                        CargaMasiva.impresora_bw.mostrar();
                        //Menu.pasos += 1;
                        System.err.println(">>>>>>Pila vacia<<<<<");
                        temp.setCliente(null);
                        //CargaMasiva.impresora_c.encolar(cliente.getId_cliente(), cliente.getNombre_cliente(), cliente.getImg_color());

                    }
                }
            }
            temp = temp.getSiguiente();
        }

    }

    public void avanzarpasos(int pasos) {
        NodoVentanilla temp = CargaMasiva.ventanilla.cabeza;
//Enviar las imagenes de la pila a su respectiva impresora
        if (CargaMasiva.listaCicular.listaVacia() == false) {
            sacarClienteLista();
        }
        if (CargaMasiva.impresora_c.colaVacia() == false) {
            enviarClienteSalaEspera();
            //enviarImagenBw();
            System.out.println("Estado actual de la impresora");
            CargaMasiva.listaCicular.mostrar();
            System.out.println("_____________");
            CargaMasiva.impresora_c.mostrar();
        }
        if (CargaMasiva.impresora_bw.colaVacia() == false) {
            System.out.println(":::::::Impresora bw<<<<<<<<<");
            enviarImagenBw();
            CargaMasiva.impresora_bw.mostrar();
        }
        guardarImg_ColasImpresion();
        if (temp.getCliente() != null) {
            // System.out.println("pasos" + pasos);
            ingresarImagPilas(pasos);

        }
        avanzarVentanilla(pasos++);
        Menu.pasos += 1;
        CargaMasiva.ventanilla.mostrarLista();

    }

//Borrar este metodo no se utliza
    public String nombre_cliente() {
        NodoVentanilla temp = CargaMasiva.ventanilla.cabeza;
        String nombre = "";
        while (temp != null) {
            if (temp.getCliente() != null) {

                if (temp.getCliente().getImg_color() == 0 && temp.getCliente().getImg_bw() == 0) {
                    nombre = temp.getCliente().getNombre_cliente();
                    break;
                }
            }
            temp = temp.getSiguiente();

        }

        return nombre;

    }

//
    public void enviarClienteSalaEspera() {

        NodoCircular temp = CargaMasiva.listaCicular.primero;
        Nodo_impresoraC impresoraC = CargaMasiva.impresora_c.frente;
        Cliente cliente;
        while (temp.getSiguiente() != CargaMasiva.listaCicular.primero) {
            cliente = (Cliente) CargaMasiva.impresora_c.devolverCliente();
            if (temp.getCliente().getId_cliente() == cliente.getId_cliente()) {
                if (impresoraC.getImg_color() > 0) {
                    impresoraC.setImg_color(impresoraC.getImg_color() - 1);
//
                    //temp.getCliente().setPasos(temp.getCliente().getPasos() + 1);

                    temp.getCliente().contaPasos();
//
                    if (impresoraC.getImg_color() == 0) {
                        cliente.setTotalImagenes(cliente.getTotalImagenes() + 1);
                        temp.getLista().insertar(cliente);
                        CargaMasiva.impresora_c.desencolar();
                        System.out.println("if1");
                    }
                }
            }
            temp = temp.getSiguiente();
        }
        cliente = (Cliente) CargaMasiva.impresora_c.devolverCliente();
        if (temp.getCliente().getId_cliente() == cliente.getId_cliente()) {
            if (impresoraC.getImg_color() > 0) {
//
                // temp.getCliente().setPasos(temp.getCliente().getPasos() + 1);

                temp.getCliente().contaPasos();
//
                impresoraC.setImg_color(impresoraC.getImg_color() - 1);
                if (impresoraC.getImg_color() == 0) {
                    System.out.println("if12");
                    cliente.setTotalImagenes(cliente.getTotalImagenes() + 1);
                    temp.getLista().insertar(cliente);
                    CargaMasiva.impresora_c.desencolar();

                }
            }
        }

    }
//_________________________________________________________________________________________________

    public void enviarImagenBw() {

        NodoCircular temp = CargaMasiva.listaCicular.primero;
        Nodo_impresoraBw impresoraC = CargaMasiva.impresora_bw.frente;
        Cliente cliente;
        while (temp.getSiguiente() != CargaMasiva.listaCicular.primero) {
            cliente = (Cliente) CargaMasiva.impresora_bw.devolverCliente();
            if (temp.getCliente().getId_cliente() == cliente.getId_cliente()) {
                if (impresoraC.getImg_bw() > 0) {
                    impresoraC.setImg_bw(impresoraC.getImg_bw() - 1);
//
                    //temp.getCliente().setPasos(temp.getCliente().getPasos() + 1);
                    temp.getCliente().contaPasos();
//
                    if (impresoraC.getImg_bw() == 0) {
                        cliente.setTotalImagenes(cliente.getTotalImagenes() + 1);
                        temp.getLista().insertar(cliente);
                        CargaMasiva.impresora_bw.desencolar();
                        System.out.println("if1");
                    }
                }
            }
            temp = temp.getSiguiente();
        }
        cliente = (Cliente) CargaMasiva.impresora_bw.devolverCliente();
        if (temp.getCliente().getId_cliente() == cliente.getId_cliente()) {
            if (impresoraC.getImg_bw() > 0) {
//
                //temp.getCliente().setPasos(temp.getCliente().getPasos() + 1);
                temp.getCliente().contaPasos();
//
                impresoraC.setImg_bw(impresoraC.getImg_bw() - 1);
                if (impresoraC.getImg_bw() == 0) {
                    System.out.println("if12");
                    cliente.setTotalImagenes(cliente.getTotalImagenes() + 1);
                    temp.getLista().insertar(cliente);
                    CargaMasiva.impresora_bw.desencolar();

                }
            }
        }

    }
//_____________________________________________________________

    public void sacarClienteLista() {
        NodoCircular temp = CargaMasiva.listaCicular.primero;
//        while (temp.getSiguiente() != CargaMasiva.listaCicular.primero) {
//            
//        }
        do {
            int suma = 0;
            NodoListaE aux = temp.getLista().cabeza;
            while (aux != null) {
                suma += aux.getCliente().getTotalImagenes();
//                if (temp.getCliente().getTotalImagenes()=) {
//                    
//                }
                aux = aux.getSiguiente();
            }

            if (temp.getCliente().getTotalImagenes() == suma) {
                temp.getCliente().contaPasos();
                //temp.getCliente().setPasos(temp.getCliente().getPasos() + 1);
                System.out.println("------------Ventanilla--------" + temp.getCliente().getVentanilla());
                System.out.println("<<<<<<<<<pasos del cliente------" + temp.getCliente().getPasos());
                System.out.println("Client eliminado" + temp.getCliente().getNombre_cliente());
                CargaMasiva.listaAtendidos.insertar(temp.getCliente());
                CargaMasiva.listaAtendidos.mostraLista();
                CargaMasiva.listaCicular.EliminarCliente(temp.getCliente().getId_cliente());

            }
            temp = temp.getSiguiente();

        } while (temp != CargaMasiva.listaCicular.primero);

//        if (temp.getCliente().getId_cliente() == cliente.getId_cliente()) {
//
//        }
    }

}

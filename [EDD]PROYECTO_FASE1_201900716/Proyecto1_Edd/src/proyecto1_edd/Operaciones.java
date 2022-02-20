/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1_edd;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Kelly
 */
public class Operaciones {

    String clienteAletarios[] = new String[15];

    public void crearLista(int nuListas) {

        for (int i = 1; i <= nuListas; i++) {
            String nombreVentanilla = "ventanilla " + String.valueOf(i);
            PilaImagenes pila = new PilaImagenes();
            Cliente cliente = null;
            CargaMasiva.ventanilla.insertar(pila, nombreVentanilla, cliente);

            //String nombreLista = "ventanilla" + String.valueOf(i);
        }
        //System.out.println("\n______________Lista_____________________");
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
                System.out.println("->El Cliente " + temp.getCliente().getId_cliente() + ". " + temp.getCliente().getNombre_cliente() + " ingresa a la " + temp.getVentanillas());
                CargaMasiva.cola.desencolar();
//metodos para genera un cliente aleatorio
                clientesAleatorios();
                GuardaClieneAleatorio();

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
                    System.out.println("->La " + temp.getVentanillas() + " Recibio una imagen");
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
                        System.out.println("->La " + temp.getVentanillas() + " Recibio una imagen");
                    }
                }

            }

            temp = temp.getSiguiente();

        }

    }

    public void guardarImg_ColasImpresion() {
        NodoVentanilla temp = CargaMasiva.ventanilla.cabeza;
        //Cliente cliente = null;
        int id = identificador_cliente();
        while (temp != null) {
            if (temp.getCliente() != null) {

                if (temp.getCliente().getId_cliente() == id) {
                    if (temp.getCliente().getImg_color() == 0 && temp.getCliente().getImg_bw() == 0) {
                        //cliente = (Cliente) temp.getPila().retornarImagen(temp.getCliente().getNombre_cliente(),2);
                        //temp.getCliente().setPasos(temp.getCliente().getPasos() + 1);

                        temp.getCliente().contaPasos();
                        temp.getPila().retornarImagen(temp.getCliente().getNombre_cliente());
                        System.out.println("->El cliente " + temp.getCliente().getNombre_cliente() + "  esta en la sala de espera.");
                        ListaEsperaS lista = new ListaEsperaS();
                        //lista.insertar(temp.getCliente());
                        CargaMasiva.listaCicular.insertar(lista, temp.getCliente());
                        //System.out.println(lista);
                        //CargaMasiva.listaCicular.mostrar();
//
//

//
                        //CargaMasiva.impresora_c.mostrar();
                        //CargaMasiva.impresora_bw.mostrar();
                        //Menu.pasos += 1;
                        //System.err.println(">>>>>>Pila vacia<<<<<");
                        temp.setCliente(null);
                        //CargaMasiva.impresora_c.encolar(cliente.getId_cliente(), cliente.getNombre_cliente(), cliente.getImg_color());

                    }
                }
            }
            temp = temp.getSiguiente();
        }

    }
//Este metodo sirve para ir controlando los pasos y llamar al resto de los metodos con un orden y validando que la estructura anterior ya se encuentre completa

    public void avanzarpasos(int pasos) {
        NodoVentanilla temp = CargaMasiva.ventanilla.cabeza;
//Enviar las imagenes de la pila a su respectiva impresora
        if (CargaMasiva.listaCicular.listaVacia() == false) {
            sacarClienteLista();
        }
        if (CargaMasiva.impresora_c.colaVacia() == false) {
            enviarClienteSalaEspera();
            //enviarImagenBw();
            //System.out.println("Estado actual de la impresora");
            // CargaMasiva.listaCicular.mostrar();
            //System.out.println("_____________");
            //  CargaMasiva.impresora_c.mostrar();
        }
        if (CargaMasiva.impresora_bw.colaVacia() == false) {
            // System.out.println(":::::::Impresora bw<<<<<<<<<");
            enviarImagenBw();
            //CargaMasiva.impresora_bw.mostrar();
        }
        guardarImg_ColasImpresion();
        if (temp.getCliente() != null) {
            // System.out.println("pasos" + pasos);
            ingresarImagPilas(pasos);

        }
        avanzarVentanilla(pasos++);
        Menu.pasos += 1;
        //CargaMasiva.ventanilla.mostrarLista();
        System.out.println("--------------Estado de la cola de cliente-----------------------");
        //CargaMasiva.cola.mostrar();
        //GuardaClieneAleatorio();

    }

//Borrar este metodo no se utliza
    public int identificador_cliente() {
        NodoVentanilla temp = CargaMasiva.ventanilla.cabeza;
        int id = 0;
        while (temp != null) {
            if (temp.getCliente() != null) {

                if (temp.getCliente().getImg_color() == 0 && temp.getCliente().getImg_bw() == 0) {
                    id = temp.getCliente().getId_cliente();
                    break;
                }
            }
            temp = temp.getSiguiente();

        }

        return id;

    }

//
    public void enviarClienteSalaEspera() {

        NodoCircular temp = CargaMasiva.listaCicular.primero;
        Nodo_impresoraC impresoraC = CargaMasiva.impresora_c.frente;
        Cliente cliente;
        try {

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
                            System.out.println("->Imagen a color entregada al cliente " + cliente.getNombre_cliente());
                            temp.getLista().insertar(cliente);
                            CargaMasiva.impresora_c.desencolar();

                            // System.out.println("if1");
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
                        System.out.println("->Imagen a color entregada al cliente " + cliente.getNombre_cliente());
                        //System.out.println("if12");
                        cliente.setTotalImagenes(cliente.getTotalImagenes() + 1);
                        temp.getLista().insertar(cliente);
                        CargaMasiva.impresora_c.desencolar();

                    }
                }
            }
        } catch (Exception e) {
            System.out.println(" ");
        }
    }
//_________________________________________________________________________________________________

    public void enviarImagenBw() {

        NodoCircular temp = CargaMasiva.listaCicular.primero;
        Nodo_impresoraBw impresoraC = CargaMasiva.impresora_bw.frente;
        Cliente cliente;
        try {

            do {
                cliente = (Cliente) CargaMasiva.impresora_bw.devolverCliente();
                //System.out.println(temp.getCliente().getNombre_cliente());
                //System.out.println("B "+temp.getCliente().getImg_bw2());
                //System.err.println(temp.getCliente().getId_cliente()+"_>"+cliente.getId_cliente());
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
                            System.out.println("->Imagen BW entregada al cliente " + cliente.getNombre_cliente());
                            CargaMasiva.impresora_bw.desencolar();
                            // System.out.println("if1");
                        }
                    }
                }
                temp = temp.getSiguiente();
            } while (temp != CargaMasiva.listaCicular.primero);

        } catch (Exception e) {
            System.err.print("");
        }
//        cliente = (Cliente) CargaMasiva.impresora_bw.devolverCliente();
//        if (temp.getCliente().getId_cliente() == cliente.getId_cliente()) {
//            if (impresoraC.getImg_bw() > 0) {
////
//                //temp.getCliente().setPasos(temp.getCliente().getPasos() + 1);
//                temp.getCliente().contaPasos();
////
//                impresoraC.setImg_bw(impresoraC.getImg_bw() - 1);
//                if (impresoraC.getImg_bw() == 0) {
//                    System.out.println("if12");
//                    cliente.setTotalImagenes(cliente.getTotalImagenes() + 1);
//                    temp.getLista().insertar(cliente);
//                    CargaMasiva.impresora_bw.desencolar();
//                    
//                }
//            }
//        }

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
                //System.out.println("------------Ventanilla--------" + temp.getCliente().getVentanilla());
                //System.out.println("<<<<<<<<<pasos del cliente------" + temp.getCliente().getPasos());
                //System.out.println("Client eliminado: " + temp.getCliente().getNombre_cliente());
                //System.out.println("imagenes de color: " + temp.getCliente().getImg_color2());

                CargaMasiva.listaAtendidos.insertar(temp.getCliente());
//llenar la lista dde top de clientes
                CargaMasiva.listaTop5.ordenarLista(temp.getCliente());
//llena la lista de top cinco blanco y negro
                CargaMasiva.listaTop5_bw.ordenarLista(temp.getCliente());
//llenar lista con los pasos
                CargaMasiva.masPasos.ordenarLista(temp.getCliente());
                System.out.println("->Cliente atendidos " + temp.getCliente().getNombre_cliente() + "<-");
                CargaMasiva.listaCicular.EliminarCliente(temp.getCliente().getId_cliente());

            }
            temp = temp.getSiguiente();

        } while (temp != CargaMasiva.listaCicular.primero);

//        if (temp.getCliente().getId_cliente() == cliente.getId_cliente()) {
//
//        }
    }

//Generar clientes aleatorios
    public void clientesAleatorios() {

        this.clienteAletarios[0] = "Melany";
        this.clienteAletarios[1] = "Antonio";
        this.clienteAletarios[2] = "Oscar";
        this.clienteAletarios[3] = "Antonio";
        this.clienteAletarios[4] = "David";
        this.clienteAletarios[5] = "Pablo";
        this.clienteAletarios[6] = "Rosario";
        this.clienteAletarios[7] = "Armando";
        this.clienteAletarios[8] = "Emely";
        this.clienteAletarios[9] = "Edward";
        this.clienteAletarios[10] = "Celeste";
        this.clienteAletarios[11] = "Rosa";
        this.clienteAletarios[12] = "Roberto";
        this.clienteAletarios[13] = "Esmeralda";
        this.clienteAletarios[14] = "Jorge";

    }

    public void GuardaClieneAleatorio() {
        String apellido[] = {"Perez", "Hernandez", "Juarez", "Lopez", "Garcia", "Alvarez", "Medina", "Suarez", "Reyes", "Flores", "Rosales", "Valle", "Ovalle", "Rojas", "Escobar"};
        // System.out.println("->->->->valor actual del id" + CargaMasiva.ultimoId);
//La variable noBw guarda un numero aleatorio para la cantidad de imagenes en blanco y negro
//La variable noColor guarda un numero aleatorio para la cantidad de imagenes a color
        int numeroCliente = getNumero(0, 3);

        for (int i = 0; i < numeroCliente; i++) {
            aumentarId();
            int noBw = getNumero(0, 4);
            int noColor = getNumero(0, 4);
            int posicion = getNumero(0, 14);

            String nombre = this.clienteAletarios[posicion] + " " + apellido[posicion];

            CargaMasiva.cola.encolar(CargaMasiva.ultimoId, nombre, noColor, noBw);
        }

    }

    public void aumentarId() {
        CargaMasiva.ultimoId += 1;

    }

    public int getNumero(int min, int max) {
        return new Random().nextInt(max - min + 1) + min;

    }
}

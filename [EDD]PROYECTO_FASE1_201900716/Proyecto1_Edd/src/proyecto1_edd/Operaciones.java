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

                temp.setCliente((Cliente) CargaMasiva.cola.devolverCliente());
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
                    temp.getPila().push(temp.getCliente().getId_cliente(), temp.getCliente().getNombre_cliente(), 2, 0);
                    System.out.println("La " + temp.getVentanillas() + " Recibio una imagen");
                    //System.out.println("Cliente:" + temp.getCliente().getNombre_cliente() + " imgcolor:" + temp.getCliente().getImg_color());
                    // Menu.pasos += 1;
                } else {
                    if (temp.getCliente().getImg_bw() > 0) {

                        temp.getCliente().setImg_bw(temp.getCliente().getImg_bw() - 1);
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
                        temp.getPila().retornarImagen(temp.getCliente().getNombre_cliente());
                        CargaMasiva.impresora_c.mostrar();
                        CargaMasiva.impresora_bw.mostrar();
                        //Menu.pasos += 1;
                        System.err.println(">>>>>>Pila vacia<<<<<");
                        temp.setCliente(null);
                        //CargaMasiva.impresora_c.encolar(cliente.getId_cliente(), cliente.getNombre_cliente(), cliente.getImg_color());
//                } else {
//                    if (temp.getCliente().getImg_bw() == 0) {
//                        //cliente = (Cliente) temp.getPila().retornarImagen(temp.getCliente().getNombre_cliente(),1);
//                        temp.getPila().retornarImagen(temp.getCliente().getNombre_cliente(), 1);
//                        //CargaMasiva.impresora_bw.encolar(cliente.getId_cliente(), cliente.getNombre_cliente(), cliente.getImg_color());
//                        CargaMasiva.impresora_bw.mostrar();
//                    }

                    }
                }
            }
            temp = temp.getSiguiente();
        }

    }

    public void avanzarpasos(int pasos) {
        NodoVentanilla temp = CargaMasiva.ventanilla.cabeza;
//Enviar las imagenes de la pila a su respectiva impresora

        guardarImg_ColasImpresion();
        if (temp.getCliente() != null) {
            // System.out.println("pasos" + pasos);
            ingresarImagPilas(pasos);

        }
        avanzarVentanilla(pasos++);
        Menu.pasos += 1;
        CargaMasiva.ventanilla.mostrarLista();

    }

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
}

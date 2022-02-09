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
            String nombreVentanilla = "ventanilla" + String.valueOf(i);
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
        //pasos++;
        System.out.println("pasos" + (pasos + 1));

        //CargaMasiva.ventanilla.insertar(pila2, "ventanilla3");
//CargaMasiva.ventanilla.mostrarLista();
        NodoVentanilla temp = CargaMasiva.ventanilla.cabeza;

        while (temp != null) {
            if (temp.getPila().PilaVacia() && temp.getCliente() == null) {

                temp.setCliente((Cliente) CargaMasiva.cola.devolverCliente());
                Cliente cliente2 = (Cliente) CargaMasiva.cola.devolverCliente();
                System.out.println("cliente" + cliente2.getNombre_cliente());
                CargaMasiva.cola.desencolar();
                Menu.pasos = 0;
                break;
            }
            temp = temp.getSiguiente();

        }

    }

    public void ingresarImagPilas(int pasos) {

        NodoVentanilla temp = CargaMasiva.ventanilla.cabeza;

        while (temp != null) {

            if (temp.getCliente() != null) {
                if (temp.getCliente().getImg_color() > 0) {
                    temp.getCliente().setImg_color(temp.getCliente().getImg_color() - 1);
                    temp.getPila().push(temp.getCliente().getId_cliente(), temp.getCliente().getNombre_cliente(), 1, 0);
                    System.out.println("Cliente:" + temp.getCliente().getNombre_cliente() + " imgcolor:" + temp.getCliente().getImg_color());

                } else {
                    if (temp.getCliente().getImg_bw() > 0) {

                        temp.getCliente().setImg_bw(temp.getCliente().getImg_bw() - 1);
                        temp.getPila().push(temp.getCliente().getId_cliente(), temp.getCliente().getNombre_cliente(), 0, 1);
                        System.out.println("Cliente:" + temp.getCliente().getNombre_cliente() + " imgbw:" + temp.getCliente().getImg_bw());

                    }
                }

            }

            temp = temp.getSiguiente();

        }

    }

    public void avanzarpasos(int pasos) {
        NodoVentanilla temp = CargaMasiva.ventanilla.cabeza;

        if (temp.getCliente() != null) {
            System.out.println("pasos" + pasos);
            ingresarImagPilas(pasos);

        }
        avanzarVentanilla(pasos++);

        CargaMasiva.ventanilla.mostrarLista();

    }
}

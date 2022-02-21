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
public class Menu {

    public static int cont1 = 0;
    public static int cont2 = 0;
    public static int pasos = 1;

    public void menu() {
        Scanner entrada = new Scanner(System.in);

        String opcion = "";

        boolean iniciar = true;

        while (iniciar) {
            System.out.println(this.opciones());
            opcion = entrada.nextLine();

            switch (opcion) {
                case "1":
                    System.out.println("Parametros iniciales\n");
                    parametrosIniciales();
                    this.linea();
//C:\Users\Kelly\Desktop\Proyecto_Edd\[EDD]PROYECTO_FASE1_201900716\Proyecto1_Edd\clientes_prueba.json

                    //a.Carga masiva de clientes
                    //CargaMasiva.abrirArchivo();
                    //b.Cantidad de ventanillas
                    break;
                case "2":
                    //System.out.println("Ejecutar pasosss\n");
                    System.out.println("\n>>>>>>>>>>>>>>>>>>>>>Paso " + this.pasos + "<<<<<<<<<<<<<<<<<<");
                    Operaciones op = new Operaciones();
                    op.avanzarpasos(pasos);

//                    op.pasos(pasos++);
//                    op.ingresarImagPilas();
//                    CargaMasiva.ventanilla.mostrarLista();
                    this.linea();
                    break;
                case "3":
                    System.out.println("Estado en memoria de las estructuras\n");

                    Grafos rep = new Grafos();
                    rep.crearGrafo("Colas.jpg", "cola", rep.generarGrafos());
                    rep.crearGrafo("ventanilla.jpg", "ventanilla", rep.GrafoVentanilla1());
                    rep.crearGrafo("impresoraC.jpg", "impresoraC", rep.generarGrafosImpresoraC());
                    rep.crearGrafo("impresoraBw.jpg", "impresoraBw", rep.generarGrafosImpresoraBw());
                    rep.crearGrafo("clienesAtendidos.jpg", "atendidos", rep.graficoClientesAtendidos());
                    rep.crearGrafo("ClientesEspera.jpg", "ClienteEspera", rep.graficaClitesE());

                    this.linea();
                    break;
                case "4":
                    System.out.println("Reportes\n");
                    this.reportes();
                    this.linea();

                    break;
                case "5":
                    System.out.println(this.acerDe());

                    this.linea();
                    break;
                case "6":

                    System.out.println("salir");
                    iniciar = false;
                    break;
                default:
                    System.out.println("La opcion no exite \n____________");
                    this.opciones();

            }

        }

    }
//mostrar una linea

    public void linea() {
        System.out.println("--------------------------------------");

    }
//Mostrar las opciones del menu

    public String opciones() {
        String opcion = "";
        opcion += ">>>>>>>>>>>>>>Menu<<<<<<<<<<<<<<<<<<<\n";

        opcion += "1.Parametros iniciales\n2.Ejecutar paso\n3.Estado en memoria de las estructuras\n4.Reportes\n5.acerca de\n6.salir";
        opcion += "\nIngrese su opcion:";

        return opcion;
    }
//Mostrar datos del estudiante

    public String acerDe() {

        String datos = "NOMBRE: KELLY MISCHEL HERRERA ESPINO\nCARNET: 201900716\n";

        return datos;
    }
//opciones de parametros inciales

    public void parametrosIniciales() {
        Scanner entrada = new Scanner(System.in);
        System.out.println(">>>>>>Parametros iniciales<<<<<<<\na.Carga masiva de Clientes.\nb-Cantidad de ventanillas\n Ingres su opcion:\n");
        String letra = entrada.nextLine();

        switch (letra) {
            case "a":
                CargaMasiva.leerArchivoJson();
                break;
            case "b":
                //System.out.println("numero de ventanillas"+cantidadVentanillas());
                Operaciones op = new Operaciones();
                op.crearLista(cantidadVentanillas());
                break;
            default:
                throw new AssertionError();
        }

    }
//Menu de reportes

    public void reportes() {
        Grafos gr = new Grafos();
        Scanner entrada = new Scanner(System.in);
        System.out.println(">>>>>>Reportes<<<<<<<\n1.Top 5 de clientes con mayor cantidad de imagenes a color.\n2.Top 5 de clientes con menor cantidad de imanenes BW");
        System.out.println("3.Informacion del cliente que mas pasos tuvo\n4.Buscar ciente. \n5.Clientes atendidos\nIngrese su opcion:");
        String numero = entrada.nextLine();

        switch (numero) {
            case "1":
               
                System.out.println("_________________________");
                CargaMasiva.listaTop5.mostraLista();
                gr.crearGrafo("Top5_color.jpg", "Top5_color", gr.Top5_color());
                break;
            case "2":
                //System.out.println("numero de ventanillas"+cantidadVentanillas());
                System.out.println("______________________________________");
                CargaMasiva.listaTop5_bw.mostraLista();
                gr.crearGrafo("Top5_bw.jpg", "Top5.jpg", gr.Top5_bw());
                break;
            case "3":
                CargaMasiva.masPasos.mostraLista();
                break;
            case "4":
                System.out.println(">>>>>>>Ingrese el numero de id del cliente<<<<<<<<<<<");
                int id = entrada.nextInt();
                CargaMasiva.listaAtendidos.buscarCliente(id);

                break;
            case "5":
                 System.out.println(">>>>>atentdidos<<<<<<<<<<<");
                CargaMasiva.listaAtendidos.mostraLista();
                break;
            default:
                throw new AssertionError();
        }

    }

    //Cantidad de ventanillas   
    public int cantidadVentanillas() {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Ingrese el numero de ventanillas:");
        int numero = entrada.nextInt();

        return numero;

    }
}

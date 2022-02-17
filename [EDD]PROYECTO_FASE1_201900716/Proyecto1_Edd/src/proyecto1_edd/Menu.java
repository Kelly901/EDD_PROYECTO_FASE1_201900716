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

////                    Reportes re = new Reportes();
//                    Cliente c1 = new Cliente(1, "Cliente 1", 5, 3, 7, "ventanilla 1", 5, 2);
//                    Cliente c2 = new Cliente(2, "Cliente 2", 4, 5, 9, "ventanilla 1", 4, 5);
//                    Cliente c3 = new Cliente(3, "Cliente 3", 9, 2, 11, "ventanilla 1", 9, 2);
//                    Cliente c4 = new Cliente(4, "Cliente 4", 2, 4, 6, "ventanilla 1", 2, 4);
//                    Cliente c5 = new Cliente(5, "Cliente 5", 4, 0, 4, "ventanilla 1", 4, 0);
//                    Cliente c6 = new Cliente(6, "Cliente 6", 3, 1, 4, "ventanilla 1", 3, 1);
//                    Cliente c7 = new Cliente(7, "Cliente 7", 1, 2, 3, "ventanilla 1", 1, 2);
//                    Cliente c8 = new Cliente(8, "Cliente 8", 1, 2, 3, "ventanilla 1", 1, 3);
//                    Cliente c9 = new Cliente(9, "Cliente 9", 1, 2, 3, "ventanilla 1", 1, 5);
////                    c1.setPasos(4);
////                    c2.setPasos(5);
////                    c3.setPasos(4);
////                    c4.setPasos(12);
////                    c5.setPasos(3);
////                    c6.setPasos(4);
////                    c7.setPasos(10);
////                    c8.setPasos(12);
////                    c9.setPasos(42);
//Grafos g= new Grafos();
//                    ListaEsperaS lis1 = new ListaEsperaS();
//                    ListaEsperaS lis2 = new ListaEsperaS();
//                    ListaEsperaS lis3 = new ListaEsperaS();
//                    ListaEsperaS lis4 = new ListaEsperaS();
//                    ListaEsperaS lis5 = new ListaEsperaS();
//lis1.insertar(c1);
//lis1.insertar(c2);
//lis1.insertar(c3);
//lis1.insertar(c4);
//lis2.insertar(c1);
//lis2.insertar(c2);
//lis3.insertar(c8);
//                    CargaMasiva.listaCicular.insertar(lis1, c1);
//                    CargaMasiva.listaCicular.insertar(lis2, c2);
//                    CargaMasiva.listaCicular.insertar(lis3, c3);
//                    CargaMasiva.listaCicular.insertar(lis4, c4);
//                    CargaMasiva.listaCicular.insertar(lis5, c5);
//                    g.crearGrafo("ClientesEspera.jpg", "ClienteEspera", g.graficaClitesE());
//                    CargaMasiva.listaAtendidos.insertar(c1);
//                    CargaMasiva.listaAtendidos.insertar(c2);
//                    CargaMasiva.listaAtendidos.insertar(c3);
//                    CargaMasiva.listaAtendidos.insertar(c4);
//                    CargaMasiva.listaAtendidos.insertar(c5);
//                    CargaMasiva.listaAtendidos.insertar(c6);
//                    CargaMasiva.listaAtendidos.insertar(c7);
//                    CargaMasiva.listaAtendidos.insertar(c8);
//                    CargaMasiva.listaAtendidos.insertar(c9);
//                    //re.top5ImaenesColor();
//
//                    ListaTop5Color top = new ListaTop5Color();
//                    top.ordenarLista(c1);
//                    top.ordenarLista(c2);
//                    top.ordenarLista(c3);
//                    top.ordenarLista(c4);
//                    top.ordenarLista(c5);
//                    top.ordenarLista(c6);
//                    top.ordenarLista(c7);
//                    top.ordenarLista(c8);
//                    top.ordenarLista(c9);
//
//                    top.mostraLista();
//
//                    ClienteConMasPasos pa = new ClienteConMasPasos();
//                    pa.ordenarLista(c1);
//                    pa.ordenarLista(c2);
//                    pa.ordenarLista(c3);
//                    pa.ordenarLista(c4);
//                    pa.ordenarLista(c5);
//                    pa.ordenarLista(c6);
//                    pa.ordenarLista(c7);
//                    pa.ordenarLista(c8);
//                    pa.ordenarLista(c9);
//                    pa.mostraLista();
//
//                    Top5Bw to=new Top5Bw();
//to.ordenarLista(c1);
//to.ordenarLista(c2);
//to.ordenarLista(c3);
//to.ordenarLista(c4);
//to.ordenarLista(c5);
//to.ordenarLista(c6);
//to.ordenarLista(c7);
//to.ordenarLista(c8);
//to.ordenarLista(c9);
//
//to.mostraLista();
//
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
        Scanner entrada = new Scanner(System.in);
        System.out.println(">>>>>>Reportes<<<<<<<\n1.Top 5 de clientes con mayor cantidad de imagenes a color.\n2.Top 5 de clientes con menor cantidad de imanenes BW");
        System.out.println("3.Informacion del cliente que mas pasos tuvo\n4.Buscar ciente.\nIngre su opcion:");
        String numero = entrada.nextLine();

        switch (numero) {
            case "1":
                System.out.println("atentdidos");
                CargaMasiva.listaAtendidos.mostraLista();
                System.out.println("_________________________");
                CargaMasiva.listaTop5.mostraLista();
                break;
            case "2":
                //System.out.println("numero de ventanillas"+cantidadVentanillas());
                CargaMasiva.listaTop5_bw.mostraLista();

                break;
            case "3":
                CargaMasiva.masPasos.mostraLista();
                break;
            case "4":
                System.out.println("Ingrese el numero de id del cliente");
                int id = entrada.nextInt();
                CargaMasiva.listaAtendidos.buscarCliente(id);

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

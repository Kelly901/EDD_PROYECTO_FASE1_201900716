/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2_edd;

import Matriz_Dispersa.Matriz;
import arbol_b.Arbol_b;
import com.sun.pisces.PiscesRenderer;
import estructuras.Arbol_B;
import estructuras.Arbol_avl;
import estructuras.Arbol_binario;
import estructuras.Capas;
import estructuras.Cliente;
import estructuras.Pixeles;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import javax.swing.JFileChooser;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Kelly
 */
public class CargaMasiva {

    public static Arbol_b arbol_b = new Arbol_b();
    public static Arbol_binario arbol_binario = new Arbol_binario();
    public static Matriz matriz = new Matriz();

    public static String abrirArchivo() {

        Scanner entrada = new Scanner(System.in);
        System.out.println("ingrese la ruta:");
        String direccion = entrada.nextLine();
        String cadena = "";
        String texto = "";
        try {

//            archivo = new File(direccion);
//            
//            BufferedReader leer = new BufferedReader(new FileReader(archivo));
//File abrir = new File(direccion);
            File archivo = new File(direccion);
            BufferedReader leer = new BufferedReader(new FileReader(archivo));
            while ((cadena = leer.readLine()) != null) {

                texto += cadena + "\n";

            }
            leer.close();

        } catch (Exception e) {
            System.err.println("No se pudo abrir el archivo");
        }
        //  System.out.println(texto);
        return texto;
    }

    public static void leerArchivo_clientes(String texto) {

        System.out.println("______________\n\n");
        // String texto1 = "[\n{\n\"dpi\":\"123\",\n\"nombre_cliente\":\"juan\",\n\"password\":\"1234\"\n},\n{\n\"dpi\":\"1234\",\n\"nombre_cliente\":\"juan2\",\n\"password\":\"12345\"\n}\n]";
        //Se cree un objeto de tipo Json a partir de una caddena de entrada.
        //La cadena se obtuvo de la carga masiva de un archivo.json (abrirArchivo funcion de tipo String que contiene la cadena)
        System.out.println(texto);

        JSONArray array = new JSONArray(texto);
        JSONObject objeto = new JSONObject(array.get(0).toString());
        objeto.get("dpi");
        //  System.out.println("dpi" + objeto.get("dpi"));

        for (int i = 0; i < array.length(); i++) {
            System.out.println("_______________" + i);
            JSONObject objeto2 = new JSONObject(array.get(i).toString());
            objeto2.get("dpi");
            System.out.println("dpi" + objeto2.get("dpi"));
            System.out.println("nombre_cliente" + objeto2.get("nombre_cliente"));
            System.out.println("password" + objeto2.get("password"));

            long dpi = Long.parseLong(objeto2.getString("dpi"));
            arbol_b.insertar(dpi);

        }

        arbol_b.crearGrafo("arbol_b.png", "arbol_b", arbol_b.getCodigos(arbol_b));
//        arbol_b.modificar_clinte("6745567890123", "d", "f");
//        System.out.println("bandera" + arbol_b.bandera);
//arbol_b.crearGrafo("arbol_b.png", "arbol_b", arbol_b.getCodigos(arbol_b));
//        arbol_b.insertar(new Cliente("1234567890123", "name1", "1"));
//        arbol_b.insertar(new Cliente("6745567890123", "name1", "2"));
//        arbol_b.insertar(new Cliente("4567891232436", "name1", "3"));
//        arbol_b.insertar(new Cliente("4567891232431", "name1", "4"));
//        arbol_b.insertar(new Cliente("4567891232432", "name1", "5"));
//        arbol_b.insertar(new Cliente("4557891232433", "name1", "6"));
//        for (int i = 0; i < 10; i++) {
//            arbol_b.insertar(new Cliente(String.valueOf(i), "b", "a"));
//        }
    }

    public static void leerArchivo_capas(String texto) {

        System.out.println("______________\n\n");
        //String texto1 = "[\n{\n\"dpi\":\"123\",\n\"nombre_cliente\":\"juan\",\n\"password\":\"1234\"\n},\n{\n\"dpi\":\"1234\",\n\"nombre_cliente\":\"juan2\",\n\"password\":\"12345\"\n}\n]";
        //Se cree un objeto de tipo Json a partir de una caddena de entrada.
        //La cadena se obtuvo de la carga masiva de un archivo.json (abrirArchivo funcion de tipo String que contiene la cadena)
        // System.out.println(texto);
//paso1: obtener el arreglo generala
        JSONArray array = new JSONArray(texto);

        for (int i = 0; i < array.length(); i++) {
            // System.out.println("_______________" + i);
//Paso 2: obtener los diccionarios
            //System.out.println(array.get(i));
            JSONObject objeto1 = new JSONObject(array.get(i).toString());
            //System.out.println("capa" + objeto1.getInt("id_capa"));
//obtner lo que esta dentro de los dicionarios
//          
//Obtener lo que esta dentro del array de pixeles
            // System.out.println("__pixeles_____");
            JSONArray array_pixeles = new JSONArray(objeto1.getJSONArray("pixeles").toString());
            //  System.out.println(objeto1.getJSONArray("pixeles").toString());
            Pixeles pixeles = new Pixeles();
            for (int k = 0; k < array_pixeles.length(); k++) {

                JSONObject objetoPixeles = new JSONObject(array_pixeles.get(k).toString());
                // System.out.println("    fila: " + objetoPixeles.get("fila"));
                //System.out.println("    columna: " + objetoPixeles.get("columna"));
                //System.out.println("    color: " + objetoPixeles.get("color"));
                pixeles.add(objetoPixeles.getInt("fila"), objetoPixeles.getInt("columna"), objetoPixeles.getString("color"));

            }
            arbol_binario.agregar(new Capas(objeto1.getInt("id_capa"), pixeles));

        }
         arbol_binario.pre_orden();
         matriz.crearGrafo("matriz.jpg");

//        }
    }

//archivo de imagenes
    public static void leerArchivo_imagenes(String texto) {

        System.out.println("______________\n\n");
        //String texto1 = "[\n{\n\"dpi\":\"123\",\n\"nombre_cliente\":\"juan\",\n\"password\":\"1234\"\n},\n{\n\"dpi\":\"1234\",\n\"nombre_cliente\":\"juan2\",\n\"password\":\"12345\"\n}\n]";
        //Se cree un objeto de tipo Json a partir de una caddena de entrada.
        //La cadena se obtuvo de la carga masiva de un archivo.json (abrirArchivo funcion de tipo String que contiene la cadena)
        System.out.println(texto);
//paso1: obtener el arreglo generala
        JSONArray array = new JSONArray(texto);
        // JSONObject objeto = new JSONObject(array.get(0).toString());
        //objeto.get("dpi");
        //  System.out.println("dpi" + objeto.get("dpi"));
        Arbol_avl arbol_avl = new Arbol_avl();
        for (int i = 0; i < array.length(); i++) {
            System.out.println("_______________" + i);
//Paso 2: obtener los diccionarios
            //System.out.println(array.get(i));
            JSONObject objeto1 = new JSONObject(array.get(i).toString());
//obtener id
            System.out.println("id" + objeto1.getInt("id"));

//Obtener lo que esta dentro del array de capas
            System.out.println("__Capas_____");
            JSONArray array_pixeles = new JSONArray(objeto1.getJSONArray("capas").toString());
            System.out.println("    capas:" + array_pixeles.toString());

            // Crera los arboles con sus capas
            Arbol_binario arbol = new Arbol_binario();
//Inicio del for
            for (int j = 0; j < array_pixeles.length(); j++) {
                System.out.println("*" + array_pixeles.getInt(j));
                arbol_binario.buscar_dato(array_pixeles.getInt(j));
                if (arbol_binario.capa != null) {
                    System.out.println("--numero de capa: " + arbol_binario.capa.getId_capa());
                    arbol.agregar(arbol_binario.capa);
                    arbol_binario.capa = null;
                }

            }

//
//Generar la grafica del arbol binario con su capa
            if (arbol.raiz != null) {
                System.out.println("________arbol");
                arbol.crearGrafo("arbol_binarioC"+objeto1.get("id").toString()+".jpg","arbol_binarioC"+String.valueOf(objeto1.getInt("id")) , arbol.getCodigos(arbol.raiz,String.valueOf(objeto1.getInt("id"))), String.valueOf(objeto1.getInt("id")) );
            }

// Insertar los arboles binarios y su id en el arbol avl
            arbol_avl.insertarI(objeto1.getInt("id"), arbol);

        }
// Generar la gráfica cel arbol binario
        arbol_avl.crearGrafo("arbol_avl.jpg", "arbo_avl", arbol_avl.getCodigos(arbol_avl.root));

    }

//aLBUM
    public static void leerArchivo_album(String texto) {

        System.out.println("______________\n\n");
        //String texto1 = "[\n{\n\"dpi\":\"123\",\n\"nombre_cliente\":\"juan\",\n\"password\":\"1234\"\n},\n{\n\"dpi\":\"1234\",\n\"nombre_cliente\":\"juan2\",\n\"password\":\"12345\"\n}\n]";
        //Se cree un objeto de tipo Json a partir de una caddena de entrada.
        //La cadena se obtuvo de la carga masiva de un archivo.json (abrirArchivo funcion de tipo String que contiene la cadena)
        System.out.println(texto);
//paso1: obtener el arreglo generala
        JSONArray array = new JSONArray(texto);
        // JSONObject objeto = new JSONObject(array.get(0).toString());
        //objeto.get("dpi");
        //  System.out.println("dpi" + objeto.get("dpi"));

        for (int i = 0; i < array.length(); i++) {
            System.out.println("_______________" + i);
//Paso 2: obtener los diccionarios
            //System.out.println(array.get(i));
            JSONObject objeto1 = new JSONObject(array.get(i).toString());
//obtener id
            System.out.println("nombre_album" + objeto1.getString("nombre_album"));

//Obtener lo que esta dentro del array de capas
            System.out.println("__imgs_____");
            JSONArray array_pixeles = new JSONArray(objeto1.getJSONArray("imgs").toString());
            System.out.println("   imgs:" + array_pixeles.toString());
            // System.out.println(objeto1.getJSONArray("pixeles").toString());
//            for (int k = 0; k < array_pixeles.length(); k++) {
//
//                JSONObject objetoPixeles = new JSONObject(array_pixeles.get(k).toString());
//                System.out.println("    fila: " + objetoPixeles.get("fila"));
//                System.out.println("    columna: " + objetoPixeles.get("columna"));
//                System.out.println("    color: " + objetoPixeles.get("color"));
//
//            }

        }
    }

}

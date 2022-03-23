 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2_edd;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Kelly
 */
public class CargaMasiva {

    public static String abrirArchivo() {

        Scanner entrada = new Scanner(System.in);
        System.out.println("ingrese la ruta:");
        String direccion = entrada.nextLine();
        String cadena = "";
        String texto = "";
        try {
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
        System.out.println(texto);
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

        }

    }

    public static void leerArchivo_capas(String texto) {

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
            System.out.println(array.get(i));
            JSONObject objeto1 = new JSONObject(array.get(i).toString());
             System.out.println("capa"+objeto1.getInt("id_capa"));
//obtner lo que esta dentro de los dicionarios
//            for (int j = 0; j < objeto1.length(); j++) {
            //System.out.println("id_capa: " + objeto1.get("id_capa").toString());
//Obtener lo que esta dentro del array de pixeles
            System.out.println("__pixeles_____");
            JSONArray array_pixeles = new JSONArray(objeto1.getJSONArray("pixeles").toString());
            //  System.out.println(objeto1.getJSONArray("pixeles").toString());
            for (int k = 0; k < array_pixeles.length(); k++) {

                JSONObject objetoPixeles = new JSONObject(array_pixeles.get(k).toString());
                System.out.println("    fila: " + objetoPixeles.get("fila"));
                System.out.println("    columna: " + objetoPixeles.get("columna"));
                System.out.println("    color: " + objetoPixeles.get("color"));

            }

        }

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

        for (int i = 0; i < array.length(); i++) {
            System.out.println("_______________" + i);
//Paso 2: obtener los diccionarios
            //System.out.println(array.get(i));
            JSONObject objeto1 = new JSONObject(array.get(i).toString());
//obtener id
            System.out.println("id"+objeto1.getInt("id"));

//Obtener lo que esta dentro del array de capas
            System.out.println("__Capas_____");
            JSONArray array_pixeles = new JSONArray(objeto1.getJSONArray("capas").toString());
            System.out.println("    capas:"+array_pixeles.toString());
            // System.out.println(objeto1.getJSONArray("pixeles").toString());
//            for (int k = 0; k < array_pixeles.length(); k++) {
//
//                JSONObject objetoPixeles = new JSONObject(array_pixeles.get(k).toString());
//                System.out.println("    fila: " + objetoPixeles.get("fila"));
//                System.out.println("    columna: " + objetoPixeles.get("columna"));
//                System.out.println("    color: " + objetoPixeles.get("color"));
//


        }

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
            System.out.println("nombre_album"+objeto1.getString("nombre_album"));

//Obtener lo que esta dentro del array de capas
            System.out.println("__imgs_____");
            JSONArray array_pixeles = new JSONArray(objeto1.getJSONArray("imgs").toString());
            System.out.println("   imgs:"+array_pixeles.toString());
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

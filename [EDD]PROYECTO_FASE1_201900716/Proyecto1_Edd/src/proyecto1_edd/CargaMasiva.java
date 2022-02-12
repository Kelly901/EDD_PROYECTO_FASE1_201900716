/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1_edd;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
import org.json.JSONObject;

/**
 *
 * @author Kelly
 */
public class CargaMasiva {
 public static Cola_clientes cola = new Cola_clientes();
 public static ListaVentanillas ventanilla = new ListaVentanillas();
public static ColaImpresora_bw impresora_bw= new ColaImpresora_bw();
public static ColaImpresora_c impresora_c= new ColaImpresora_c();
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

    public static void leerArchivoJson() {
       

        System.out.println("______________\n\n");
        //Se cree un objeto de tipo Json a partir de una caddena de entrada.
        //La cadena se obtuvo de la carga masiva de un archivo.json (abrirArchivo funcion de tipo String que contiene la cadena)
        JSONObject myJSON2 = new JSONObject(abrirArchivo());
        System.out.println(myJSON2.keys());
        for (int i = myJSON2.length() - 1; i >= 0; i--) {

            //Se obtiene el nombre de la key del primer diccionario
            String c2 = myJSON2.names().get(i).toString();
            System.out.println("id_cliente:->" + myJSON2.getJSONObject(c2).get("id_cliente"));

            System.out.println("nombre_cliente:->" + myJSON2.getJSONObject(c2).get("nombre_cliente"));
            System.out.println("img_color:->" + myJSON2.getJSONObject(c2).get("img_color"));

            System.out.println("img_bw:->" + myJSON2.getJSONObject(c2).get("img_bw"));
            cola.encolar(Integer.parseInt(myJSON2.getJSONObject(c2).get("id_cliente").toString()), myJSON2.getJSONObject(c2).get("nombre_cliente").toString(), Integer.parseInt(myJSON2.getJSONObject(c2).get("img_color").toString()), Integer.parseInt(myJSON2.getJSONObject(c2).get("img_bw").toString()));
            System.out.println("_______________");
            //con el segundo for se recorre para obtener los datos dentro de los subdiccionarios

        }
        cola.mostrar();
       // System.out.println("-------\n Desencolar:" + cola.desencolar() + "\n________________\ncola");
        cola.mostrar();

        //System.out.println(cadena2);
    }

}

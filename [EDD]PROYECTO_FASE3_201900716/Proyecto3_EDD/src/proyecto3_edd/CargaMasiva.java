/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto3_edd;

import Estructuras.Clientes;
import Estructuras.Grafo;
import Estructuras.Lista;
import Estructuras.Lista2;
import Estructuras.ListaAdyacente;
import Estructuras.Lista_Lugares;
import Graficas.Grafica;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
import netscape.javascript.JSObject;
import org.json.JSONArray;
import org.json.JSONObject;
import org.mindrot.bcrypt.BCrypt;

/**
 *
 * @author herre
 */
public class CargaMasiva {

    public static Lista lista = new Lista();
    public static Estructuras.TablaHash th = new Estructuras.TablaHash(37);
    public static Lista2 lista2 = new Lista2();
    public static ListaAdyacente lA = new ListaAdyacente();
    public static Lista_Lugares lista_lugares = new Lista_Lugares();

    public static int idCliente = 0;

    public static String AbrirArchivo(File file, String ruta) {

        Scanner entrada = new Scanner(System.in);

        System.out.println("Ingrese la ruta");
        String direccion = ruta;

        String cadena = "";
        String texto = "";

        try {
            File abrir = new File(direccion);
            BufferedReader leerArchivo = new BufferedReader(new FileReader(abrir));

            while ((cadena = leerArchivo.readLine()) != null) {

                texto += cadena + "\n";

            }

            leerArchivo.close();
        } catch (Exception e) {

            System.err.println("No se pudo abrir el archivo");
        }

        return texto;

    }

    public static void leerArchivo_clientes(String texto) {

        System.out.println("___________________________");
        //Obtener los clientes del Array
        JSONArray array = new JSONArray(texto);
        System.out.println(array);

        for (int i = 0; i < array.length(); i++) {
            // System.out.println(array.get(i));
            // System.out.println("_____________________________________");
            JSONObject ob = new JSONObject(array.get(i).toString());
//            System.out.println("dpi: "+ob.get("dpi"));
//            System.out.println("nombres: "+ob.get("nombre_completo"));
//            System.out.println("usuario: "+ob.get("nombre_usuario"));
//            System.out.println("correo: "+ob.get("correo"));
//            System.out.println("contrase??a: "+ob.get("contrasenia"));
//            System.out.println("telefono: "+ob.get("telefono"));
//            System.out.println("direccion: "+ob.get("direccion"));
//            System.out.println("id_municipio: "+ob.get("id_municipio"));

            boolean ban = lista.clienteExistente(ob.get("nombre_usuario").toString());

            if (ban) {
                System.out.println("El cliente ya existe");
            } else {

                String hashed = BCrypt.hashpw(ob.get("contrasenia").toString(), BCrypt.gensalt());
                lista.add(new Clientes(ob.get("dpi").toString(), ob.get("nombre_completo").toString(), ob.get("nombre_usuario").toString(), ob.get("correo").toString(), hashed, ob.get("telefono").toString(), ob.get("direccion").toString(), ob.get("id_municipio").toString()));
            }

        }

        Grafica graf = new Grafica();
        graf.crearGrafo("Clientes" + String.valueOf(idCliente) + ".jpg", "Clientes", graf.clientes());
        System.out.println("________________________");
        //lista.mostrar();

    }

    public static void leerArchivo_mensajeros(String texto) {

        // System.out.println("___________________________");
        //Obtener los clientes del Array
        JSONArray array = new JSONArray(texto);
        System.out.println(array);
        //ob= sera el objeto que contiene los datos del cliente
        for (int i = 0; i < array.length(); i++) {
            // System.out.println(array.get(i));
            // System.out.println("_____________________________________");
            JSONObject ob = new JSONObject(array.get(i).toString());
//            System.out.println("dpi: "+ob.get("dpi"));
//            System.out.println("nombres: "+ob.get("nombres"));
//            System.out.println("apellidos: "+ob.get("apellidos"));
//            System.out.println("tipo_licencia "+ob.get("tipo_licencia"));
//            System.out.println("genero: "+ob.get("genero"));
//            System.out.println("direccion: "+ob.get("direccion"));

            th.insertarHash(Long.parseLong(ob.get("dpi").toString()),ob.get("nombres").toString(),ob.get("apellidos").toString(),ob.get("tipo_licencia").toString(),ob.get("genero").toString(),ob.get("direccion").toString());
            //  System.out.println(th.factor_carga);

        }
        System.out.println("_________mostrar__________________");
        th.imprimir();
        //th.mostrar();
        System.out.println("factor de carga: " + th.factor_carga);
        System.out.println("tama??o " + th.tamanio);
        Grafica graf = new Grafica();
        graf.crearGrafo("tabla.jpg", "tabla", graf.tabla());
        graf.crearGrafo("tabla1.jpg", "tabla1", graf.TablaHash());
        //System.out.println(graf.tabla());
    }

    public static void leerArchivo_lugares(String texto) {

        System.out.println("___________________________");
        //Obtener los clientes del Array

        JSONObject ob = new JSONObject(texto);

        System.out.println(ob.get("Lugares"));

        JSONArray array = new JSONArray(ob.get("Lugares").toString());

        for (int i = 0; i < array.length(); i++) {

            JSONObject ob2 = new JSONObject(array.get(i).toString());
            System.out.println("id: " + ob2.get("id"));
            System.out.println("departamento: " + ob2.get("departamento"));
            System.out.println("nombre: " + ob2.get("nombre"));
            System.out.println("sn_sucursal: " + ob2.get("sn_sucursal"));
            lista_lugares.add(Integer.parseInt(ob2.get("id").toString()), ob2.get("departamento").toString(), ob2.get("nombre").toString(), ob2.get("sn_sucursal").toString());

        }
        
        Grafica graf= new Grafica();
        graf.crearGrafo("Lugares.jpg", "Lugares", graf.Lugares());
    }

    public static void leerArchivo_Grafo(String texto) {

        System.out.println("___________________________");
        //Obtener los clientes del Array

        JSONObject ob = new JSONObject(texto);

        System.out.println(ob.get("Grafo"));

        JSONArray array = new JSONArray(ob.get("Grafo").toString());
        for (int i = 0; i < array.length(); i++) {

            JSONObject ob2 = new JSONObject(array.get(i).toString());
            System.out.println("inicio: " + ob2.get("inicio"));
            System.out.println("final: " + ob2.get("final"));
            System.out.println("peso: " + ob2.get("peso"));
            lista2.insertar(new Grafo(Integer.parseInt(ob2.get("inicio").toString()), Integer.parseInt(ob2.get("final").toString()), Integer.parseInt(ob2.get("peso").toString())));

        }

        if (lista2.size() != 0) {
            lA.reccorer(lista2);
            lA.mostrar();
        } else {
            System.out.println("vacia");
        }

        Grafica gra = new Grafica();
        gra.crearGrafo("grafo.jpg", "grafo", gra.grafica1());
        gra.crearGrafo("listaAd.jpg", "listaAd", gra.ListaAdyacente());

    }

}

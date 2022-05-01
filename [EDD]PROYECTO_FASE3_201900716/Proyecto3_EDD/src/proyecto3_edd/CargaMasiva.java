/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto3_edd;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
import netscape.javascript.JSObject;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author herre
 */
public class CargaMasiva {
    
    
    public static String AbrirArchivo(){
        
        
        Scanner entrada= new Scanner(System.in);
        
        System.out.println("Ingrese la ruta");
        String direccion=entrada.nextLine();
        
        String cadena="";
        String texto="";
        
        try {
           File abrir = new File(direccion);
            BufferedReader leerArchivo= new BufferedReader(new FileReader(abrir));
        
            while ((cadena=leerArchivo.readLine())!=null) {

                texto+=cadena+"\n";
                
                
            }
            
            leerArchivo.close();
        } catch (Exception e) {
            
            System.err.println("No se pudo abrir el archivo");
        }
        
        
        return texto;
  
    }
    
    public static void leerArchivo_clientes(String texto){
        
        System.out.println("___________________________");
        //Obtener los clientes del Array
        JSONArray array= new JSONArray(texto);
        System.out.println(array);
        
        for (int i = 0; i < array.length(); i++) {
           // System.out.println(array.get(i));
            System.out.println("_____________________________________");
            JSONObject ob= new JSONObject(array.get(i).toString());
            System.out.println("dpi: "+ob.get("dpi"));
            System.out.println("nombres: "+ob.get("nombre_completo"));
            System.out.println("usuario: "+ob.get("nombre_usuario"));
            System.out.println("correo: "+ob.get("correo"));
            System.out.println("contraseña: "+ob.get("contrasenia"));
            System.out.println("telefono: "+ob.get("telefono"));
            System.out.println("direccion: "+ob.get("direccion"));
            System.out.println("id_municipio: "+ob.get("id_municipio"));
        }
        
        //recorrer el array
        
    }
    
    public static void leerArchivo_mensajeros(String texto){
        
        System.out.println("___________________________");
        //Obtener los clientes del Array
        JSONArray array= new JSONArray(texto);
        System.out.println(array);
        //ob= sera el objeto que contiene los datos del cliente
        for (int i = 0; i < array.length(); i++) {
           // System.out.println(array.get(i));
            System.out.println("_____________________________________");
            JSONObject ob= new JSONObject(array.get(i).toString());
            System.out.println("dpi: "+ob.get("dpi"));
            System.out.println("nombres: "+ob.get("nombres"));
            System.out.println("apellidos: "+ob.get("apellidos"));
            System.out.println("tipo_licencia "+ob.get("tipo_licencia"));
            System.out.println("genero: "+ob.get("genero"));
            System.out.println("direccion: "+ob.get("direccion"));
      
        }
   
    }
    
        public static void leerArchivo_lugares(String texto){
        
        System.out.println("___________________________");
        //Obtener los clientes del Array
       
        JSONObject ob= new JSONObject(texto);
        
        System.out.println(ob.get("Lugares"));
        
         JSONArray array= new JSONArray(ob.get("Lugares").toString());
         
            for (int i = 0; i < array.length(); i++) {
                
                JSONObject ob2= new JSONObject(array.get(i).toString());
                   System.out.println("id: "+ob2.get("id"));
                   System.out.println("departamento: "+ob2.get("departamento"));
                   System.out.println("nombre: "+ob2.get("nombre"));
                   System.out.println("sn_sucursal: "+ob2.get("sn_sucursal"));

            }
      
   
    }
        
              public static void leerArchivo_Grafo(String texto){
        
        System.out.println("___________________________");
        //Obtener los clientes del Array
       
        JSONObject ob= new JSONObject(texto);
        
        System.out.println(ob.get("Grafo"));
        
         JSONArray array= new JSONArray(ob.get("Grafo").toString());
         
            for (int i = 0; i < array.length(); i++) {
                
                JSONObject ob2= new JSONObject(array.get(i).toString());
                   System.out.println("inicio: "+ob2.get("inicio"));
                   System.out.println("final: "+ob2.get("final"));
                   System.out.println("peso: "+ob2.get("peso"));
   

            }
      
   
    }
        
        
}

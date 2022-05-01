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
            System.out.println("nombres: "+ob.get("nombres"));
            System.out.println("usuario: "+ob.get("usuario"));
            System.out.println("correo: "+ob.get("correo"));
            System.out.println("telefono: "+ob.get("telefono"));
            System.out.println("direccion: "+ob.get("direccion"));
            System.out.println("id_municipio: "+ob.get("id_Municipio"));
        }
        
        //recorrer el array
        
//        for (int i = 0; i < array.length(); i++) {
//            System.out.println("_____________");
//            
//            JSONObject cliente = new JSONObject(array.get(i));
//            
//            System.out.println("dpi "+cliente.get("dpi"));
//            System.out.println("Nombre "+cliente.get("nombres"));
//            System.out.println("Usuario: "+cliente.get("usuario"));
//            System.out.println("correo "+cliente.get("correo"));
//            System.out.println("contraseña: "+cliente.get("contraseña"));
//            System.out.println("telefono: "+cliente.get("telefono"));
//            System.out.println("direccion: "+cliente.get("direccion"));
//            System.out.println("id_municipio: "+cliente.get("id_Municipio"));
//            
//        }
        
    }
}

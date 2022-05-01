package Estructuras;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author herre
 */
public class Mensajero {
    
    private String dpi;
    private String nombre;
    private String apellido;
    private String tipo_licencia;
    private String genero;
    private String direccion;
    
      public Mensajero(String dpi, String nombre, String apellido, String tipo_licencia, String genero, String direccion) {
        this.dpi = dpi;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipo_licencia = tipo_licencia;
        this.genero = genero;
        this.direccion = direccion;
    }

    public String getDpi() {
        return dpi;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getTipo_licencia() {
        return tipo_licencia;
    }

    public String getGenero() {
        return genero;
    }

    public String getDireccion() {
        return direccion;
    }

  
    
}

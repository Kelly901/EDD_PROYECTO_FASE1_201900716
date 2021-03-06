/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *
 * @author herre
 */
public class NodoLugar {
    
    
    private int id;
    private String departamento;
    private String nombre;
    private String sn_sucursal;
    private NodoLugar siguiente;

    public NodoLugar(int id, String departamento, String nombre, String sn_sucursal) {
        this.id = id;
        this.departamento = departamento;
        this.nombre = nombre;
        this.sn_sucursal = sn_sucursal;
        this.siguiente=null;
    }

    public NodoLugar getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoLugar siguiente) {
        this.siguiente = siguiente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSn_sucursal() {
        return sn_sucursal;
    }

    public void setSn_sucursal(String sn_sucursal) {
        this.sn_sucursal = sn_sucursal;
    }
    
   
    
}

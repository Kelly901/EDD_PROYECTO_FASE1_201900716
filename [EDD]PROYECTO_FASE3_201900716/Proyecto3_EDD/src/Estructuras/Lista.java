/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

import org.mindrot.bcrypt.BCrypt;

/**
 *
 * @author herre
 */
public class Lista {
    
    public Nodo_lista primero;
    public int tamanio;
    
    public Lista() {
        this.primero = null;
    }
    
    public void add(Clientes cliente) {
        
        Nodo_lista nuevo = new Nodo_lista(cliente);
        tamanio++;
        
        if (this.primero == null) {
            
            this.primero = nuevo;
            
        } else {
            Nodo_lista aux = this.primero;
            
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nuevo);
        }
    }
    
    public boolean getCliente(String password, String usuario) {
        
        Nodo_lista aux = this.primero;
        while (aux != null) {
            
            if (BCrypt.checkpw(password, aux.getCliente().getPassword()) && usuario.equals(aux.getCliente().getUsuario())) {
                System.out.println("It matches");
                
                return true;
                
            }
//            if (aux.getCliente().getUsuario().equals(usuario) && aux.getCliente().getPassword().equals(password)) {
            //   System.out.println("bienvenido usuario");

            // return aux.getCliente().getNombre();
            // }
            aux = aux.getSiguiente();
        }
        System.err.println("It does not match");
        
        return false;
        
    }
    
    public boolean clienteExistente(String usuario) {
        
        Nodo_lista aux = this.primero;
        
        while (aux != null) {
            //System.out.println("comaparar");
            // System.out.println("a"=="a");
            //System.out.println("entrante "+usuario.toString()+"  actual"+aux.getCliente().getUsuario()+"  "+(usuario.toString()==aux.getCliente().getUsuario()));
            if (aux.getCliente().getUsuario().equals(usuario)) {
                System.err.println("el usuario ya exisate");
                return true;
            }
            
            aux = aux.getSiguiente();
        }
        
        return false;
        
    }

    //
    public void modificarCliente(String dpi, String nombre, String usuario, String contraseña, String dirreccion, String correo, String id_mu, String telefono) {
        
        Nodo_lista aux = this.primero;
        
        while (aux != null) {
            
            if (dpi.equals(aux.getCliente().getDpi())) {
                if (nombre == "") {
                    System.out.println("vacio");
                } else {
                    aux.getCliente().setNombre(nombre);
                }
                
                if (usuario == "") {
                    System.out.println("vacio");
                } else {
                    aux.getCliente().setUsuario(usuario);
                    
                }
                
                if (dirreccion == "") {
                    System.out.println("vacio");
                } else {
                    aux.getCliente().setDirección(dirreccion);
                    
                }
                
                if (correo == "") {
                    System.out.println("vacio");
                } else {
                    aux.getCliente().setCorreo(correo);
                    
                }
                
                if (contraseña == "") {
                    System.out.println("vacio");
                } else {
                    aux.getCliente().setPassword(contraseña);
                    
                }
                
                if (telefono == "") {
                    System.out.println("vacio");
                } else {
                    aux.getCliente().setTelefono(telefono);
                    
                }
                
                if (id_mu == "") {
                    System.out.println("vacio");
                } else {
                    aux.getCliente().setId_municipio(id_mu);
                    
                }
            }
            
            aux = aux.getSiguiente();
        }
        
    }

    //
    public void mostrar() {
        Nodo_lista aux = this.primero;
        
        while (aux != null) {
            System.out.println("________________________________________");
            System.out.println("dpi: " + aux.getCliente().getDpi());
            System.out.println("nombres: " + aux.getCliente().getNombre());
            System.out.println("usuario: " + aux.getCliente().getUsuario());
            System.out.println("correo: " + aux.getCliente().getCorreo());
            System.out.println("contraseña: " + aux.getCliente().getPassword());
            System.out.println("telefono: " + aux.getCliente().getTelefono());
            System.out.println("direccion: " + aux.getCliente().getDirección());
            System.out.println("id_municipio: " + aux.getCliente().getId_municipio());
            aux = aux.getSiguiente();
        }
    }
    
    public int size() {
        
        return this.tamanio;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto3_edd;

import Estructuras.Datos;

/**
 *
 * @author herre
 */
public class TablaHash {
     int tamanio;
    Estructuras.NodoHash primero;
    double factor_carga;
    int id;
    Datos dpis[];

    public TablaHash(int tamanio) {
        this.tamanio = tamanio;
        this.primero = null;
        this.factor_carga = 0.0;
        this.id = 0;
        this.dpis = new Datos[tamanio];

        for (int i = 0; i < this.dpis.length; i++) {
            this.dpis[i] = new Datos(-1, 0);
        }

    }

    public void insertarHash(long dpi) {
        //factor de carga
        this.factor_carga = (this.id / this.tamanio) * 100;
        System.out.println("factor " + factor_carga);

        if (this.factor_carga < 75 && this.factor_carga >= 0) {

            int key = 0;
            boolean bandera = false;

            for (int i = 0; i < this.dpis.length; i++) {
                //  System.out.println(this.dpis[i].getDpi());
                if (this.dpis[i].getDpi() == dpi) {

                    key = this.dpis[i].getLlave();
                    bandera = true;
                    break;
                }

            }

            if (bandera == false) {
                key = (int) (dpi % this.tamanio);
                System.out.println("key1 " + key);
            }

            if (busqueda_llave(key) && bandera == true) {
                System.out.println("key2: "+key);
                Estructuras.NodoHash aux = this.busqueda(key);
                  

            }else{
                System.out.println("______entro a_______");
                 this.insertar(dpi, key);
            } 
        } else {
            this.tamanio += 2;
            this.insertarHash(dpi);
        }

    }

    public Estructuras.NodoHash busqueda(int key) {

        Estructuras.NodoHash aux = this.primero;

        while (aux != null) {

            if (key == aux.getLlave()) {
                return aux;
            }
            aux = aux.getSiguiente();

        }
        System.out.println("__________sf");

        return null;
    }

    // insertar
    public void insertar(long dpi, int key) {
                System.out.println("______Insertar_______");

        Estructuras.NodoHash nuevo = new Estructuras.NodoHash(dpi, key);

        if (this.primero == null) {

            this.id += 1;
            this.primero = nuevo;
            System.out.println("__________A1");
            this.agregar_arreglo(nuevo.getDpi(), nuevo.getLlave());
            System.out.println("_______________________________________-fin");
            return;
           
        }
        //colisione
        System.out.println("_______coliciones");
        if (this.busqueda_llave(key)) {
            int i = 0;
            int pos = this.cuadratica(nuevo, i);
            this.insertar(dpi, pos);
        } else {
            
            Estructuras.NodoHash temp = this.primero;

            if (nuevo.getLlave() < temp.getLlave()) {
                nuevo.setSiguiente(temp);
                this.primero = nuevo;
                this.id += 1;

                this.agregar_arreglo(nuevo.getDpi(), nuevo.getLlave());

            } else {
                while (temp.getSiguiente() != null) {
                    Estructuras.NodoHash temp2 = temp.getSiguiente();

                    if (nuevo.getLlave() < temp2.getLlave()) {
                        temp.setSiguiente(nuevo);
                        nuevo.setSiguiente(temp2);
                        this.id += 1;
                        
                        this.agregar_arreglo(nuevo.getDpi(), nuevo.getLlave());
                        break;

                    }
                    temp = temp.getSiguiente();
                }
                if (temp.getSiguiente() == null) {
                    temp.setSiguiente(nuevo);
                    this.id += 1;
                    this.agregar_arreglo(nuevo.getDpi(), nuevo.getLlave());
                }
            }
        }

    }

    public boolean busqueda_llave(int llave) {

        Estructuras.NodoHash aux = this.primero;

        while (aux != null) {
            if (llave == aux.getLlave()) {
                return true;
            }
        }

        return false;
    }

    public void agregar_arreglo(long dpi, int llave) {

        for (int i = 0; i < this.dpis.length; i++) {

            if (dpis[i] == null) {

                dpis[i].setDpi(dpi);
                dpis[i].setLlave(llave);
                break;
            }

        }
    }

    public int cuadratica(Estructuras.NodoHash temp, int i) {

        int pos = ((temp.getLlave() % 7) + 1) * i;
        System.out.println("pos " + pos);

        if (this.busqueda_llave(pos)) {
            i = i + 1;

            return this.cuadratica(temp, i);

        }
        return pos;
    }

    public void mostrar() {

        Estructuras.NodoHash aux = this.primero;
        
        while (aux != null) {
            System.out.println("dpi: " + aux.getDpi());
            aux = aux.getSiguiente();
        }
    }
    
    public void mostar1(){
        System.out.println("_____mostrar___________");
        for (int i = 0; i < this.dpis.length; i++) {
            
            System.out.println(this.dpis[i].getDpi());
        }
    }
}

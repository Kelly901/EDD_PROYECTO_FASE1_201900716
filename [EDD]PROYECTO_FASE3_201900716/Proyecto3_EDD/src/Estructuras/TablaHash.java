/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

import java.util.ArrayList;

/**
 *
 * @author herre
 */
public class TablaHash {

    public int tamanio;
    //  NodoHash primero;
    public double factor_carga;
    int n; //Cantidad de elemento insertados
    int primos[] = {41, 43, 47, 52, 59, 61, 67, 71, 73, 79, 83, 89, 97};
    int cont;
    int numElementos;
    public Datos tabla[];
    // NodoHash dpis[];

    public TablaHash(int tamanio) {
        this.tamanio = tamanio;
        //this.primero = null;
        this.factor_carga = 0.0;
        this.n = 0;
        this.cont = 0;
        this.numElementos = 0;
        this.tabla = new Datos[tamanio];
        //this.dpis = new NodoHash[tamanio];

    }

    public void insertarHash(long dpi) {

        boolean bander = false;

        if (factor_carga < 74.0 && factor_carga >= 0) {
            System.out.println(factor_carga < 75.0 && factor_carga >= 0);

            for (int i = 0; i < this.tamanio; i++) {
                int llave = obtenerLlave(dpi);
                int posicion = funcion_doble_dispersion(llave, i);

                if (posicion > tamanio) {
                    posicion -= tamanio;
                }
                //System.out.println("posicion___ "+posicion);
                if (tabla[posicion] == null) {
                    tabla[posicion] = new Datos(dpi, posicion);
                    this.n += 1;
                    factor_carga = getFactorCarga();
                    // System.out.println("n+ "+this.n);
                    bander = true;
                    break;

                } else {
                    if (tabla[posicion].getDpi() == dpi) {
                        System.out.println("ya existe");
                    } else {
                        System.out.println("colicion en la pos " + posicion);
                    }
                }

            }
            if (bander == true) {
                System.out.println("valor insertado");
            }

        } else {

            //rizising  
            Resizing();
            insertarHash(dpi);
        }

//        
        //System.out.println("hash overflow");

//         
//      
    }

    public void Resizing() {
        //Crear un arreglo temporal

        Datos auxiliar[] = tabla.clone();
        int tamanio_temp = this.tamanio;
        // System.out.println("____tamaño  _"+tamanio);
        this.tamanio = numeroPrimo(tamanio_temp + 2);
        this.tabla = new Datos[this.tamanio];
        this.n = 0;
        factor_carga = getFactorCarga();
        for (int i = 0; i < tamanio_temp; i++) {
            if (auxiliar[i] != null) {
                insertarHash(auxiliar[i].getDpi());
                // this.tabla[i]=auxiliar[i];
            }
        }
    }

    public void imprimir() {
        System.out.println("__________________-imprimir_______________");
        for (int i = 0; i < tabla.length; i++) {
            if (tabla[i]!=null) {
                            System.out.println("llave " + tabla[i].getLlave() + " dpi: " + tabla[i].getDpi());

            }else{
                               System.out.println("llave " + i + " dpi: null" );
 
            }

        }

        //System.out.println("333333333333333333333");
    
}

public int obtenerLlave(long dpi) {

        return (int) (dpi % this.tamanio);
    }

    public double getFactorCarga() {
        double n1=(double)this.n;
        double n2=(double)this.tamanio;
        double val=(n1/n2)*100;
        System.out.println("________________"+(this.n)+"_____________"+this.tamanio+"__________"+val);
        return val;

    }

    public int funcion_division(int llv) {

        return llv % tamanio;
    }

    public int funcion_doble_dispersion(int llv, int i) {

        return (llv % 7 + 1) * i;
    }


    public boolean busquedaLlave(int llave) {

        for (int i = 0; i < tabla.length; i++) {
            if (tabla[i] != null) {
                if (tabla[i].getLlave() == llave) {
                    return true;
                }
            }

        }
        return false;
    }


    public int cuadratica(int key, int i) {

        int pos = ((key % 7) + 1) * i;
        System.out.println("pos " + pos);

        if (this.busquedaLlave(pos)) {
            i += 1;

            return this.cuadratica(key, i);

        }
        return pos;
    }


    public int numeroPrimo(int num) {

        int n = num;

        for (int j = 2; j < num / 2; j++) {
//                System.out.println(num % j);
            if (num % j == 0) {
                //System.out.println("true");
                return numeroPrimo(num + 2);
            }

        }

        //  System.out.println("num: "+num);
        return num;

    }

}

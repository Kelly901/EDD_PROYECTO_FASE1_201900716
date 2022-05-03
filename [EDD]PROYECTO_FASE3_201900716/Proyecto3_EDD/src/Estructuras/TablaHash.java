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

   public  int tamanio;
    NodoHash primero;
  public  double factor_carga;
    int id;
   // NodoHash dpis[];

    public TablaHash(int tamanio) {
        this.tamanio = tamanio;
        this.primero = null;
        this.factor_carga = 0.0;
        this.id = 0;
        //this.dpis = new NodoHash[tamanio];

       

    }

    public void insertarHash(long dpi) {
        //factor de carga
        this.factor_carga = (this.id / this.tamanio) * 100;
        

        if (this.factor_carga < 75 && this.factor_carga >= 0) {

             int key=(int) (dpi% this.tamanio);
             this.insertar(dpi, key);
        }else{
            
          //  System.out.println("tamaño+ "+tamanio);
            this.tamanio=numeroPrimo(tamanio+2);
        }
       // System.out.println("facto");
    }

    public NodoHash busqueda(int key) {

        NodoHash aux = this.primero;

        while (aux != null) {

            if (key == aux.getLlave()) {
                return aux;
            }
            aux = aux.getSiguiente();

        }
      //  System.out.println("__________sf");

        return null;
    }

    // insertar
    public void insertar(long dpi, int key) {
                //System.out.println("______Insertar_______");

        NodoHash nuevo = new NodoHash(dpi, key);

        if (this.primero == null) {

            this.id += 1;
            this.primero = nuevo;
            //System.out.println("__________A1");
           // this.agregar_arreglo(nuevo.getDpi(), nuevo.getLlave());
            //System.out.println("_______________________________________-fin");
            return;
           
        }
        //colisione
       // System.out.println("_______coliciones");
        if (this.busqueda_llave(key)) {
            int i = 0;
            int pos = this.cuadratica(nuevo, i);
            this.insertar(dpi, pos);
        } else {
            
            NodoHash temp = this.primero;

            if (nuevo.getLlave() < temp.getLlave()) {
                nuevo.setSiguiente(temp);
                this.primero = nuevo;
                this.id += 1;

               // this.agregar_arreglo(nuevo.getDpi(), nuevo.getLlave());

            } else {
                while (temp.getSiguiente() != null) {
                    NodoHash temp2 = temp.getSiguiente();

                    if (nuevo.getLlave() < temp2.getLlave()) {
                        temp.setSiguiente(nuevo);
                        nuevo.setSiguiente(temp2);
                        this.id += 1;
                        
                        //this.agregar_arreglo(nuevo.getDpi(), nuevo.getLlave());
                        break;

                    }
                    temp = temp.getSiguiente();
                }
                if (temp.getSiguiente() == null) {
                    temp.setSiguiente(nuevo);
                    this.id += 1;
                  //  this.agregar_arreglo(nuevo.getDpi(), nuevo.getLlave());
                }
            }
        }

    }

    public boolean busqueda_llave(int llave) {

        NodoHash aux = this.primero;
        //System.out.println("se qued aqui");
        while (aux != null) {
            System.out.println();
            if (llave == aux.getLlave()) {
              //  System.out.println("llave"+llave);
                return true;
            }
            aux=aux.getSiguiente();
        }

        return false;
    }

//    public void agregar_arreglo(long dpi, int llave) {
//
//        for (int i = 0; i < this.dpis.length; i++) {
//
//            if (dpis[i] == null) {
//
//                dpis[i].setDpi(dpi);
//                dpis[i].setLlave(llave);
//                break;
//            }
//
//        }
//    }

    public int cuadratica(NodoHash temp, int i) {

        int pos = ((temp.getLlave() % 7) + 1) * i;
        //System.out.println("pos " + pos);

        if (this.busqueda_llave(pos)) {
            i = i + 1;

            return this.cuadratica(temp, i);

        }
        return pos;
    }

    public void mostrar() {

        NodoHash aux = this.primero;
        
        while (aux != null) {
            System.out.println("Key: "+aux.getLlave()+" dpi: " + aux.getDpi());
            aux = aux.getSiguiente();
        }
    }
    
    
    public int numeroPrimo(int num) {

        int n = num;
    
            
            for (int j = 2; j < num / 2; j++) {
//                System.out.println(num % j);
                if (num % j == 0) {
                    //System.out.println("true");
           return numeroPrimo(num+2);
                }

              
            
        }

          //  System.out.println("num: "+num);
        return num;

    }
   
}

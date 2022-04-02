/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arbol_b;

/**
 *
 * @author Kelly
 */
public class Pagina {
      boolean hoja;
    int cont;
   public Nodo primero;

    public Pagina() {
        this.primero = null;
        this.hoja = true;
        this.cont = 0;

    }

    public void insertar(Nodo nuevo) {

        if (primero == null) {

            primero = nuevo;
            this.cont++;
        } else {
            Nodo aux = this.primero;

            while (aux != null) {
                if ( nuevo.getId()==aux.getId()) {
                    System.out.println("El id" + nuevo.getId() + "ya existe");
                    break;
                } else {
                    if (aux.getId() > nuevo.getId()) {

                        if (aux == primero) {
                            aux.setAnterior(nuevo);
                            nuevo.setSiguiente(aux);

                            aux.setLeft(nuevo.getRight());
                            nuevo.setRight(null);
                            primero = nuevo;
                            cont++;
                            break;
                        } else {

                            nuevo.setSiguiente(aux);
                            aux.setLeft(nuevo.getRight());
                            nuevo.setRight(null);

                            nuevo.setAnterior(aux.getAnterior());
                            aux.getAnterior().setSiguiente(nuevo);
                            aux.setAnterior(nuevo);
                            cont++;
                            break;
                        }
                    } else if (aux.getSiguiente() == null) {
                        aux.setSiguiente(nuevo);
                        nuevo.setAnterior(aux);
                        cont++;
                        break;
                    }
                }
                aux = aux.getSiguiente();

            }
        }
    }

//______________
    public void mostrar() {

        Nodo aux = this.primero;

        while (aux.getSiguiente() != null) {
            System.out.println(aux.getId() + ", ");
            aux = aux.getSiguiente();
        }
    }
}

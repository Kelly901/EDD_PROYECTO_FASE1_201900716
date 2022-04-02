/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras;

/**
 *
 * @author Kelly
 */
public class Capas {

    private int id_capa;
    private Pixeles pixeles;

    public Capas(int id_capa, Pixeles pixeles) {
        this.id_capa = id_capa;
        this.pixeles = pixeles;
    }

    public int getId_capa() {
        return id_capa;
    }

    public void setId_capa(int id_capa) {
        this.id_capa = id_capa;
    }

    public Pixeles getPixeles() {
        return pixeles;
    }

    public void setPixeles(Pixeles pixeles) {
        this.pixeles = pixeles;
    }

}

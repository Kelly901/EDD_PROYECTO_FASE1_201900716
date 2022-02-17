/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1_edd;

/**
 *
 * @author Kelly
 */
public class Cliente {

    private int id_cliente;
    private String nombre_cliente;
    private int img_color;
    private int img_color2;
    private int img_bw;
    private int img_bw2;

  

    private int totalImagenes;
    private String ventanilla;
    private int pasos = 0;

    public Cliente(int id_cliente, String nombre_cliente, int img_color, int img_bw, int totalImgenes, String ventanilla, int img_color2, int img_bw2) {
        this.id_cliente = id_cliente;
        this.nombre_cliente = nombre_cliente;
        this.img_color = img_color;
        this.img_bw = img_bw;
        this.totalImagenes = totalImgenes;
        this.img_color2 = img_color2;
        this.img_bw2 = img_bw2;
//------------------------------------------
        this.ventanilla = ventanilla;

    }

    public String getVentanilla() {
        return ventanilla;
    }

    public void setVentanilla(String ventanilla) {
        this.ventanilla = ventanilla;
    }

    public int getPasos() {
        return pasos;
    }

    public void setPasos(int pasos) {
        this.pasos = pasos;
    }

    public int getTotalImagenes() {
        return totalImagenes;
    }

    public void setTotalImagenes(int totalImagenes) {
        this.totalImagenes = totalImagenes;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public int getImg_color() {
        return img_color;
    }

    public void setImg_color(int img_color) {
        this.img_color = img_color;
    }

    public int getImg_bw() {
        return img_bw;
    }

    public void setImg_bw(int img_bw) {
        this.img_bw = img_bw;
    }

  public int getImg_color2() {
        return img_color2;
    }

    public void setImg_color2(int img_color2) {
        this.img_color2 = img_color2;
    }

    public int getImg_bw2() {
        return img_bw2;
    }

    public void setImg_bw2(int img_bw2) {
        this.img_bw2 = img_bw2;
    }

    public void mostrarCliente() {
        System.out.println("id" + this.getId_cliente());
        System.out.println("nombre:" + this.getNombre_cliente());
        System.out.println("Total de imagenes" + this.getTotalImagenes());
        System.out.println("Img-color:" + this.getImg_color());
        System.out.println("Img-bw:" + this.getImg_bw());

    }



    public void contaPasos() {
        this.pasos += 1;

    }
}

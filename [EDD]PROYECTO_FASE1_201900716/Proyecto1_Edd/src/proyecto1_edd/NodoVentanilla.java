package proyecto1_edd;

public class NodoVentanilla {

    private NodoVentanilla siguiente;
    private PilaImagenes pila;
    private Cliente cliente;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    private String ventanillas;

    public NodoVentanilla(PilaImagenes pila, String ventanillas, Cliente cliente) {
        this.pila = pila;
        this.ventanillas = ventanillas;
        this.cliente = cliente;
        this.siguiente = null;

    }

    public NodoVentanilla getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoVentanilla siguiente) {
        this.siguiente = siguiente;
    }

    public PilaImagenes getPila() {
        return pila;
    }

    public void setPila(PilaImagenes pila) {
        this.pila = pila;
    }

    public String getVentanillas() {
        return ventanillas;
    }

    public void setVentanillas(String ventanillas) {
        this.ventanillas = ventanillas;
    }

}

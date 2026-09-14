public class Asiento {
    private int numero;
    private int fila;
    private double precio;
 
    public Asiento(int numero, int fila, double precio) {
        this.numero = numero;
        this.fila = fila;
        this.precio = precio;
    }
 
    public Asiento() {
    }
 
    public int getNumero() {
        return numero;
    }
 
    public void setNumero(int numero) {
        this.numero = numero;
    }
 
    public int getFila() {
        return fila;
    }
 
    public void setFila(int fila) {
        this.fila = fila;
    }
 
    public double getPrecio() {
        return precio;
    }
 
    public void setPrecio(double precio) {
        this.precio = precio;
    }
 
    @Override
    public String toString() {
        return String.format("Fila %d - Asiento #%-3d | $%8.2f", fila, numero, precio);
    }
}
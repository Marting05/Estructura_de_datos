public class ObjAlmacen {
    String Nombre;
    Double Precio;
    int cantidad;
    
    public ObjAlmacen(String nombre, Double precio, int cantidad) {
        Nombre = nombre;
        Precio = precio;
        this.cantidad = cantidad;
    }


    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public Double getPrecio() {
        return Precio;
    }

    public void setPrecio(Double precio) {
        Precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }


    
}

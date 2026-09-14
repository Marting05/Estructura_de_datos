public class ObjCelular {
    private String Modelo;
    private String Marca;
    private Double Precio;
    private int Cantidad_disponible;
    private String Caracteristicas;
    private Double Descuento;
    private Double Precio_promocion;
    private String Estado_promocion;
 
    public ObjCelular(String modelo, String marca, Double precio, int cantidad_disponible,
            String caracteristicas, Double descuento, Double precio_promocion, String estado_promocion) {
        Modelo = modelo;
        Marca = marca;
        Precio = precio;
        Cantidad_disponible = cantidad_disponible;
        Caracteristicas = caracteristicas;
        Descuento = descuento;
        Precio_promocion = precio_promocion;
        Estado_promocion = estado_promocion;
    }
 
    public ObjCelular() {
    }
 
    public String getModelo() {
        return Modelo;
    }
 
    public void setModelo(String modelo) {
        Modelo = modelo;
    }
 
    public String getMarca() {
        return Marca;
    }
 
    public void setMarca(String marca) {
        Marca = marca;
    }
 
    public Double getPrecio() {
        return Precio;
    }
 
    public void setPrecio(Double precio) {
        Precio = precio;
    }
 
    public int getCantidad_disponible() {
        return Cantidad_disponible;
    }
 
    public void setCantidad_disponible(int cantidad_disponible) {
        Cantidad_disponible = cantidad_disponible;
    }
 
    public String getCaracteristicas() {
        return Caracteristicas;
    }
 
    public void setCaracteristicas(String caracteristicas) {
        Caracteristicas = caracteristicas;
    }
 
    public Double getDescuento() {
        return Descuento;
    }
 
    public void setDescuento(Double descuento) {
        Descuento = descuento;
    }
 
    public Double getPrecio_promocion() {
        return Precio_promocion;
    }
 
    public void setPrecio_promocion(Double precio_promocion) {
        Precio_promocion = precio_promocion;
    }
 
    public String getEstado_promocion() {
        return Estado_promocion;
    }
 
    public void setEstado_promocion(String estado_promocion) {
        Estado_promocion = estado_promocion;
    }
 
}
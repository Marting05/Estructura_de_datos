
public class ObjDeportista {
    private String Nombre;
    private int Edad;
    private String Categoria;
    private Double Resultado;
    private int Puesto;
    private String Condicion;

    public ObjDeportista(String nombre, int edad, String categoria, Double resultado,
            int puesto, String condicion) {
        Nombre = nombre;
        Edad = edad;
        Categoria = categoria;
        Resultado = resultado;
        Puesto = puesto;
        Condicion = condicion;
    }

    public ObjDeportista() {
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int edad) {
        Edad = edad;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String categoria) {
        Categoria = categoria;
    }

    public Double getResultado() {
        return Resultado;
    }

    public void setResultado(Double resultado) {
        Resultado = resultado;
    }

    public int getPuesto() {
        return Puesto;
    }

    public void setPuesto(int puesto) {
        Puesto = puesto;
    }

    public String getCondicion() {
        return Condicion;
    }

    public void setCondicion(String condicion) {
        Condicion = condicion;
    }

}

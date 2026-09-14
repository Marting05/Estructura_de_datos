
public class ObjServicio {
    private String Cliente;
    private String Empleado;
    private String Tipo_servicio;
    private String Fecha;
    private Double Valor;

    public ObjServicio(String cliente, String empleado, String tipo_servicio, String fecha, Double valor) {
        Cliente = cliente;
        Empleado = empleado;
        Tipo_servicio = tipo_servicio;
        Fecha = fecha;
        Valor = valor;
    }

    public ObjServicio() {
    }

    public String getCliente() {
        return Cliente;
    }

    public void setCliente(String cliente) {
        Cliente = cliente;
    }

    public String getEmpleado() {
        return Empleado;
    }

    public void setEmpleado(String empleado) {
        Empleado = empleado;
    }

    public String getTipo_servicio() {
        return Tipo_servicio;
    }

    public void setTipo_servicio(String tipo_servicio) {
        Tipo_servicio = tipo_servicio;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
    }

    public Double getValor() {
        return Valor;
    }

    public void setValor(Double valor) {
        Valor = valor;
    }

}

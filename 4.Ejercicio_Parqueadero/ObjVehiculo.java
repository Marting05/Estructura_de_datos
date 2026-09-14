public class ObjVehiculo {
    private String Vehiculo;
    private String Propietario;
    private String Tipo_vehiculo;
    private String Plan_contratado;
    private Double Valor_plan;
    private Double Descuento;
    private Double Total_pagar;
    
    public ObjVehiculo(String vehiculo, String propietario, String tipo_vehiculo, String plan_contratado,
            Double valor_plan, Double descuento, Double total_pagar) {
        Vehiculo = vehiculo;
        Propietario = propietario;
        Tipo_vehiculo = tipo_vehiculo;
        Plan_contratado = plan_contratado;
        Valor_plan = valor_plan;
        Descuento = descuento;
        Total_pagar = total_pagar;
    }

    public ObjVehiculo() {
    }

    public String getVehiculo() {
        return Vehiculo;
    }

    public void setVehiculo(String vehiculo) {
        Vehiculo = vehiculo;
    }

    public String getPropietario() {
        return Propietario;
    }

    public void setPropietario(String propietario) {
        Propietario = propietario;
    }

    public String getTipo_vehiculo() {
        return Tipo_vehiculo;
    }

    public void setTipo_vehiculo(String tipo_vehiculo) {
        Tipo_vehiculo = tipo_vehiculo;
    }

    public String getPlan_contratado() {
        return Plan_contratado;
    }

    public void setPlan_contratado(String plan_contratado) {
        Plan_contratado = plan_contratado;
    }

    public Double getValor_plan() {
        return Valor_plan;
    }

    public void setValor_plan(double valor_plan) {
        Valor_plan = valor_plan;
    }

    public Double getDescuento() {
        return Descuento;
    }

    public void setDescuento(Double descuento) {
        Descuento = descuento;
    }

    public Double getTotal_pagar() {
        return Total_pagar;
    }

    public void setTotal_pagar(Double total_pagar) {
        Total_pagar = total_pagar;
    }
    
}

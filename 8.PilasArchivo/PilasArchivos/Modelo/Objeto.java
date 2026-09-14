package Modelo;

import java.util.UUID;

public class Objeto {
    private UUID id;
    private int TipoVehiculo;
    private String Marca;
    private String Color;
    private Double Valor;
    private String CedulaPropietario;
    private String NombrePropietario;

    public Objeto() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getTipoVehiculo() {
        return TipoVehiculo;
    }

    public void setTipoVehiculo(int tipoVehiculo) {
        TipoVehiculo = tipoVehiculo;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String marca) {
        Marca = marca;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public Double getValor() {
        return Valor;
    }

    public void setValor(Double valor) {
        Valor = valor;
    }

    public String getCedulaPropietario() {
        return CedulaPropietario;
    }

    public void setCedulaPropietario(String cedulaPropietario) {
        CedulaPropietario = cedulaPropietario;
    }

    public String getNombrePropietario() {
        return NombrePropietario;
    }

    public void setNombrePropietario(String nombrePropietario) {
        NombrePropietario = nombrePropietario;
    }

}

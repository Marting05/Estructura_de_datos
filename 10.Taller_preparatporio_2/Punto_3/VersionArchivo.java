import java.util.Date;
 
public class VersionArchivo {
    private int numeroVersion;
    private String nombreArchivo;
    private Date fecha;
    private String descripcion;
 
    public VersionArchivo() {
    }
 
    public VersionArchivo(int numeroVersion, String nombreArchivo, Date fecha, String descripcion) {
        this.numeroVersion = numeroVersion;
        this.nombreArchivo = nombreArchivo;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }
 
    public int getNumeroVersion() {
        return numeroVersion;
    }
 
    public void setNumeroVersion(int numeroVersion) {
        this.numeroVersion = numeroVersion;
    }
 
    public String getNombreArchivo() {
        return nombreArchivo;
    }
 
    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }
 
    public Date getFecha() {
        return fecha;
    }
 
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
 
    public String getDescripcion() {
        return descripcion;
    }
 
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
 
    @Override
    public String toString() {
        return "Version: " + numeroVersion + " | Archivo: " + nombreArchivo
                + " | Fecha: " + fecha + " | Descripcion: " + descripcion;
    }
}
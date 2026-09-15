import java.util.Date;

public class CambioTexto{
    private String TextoAnterior;
    private String TextoNuevo;
    private Date Fecha;
    private String Usuario;

    public CambioTexto(String textoAnterior, String textoNuevo, Date fecha, String usuario) {
        TextoAnterior = textoAnterior;
        TextoNuevo = textoNuevo;
        Fecha = fecha;
        Usuario = usuario;
    }

    public CambioTexto() {
    }

    public String getTextoAnterior() {
        return TextoAnterior;
    }

    public void setTextoAnterior(String TextoAnterior) {
        this.TextoAnterior = TextoAnterior;
    }

    public String getTextoNuevo() {
        return TextoNuevo;
    }

    public void setTextoNuevo(String TextoNuevo) {
        this.TextoNuevo = TextoNuevo;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    @Override
    public String toString(){
        return "Usuario: "+Usuario+" | Fecha: "+Fecha
                +" | Texto anterior: \""+TextoAnterior+"\""
                +" | Texto nuevo: \""+TextoNuevo+"\"";
    }
}
package src.Clases;
import java.time.LocalDate;

public class Pagina {
    private static int nextId = 1;
    private int id;
    private String Url; 
    private String Titulo;
    private LocalDate Fecha;

    public Pagina(String url, String titulo) {
        id = nextId++;
        Url = url;
        Titulo = titulo;
        Fecha = LocalDate.now();
    }

    public Pagina(){
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Pagina.nextId = nextId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public LocalDate getFecha() {
        return Fecha;
    }

    public void setFecha(LocalDate fecha) {
        Fecha = fecha;
    }

    
}

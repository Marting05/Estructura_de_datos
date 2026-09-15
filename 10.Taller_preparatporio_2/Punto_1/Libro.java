public class Libro{
    private String Isbn;
    private String Titulo;
    private String Autor;
    private int AnioPublicacion;

    public Libro(String isbn, String titulo, String autor, int anioPublicacion) {
        Isbn = isbn;
        Titulo = titulo;
        Autor = autor;
        AnioPublicacion = anioPublicacion;
    }

    public Libro() {
    }

    public String getIsbn() {
        return Isbn;
    }

    public void setIsbn(String isbn) {
        Isbn = isbn;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String autor) {
        Autor = autor;
    }

    public int getAnioPublicacion() {
        return AnioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        AnioPublicacion = anioPublicacion;
    }

    @Override
    public String toString(){
        return "ISBN: "+Isbn+" |Titulo: "+Titulo+" |Autor: "+Autor+" |Año: "+AnioPublicacion;
    }

}
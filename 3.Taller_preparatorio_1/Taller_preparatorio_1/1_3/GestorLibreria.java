import java.util.Random;
 
public class GestorLibreria {
 
    public Libro[][] llenarLibreria(Libro[][] libreria, String[] titulos, String[] autores) {
        int contador = 0;
        Random random = new Random();
        for (int i = 0; i < libreria.length; i++) {
            for (int j = 0; j < libreria[i].length; j++) {
                Libro l = new Libro();
                l.setTitulo(titulos[contador]);
                l.setAutor(autores[contador]);
                l.setPrecio(random.nextInt(80000) + 20000);
                libreria[i][j] = l;
                contador++;
            }
        }
        return libreria;
    }
 
    public void mostrarLibreria(Libro[][] libreria) {
        System.out.println("===Catalogo de la Libreria===");
        for (int i = 0; i < libreria.length; i++) {
            for (int j = 0; j < libreria[i].length; j++) {
                System.out.printf("[%d][%d] %s%n", i, j, libreria[i][j]);
            }
        }
    }
 
    public Libro encontrarLibroMasCaro(Libro[][] libreria) {
        Libro libroMasCaro = null;
        for (int i = 0; i < libreria.length; i++) {
            for (int j = 0; j < libreria[i].length; j++) {
                Libro actual = libreria[i][j];
                if (actual != null) {
                    if (libroMasCaro == null || actual.getPrecio() > libroMasCaro.getPrecio()) {
                        libroMasCaro = actual;
                    }
                }
            }
        }
        return libroMasCaro;
    }
}
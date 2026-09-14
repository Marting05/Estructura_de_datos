public class Libreria {
    public static void main(String[] args) {
        Libro[][] matrizLibros = new Libro[5][6];
 
        String[] titulos = {
                "Cien Anios de Soledad", "El Aleph", "Rayuela", "Pedro Paramo", "La Casa Verde", "Ficciones",
                "El Otono del Patriarca", "Sobre Heroes y Tumbas", "La Ciudad y los Perros", "Bomarzo", "El Tunel", "La Muerte de Artemio Cruz",
                "Los Rios Profundos", "Conversacion en la Catedral", "Doña Barbara", "El Reino de este Mundo", "Los de Abajo", "Al Filo del Agua",
                "El Coronel no tiene quien le escriba", "Del Amor y otros Demonios", "La Vorágine", "Marianela", "Los Pasos Perdidos", "El Siglo de las Luces",
                "Terra Nostra", "La Region mas Transparente", "Cronica de una Muerte Anunciada", "El Amor en los Tiempos del Colera", "Rebelion en la Granja", "1984"
        };
 
        String[] autores = {
                "G. Garcia Marquez", "J. L. Borges", "J. Cortazar", "J. Rulfo", "M. Vargas Llosa", "J. L. Borges",
                "G. Garcia Marquez", "E. Sabato", "M. Vargas Llosa", "M. Mujica Lainez", "E. Sabato", "C. Fuentes",
                "J. M. Arguedas", "M. Vargas Llosa", "R. Gallegos", "A. Carpentier", "M. Azuela", "A. Yañez",
                "G. Garcia Marquez", "G. Garcia Marquez", "J. E. Rivera", "B. Perez Galdos", "A. Carpentier", "A. Carpentier",
                "C. Fuentes", "C. Fuentes", "G. Garcia Marquez", "G. Garcia Marquez", "G. Orwell", "G. Orwell"
        };
 
        GestorLibreria gestor = new GestorLibreria();
        gestor.llenarLibreria(matrizLibros, titulos, autores);
        gestor.mostrarLibreria(matrizLibros);
 
        Libro libroMasCaro = gestor.encontrarLibroMasCaro(matrizLibros);
 
        System.out.println("\nEl libro mas caro es:");
        System.out.println(libroMasCaro);
    }
}
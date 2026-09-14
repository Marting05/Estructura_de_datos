
import java.util.Scanner;

public class Competencia {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la dimension de la matriz: ");
        int n = sc.nextInt();
        sc.nextLine();
        ObjDeportista[][] deportista = new ObjDeportista[n][n];
        MetodoDeportista m = new MetodoDeportista();
        Boolean continuar = true;

        while (continuar) {
            System.out.println("\nBienvenidos a la competencia deportiva Estructuras S.A.S");
            System.out.println("Que desea realizar");
            System.out.println("1) Registrar participantes");
            System.out.println("2) Mostrar participantes registrados");
            System.out.println("3) Ver criterio de premiacion");
            System.out.println("4) Configurar o modificar el criterio de premiacion");
            System.out.println("5) Consultar una categoria");
            System.out.println("6) Informe para los organizadores");
            System.out.println("7) Preguntas que se le deben hacer a los organizadores");
            System.out.println("8) Salir");
            int opt = sc.nextInt();
            sc.nextLine();
            switch (opt) {
                case 1:
                    deportista = m.LlenarMatriz(deportista, sc);
                    break;
                case 2:
                    m.MostrarMatriz(deportista);
                    break;
                case 3:
                    m.MostrarCriterios();
                    break;
                case 4:
                    m.ModificarCriterios(deportista, sc);
                    break;
                case 5:
                    System.out.println("Ingrese la categoria a consultar: ");
                    String categoria = sc.nextLine();
                    System.out.println("\n Categoria: " + categoria);
                    m.MostrarPorCategoria(deportista, categoria);
                    break;
                case 6:
                    m.ReporteOrganizadores(deportista);
                    break;
                case 7:
                    m.PreguntasOrganizadores();
                    break;
                case 8:
                    System.out.println("Hasta luego.");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opcion no valida, intente nuevamente.");
                    break;
            }
        }
        sc.close();
    }
}

import java.util.Scanner;
 
public class EmpresaCelulares {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la dimension de la matriz: ");
        int n = sc.nextInt();
        sc.nextLine();
        ObjCelular[][] celular = new ObjCelular[n][n];
        MetodoCelular m = new MetodoCelular();
        Boolean continuar = true;
 
        while (continuar) {
            System.out.println("\nBienvenido a la comercializadora de celulares Estructuras S.A.S");
            System.out.println("Que desea realizar");
            System.out.println("1) Registrar celulares");
            System.out.println("2) Mostrar celulares registrados");
            System.out.println("3) Ver criterio de promocion");
            System.out.println("4) Configurar o modificar el criterio de promocion");
            System.out.println("5) Informe para la gerencia");
            System.out.println("6) Preguntas que se le deben hacer al gerente");
            System.out.println("7) Salir");
            int opt = sc.nextInt();
            sc.nextLine();
            switch (opt) {
                case 1:
                    celular = m.LlenarMatriz(celular, sc);
                    break;
                case 2:
                    m.MostrarMatriz(celular);
                    break;
                case 3:
                    m.MostrarCriterios();
                    break;
                case 4:
                    m.ModificarCriterios(celular, sc);
                    break;
                case 5:
                    m.ReporteGerencia(celular);
                    break;
                case 6:
                    m.PreguntasAlGerente();
                    break;
                case 7:
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
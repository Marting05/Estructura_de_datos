
import java.util.Scanner;

public class EmpresaServicios {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la dimension de la matriz: ");
        int n = sc.nextInt();
        sc.nextLine();
        ObjServicio[][] servicio = new ObjServicio[n][n];
        MetodoServicio m = new MetodoServicio();
        Boolean continuar = true;

        while (continuar) {
            System.out.println("\nBienvenidos a la empresa de servicios Estructuras S.A.S");
            System.out.println("Que desea realizar");
            System.out.println("1) Registrar servicios del mes");
            System.out.println("2) Mostrar servicios registrados");
            System.out.println("3) Ver criterio de desempeño");
            System.out.println("4) Configurar o modificar el criterio de desempeño");
            System.out.println("5) Consultar un empleado");
            System.out.println("6) Informe de desempeño para la gerencia");
            System.out.println("7) Preguntas que se le deben hacer a la gerencia");
            System.out.println("8) Salir");
            int opt = sc.nextInt();
            sc.nextLine();
            switch (opt) {
                case 1:
                    servicio = m.LlenarMatriz(servicio, sc);
                    break;
                case 2:
                    m.MostrarMatriz(servicio);
                    break;
                case 3:
                    m.MostrarCriterios();
                    break;
                case 4:
                    m.ModificarCriterios(sc);
                    break;
                case 5:
                    System.out.println("Ingrese el nombre del empleado: ");
                    String empleado = sc.nextLine();
                    int cantidad = m.ContarServicios(servicio, empleado);
                    if (cantidad == 0) {
                        System.out.println("Ese empleado no tiene servicios registrados.");
                    } else {
                        System.out.println("\nEmpleado: " + empleado);
                        System.out.println("Servicios realizados: " + cantidad);
                        System.out.println("Total facturado: $" + m.TotalEmpleado(servicio, empleado));
                        System.out.println("Promedio por servicio: $" + m.PromedioEmpleado(servicio, empleado));
                    }
                    break;
                case 6:
                    m.ReporteGerencia(servicio);
                    break;
                case 7:
                    m.PreguntasGerencia();
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


import java.util.Scanner;

public class Parqueadero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa la dimension de la matriz: ");
        int n = sc.nextInt();
        sc.nextLine();
        ObjVehiculo[][] vehiculo = new ObjVehiculo[n][n];
        Metodo m = new Metodo();
        Boolean continuar = true;
        while(continuar){
            System.out.println("Bienvenidos al parqueadero Estructuras S.A.S");
            System.out.println("Que desea realizar");
            System.out.println("1) Registrar Vehiculos");
            System.out.println("2) Mostrar vehiculos registrados");
            System.out.println("3) Determinar planes de pago ");
            System.out.println("4) Configurar o modificar valores y descuentos de planes");
            System.out.println("5) Reportes de administracion");
            System.out.println("6) Salir");    
            int opt = sc.nextInt();
            switch (opt) {
                case 1:
                    vehiculo = m.LlenarMatriz(vehiculo, sc);
                    break;
                case 2:
                    m.MostrarMatriz(vehiculo);
                    break;
                case 3:
                    m.MostrarPlanes();
                    break; 
                case 4:
                    m.ModificarPlanes(sc);
                    break;   
                case 5:
                    m.ReporteAdministracion(vehiculo);
                    break;
                case 6:
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

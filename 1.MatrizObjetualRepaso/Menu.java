
import java.util.Scanner;

public class Menu{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa la dimension de la matrix");
        int n = sc.nextInt();
        ObjComidaRapida[][] ventas = new ObjComidaRapida[n][n];
        Metodos m = new Metodos();
        boolean continuar = true;
        while (continuar) { 
            int opt = m.OpcionesMenuPrincipal();
            switch (opt) {
                case 1:
                    ventas = m.LLenarRegistros(n);
                    break;
                case 2:
                    System.out.println("Se muestran a continuacion los turnos pendiente");
                    m.MostrarTurnosPendientes(ventas);
                    break;
                case 3:
                    System.out.println("Los pedidos despachados son:");
                    m.MostrarTurnosDespachados(ventas);
                    break;
                case 4:
                    ventas = m.Despachar(ventas);
                    break;  
                case 5:
                    System.out.println("Que tenga un feliz día");
                    continuar = false;
                    break;                                                                              
                default:
                    System.out.println("Esta opción no existe por favor valide de nuevo ");
                    break;
            }
        }
    }
}
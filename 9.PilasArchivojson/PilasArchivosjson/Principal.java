import java.util.Scanner;
import java.util.Stack;

public class Principal {

    public static void main(String[] args) {
        Stack<objcarro> pila = new Stack<>();
        Scanner sc = new Scanner(System.in);
        Medotos m = new Medotos();
        boolean continuar = true;
        while (continuar) {
            System.out.println("Que desea realizar ");
            System.out.println(" 1) Ingresar registros");
            System.out.println(" 2) Modificar Registros");
            System.out.println(" 3) Eliminar Registros");
            System.out.println(" 4) Mostrar Registros");
            System.out.println(" 5) Importar Archivo");
            System.out.println(" 6) Exportar Archivo");
            System.out.println(" 7) Salir");
            int opt = sc.nextInt();
            switch (opt) {
                case 1:
                    pila = m.LlenarPila(pila, sc);
                    break;
                case 2:
                    System.out.println("pagina en mantenimiento");
                    break;
                case 3:
                    pila = m.EliminarPorObjeto(pila, sc);
                    break;
                case 4:
                    m.MostrarPilar(pila);
                    break;
                case 5:
                    pila = m.ImportarJson(sc);
                    break;
                case 6:
                    m.ExportarJson(pila);
                    break;
                case 7:
                    System.out.println("Hasta luego compadre");
                    continuar = false;
                    break;

                default:
                    System.out.println("esta Opcion no es correcta por favor valide ");
                    break;
            }
        }

    }
}
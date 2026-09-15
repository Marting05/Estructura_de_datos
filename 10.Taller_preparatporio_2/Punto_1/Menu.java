import java.util.Scanner;
import java.util.Stack;

public class Menu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Libro> pila = new Stack<>();
        Metodo m = new Metodo();
        boolean continuar = true;
        while (continuar) { 
            System.out.println("Bienvenido al sistema de Gestión de Libros (Pilas)");
            System.out.println("Que desea realizar");
            System.out.println("1) Registrar libro ");
            System.out.println("2) Retirar ultimo libro registrado ");
            System.out.println("3) Consultar ultimo libro registrado (peek) ");
            System.out.println("4) Mostrar todos los libros ");
            System.out.println("5) Salir ");
            int opt = m.ValidarEntero(sc);
            switch (opt) {
                case 1:
                    pila = m.RegistrarLibro(pila,sc,m);
                    break;
                case 2:
                    pila = m.RetirarUltimoLibro(pila);
                    break;                    
                case 3:
                    m.ConsultarUltimoLibro(pila);
                    break;            
                case 4:
                    m.MostrarLibro(pila);
                    break; 
                case 5:
                    System.out.println("Hasta luego");
                    continuar = false;
                    break; 
                default:
                    System.out.println("esta opcion no existe");
                    break;
            }
        }
    }
}

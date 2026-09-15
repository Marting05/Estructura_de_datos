import java.util.Scanner;
import java.util.Stack;


public class Menu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<CambioTexto> pila = new Stack<>();
        Metodos m = new Metodos();
        boolean continuar = true;
        while (continuar){
            System.out.println("Bienvenidos al Sistema de Deshacer del Editor de Texto (Pilas)");
            System.out.println("Que desea realizar");
            System.out.println("1) Registrar cambio");
            System.out.println("2) Deshacer ultimo cambio");
            System.out.println("3) Consultar ultimo cambio (peek)");
            System.out.println("4) Mostrar historial de cambios");
            System.out.println("5) Salir");
            int opt = m.ValidarEntero(sc);
            switch (opt) {
                case 1:
                    pila = m.RegistrarCambio(pila,sc, m);
                    break;
                case 2:
                    pila = m.DeshacerUltimoCambio(pila);
                    break;        
                case 3:
                    m.ConsultarUltimoCambio(pila);
                    break; 
                case 4:
                    m.MostrarHistorialCambios(pila);
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

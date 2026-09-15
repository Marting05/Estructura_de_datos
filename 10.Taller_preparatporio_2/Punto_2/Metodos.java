
import java.util.Date;
import java.util.Scanner;
import java.util.Stack;

public class Metodos {

    public Stack<CambioTexto> RegistrarCambio(Stack<CambioTexto> pila, Scanner sc, Metodos m){
        sc.nextLine();
        System.out.println("Ingrese el texto anterior");
        String textoAnterior = sc.nextLine();
        System.out.println("Ingrese el texto nuevo");
        String textoNuevo = sc.nextLine();
        System.out.println("Ingrese el usuario que realiza el cambio");
        String usuario = sc.nextLine();

        CambioTexto cambio = new CambioTexto(textoAnterior, textoNuevo, new Date(), usuario);
        pila.push(cambio);
        System.out.println("Cambio registrado con exito");

        return pila;
    }

    public Stack<CambioTexto> DeshacerUltimoCambio(Stack<CambioTexto> pila){
        if(pila.isEmpty()){
            System.out.println("No hay cambios registrados en la pila");
        } else {
            CambioTexto cambio = pila.pop();
            System.out.println("Se deshizo el siguiente cambio:");
            System.out.println(cambio);
        }
        return pila;
    }

    public void ConsultarUltimoCambio(Stack<CambioTexto> pila){
        if(pila.isEmpty()){
            System.out.println("No hay cambios registrados en la pila");
        } else {
            CambioTexto cambio = pila.peek();
            System.out.println("El ultimo cambio registrado es:");
            System.out.println(cambio);
        }
    }

    public void MostrarHistorialCambios(Stack<CambioTexto> pila){
        if(pila.isEmpty()){
            System.out.println("No hay cambios registrados en la pila");
        } else {
            System.out.println("Historial de cambios (del ultimo al primero registrado):");
            for(CambioTexto cambio:pila){
                System.out.println(cambio);
            }
        }
    }

    public int ValidarEntero(Scanner sc){
        while(!sc.hasNextInt()){
            System.out.println( "Por favor tenga en cuenta que se le esta pidiendo un dato numerico ");
            sc.next();
        }
        return sc.nextInt();
    }
}

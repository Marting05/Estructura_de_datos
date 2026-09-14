import java.util.Scanner;
import java.util.Stack;

public class Metodos {
    public Stack<Obj> LLenarPila(Stack<Obj> pila, Scanner sc, Metodos m) {
        boolean continuar = true;
        while (continuar) {
            Obj o = new Obj();
            o.setNumero((int) (Math.random() * 50 + 1));
            pila.push(o);
            System.out.println("Desea Continuar ingresanbdo registros 1) si , 2) no ");
            int opt = m.ValidarEentero(sc);
            if (opt == 2) {
                continuar = false;
            }
        }
        return pila;
    }

    public void MostrarPila(Stack<Obj> pila) {
        System.out.println(pila);
    }

    public void MostrarPilaObjetual(Stack<Obj> pila) {
        for (Obj o : pila) {
            System.out.println(o.getNumero());
        }
    }

    public Stack<Obj> EliminarTope(Stack<Obj> pila) {
        pila.pop();
        return pila;
    }

    public Stack<Obj> EliminarRegitro(Stack<Obj> pila, Scanner sc, Metodos m) {
        System.out.println("Ingrese el Numero a eliminar");
        int numero = m.ValidarEentero(sc);
        Stack<Obj> pilaaux = new Stack<>();
        while (!pila.isEmpty()){
            Obj o=pila.pop();
                if(o.getNumero()==numero){
                    System.out.println("registro eliminado");
                }else{
                    pilaaux.push(o);
                }
        }
        while (!pilaaux.isEmpty()) {
            pila.push(pilaaux.pop());
        }

        return pila;

    }

    public int ValidarEentero(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.println(
                    "Por favor tenga en cuenta que se le esta pidiendo un dato numerico ojala en el rango de 1 a 5 ");
            sc.next();
        }
        return sc.nextInt();
    }

}
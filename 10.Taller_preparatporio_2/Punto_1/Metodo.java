import java.util.Scanner;
import java.util.Stack;

public class Metodo {
    public Stack<Libro> RegistrarLibro(Stack<Libro> pila, Scanner sc, Metodo m){
        sc.nextLine(); // limpiar el buffer que deja el nextInt() del menu
        System.out.println("Ingrese el ISBN del libro");
        String isbn = sc.nextLine();
        System.out.println("Ingrese el titulo del libro");
        String titulo = sc.nextLine();
        System.out.println("Ingrese el autor del libro");
        String autor = sc.nextLine();
        System.out.println("Ingrese el año de publicacion");
        int anio = m.ValidarEntero(sc);
        Libro libro = new Libro(isbn, titulo, autor, anio);
        pila.push(libro);
        System.out.println("Libro registrado con exito");

        return pila;
    }

    public Stack<Libro> RetirarUltimoLibro(Stack<Libro> pila){
        if(pila.isEmpty()){
            System.out.println("No hay libros registrados en la pila");
        } else {
            Libro libro = pila.pop();
            System.out.println("Se retiro el siguiente libro:");
            System.out.println(libro);
        }
        return pila;
    }

    public void ConsultarUltimoLibro(Stack<Libro> pila){
        if(pila.isEmpty()){
            System.out.println("No hay libros registrados en la pila");
        } else{
            Libro libro = pila.peek();
            System.out.println("El ultimo libro registrado es:");
            System.out.println(libro);
        }
    }

    public void MostrarLibro(Stack<Libro> pila){
        if(pila.isEmpty()){
            System.out.println("No hay libros registrados en la pila");
        } else {
            System.out.println("Listado de libros en la pila (del ultimo al primero registrado):");
            for(Libro libro: pila){
                System.out.println(libro);
            }
        }
    }

    public int ValidarEntero(Scanner sc){
        while(!sc.hasNext()){
            System.out.println("Por favor tenga en cuenta que se le esta pidiendo un dato numerico.");
            sc.next();
        }
        return sc.nextInt();
    }
}

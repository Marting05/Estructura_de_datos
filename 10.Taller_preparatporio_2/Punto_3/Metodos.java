import java.util.Date;
import java.util.Scanner;
import java.util.Stack;
 
public class Metodos {
 
    public Stack<VersionArchivo> CrearVersion(Stack<VersionArchivo> pila, Scanner sc, Metodos m) {
        sc.nextLine(); // limpiar el buffer que deja el nextInt() del menu
 
        System.out.println("Ingrese el nombre del archivo");
        String nombreArchivo = sc.nextLine();
 
        System.out.println("Ingrese la descripcion de esta version");
        String descripcion = sc.nextLine();
 
        VersionArchivo version = new VersionArchivo();
        version.setNumeroVersion(pila.size() + 1); // se calcula automaticamente segun las versiones existentes
        version.setNombreArchivo(nombreArchivo);
        version.setFecha(new Date()); // se registra automaticamente la fecha y hora de la version
        version.setDescripcion(descripcion);
 
        pila.push(version);
        System.out.println("Version creada y guardada con exito");
 
        return pila;
    }
 
    public Stack<VersionArchivo> VolverVersionAnterior(Stack<VersionArchivo> pila) {
        if (pila.isEmpty()) {
            System.out.println("No hay versiones registradas en la pila");
        } else {
            VersionArchivo version = pila.pop();
            System.out.println("Se elimino la siguiente version:");
            MostrarDetalleVersion(version);
            if (!pila.isEmpty()) {
                System.out.println("Ahora la version actual es:");
                MostrarDetalleVersion(pila.peek());
            } else {
                System.out.println("No quedan versiones anteriores registradas");
            }
        }
        return pila;
    }
 
    public void ConsultarVersionActual(Stack<VersionArchivo> pila) {
        if (pila.isEmpty()) {
            System.out.println("No hay versiones registradas en la pila");
        } else {
            System.out.println("La version actual es:");
            MostrarDetalleVersion(pila.peek());
        }
    }
 
    public void MostrarVersiones(Stack<VersionArchivo> pila) {
        if (pila.isEmpty()) {
            System.out.println("No hay versiones registradas en la pila");
        } else {
            System.out.println("Listado de versiones (de la primera creada a la mas reciente):");
            for (VersionArchivo version : pila) {
                MostrarDetalleVersion(version);
            }
        }
    }
 
    public void MostrarDetalleVersion(VersionArchivo version) {
        System.out.println("Version: " + version.getNumeroVersion()
                + " | Archivo: " + version.getNombreArchivo()
                + " | Fecha: " + version.getFecha()
                + " | Descripcion: " + version.getDescripcion());
    }
 
    public int ValidarEentero(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.println(
                    "Por favor tenga en cuenta que se le esta pidiendo un dato numerico ");
            sc.next();
        }
        return sc.nextInt();
    }
}
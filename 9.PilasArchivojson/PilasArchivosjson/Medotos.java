import java.security.PublicKey;
import java.util.Scanner;
import java.util.Stack;

public class Medotos {
    public int SolicitarDimension() {
        Scanner sc = new Scanner(System.in);
        int d = 0;
        System.out.println("por favor ingrese la dimensión de la mtriz ");
        d = sc.nextInt();
        return d;
    }

    public int[][] LLenarMatriz(int d) {
        int[][] m = new int[d][d];
        for (int i = 0; i < m.length; i++) { // for para las filas
            for (int j = 0; j < m.length; j++) { // columnas
                m[i][j] = (int) (Math.random() * 50 + 1);
            }

        }
        return m;
    }

    public Stack<objcarro> LlenarPila(Stack<objcarro> p, Scanner sc) {
        boolean bandera = true;
        int opt = 0;
        while (bandera) {
            objcarro o = new objcarro();
            System.out.println("ingrese marca");
            o.setMarca(sc.next());
            System.out.println("ingrese el color");
            o.setColor(sc.next());
            System.out.println("ingrese el precio");
            o.setPrecio(sc.nextInt());
            p.push(o);

            System.out.println("desea continuar 1:si, 2:NO");
            opt = sc.nextInt();
            if (opt == 2) {
                bandera = false;
            }
        }
        return p;
    }

    public void MostrarPilar(Stack<objcarro> p) {
        for (objcarro objcarro : p) {
            System.out.println(objcarro.getMarca());
            System.out.println(objcarro.getColor());
            System.out.println(objcarro.getPrecio());
            System.out.println();

        }
    }

    public Stack<objcarro> EliminarPorObjeto(Stack<objcarro> p, Scanner sc) {
        System.out.println("Ingrese la marca que desea eliminar");
        String marca = sc.next();
        for (objcarro objcarro : p) {
            if (objcarro.getMarca().equalsIgnoreCase(marca)) {
                p.pop();
            }
        }
        return p;
    }

    public Stack<objcarro> ImportarJson(Scanner sc) {
        Stack<objcarro> p = new Stack<>();
        ImportarJson i = new ImportarJson();
        System.out.println("Por favor Ingrese el nombre del archivo ");
        String nombreArchivo = sc.next();
        p = i.Importar(nombreArchivo);
        return p;
    }

    public void ExportarJson(Stack<objcarro> p) {
        ExportarJson e = new ExportarJson();
        e.exportarJson(p);
    }
}

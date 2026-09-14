import java.util.Scanner;

public class Metodos {
    public ObjAlmacen[][] LlenarAlmacen(ObjAlmacen[][] a, Scanner sc) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.println("Ingrese el nombre del producto: ");
                String nombre = sc.next();
                System.out.println("Ingrese el precio del producto: ");
                Double precio = sc.nextDouble();
                System.out.println("Ingrese la cantidad del producto: ");
                int cantidad = sc.nextInt();
                ObjAlmacen o = new ObjAlmacen(nombre, precio, cantidad);
                a[i][j] = o;
            }
        }
        return a;
    }

    public ObjAlmacen[][] UnificarAlmacenes(ObjAlmacen[][] a, ObjAlmacen[][] b, ObjAlmacen[][] c) {
        // unificar matrices
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                for (int i1 = 0; i1 < b.length; i1++) {
                    for (int j1 = 0; j1 < b[0].length; j1++) {
                        if (a[i][j].getNombre().equalsIgnoreCase(b[i1][j1].getNombre())) {
                            a[i][j].setCantidad(a[i][j].getCantidad() + b[i1][j1].getCantidad());
                            b[i1][j1].setNombre(null);
                        }
                    }
                }
            }
        }
        // pasar los datos de la matriz a a la c
        int auxc = a.length;

        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c.length; j++) {
                c[i][j] = a[i][j];

            }

        }
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (b[i][j].getNombre() != null)
                    c[i][auxc] = b[i][j];
                auxc++;
            }
            auxc= a.length;
        }
        return c;
    }

    public void MostrarAlmacen(ObjAlmacen[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] != null){
                System.out.println("Nombre Producto: " + matrix[i][j].getNombre());
                System.out.println("Precio Producto: " + matrix[i][j].getPrecio());
                System.out.println("Stock Producto: " + matrix[i][j].getCantidad());
                System.out.println("----------------------------------------------------");
                }
            }
            System.out.println();
        }
    }

    public void Buscardato(ObjAlmacen[][] matrix, Scanner sc) {
        System.out.println("Por favor ingrese nombre para buscar");
        String dato = sc.next();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j].getNombre().equalsIgnoreCase(dato)){
                    System.out.println("Nombre Producto: " + matrix[i][j].getNombre());
                    System.out.println("Precio Producto: " + matrix[i][j].getPrecio());
                    System.out.println("Stock Producto: " + matrix[i][j].getCantidad());
                    System.out.println("----------------------------------------------------");
                }
            }
        }
        System.out.println();
    }

}

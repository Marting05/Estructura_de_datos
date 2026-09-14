import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Metodos U = new Metodos();
        Boolean continuar = true;
        System.out.println("Ingrese el tamaño del almacen: ");
        int n = sc.nextInt();
        ObjAlmacen[][] almacen1 = new ObjAlmacen[n][n];
        ObjAlmacen[][] almacen2 = new ObjAlmacen[n][n];
        ObjAlmacen[][] almacenUnificado = new ObjAlmacen[n][n*n];

        while (continuar) {
            System.out.println("Bienvenido al Almacen de Productos");
            System.out.println("que desea realizar: ");
            System.out.println("1) Llenar almacen 1: ");
            System.out.println("2) mostar almacen 1: ");
            System.out.println("3) Llenar almacen 2: ");
            System.out.println("4) mostar almacen 2: ");
            System.out.println("5) Buscar Producto: ");
            System.out.println("6) Unificar Almacenes: ");
            System.out.println("7) Mostrar almacenes Unificados: ");
            System.out.println("8) Salir ");
            int opt = sc.nextInt();
            switch (opt) {
                case 1:
                    almacen1 = U.LlenarAlmacen(almacen1, sc);
                    break;
                case 2:
                    U.MostrarAlmacen(almacen1);
                    break;
                case 3:
                    almacen2 = U.LlenarAlmacen(almacen2, sc);
                    break;
                case 4:
                    U.MostrarAlmacen(almacen2);
                    break;
                case 5:
                    U.Buscardato(almacenUnificado, sc);
                    break;
                case 6:
                    U.UnificarAlmacenes(almacen1, almacen2, almacenUnificado);
                    break;
                case 7:
                    U.MostrarAlmacen(almacenUnificado);
                    break;
                case 8:
                    System.out.println("Gracias por usar el sistema. ");
                    continuar = false;
                    break;
                case 9:
                    System.out.println("Opción no válida. ");
                    break;

            }
        }
    }
}

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        boolean continuar = true;
        Scanner sc = new Scanner(System.in);
        metodos m = new metodos();
        int n = 0;
        System.out.println("Ingrese la dimension de la matriz");
        n = sc.nextInt();
        int[][] ME = new int[n][n];
        ObjMatriz[][] MO = new ObjMatriz[n][n];
        while(continuar){
            System.out.println("Que desea realizar");
            System.out.println("1: llenar matriz de enteros");
            System.out.println("2: mostrar matriz de enteros");
            System.out.println("3: llenar matriz de objetos");
            System.out.println("4: mostrar matriz de objetos");
            System.out.println("5: mostrar numeros pares de la matriz de enteros");
            System.out.println("6: salir");
            int opt = sc.nextInt();
            switch (opt) {
                case 1:
                    ME = m.LLenarMatrizEntera(ME);
                    break;
                case 2:
                    m.MostrarMatrizEntera(ME);
                    break;
                case 3:
                    MO = m.LLenarMatrizObjetual(MO);
                    break;
                case 4:
                    m.MostrarMatrizObjetual(MO);
                    break;
                case 5:
                    m.MostrarPar(ME);
                    break;
                case 6:
                    System.out.println("hasta luego");
                    continuar = false;
                    break;                                                                                                
                default:
                    System.out.println("esta opcion no existe por favor validar...");
                    break;
            }    
        }
    }
}

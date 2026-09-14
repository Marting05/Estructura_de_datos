import java.util.Scanner;
 
 
public class Almacen {
    public static void main(String[] args) {
        Producto[][] matrizProducto = new Producto[5][6];
    
        String[] NombresInventario = {
                "Arroz", "Aceite", "Azucar", "Sal", "Cafe", "Pasta",
                "Leche", "Huevos", "Harina", "Frijol", "Lenteja", "Atun",
                "Jabon", "Detergente", "Papel", "Servilletas", "Galletas", "Chocolate",
                "Mermelada", "Miel", "Cereal", "Avena", "Panela", "Chocolatina",
                "Vinagre", "Salsa", "Mayonesa", "Mostaza", "Te", "Gaseosa"
            };
        
        GestorAlmacen gestor = new GestorAlmacen();
        gestor.LlenarAlmacen(matrizProducto, NombresInventario);
        gestor.MostrarAlmace(matrizProducto); 
        Scanner sc = new Scanner(System.in);
        System.out.print("\nIngrese el nombre del producto a buscar: ");  
        String nombreBuscado = sc.nextLine().trim();  
        int[] posicion = gestor.BuscarProducto(matrizProducto, nombreBuscado);
        if(posicion != null){
            System.out.println("\nProducto encontrado en la posición ["+posicion[0]+"]["+posicion[1]+"]");
            System.out.println("Detalle: "+matrizProducto[posicion[0]][posicion[1]]);
        } else{
            System.out.println("\nEl producto "+nombreBuscado+" no se encuentra en el almacen.");
        }
        sc.close();
    }
}
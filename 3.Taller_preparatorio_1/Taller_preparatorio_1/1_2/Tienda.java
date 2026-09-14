public class Tienda {
    public static void main(String[] args) {
        Producto[][] matrizProducto = new Producto[5][6];
 
        String[] nombresInventario = {
                "Arroz", "Aceite", "Azucar", "Sal", "Cafe", "Pasta",
                "Leche", "Huevos", "Harina", "Frijol", "Lenteja", "Atun",
                "Jabon", "Detergente", "Papel", "Servilletas", "Galletas", "Chocolate",
                "Mermelada", "Miel", "Cereal", "Avena", "Panela", "Chocolatina",
                "Vinagre", "Salsa", "Mayonesa", "Mostaza", "Te", "Gaseosa"
        };
 
        GestorInventario gestor = new GestorInventario();
        gestor.llenarTienda(matrizProducto, nombresInventario);
        gestor.mostrarTienda(matrizProducto);
 
        int inventarioTotal = gestor.calcularInventarioTotal(matrizProducto);
 
        System.out.println("\nEl inventario total de la tienda es: " + inventarioTotal + " unidades.");
    }
}
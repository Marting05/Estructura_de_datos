import java.util.Random;
 
public class GestorInventario {
 
    public Producto[][] llenarTienda(Producto[][] tienda, String[] nombresInventario) {
        int contador = 0;
        Random random = new Random();
        for (int i = 0; i < tienda.length; i++) {
            for (int j = 0; j < tienda[i].length; j++) {
                Producto p = new Producto();
                p.setNombre(nombresInventario[contador]);
                p.setPrecio(random.nextInt(30000) + 20000);
                p.setStock((int) (Math.random() * 100));
                tienda[i][j] = p;
                contador++;
            }
        }
        return tienda;
    }
 
    public void mostrarTienda(Producto[][] tienda) {
        System.out.println("===Inventario de la Tienda===");
        for (int i = 0; i < tienda.length; i++) {
            for (int j = 0; j < tienda[i].length; j++) {
                System.out.printf("[%d][%d] %s%n", i, j, tienda[i][j]);
            }
        }
    }
 
    public int calcularInventarioTotal(Producto[][] tienda) {
        int total = 0;
        for (int i = 0; i < tienda.length; i++) {
            for (int j = 0; j < tienda[i].length; j++) {
                if (tienda[i][j] != null) {
                    total += tienda[i][j].getStock();
                }
            }
        }
        return total;
    }
}
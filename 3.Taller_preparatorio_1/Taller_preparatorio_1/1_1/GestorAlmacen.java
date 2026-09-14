import java.util.Random;
 
public class GestorAlmacen {
 
    public Producto[][] LlenarAlmacen(Producto[][] Almacen, String[] NombresInventario){
        int contador = 0;
        Random random = new Random();
        for (int i = 0; i < Almacen.length; i++) {
           for (int j = 0; j < Almacen[i].length; j++) {
            Producto o = new Producto();
            o.setNombre(NombresInventario[contador]);
            o.setPrecio(random.nextInt(30000) + 20000);
            o.setStock((int) (Math.random()*100));
            Almacen[i][j] = o;
            contador++;
           } 
        }
        return Almacen;
    }
 
    public void MostrarAlmace(Producto[][] almacen){
        System.out.println("===Inventario del Almacen===");
        for (int i = 0; i < almacen.length; i++) {
            for (int j = 0; j < almacen[i].length; j++) {
                System.out.printf("[%d][%d] %s%n", i, j, almacen[i][j]);
            }
        }
    }
 
    public int[] BuscarProducto(Producto[][] almacen, String nombreBuscado){
        for (int i = 0; i < almacen.length; i++) {
            for (int j = 0; j < almacen[i].length; j++) {
                if(almacen[i][j] != null && almacen[i][j].getNombre().equalsIgnoreCase(nombreBuscado)){
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
 
}
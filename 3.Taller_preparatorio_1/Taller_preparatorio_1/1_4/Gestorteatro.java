
import java.util.Random;
 
public class Gestorteatro {
 
    public Asiento[][] llenarTeatro(Asiento[][] teatro) {
        Random random = new Random();
        for (int i = 0; i < teatro.length; i++) {
            for (int j = 0; j < teatro[i].length; j++) {
                Asiento a = new Asiento();
                a.setFila(i + 1);
                a.setNumero(j + 1);
                a.setPrecio(random.nextInt(80000) + 20000);
                teatro[i][j] = a;
            }
        }
        return teatro;
    }
 
    public void mostrarTeatro(Asiento[][] teatro) {
        System.out.println("===Mapa del Teatro===");
        for (int i = 0; i < teatro.length; i++) {
            for (int j = 0; j < teatro[i].length; j++) {
                System.out.printf("[%d][%d] %s%n", i, j, teatro[i][j]);
            }
        }
    }
 
    public void ordenarAsientosPorFila(Asiento[][] teatro) {
        for (int i = 0; i < teatro.length; i++) {
            // Ordenamiento burbuja de la fila i
            for (int j = 0; j < teatro[i].length - 1; j++) {
                for (int k = 0; k < teatro[i].length - 1 - j; k++) {
                    if (teatro[i][k].getPrecio() > teatro[i][k + 1].getPrecio()) {
                        // Intercambiamos los asientos de posicion
                        Asiento temporal = teatro[i][k];
                        teatro[i][k] = teatro[i][k + 1];
                        teatro[i][k + 1] = temporal;
                    }
                }
            }
        }
    }
}
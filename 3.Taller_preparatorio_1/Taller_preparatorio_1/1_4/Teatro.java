public class Teatro {
    public static void main(String[] args) {
        Asiento[][] matrizAsientos = new Asiento[5][6];
 
        Gestorteatro gestor = new Gestorteatro();
        gestor.llenarTeatro(matrizAsientos);
 
        System.out.println(">>> ANTES de ordenar <<<");
        gestor.mostrarTeatro(matrizAsientos);
 
        gestor.ordenarAsientosPorFila(matrizAsientos);
 
        System.out.println("\n>>> DESPUES de ordenar (precio ascendente por fila) <<<");
        gestor.mostrarTeatro(matrizAsientos);
    }
}


import java.util.Scanner;

public class MetodoDeportista {

    // ---------------------------------------------------------------
    // ANALISIS DEL PROBLEMA
    // El enunciado no define que es un "mejor participante":
    //   - no dice si un resultado alto es bueno (puntos) o malo (tiempo)
    //   - no dice si se compara a todos juntos o cada categoria aparte
    //   - no dice cuantos participantes se consideran los mejores
    // Por eso esas tres decisiones quedan como variables que los
    // organizadores configuran desde el menu. Empiezan en -1 = sin configurar.
    // ---------------------------------------------------------------

    private int tipoResultado = -1;     // 1 = gana el mayor (puntos), 2 = gana el menor (tiempo)
    private int modoComparacion = -1;   // 1 = por categoria, 2 = general (todos contra todos)
    private int cantidadMejores = -1;   // cuantos puestos se consideran "los mejores"

    // Retorna true si los organizadores ya definieron las tres condiciones
    public boolean CriteriosConfigurados() {
        return tipoResultado != -1 && modoComparacion != -1 && cantidadMejores != -1;
    }

    // Preguntas que se le deben hacer a los organizadores
    public void PreguntasOrganizadores() {
        System.out.println("\n===== PREGUNTAS PARA LOS ORGANIZADORES =====");
        System.out.println("1) El resultado obtenido es un puntaje (gana el mayor) o un tiempo (gana el menor)?");
        System.out.println("2) Todos los participantes se comparan entre si o cada categoria se premia aparte?");
        System.out.println("3) Cuantos participantes se consideran 'los mejores' (solo el primero, top 3, top 5)?");
        System.out.println("4) La edad influye en la premiacion o solo sirve para clasificar la categoria?");
        System.out.println("5) Que se hace cuando dos participantes empatan en el mismo resultado?");
        System.out.println("6) Un participante de una categoria puede competir contra otra categoria?");
        System.out.println("\nRESPUESTA ASUMIDA EN ESTE PROGRAMA:");
        System.out.println("Nada de esto queda fijo en el codigo. En la opcion 4 se define el tipo de");
        System.out.println("resultado, si la comparacion es por categoria o general, y cuantos se premian.");
        System.out.println("En caso de empate los participantes comparten el mismo puesto.");
    }

    // Pide un entero dentro de un rango valido
    public int PedirOpcion(Scanner sc, String mensaje, int minimo, int maximo) {
        int valor = minimo - 1;
        while (valor < minimo || valor > maximo) {
            System.out.println(mensaje);
            valor = sc.nextInt();
            sc.nextLine();
            if (valor < minimo || valor > maximo) {
                System.out.println("Debe ingresar un valor entre " + minimo + " y " + maximo + ".");
            }
        }
        return valor;
    }

    // Pide la edad del participante
    public int PedirEdad(Scanner sc) {
        int edad = -1;
        while (edad <= 0 || edad > 110) {
            System.out.println("Ingrese la edad: ");
            edad = sc.nextInt();
            sc.nextLine();
            if (edad <= 0 || edad > 110) {
                System.out.println("La edad debe estar entre 1 y 110.");
            }
        }
        return edad;
    }

    // Pide el resultado obtenido (no puede ser negativo)
    public double PedirResultado(Scanner sc) {
        double resultado = -1;
        while (resultado < 0) {
            System.out.println("Ingrese el resultado obtenido: ");
            resultado = sc.nextDouble();
            sc.nextLine();
            if (resultado < 0) {
                System.out.println("El resultado no puede ser negativo.");
            }
        }
        return resultado;
    }

    // Pide a los organizadores las condiciones de la premiacion
    public void ConfigurarCriterios(Scanner sc) {
        System.out.println("\n===== CONFIGURACION DEL CRITERIO DE PREMIACION =====");
        System.out.println("\nComo se interpreta el resultado?");
        System.out.println(" 1) Gana el resultado MAS ALTO (puntos, goles, distancia)");
        System.out.println(" 2) Gana el resultado MAS BAJO (tiempo, penalizaciones)");
        tipoResultado = PedirOpcion(sc, "Ingrese la opcion: ", 1, 2);

        System.out.println("\nComo se comparan los participantes?");
        System.out.println(" 1) Cada categoria se premia por separado");
        System.out.println(" 2) Todos compiten entre si (general)");
        modoComparacion = PedirOpcion(sc, "Ingrese la opcion: ", 1, 2);

        cantidadMejores = PedirOpcion(sc, "\nCuantos participantes se consideran los mejores? ", 1, 100);

        System.out.println("\nCriterio configurado correctamente.");
    }

    // Registra los participantes en la matriz
    public ObjDeportista[][] LlenarMatriz(ObjDeportista[][] matriz, Scanner sc) {
        if (!CriteriosConfigurados()) {
            System.out.println("\nAun no se ha definido como se eligen los mejores participantes.");
            System.out.println("Debe definirlo para poder registrar la competencia.");
            ConfigurarCriterios(sc);
        }

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.println("\n--- Registro del participante de la posicion [" + i + "][" + j + "] ---\n");
                ObjDeportista d = new ObjDeportista();
                System.out.println("Ingrese el nombre completo: ");
                d.setNombre(sc.nextLine());
                d.setEdad(PedirEdad(sc));
                System.out.println("Ingrese la categoria: ");
                d.setCategoria(sc.nextLine());
                d.setResultado(PedirResultado(sc));
                d.setPuesto(0);
                d.setCondicion("SIN EVALUAR");
                matriz[i][j] = d;
            }
        }
        // Al terminar el registro se calculan de una vez los puestos
        EvaluarMejores(matriz);
        return matriz;
    }

    // Retorna true si el deportista a le gana al deportista b segun el tipo de resultado
    public boolean LeGana(ObjDeportista a, ObjDeportista b) {
        if (tipoResultado == 1) {
            return a.getResultado() > b.getResultado();
        } else {
            return a.getResultado() < b.getResultado();
        }
    }

    // Calcula el puesto de cada participante sin necesidad de ordenar la matriz:
    // el puesto es la cantidad de rivales que lo superan, mas uno.
    // Si el modo es "por categoria" solo se compara con los de su misma categoria.
    public void EvaluarMejores(ObjDeportista[][] matriz) {
        if (!CriteriosConfigurados()) {
            System.out.println("Primero debe configurar el criterio (opcion 4).");
            return;
        }
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (matriz[i][j] != null) {
                    int superan = 0;
                    for (int x = 0; x < matriz.length; x++) {
                        for (int y = 0; y < matriz[0].length; y++) {
                            if (matriz[x][y] != null && matriz[x][y] != matriz[i][j]) {
                                boolean mismoGrupo = true;
                                if (modoComparacion == 1) {
                                    mismoGrupo = matriz[x][y].getCategoria()
                                            .equalsIgnoreCase(matriz[i][j].getCategoria());
                                }
                                if (mismoGrupo && LeGana(matriz[x][y], matriz[i][j])) {
                                    superan++;
                                }
                            }
                        }
                    }
                    matriz[i][j].setPuesto(superan + 1);
                    if ((superan + 1) <= cantidadMejores) {
                        matriz[i][j].setCondicion("MEJOR PARTICIPANTE");
                    } else {
                        matriz[i][j].setCondicion("PARTICIPANTE");
                    }
                }
            }
        }
    }

    // Muestra todos los participantes registrados
    public void MostrarMatriz(ObjDeportista[][] matriz) {
        boolean hayRegistros = false;
        System.out.println("\n===== PARTICIPANTES REGISTRADOS =====");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (matriz[i][j] != null) {
                    hayRegistros = true;
                    System.out.println("\nPosicion [" + i + "][" + j + "]");
                    System.out.println("Nombre: " + matriz[i][j].getNombre());
                    System.out.println("Edad: " + matriz[i][j].getEdad());
                    System.out.println("Categoria: " + matriz[i][j].getCategoria());
                    System.out.println("Resultado: " + matriz[i][j].getResultado());
                    System.out.println("Puesto: " + matriz[i][j].getPuesto());
                    System.out.println("Condicion: " + matriz[i][j].getCondicion());
                }
            }
        }
        if (!hayRegistros) {
            System.out.println("Aun no hay participantes registrados.");
        }
    }

    // Muestra el criterio configurado
    public void MostrarCriterios() {
        System.out.println("\n===== CRITERIO DE PREMIACION ACTUAL =====");
        if (!CriteriosConfigurados()) {
            System.out.println("Sin configurar (use la opcion 4).");
            return;
        }
        if (tipoResultado == 1) {
            System.out.println("- Resultado: gana el mas alto");
        } else {
            System.out.println("- Resultado: gana el mas bajo");
        }
        if (modoComparacion == 1) {
            System.out.println("- Comparacion: cada categoria por separado");
        } else {
            System.out.println("- Comparacion: general, todos contra todos");
        }
        System.out.println("- Se premian los primeros " + cantidadMejores + " puesto(s)");
    }

    // Cambia el criterio y vuelve a calcular los puestos de los ya registrados
    public void ModificarCriterios(ObjDeportista[][] matriz, Scanner sc) {
        ConfigurarCriterios(sc);
        EvaluarMejores(matriz);
        System.out.println("Los puestos se recalcularon con el nuevo criterio.");
    }

    // Muestra los participantes de una categoria puntual
    public void MostrarPorCategoria(ObjDeportista[][] matriz, String categoria) {
        int contador = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (matriz[i][j] != null && matriz[i][j].getCategoria().equalsIgnoreCase(categoria)) {
                    System.out.println("  Puesto " + matriz[i][j].getPuesto() + ") "
                            + matriz[i][j].getNombre()
                            + " | Edad: " + matriz[i][j].getEdad()
                            + " | Resultado: " + matriz[i][j].getResultado());
                    contador++;
                }
            }
        }
        if (contador == 0) {
            System.out.println("  No hay participantes en esa categoria.");
        } else {
            System.out.println("  Total participantes: " + contador);
        }
    }

    // Informe que necesitan los organizadores
    public void ReporteOrganizadores(ObjDeportista[][] matriz) {
        System.out.println("\n===== INFORME PARA LOS ORGANIZADORES =====");

        System.out.println("\n--- 1. Mejores participantes segun el criterio definido ---");
        int premiados = 0;
        // Se imprimen por puesto para que salgan en orden (1ro, 2do, 3ro...)
        for (int puesto = 1; puesto <= matriz.length * matriz[0].length; puesto++) {
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[0].length; j++) {
                    if (matriz[i][j] != null
                            && matriz[i][j].getPuesto() == puesto
                            && matriz[i][j].getCondicion().equalsIgnoreCase("MEJOR PARTICIPANTE")) {
                        System.out.println(" Puesto " + puesto + ": " + matriz[i][j].getNombre()
                                + " | Categoria: " + matriz[i][j].getCategoria()
                                + " | Resultado: " + matriz[i][j].getResultado());
                        premiados++;
                    }
                }
            }
        }
        if (premiados == 0) {
            System.out.println(" No hay participantes evaluados todavia.");
        }

        System.out.println("\n--- 2. Participantes agrupados por categoria ---");
        // Se recorre la matriz y cada categoria se imprime una sola vez
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (matriz[i][j] != null) {
                    boolean yaImpresa = false;
                    for (int x = 0; x <= i; x++) {
                        for (int y = 0; y < matriz[0].length; y++) {
                            if (x < i || y < j) {
                                if (matriz[x][y] != null && matriz[x][y].getCategoria()
                                        .equalsIgnoreCase(matriz[i][j].getCategoria())) {
                                    yaImpresa = true;
                                }
                            }
                        }
                    }
                    if (!yaImpresa) {
                        System.out.println("\n Categoria: " + matriz[i][j].getCategoria());
                        MostrarPorCategoria(matriz, matriz[i][j].getCategoria());
                    }
                }
            }
        }

        System.out.println("\n--- 3. Mejor y peor resultado de toda la competencia ---");
        ObjDeportista mejor = null;
        ObjDeportista peor = null;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (matriz[i][j] != null) {
                    if (mejor == null || LeGana(matriz[i][j], mejor)) {
                        mejor = matriz[i][j];
                    }
                    if (peor == null || LeGana(peor, matriz[i][j])) {
                        peor = matriz[i][j];
                    }
                }
            }
        }
        if (mejor != null) {
            System.out.println(" Mejor resultado: " + mejor.getNombre() + " (" + mejor.getResultado() + ")");
            System.out.println(" Resultado mas bajo: " + peor.getNombre() + " (" + peor.getResultado() + ")");
        } else {
            System.out.println(" No hay registros.");
        }

        System.out.println("\n--- 4. Estadisticas generales ---");
        int total = 0;
        double sumaResultados = 0;
        double sumaEdades = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (matriz[i][j] != null) {
                    total++;
                    sumaResultados = sumaResultados + matriz[i][j].getResultado();
                    sumaEdades = sumaEdades + matriz[i][j].getEdad();
                }
            }
        }
        if (total > 0) {
            System.out.println(" Total participantes: " + total);
            System.out.println(" Promedio de resultados: " + (sumaResultados / total));
            System.out.println(" Promedio de edad: " + (sumaEdades / total));
        } else {
            System.out.println(" No hay participantes registrados.");
        }
    }

}


import java.util.Scanner;

public class MetodoServicio {

    // ---------------------------------------------------------------
    // ANALISIS DEL PROBLEMA
    // El registro que se captura es el SERVICIO, pero lo que la gerencia
    // quiere medir es el EMPLEADO. Por eso hay que agrupar los servicios
    // por empleado antes de poder hablar de desempeño.
    //
    // El enunciado no dice que es "mejor desempeño": puede ser el que mas
    // servicios hace, el que mas dinero factura, el que tiene el mejor
    // promedio por servicio, o una combinacion de cantidad y valor.
    // Por eso el criterio queda en variables que la gerencia configura.
    // Empiezan en -1 = sin configurar.
    // ---------------------------------------------------------------

    private int criterioDesempeno = -1;   // 1=cantidad, 2=valor facturado, 3=promedio por servicio, 4=ponderado
    private double pesoCantidad = -1;     // solo se usa si el criterio es 4 (ya en decimal)
    private double pesoValor = -1;        // solo se usa si el criterio es 4 (ya en decimal)
    private int cantidadDestacados = -1;  // cuantos empleados se consideran de mejor desempeño
    private double metaMinima = -1;       // facturacion minima que debe cumplir un empleado para destacarse

    // Retorna true si la gerencia ya definio las condiciones
    public boolean CriteriosConfigurados() {
        if (criterioDesempeno == -1 || cantidadDestacados == -1 || metaMinima == -1) {
            return false;
        }
        if (criterioDesempeno == 4 && (pesoCantidad == -1 || pesoValor == -1)) {
            return false;
        }
        return true;
    }

    // Preguntas que se le deben hacer a la gerencia
    public void PreguntasGerencia() {
        System.out.println("\n===== PREGUNTAS PARA LA GERENCIA =====");
        System.out.println("1) Que significa 'mejor desempeño': hacer mas servicios, facturar mas dinero,");
        System.out.println("   o tener el mejor promedio de valor por servicio?");
        System.out.println("2) Si son varios factores a la vez, que peso tiene cada uno?");
        System.out.println("3) Existe una meta minima de facturacion que el empleado deba cumplir?");
        System.out.println("4) Cuantos empleados se deben destacar en el informe?");
        System.out.println("5) Todos los tipos de servicio valen igual o unos pesan mas que otros?");
        System.out.println("6) Se mide todo el mes completo o solo un rango de fechas?");
        System.out.println("7) Se tiene en cuenta la cantidad de clientes distintos que atendio el empleado?");
        System.out.println("\nRESPUESTA ASUMIDA EN ESTE PROGRAMA:");
        System.out.println("El criterio no queda fijo. En la opcion 4 la gerencia elige el factor de medicion,");
        System.out.println("los pesos (si es ponderado), la meta minima y cuantos empleados se destacan.");
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

    // Pide un valor de dinero mayor que 0
    public double PedirValor(Scanner sc, String mensaje) {
        double valor = -1;
        while (valor <= 0) {
            System.out.println(mensaje);
            valor = sc.nextDouble();
            sc.nextLine();
            if (valor <= 0) {
                System.out.println("El valor debe ser mayor que 0.");
            }
        }
        return valor;
    }

    // Pide un valor de dinero que puede ser 0 (para la meta minima)
    public double PedirMeta(Scanner sc) {
        double valor = -1;
        while (valor < 0) {
            System.out.println("Meta minima de facturacion por empleado (0 si no aplica): ");
            valor = sc.nextDouble();
            sc.nextLine();
            if (valor < 0) {
                System.out.println("La meta no puede ser negativa.");
            }
        }
        return valor;
    }

    // Pide a la gerencia como se mide el desempeño
    public void ConfigurarCriterios(Scanner sc) {
        System.out.println("\n===== CONFIGURACION DEL CRITERIO DE DESEMPEÑO =====");
        System.out.println("\nComo se mide el desempeño de un empleado?");
        System.out.println(" 1) Por la cantidad de servicios realizados");
        System.out.println(" 2) Por el valor total facturado");
        System.out.println(" 3) Por el promedio de valor por servicio");
        System.out.println(" 4) Ponderado entre cantidad y valor facturado");
        criterioDesempeno = PedirOpcion(sc, "Ingrese la opcion: ", 1, 4);

        if (criterioDesempeno == 4) {
            int peso = PedirOpcion(sc, "\nQue porcentaje pesa la CANTIDAD de servicios (0 a 100)? ", 0, 100);
            pesoCantidad = peso / 100.0;
            pesoValor = 1 - pesoCantidad;
            System.out.println("Entonces el valor facturado pesa " + (pesoValor * 100) + "%.");
        } else {
            pesoCantidad = 0;
            pesoValor = 0;
        }

        metaMinima = PedirMeta(sc);
        cantidadDestacados = PedirOpcion(sc, "Cuantos empleados se deben destacar? ", 1, 100);
        System.out.println("\nCriterio configurado correctamente.");
    }

    // Registra los servicios del mes en la matriz
    public ObjServicio[][] LlenarMatriz(ObjServicio[][] matriz, Scanner sc) {
        if (!CriteriosConfigurados()) {
            System.out.println("\nAun no se ha definido como se mide el desempeño.");
            System.out.println("Debe definirlo para poder registrar los servicios.");
            ConfigurarCriterios(sc);
        }

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.println("\n--- Registro del servicio de la posicion [" + i + "][" + j + "] ---\n");
                ObjServicio s = new ObjServicio();
                System.out.println("Ingrese el nombre del cliente: ");
                s.setCliente(sc.nextLine());
                System.out.println("Ingrese el empleado responsable: ");
                s.setEmpleado(sc.nextLine());
                System.out.println("Ingrese el tipo de servicio: ");
                s.setTipo_servicio(sc.nextLine());
                System.out.println("Ingrese la fecha (dd/mm/aaaa): ");
                s.setFecha(sc.nextLine());
                s.setValor(PedirValor(sc, "Ingrese el valor del servicio: "));
                matriz[i][j] = s;
            }
        }
        return matriz;
    }

    // Muestra todos los servicios registrados
    public void MostrarMatriz(ObjServicio[][] matriz) {
        boolean hayRegistros = false;
        System.out.println("\n===== SERVICIOS REGISTRADOS =====");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (matriz[i][j] != null) {
                    hayRegistros = true;
                    System.out.println("\nPosicion [" + i + "][" + j + "]");
                    System.out.println("Cliente: " + matriz[i][j].getCliente());
                    System.out.println("Empleado: " + matriz[i][j].getEmpleado());
                    System.out.println("Tipo de servicio: " + matriz[i][j].getTipo_servicio());
                    System.out.println("Fecha: " + matriz[i][j].getFecha());
                    System.out.println("Valor: $" + matriz[i][j].getValor());
                }
            }
        }
        if (!hayRegistros) {
            System.out.println("Aun no hay servicios registrados.");
        }
    }

    // Muestra el criterio configurado
    public void MostrarCriterios() {
        System.out.println("\n===== CRITERIO DE DESEMPEÑO ACTUAL =====");
        if (!CriteriosConfigurados()) {
            System.out.println("Sin configurar (use la opcion 4).");
            return;
        }
        if (criterioDesempeno == 1) {
            System.out.println("- Medicion: cantidad de servicios realizados");
        } else if (criterioDesempeno == 2) {
            System.out.println("- Medicion: valor total facturado");
        } else if (criterioDesempeno == 3) {
            System.out.println("- Medicion: promedio de valor por servicio");
        } else {
            System.out.println("- Medicion: ponderada");
            System.out.println("  Cantidad de servicios: " + (pesoCantidad * 100) + "%");
            System.out.println("  Valor facturado: " + (pesoValor * 100) + "%");
        }
        System.out.println("- Meta minima de facturacion: $" + metaMinima);
        System.out.println("- Empleados a destacar: " + cantidadDestacados);
    }

    // Cambia el criterio de medicion
    public void ModificarCriterios(Scanner sc) {
        ConfigurarCriterios(sc);
        System.out.println("El informe de desempeño se calculara con el nuevo criterio.");
    }

    // ---------- Metodos de calculo por empleado ----------

    // Cuenta cuantos servicios hizo un empleado
    public int ContarServicios(ObjServicio[][] matriz, String empleado) {
        int contador = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (matriz[i][j] != null && matriz[i][j].getEmpleado().equalsIgnoreCase(empleado)) {
                    contador++;
                }
            }
        }
        return contador;
    }

    // Suma cuanto facturo un empleado
    public double TotalEmpleado(ObjServicio[][] matriz, String empleado) {
        double total = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (matriz[i][j] != null && matriz[i][j].getEmpleado().equalsIgnoreCase(empleado)) {
                    total = total + matriz[i][j].getValor();
                }
            }
        }
        return total;
    }

    // Promedio de valor por servicio de un empleado
    public double PromedioEmpleado(ObjServicio[][] matriz, String empleado) {
        int cantidad = ContarServicios(matriz, empleado);
        if (cantidad == 0) {
            return 0;
        }
        return TotalEmpleado(matriz, empleado) / cantidad;
    }

    // Mayor cantidad de servicios hecha por un solo empleado (sirve para normalizar el ponderado)
    public int MaxCantidad(ObjServicio[][] matriz) {
        int maximo = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (matriz[i][j] != null) {
                    int cantidad = ContarServicios(matriz, matriz[i][j].getEmpleado());
                    if (cantidad > maximo) {
                        maximo = cantidad;
                    }
                }
            }
        }
        return maximo;
    }

    // Mayor facturacion lograda por un solo empleado
    public double MaxTotal(ObjServicio[][] matriz) {
        double maximo = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (matriz[i][j] != null) {
                    double total = TotalEmpleado(matriz, matriz[i][j].getEmpleado());
                    if (total > maximo) {
                        maximo = total;
                    }
                }
            }
        }
        return maximo;
    }

    // Calcula el puntaje de desempeño del empleado segun el criterio configurado.
    // En el modo ponderado los dos factores se llevan a una escala de 0 a 100
    // dividiendolos por el mejor del grupo, porque cantidad y dinero no se pueden sumar directo.
    public double PuntajeEmpleado(ObjServicio[][] matriz, String empleado) {
        if (criterioDesempeno == 1) {
            return ContarServicios(matriz, empleado);
        } else if (criterioDesempeno == 2) {
            return TotalEmpleado(matriz, empleado);
        } else if (criterioDesempeno == 3) {
            return PromedioEmpleado(matriz, empleado);
        } else {
            int maxCant = MaxCantidad(matriz);
            double maxTot = MaxTotal(matriz);
            double parteCantidad = 0;
            double parteValor = 0;
            if (maxCant > 0) {
                parteCantidad = (ContarServicios(matriz, empleado) * 100.0 / maxCant) * pesoCantidad;
            }
            if (maxTot > 0) {
                parteValor = (TotalEmpleado(matriz, empleado) * 100.0 / maxTot) * pesoValor;
            }
            return parteCantidad + parteValor;
        }
    }

    // Retorna true si esta es la primera vez que aparece ese empleado en la matriz.
    // Sirve para recorrer empleados sin repetirlos.
    public boolean EsPrimerRegistro(ObjServicio[][] matriz, int fila, int columna) {
        for (int x = 0; x < matriz.length; x++) {
            for (int y = 0; y < matriz[0].length; y++) {
                if (x < fila || (x == fila && y < columna)) {
                    if (matriz[x][y] != null && matriz[x][y].getEmpleado()
                            .equalsIgnoreCase(matriz[fila][columna].getEmpleado())) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    // Puesto del empleado: cuantos empleados distintos tienen mejor puntaje, mas uno
    public int PuestoEmpleado(ObjServicio[][] matriz, String empleado) {
        double miPuntaje = PuntajeEmpleado(matriz, empleado);
        int superan = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (matriz[i][j] != null && EsPrimerRegistro(matriz, i, j)
                        && !matriz[i][j].getEmpleado().equalsIgnoreCase(empleado)) {
                    if (PuntajeEmpleado(matriz, matriz[i][j].getEmpleado()) > miPuntaje) {
                        superan++;
                    }
                }
            }
        }
        return superan + 1;
    }

    // ---------- Informe ----------

    public void ReporteGerencia(ObjServicio[][] matriz) {
        if (!CriteriosConfigurados()) {
            System.out.println("Primero debe configurar el criterio de desempeño (opcion 4).");
            return;
        }
        System.out.println("\n===== INFORME DE DESEMPEÑO PARA LA GERENCIA =====");

        System.out.println("\n--- 1. Resumen por empleado ---");
        int empleados = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (matriz[i][j] != null && EsPrimerRegistro(matriz, i, j)) {
                    String nombre = matriz[i][j].getEmpleado();
                    System.out.println(" " + nombre
                            + " | Servicios: " + ContarServicios(matriz, nombre)
                            + " | Facturado: $" + TotalEmpleado(matriz, nombre)
                            + " | Promedio: $" + PromedioEmpleado(matriz, nombre)
                            + " | Puntaje: " + PuntajeEmpleado(matriz, nombre)
                            + " | Puesto: " + PuestoEmpleado(matriz, nombre));
                    empleados++;
                }
            }
        }
        if (empleados == 0) {
            System.out.println(" No hay servicios registrados.");
            return;
        }

        System.out.println("\n--- 2. Empleados con mejor desempeño ---");
        int destacados = 0;
        for (int puesto = 1; puesto <= empleados; puesto++) {
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[0].length; j++) {
                    if (matriz[i][j] != null && EsPrimerRegistro(matriz, i, j)) {
                        String nombre = matriz[i][j].getEmpleado();
                        if (PuestoEmpleado(matriz, nombre) == puesto && puesto <= cantidadDestacados) {
                            if (TotalEmpleado(matriz, nombre) >= metaMinima) {
                                System.out.println(" Puesto " + puesto + ": " + nombre
                                        + " | Puntaje: " + PuntajeEmpleado(matriz, nombre));
                            } else {
                                System.out.println(" Puesto " + puesto + ": " + nombre
                                        + " | NO SE DESTACA: no alcanzo la meta minima de $" + metaMinima);
                            }
                            destacados++;
                        }
                    }
                }
            }
        }
        if (destacados == 0) {
            System.out.println(" Ningun empleado cumple el criterio definido.");
        }

        System.out.println("\n--- 3. Servicios por tipo ---");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (matriz[i][j] != null) {
                    // el tipo se imprime una sola vez
                    boolean yaImpreso = false;
                    for (int x = 0; x < matriz.length; x++) {
                        for (int y = 0; y < matriz[0].length; y++) {
                            if (x < i || (x == i && y < j)) {
                                if (matriz[x][y] != null && matriz[x][y].getTipo_servicio()
                                        .equalsIgnoreCase(matriz[i][j].getTipo_servicio())) {
                                    yaImpreso = true;
                                }
                            }
                        }
                    }
                    if (!yaImpreso) {
                        String tipo = matriz[i][j].getTipo_servicio();
                        int cantidad = 0;
                        double valorTipo = 0;
                        for (int x = 0; x < matriz.length; x++) {
                            for (int y = 0; y < matriz[0].length; y++) {
                                if (matriz[x][y] != null
                                        && matriz[x][y].getTipo_servicio().equalsIgnoreCase(tipo)) {
                                    cantidad++;
                                    valorTipo = valorTipo + matriz[x][y].getValor();
                                }
                            }
                        }
                        System.out.println(" " + tipo + ": " + cantidad + " servicio(s) | $" + valorTipo);
                    }
                }
            }
        }

        System.out.println("\n--- 4. Cliente que mas contrato en el mes ---");
        ObjServicio mejorCliente = null;
        double mayorGasto = -1;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (matriz[i][j] != null) {
                    double gasto = 0;
                    for (int x = 0; x < matriz.length; x++) {
                        for (int y = 0; y < matriz[0].length; y++) {
                            if (matriz[x][y] != null && matriz[x][y].getCliente()
                                    .equalsIgnoreCase(matriz[i][j].getCliente())) {
                                gasto = gasto + matriz[x][y].getValor();
                            }
                        }
                    }
                    if (gasto > mayorGasto) {
                        mayorGasto = gasto;
                        mejorCliente = matriz[i][j];
                    }
                }
            }
        }
        System.out.println(" " + mejorCliente.getCliente() + " con $" + mayorGasto);

        System.out.println("\n--- 5. Totales del mes ---");
        int totalServicios = 0;
        double totalFacturado = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (matriz[i][j] != null) {
                    totalServicios++;
                    totalFacturado = totalFacturado + matriz[i][j].getValor();
                }
            }
        }
        System.out.println(" Servicios realizados: " + totalServicios);
        System.out.println(" Empleados que participaron: " + empleados);
        System.out.println(" Total facturado en el mes: $" + totalFacturado);
    }

}

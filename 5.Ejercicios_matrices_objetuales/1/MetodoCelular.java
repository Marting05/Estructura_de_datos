import java.util.Scanner;
 
public class MetodoCelular {
 
    // ---------------------------------------------------------------
    // ANALISIS DEL PROBLEMA
    // El enunciado NO define cuando un celular debe entrar en promocion,
    // por eso el criterio NO se deja quemado en el codigo: se guarda en
    // variables que el gerente configura desde el menu (opcion 4).
    // Empiezan en -1, que significa "sin configurar".
    // ---------------------------------------------------------------
 
    private int stockMinimo = -1;          // desde cuantas unidades se considera exceso de inventario
    private double precioMinimo = -1;      // desde que precio se considera equipo de baja rotacion
    private double descuentoPromocion = -1;// porcentaje de descuento que se aplica (ya en decimal)
    private int tipoCriterio = -1;         // 1=solo stock, 2=solo precio, 3=stock Y precio, 4=stock O precio
 
    // Retorna true si el gerente ya definio todas las condiciones
    public boolean CriteriosConfigurados() {
        return stockMinimo != -1 && precioMinimo != -1
                && descuentoPromocion != -1 && tipoCriterio != -1;
    }
 
    // Preguntas que se le deben hacer al gerente antes de programar
    public void PreguntasAlGerente() {
        System.out.println("\n===== PREGUNTAS QUE SE LE DEBEN HACER AL GERENTE =====");
        System.out.println("1) Que significa para la empresa que un celular 'deba promocionarse':");
        System.out.println("   se quiere sacar inventario acumulado o impulsar equipos de alto valor?");
        System.out.println("2) A partir de cuantas unidades disponibles se considera que hay exceso de stock?");
        System.out.println("3) A partir de que precio se considera que un equipo es de baja rotacion?");
        System.out.println("4) Las dos condiciones se deben cumplir al mismo tiempo o basta con una sola?");
        System.out.println("5) Que porcentaje de descuento se aplica a los equipos promocionados?");
        System.out.println("6) El descuento es igual para todas las marcas o cambia segun la marca?");
        System.out.println("7) Las caracteristicas del equipo influyen en la decision o son solo informativas?");
        System.out.println("\nRESPUESTA ASUMIDA EN ESTE PROGRAMA:");
        System.out.println("El criterio no se fija en el codigo. El gerente lo define en la opcion 4");
        System.out.println("(stock minimo, precio minimo, si se exige una o las dos condiciones y el descuento).");
    }
 
    // Pide un valor de dinero valido (mayor que 0)
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
 
    // Pide una cantidad entera valida (mayor o igual a 0)
    public int PedirEntero(Scanner sc, String mensaje) {
        int valor = -1;
        while (valor < 0) {
            System.out.println(mensaje);
            valor = sc.nextInt();
            sc.nextLine();
            if (valor < 0) {
                System.out.println("La cantidad no puede ser negativa.");
            }
        }
        return valor;
    }
 
    // Pide un porcentaje entre 0 y 100 y lo retorna en decimal (20 -> 0.20)
    public double PedirDescuento(Scanner sc) {
        double porcentaje = -1;
        while (porcentaje <= 0 || porcentaje > 100) {
            System.out.println("Ingrese el porcentaje de descuento de la promocion (ej: 15 para 15%): ");
            porcentaje = sc.nextDouble();
            sc.nextLine();
            if (porcentaje <= 0 || porcentaje > 100) {
                System.out.println("El porcentaje debe estar entre 1 y 100.");
            }
        }
        return porcentaje / 100;
    }
 
    // Pide como se deben combinar las condiciones
    public int PedirTipoCriterio(Scanner sc) {
        int tipo = -1;
        while (tipo < 1 || tipo > 4) {
            System.out.println("\nComo se decide que un celular entra en promocion?");
            System.out.println(" 1) Solo por exceso de inventario (cantidad disponible)");
            System.out.println(" 2) Solo por precio alto");
            System.out.println(" 3) Debe cumplir las DOS condiciones");
            System.out.println(" 4) Basta con cumplir UNA de las dos");
            System.out.println("Ingrese la opcion: ");
            tipo = sc.nextInt();
            sc.nextLine();
            if (tipo < 1 || tipo > 4) {
                System.out.println("Opcion no valida.");
            }
        }
        return tipo;
    }
 
    // Pide al gerente todas las condiciones de la promocion
    public void ConfigurarCriterios(Scanner sc) {
        System.out.println("\n===== CONFIGURACION DEL CRITERIO DE PROMOCION =====");
        tipoCriterio = PedirTipoCriterio(sc);
        stockMinimo = PedirEntero(sc, "Cantidad minima disponible para considerarlo exceso de inventario: ");
        precioMinimo = PedirValor(sc, "Precio minimo para considerarlo equipo de baja rotacion: ");
        descuentoPromocion = PedirDescuento(sc);
        System.out.println("\nCriterio configurado correctamente.");
    }
 
    // Aplica el criterio configurado sobre un celular y calcula su precio promocional
    public void EvaluarPromocion(ObjCelular c) {
        boolean porStock = c.getCantidad_disponible() >= stockMinimo;
        boolean porPrecio = c.getPrecio() >= precioMinimo;
        boolean promocionar = false;
 
        if (tipoCriterio == 1) {
            promocionar = porStock;
        } else if (tipoCriterio == 2) {
            promocionar = porPrecio;
        } else if (tipoCriterio == 3) {
            promocionar = porStock && porPrecio;
        } else if (tipoCriterio == 4) {
            promocionar = porStock || porPrecio;
        }
 
        if (promocionar) {
            c.setEstado_promocion("PROMOCIONAR");
            c.setDescuento(descuentoPromocion);
            c.setPrecio_promocion(c.getPrecio() * (1 - descuentoPromocion));
        } else {
            c.setEstado_promocion("PRECIO NORMAL");
            c.setDescuento(0.0);
            c.setPrecio_promocion(c.getPrecio());
        }
    }
 
    // Registra los celulares en la matriz
    public ObjCelular[][] LlenarMatriz(ObjCelular[][] matriz, Scanner sc) {
        if (!CriteriosConfigurados()) {
            System.out.println("\nAun no se ha definido el criterio de promocion.");
            System.out.println("Debe definirlo para poder registrar los celulares.");
            ConfigurarCriterios(sc);
        }
 
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.println("\n--- Registro del celular de la posicion [" + i + "][" + j + "] ---\n");
                ObjCelular c = new ObjCelular();
                System.out.println("Ingrese el modelo: ");
                c.setModelo(sc.nextLine());
                System.out.println("Ingrese la marca: ");
                c.setMarca(sc.nextLine());
                c.setPrecio(PedirValor(sc, "Ingrese el precio: "));
                c.setCantidad_disponible(PedirEntero(sc, "Ingrese la cantidad disponible: "));
                System.out.println("Ingrese las caracteristicas: ");
                c.setCaracteristicas(sc.nextLine());
 
                EvaluarPromocion(c);
                matriz[i][j] = c;
            }
        }
        return matriz;
    }
 
    // Muestra todos los celulares registrados
    public void MostrarMatriz(ObjCelular[][] matriz) {
        boolean hayRegistros = false;

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (matriz[i][j] != null) {
                    hayRegistros = true;
                    System.out.println("Modelo: " + matriz[i][j].getModelo());
                    System.out.println("Marca: " + matriz[i][j].getMarca());
                    System.out.println("Precio: $" + matriz[i][j].getPrecio());
                    System.out.println("Cantidad disponible: " + matriz[i][j].getCantidad_disponible());
                    System.out.println("Caracteristicas: " + matriz[i][j].getCaracteristicas());
                    System.out.println("Estado: " + matriz[i][j].getEstado_promocion());
                    System.out.println("Descuento: " + (matriz[i][j].getDescuento() * 100) + "%");
                    System.out.println("Precio con promocion: $" + matriz[i][j].getPrecio_promocion());
                    System.out.println("----------------------------------------------------");
                }
            }
            System.out.println();
        }
        if (!hayRegistros) {
            System.out.println("Aun no hay celulares registrados.");
        }
    }
 
    // Muestra el criterio configurado
    public void MostrarCriterios() {
        System.out.println("\n===== CRITERIO DE PROMOCION ACTUAL =====");
        if (!CriteriosConfigurados()) {
            System.out.println("Sin configurar (use la opcion 4).");
            return;
        }
        if (tipoCriterio == 1) {
            System.out.println("- Regla: solo por exceso de inventario");
        } else if (tipoCriterio == 2) {
            System.out.println("- Regla: solo por precio alto");
        } else if (tipoCriterio == 3) {
            System.out.println("- Regla: debe cumplir stock Y precio");
        } else {
            System.out.println("- Regla: basta con cumplir stock O precio");
        }
        System.out.println("- Stock minimo: " + stockMinimo + " unidades");
        System.out.println("- Precio minimo: $" + precioMinimo);
        System.out.println("- Descuento: " + (descuentoPromocion * 100) + "%");
    }
 
    // Permite cambiar el criterio y reevalua los celulares ya registrados
    public void ModificarCriterios(ObjCelular[][] matriz, Scanner sc) {
        ConfigurarCriterios(sc);
        int reevaluados = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (matriz[i][j] != null) {
                    EvaluarPromocion(matriz[i][j]);
                    reevaluados++;
                }
            }
        }
        System.out.println("Se reevaluaron " + reevaluados + " celular(es) con el nuevo criterio.");
    }
 
    // Reporte que responde al requerimiento del gerente
    public void ReporteGerencia(ObjCelular[][] matriz) {
        System.out.println("\n===== INFORME PARA LA GERENCIA =====");
 
        System.out.println("\n--- 1. Celulares que deben promocionarse ---");
        int enPromocion = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (matriz[i][j] != null && matriz[i][j].getEstado_promocion().equalsIgnoreCase("PROMOCIONAR")) {
                    System.out.println(" " + matriz[i][j].getMarca() + " " + matriz[i][j].getModelo()
                            + " | Precio: $" + matriz[i][j].getPrecio()
                            + " | Stock: " + matriz[i][j].getCantidad_disponible()
                            + " | Promocion: $" + matriz[i][j].getPrecio_promocion());
                    enPromocion++;
                }
            }
        }
        if (enPromocion == 0) {
            System.out.println(" Ningun celular cumple el criterio definido.");
        } else {
            System.out.println(" Total en promocion: " + enPromocion);
        }
 
        System.out.println("\n--- 2. Celulares que se quedan a precio normal ---");
        int normales = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (matriz[i][j] != null && matriz[i][j].getEstado_promocion().equalsIgnoreCase("PRECIO NORMAL")) {
                    System.out.println(" " + matriz[i][j].getMarca() + " " + matriz[i][j].getModelo());
                    normales++;
                }
            }
        }
        if (normales == 0) {
            System.out.println(" No hay celulares a precio normal.");
        }
 
        System.out.println("\n--- 3. Celular mas costoso y mas economico ---");
        ObjCelular masCaro = null;
        ObjCelular masBarato = null;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (matriz[i][j] != null) {
                    if (masCaro == null || matriz[i][j].getPrecio() > masCaro.getPrecio()) {
                        masCaro = matriz[i][j];
                    }
                    if (masBarato == null || matriz[i][j].getPrecio() < masBarato.getPrecio()) {
                        masBarato = matriz[i][j];
                    }
                }
            }
        }
        if (masCaro != null) {
            System.out.println(" Mas costoso: " + masCaro.getMarca() + " " + masCaro.getModelo()
                    + " ($" + masCaro.getPrecio() + ")");
            System.out.println(" Mas economico: " + masBarato.getMarca() + " " + masBarato.getModelo()
                    + " ($" + masBarato.getPrecio() + ")");
        } else {
            System.out.println(" No hay registros.");
        }
 
        System.out.println("\n--- 4. Valor del inventario ---");
        double valorNormal = 0;
        double valorPromocion = 0;
        int unidades = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (matriz[i][j] != null) {
                    valorNormal = valorNormal + (matriz[i][j].getPrecio() * matriz[i][j].getCantidad_disponible());
                    valorPromocion = valorPromocion + (matriz[i][j].getPrecio_promocion() * matriz[i][j].getCantidad_disponible());
                    unidades = unidades + matriz[i][j].getCantidad_disponible();
                }
            }
        }
        System.out.println(" Unidades totales en inventario: " + unidades);
        System.out.println(" Valor a precio normal: $" + valorNormal);
        System.out.println(" Valor aplicando las promociones: $" + valorPromocion);
        System.out.println(" Descuento total otorgado: $" + (valorNormal - valorPromocion));
    }
 
}
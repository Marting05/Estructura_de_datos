
import java.util.Scanner;

public class Metodo {

     // Valores y descuentos de los planes: variables simples
    // Empiezan en -1, que significa "sin configurar": el usuario debe ingresarlos antes de poder registrar el primer vehiculo.
    private double valorQuincenal = -1;
    private double descuentoQuincenal = -1;
    private double valorMensual = -1;
    private double descuentoMensual = -1;
    private double valorTrimestral = -1;
    private double descuentoTrimestral = -1;

    // Retorna true si el usuario ya ingreso todos los valores y descuentos
    public boolean PlanesConfigurados(){
        return valorQuincenal != -1 && descuentoQuincenal != -1
        && valorMensual != -1 && descuentoMensual != -1
        && valorTrimestral != -1 && descuentoTrimestral != -1;
    }

    // Pide un valor de plan valido (mayor que 0)
    public double PedirValor(Scanner sc){
        double valor = -1;
        while(valor <= 0){
            System.out.println("Ingrese el valor del plan: ");
            valor = sc.nextDouble();
            sc.nextLine(); //limpiar el salto de linea pendiente
            if(valor <=0){
                System.out.println("El valor debe ser mayor que 0.");
            }
        }
        return valor;
    }

    // Pide un porcentaje de descuento valido (entre 0 y 100) y lo retorna ya convertido a decimal (20 -> 0.20)
    public double PedirDescuento(Scanner sc){
        double porcentaje = -1;
        while (porcentaje <0 || porcentaje >100){
            System.out.println("Ingrese el porcentaje de descuento (ej: 20 para 20%): ");
            porcentaje = sc.nextDouble();
            sc.nextLine();
            if(porcentaje <0 || porcentaje >100){
                System.out.println("El porcentaje debe estar entre o y 100.");
            }
        }
        return porcentaje / 100;
    }

    // Pide al usuario el valor y el descuento de cada plan
    public void ConfigurarPlanes(Scanner sc){
        System.out.println("\n========= CONFIGURACION DE PLANES =========");
        System.out.println("\nPlan Quincenal:");
        valorQuincenal = PedirValor(sc);
        descuentoQuincenal = PedirDescuento(sc);
        System.out.println("\nPlan Mensual:");
        valorMensual = PedirValor(sc);
        descuentoMensual = PedirDescuento(sc);
        System.out.println("\nPlan Trimestral:");
        valorTrimestral = PedirValor(sc);
        descuentoTrimestral = PedirDescuento(sc);
        System.out.println("\nPlanes configurados correctamente.");
    }


    public ObjVehiculo[][] LlenarMatriz(ObjVehiculo[][] matriz, Scanner sc){
        // Antes de registrar el primer vehiculo se valida que los planes
        // ya tengan valor y descuento; si no, se le piden al usuario
        if(!PlanesConfigurados()){
            System.out.println("\nAun no se han ingresado los valores y descuentos de los planes.");
            System.out.println("Debe ingresarlos para poder registrar los vehiculos.");
            ConfigurarPlanes(sc);
        }

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.println("\n--- Registro del vehiculo de la posición ["+i+"]["+j+"]---\n");
                sc.nextLine();
                ObjVehiculo m = new ObjVehiculo();
                System.out.println("Ingrese la marca del vehiculo: ");
                m.setVehiculo(sc.nextLine());
                System.out.println("Ingrese su nombre completo: ");
                m.setPropietario(sc.nextLine());
                System.out.println("Ingrese el tipo del vehiculo (Carro/Moto): ");
                m.setTipo_vehiculo(sc.nextLine());

                // Se repite la pregunta hasta que el plan sea valido,para evitar que Valor_plan quede en null.
                //Los valores se toman de las variables de los planes.
                Boolean planValido = false;
                while(!planValido){
                    System.out.println("Ingrese el plan contratado (Mensual/Quincenal/Trimestral): ");
                    m.setPlan_contratado(sc.nextLine());
                    if(m.getPlan_contratado().equalsIgnoreCase("Quincenal")){
                        m.setValor_plan(valorQuincenal);
                        m.setDescuento(descuentoQuincenal);
                        planValido = true;
                    } else if (m.getPlan_contratado().equalsIgnoreCase("Mensual")){
                        m.setValor_plan(valorMensual);
                        m.setDescuento(descuentoMensual);
                        planValido = true;
                    } else if(m.getPlan_contratado().equalsIgnoreCase("Trimestal")){
                        m.setValor_plan(valorTrimestral);
                        m.setDescuento(descuentoTrimestral);
                        planValido = true;
                    } else{
                        System.out.println("Plan no valido, intente de nuevo.");
                    }
                }
                m.setTotal_pagar(m.getValor_plan()*(1-m.getDescuento()));
                matriz[i][j] = m;
            }
        }
        return matriz;
    }

    public void MostrarMatriz(ObjVehiculo[][] matriz){
        boolean hayRegistos = false;
        System.out.println("\n=====Vehiculos Registrados====="); 
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if(matriz[i][j] != null){
                    hayRegistos = true;
                    System.out.println("Vehiculo: "+matriz[i][j].getVehiculo());
                    System.out.println("Propietario: "+matriz[i][j].getPropietario());
                    System.out.println("Tipo vehiculo: "+matriz[i][j].getTipo_vehiculo());
                    System.out.println("Plan contratado: "+matriz[i][j].getPlan_contratado());
                    System.out.println("Valor del plan: "+matriz[i][j].getValor_plan());
                    System.out.println("Descuento: "+(matriz[i][j].getDescuento()*100)+"%");
                    System.out.println("Total a pagar: "+matriz[i][j].getTotal_pagar());                    
                }
            }
        }
        if(!hayRegistos){
            System.out.println("Aun no hay vehiculos registrados.");
        }
    }

    // Imprime la linea de un plan, o SIN CONFIGURAR si aun no tiene valores
    public void MostrarUnPlan(String nombre, double valor, double descuento){
        if(valor == -1){
            System.out.println("- "+nombre+"| sin configurar (use la opción 4)");
        }else{
            System.out.println("- "+nombre+" | Valor: $"+valor+" | Descuento: "+(descuento*100)+"%");
        }
    }

    // Opcion 3: muestra los planes de pago con su tarifa y descuento actual
    public void MostrarPlanes(){
        System.out.println("\n========= PLANES DE PAGO =========");
        MostrarUnPlan("Quincenal", valorQuincenal, descuentoQuincenal);
        MostrarUnPlan("Mensual", valorMensual, descuentoMensual);
        MostrarUnPlan("Trimestral", valorTrimestral, descuentoTrimestral);
    }


    // Opcion 4: si los planes aun no tienen valores, los pide todos;
    // si ya estan configurados, permite modificar el que el usuario elija
    public void ModificarPlanes(Scanner sc){
        if(!PlanesConfigurados()){
            ConfigurarPlanes(sc);
            return;
        }
        MostrarPlanes();
        System.out.println("\nIngrese el nombre del plan a modificar: ");
        String nombre = sc.nextLine();
        if(nombre.equalsIgnoreCase("Quincenal")){
            valorQuincenal = PedirValor(sc);
            descuentoQuincenal = PedirDescuento(sc);
        } else if(nombre.equalsIgnoreCase("Mensual")){
            valorMensual = PedirValor(sc);
            descuentoMensual = PedirDescuento(sc);
        } else if(nombre.equalsIgnoreCase("Trimestral")){
            valorTrimestral = PedirValor(sc);
            descuentoTrimestral = PedirDescuento(sc);
        } else{
            System.out.println("Ese plan no existe.");
            return;
        }
        System.out.println("Plan "+nombre+" actualizado.");
        System.out.println("Nota: aplica para los vehiculos que se registren de ahora en adelante.");
    }

    // Muestra los vehiculos de un tipo (Carro o Moto) recorriendo la matriz
    public void MostrarPorTipo(ObjVehiculo[][] matriz, String tipo){
        int contador = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if(matriz[i][j] != null && matriz[i][j].getTipo_vehiculo().equalsIgnoreCase(tipo)){
                    System.out.println(" "+contador+") "+matriz[i][j].getVehiculo()+
                                        " - Propietario: "+matriz[i][j].getPropietario()+
                                        " - Posición ["+i+"]["+j+"]");
                    contador++;
                }
            }
        }
        if(contador == 0){
            System.out.println("No hay registros de tipo "+tipo+".");
        } else{
            System.out.println("Total "+tipo+" s: "+contador);
        }
    }

    // Opcion 5: reportes que necesita la administracion al finalizar el proceso
    public void ReporteAdministracion(ObjVehiculo[][] matriz){
        System.out.println("\n========= REPORTES DE ADMINISTRACION =========");
        System.out.println("\n--- 1. Carros registrados ---");
        MostrarPorTipo(matriz, "Carro");
        System.out.println("\n--- 2. Motos registradas ---");
        MostrarPorTipo(matriz, "Moto");
        System.out.println("\n--- 3. Propietarios de los vehiculos ---");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if(matriz[i][j] != null){
                    System.out.println(" "+matriz[i][j].getPropietario()+" ("+matriz[i][j].getVehiculo()+")");
                }
            }
        }
        System.out.println("\n--- 4. Planes contratados ---");
        // Contadores simples (variables), uno por plan
        int contQuincenal = 0;
        int contMensual = 0;
        int contTrimestral = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (matriz[i][j] != null){
                    if(matriz[i][j].getPlan_contratado().equalsIgnoreCase("Quincenal")){
                        contQuincenal++;
                    } else if(matriz[i][j].getPlan_contratado().equalsIgnoreCase("Mensual")){
                        contMensual++;
                    } else if(matriz[i][j].getPlan_contratado().equalsIgnoreCase("Trimestral")){
                        contTrimestral++;
                    }
                }
            }
        }
        System.out.println("  Plan Quincenal: " + contQuincenal + " vehiculo(s)");
        System.out.println("  Plan Mensual: " + contMensual + " vehiculo(s)");
        System.out.println("  Plan Trimestral: " + contTrimestral + " vehiculo(s)");

        System.out.println("\n--- 5. Total a pagar por cada cliente ---");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if(matriz[i][j] != null){
                    System.out.println(" "+matriz[i][j].getPropietario()
                                        +" debe pagar: "+matriz[i][j].getTotal_pagar());
                }
            }
        }

        System.out.println("\n--- 6. Dinero total recaudado ---");
        double recaudo = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if(matriz[i][j] != null){
                    recaudo = recaudo + matriz[i][j].getTotal_pagar();
                }
            }
        }
        System.out.println(" El parqueadero recaudo en total: $"+recaudo);
    }

}

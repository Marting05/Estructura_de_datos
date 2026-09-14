package Vista;

import java.util.Scanner;
import java.util.Stack;
import Modelo.Objeto;
import Validaciones.Validaciones;
import java.util.UUID;

public class Metodos {
    Scanner sc = new Scanner(System.in);

    public Stack<Objeto> LLenarDatos(Stack<Objeto> p) {
        boolean continuar = true;
        Validaciones v = new Validaciones();
        while (continuar) {
            Objeto o = new Objeto();
            o.setId(UUID.randomUUID());
            System.out.println("Ingrese tipo vehiculo 1) sedan 2) camioneta");
            o.setTipoVehiculo(v.ValidarEntero(sc));
            System.out.println("Ingrese La marca");
            o.setMarca(sc.next());
            System.out.println("Ingrese el color del vehiculo");
            o.setColor(sc.next());
            System.out.println("Ingrese el valor");
            o.setValor(v.ValidarDecimal(sc));
            System.out.println("Ingrese la cedula");
            o.setCedulaPropietario(sc.next());
            System.out.println("Ingrese el nombre del propietario");
            o.setNombrePropietario(sc.next());
            p.push(o);
            System.out.println("Desea seguir ingresando valores 1) si 2) no");
            int opt = v.ValidarEntero(sc);
            if (opt == 2) {
                continuar = false;
            }

        }
        return p;
    }
}

package Validaciones;

import java.util.Scanner;

public class Validaciones {
    public int ValidarEntero(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.println("Por favor Ingrese un digito nuerico");
            sc.next();
        }
        return sc.nextInt();
    }

    public Double ValidarDecimal(Scanner sc) {
        while (!sc.hasNextDouble()) {
            System.out.println("Por favor Ingrese un digito nuerico");
            sc.next();
        }
        return sc.nextDouble();
    }
}

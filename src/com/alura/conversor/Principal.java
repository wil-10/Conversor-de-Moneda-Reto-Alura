package com.alura.conversor;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        int n = 0;
        Scanner teclado = new Scanner(System.in);
        String opciones = """
                 ******************************************
                 1- Dólar Americano a Peso Mexicano       *
                 2- Peso Mexicano a Dólar Americano       *
                 3- Dólar Americano a Colón Costarricense *
                 4- Colón Costarricense a Dólar Americano *
                 5- Dólar Americano a Dólar Canadiense    *
                 6- Dólar Canadiense a Dólar Americano    *
                 7- Salir                                 *
                 ******************************************
                |- SELECCIONE UNA OPCIÓN VÁLIDA -|
                """;
        while (n != 7) {
            System.out.println(opciones);
            n = teclado.nextInt();
            if (n == 7) {
                System.out.println("|Saliendo de la aplicación...Hasta luego|");
                break;
            }
            if(n > 7 || n < 1){
                System.out.println("|No ha introducido una opción válida...Intente de nuevo|");
                continue;
            }
            System.out.println("¿Qué cantidad desea convertir?");
            Double m = teclado.nextDouble();
            Calculos calculo = new Calculos();
            System.out.println(calculo.calculo(n, m));
        }

    }
}

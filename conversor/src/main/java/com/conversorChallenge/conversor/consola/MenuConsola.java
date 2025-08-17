package com.conversorChallenge.conversor.consola;


import com.conversorChallenge.conversor.servicios.ConversorMoneda;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuConsola {

    private final Scanner scanner = new Scanner(System.in);
    private final ConversorMoneda conversor = new ConversorMoneda();

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";

    public void iniciar() {
        try {
            while (true) {
                mostrarMenu();
                int opcion = leerOpcion();

                if (opcion == ConversorMoneda.OPTION_SALIR) {
                    if (confirmarSalida()) {
                        System.out.println(ANSI_GREEN + "✅ Gracias por utilizar el conversor. ¡Hasta la próxima!" + ANSI_RESET);
                        break;
                    }
                    continue;
                }

                if (!conversor.esOpcionValida(opcion)) {
                    System.out.println(ANSI_RED + "⚠️ Opción incorrecta, inténtelo nuevamente." + ANSI_RESET);
                    continue;
                }

                double monto = leerMonto();
                if (monto <= 0) {
                    System.out.println(ANSI_RED + "⚠️ El monto debe ser mayor a cero." + ANSI_RESET);
                    continue;
                }

                try {
                    double resultado = conversor.convertir(opcion, monto);
                    conversor.mostrarResultado(monto, resultado, opcion);
                } catch (IOException | InterruptedException e) {
                    System.out.println(ANSI_RED + "❌ Ocurrió un error al realizar la conversión. Intente más tarde." + ANSI_RESET);
                }
            }
        } finally {
            scanner.close();
        }
    }

    private void mostrarMenu() {
        System.out.println(ANSI_CYAN + """
            ╔═══════════════════════════════════════════════╗
            ║        🌍 Bienvenido al Conversor  🌍         ║
            ╚═══════════════════════════════════════════════╝""" + ANSI_RESET);

        conversor.mostrarOpciones();
        System.out.print("Seleccione una opción: ");
    }

    private int leerOpcion() {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            scanner.nextLine();
            return -1;
        }
    }

    private double leerMonto() {
        System.out.print("Ingrese el monto que desea convertir: ");
        try {
            return scanner.nextDouble();
        } catch (InputMismatchException e) {
            scanner.nextLine();
            return -1;
        }
    }

    private boolean confirmarSalida() {
        System.out.print("¿Desea salir del programa? (s/n): ");
        String respuesta = scanner.next().trim().toLowerCase();
        return respuesta.equals("s");
    }
}

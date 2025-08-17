package com.conversorChallenge.conversor.servicios;

import java.io.IOException;

public class ConversorMoneda {

    public static final int OPTION_SALIR = 7;

    private static final String[][] CONVERSIONES = {
            {"USD", "ARS"},
            {"ARS", "USD"},
            {"USD", "BRL"},
            {"BRL", "USD"},
            {"USD", "COP"},
            {"COP", "USD"}
    };

    public void mostrarOpciones() {
        for (int i = 0; i < CONVERSIONES.length; i++) {
            System.out.printf("%d) %s => %s%n", (i + 1), CONVERSIONES[i][0], CONVERSIONES[i][1]);
        }
        System.out.printf("%d) Salir%n", OPTION_SALIR);
        System.out.println("****************************************************");
    }

    public boolean esOpcionValida(int opcion) {
        return opcion >= 1 && opcion <= CONVERSIONES.length;
    }

    public double convertir(int opcion, double cantidad) throws IOException, InterruptedException {
        String from = CONVERSIONES[opcion - 1][0];
        String to = CONVERSIONES[opcion - 1][1];
        return ConsultarAPI.obtenerConversion(from, to, cantidad);
    }

    public void mostrarResultado(double cantidad, double resultado, int opcion) {
        String from = CONVERSIONES[opcion - 1][0];
        String to = CONVERSIONES[opcion - 1][1];
        String mensaje = String.format(
                "El valor de %.2f [%s] corresponde a %.2f [%s]",
                cantidad, from, resultado, to
        );
        String borde = "*".repeat(mensaje.length());
        System.out.println("\u001B[32m" + borde);
        System.out.println(mensaje);
        System.out.println(borde + "\u001B[0m");
    }
}
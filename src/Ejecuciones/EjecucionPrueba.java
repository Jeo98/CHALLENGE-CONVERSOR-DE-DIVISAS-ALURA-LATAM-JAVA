package Ejecuciones;

import Conversion.ConsultaAPI;
import Conversion.Convert;

public class EjecucionPrueba {
    public static void main(String[] args) {

        ConsultaAPI consulta = new ConsultaAPI();
        Convert conversion = consulta.buscaDivisas("USD","ARS",2.5);
        System.out.println(conversion);

    }
}

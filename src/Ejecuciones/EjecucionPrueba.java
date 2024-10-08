package Ejecuciones;

import Conversion.ConsultaAPI;
import Conversion.Convert;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Scanner;

public class EjecucionPrueba {
    public static void main(String[] args) {

        ConsultaAPI consulta = new ConsultaAPI();
        Convert conversion = consulta.buscaDivisas("USD","ARS",2.5);
        System.out.println(conversion);

        Gson gson = new GsonBuilder().
                setFieldNamingPolicy(FieldNamingPolicy.
                        UPPER_CAMEL_CASE).setPrettyPrinting() // para que se vea más pretty
                .create();

        double moneda;

        Scanner lectura = new Scanner(System.in);


        int menu=0, opcion;

        while(menu==0){

            System.out.println("-----------------------JEO CONVERSOR DE MONEDAS-------------------------");
            System.out.println("\n1- Dólar          --->Peso Argentino");
            System.out.println("2- Peso Argentino   ---> Dólar");
            System.out.println("3- Dolar            ---> Real brasileño");
            System.out.println("4- Real brasileño   ---> Dolar");
            System.out.println("5- Dolar            ---> Peso Colombiano");
            System.out.println("6- Peso Colombiano  ---> Dolar");
            System.out.println("\n9- SALIR DE CONVERSOR");
            System.out.print("-> ");
            opcion= lectura.nextInt();

            switch(opcion){

                case 1:
                    System.out.println("DÓLAR A PESO ARGERTINO--------------");
                    System.out.println("ingrese cantidad de dólares a convertir: ");
                    moneda = lectura.nextDouble();
                    while(moneda < 0 ) { // Mientras ingrese valor negativo, vuelve a pedir ingreso correcto

                        System.out.println("Incorrecto! por favor ingrese valor mayor a cero");
                        moneda = lectura.nextDouble();

                    }
                    System.out.println(consulta.buscaDivisas("USD","ARS",moneda));  //retorno funcion que realiza la conversion

                    break;

                case 2:
                    System.out.println("PESO ARGERTINO A DÓLAR--------------");
                    System.out.println("ingrese cantidad de pesos argentinos a convertir en dólares: ");
                    moneda = lectura.nextDouble();
                    while(moneda <= 0 ) { // Mientras ingrese valor negativo, vuelve a pedir ingreso correcto

                        System.out.println("Incorrecto! por favor ingrese valor mayor a cero");
                        moneda = (double) lectura.nextDouble();

                    }
                    //consulta.buscaDivisas("USD","ARS",moneda);

                    System.out.println(consulta.buscaDivisas("ARS","USD",moneda)); //retorno funcion que realiza la conversion

                    break;

            }





        }

    }
}

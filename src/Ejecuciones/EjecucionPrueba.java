package Ejecuciones;

import Conversion.ConsultaAPI;
import Conversion.Convert;
import Conversion.Monedas;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EjecucionPrueba {
    public static void main(String[] args) {
        Monedas menuMonedas = new Monedas();
        double moneda;
        Scanner lectura = new Scanner(System.in);
        boolean menu=true;
        int  opcion=0;

        ConsultaAPI consulta = new ConsultaAPI();
        Convert conversion = consulta.buscaDivisas("USD","ARS",2.5);
        System.out.println(conversion);

        Gson gson = new GsonBuilder().
                setFieldNamingPolicy(FieldNamingPolicy.
                        UPPER_CAMEL_CASE).setPrettyPrinting() // para que se vea más pretty
                .create();
        while(menu){
            try{
                System.out.println(menuMonedas.menu());

                opcion = lectura.nextInt();
                while ((opcion < 1 || opcion > 6 || opcion != 9)) {

                    System.out.println("Error, ingrese opción válida: ");
                    opcion = lectura.nextInt();
                    System.out.println(menuMonedas.menu());

                }
            }catch (InputMismatchException  e ) { //en caso de que ingrese un tipo de dato incorrecto
                System.out.println("Error: dato ingresado no valido. INGRESE OPCION CORRECTA: ");
                opcion = lectura.nextInt();
            }
            switch(opcion){

                case 1:
                    System.out.println("DÓLAR A PESO ARGERTINO--------------");
                    System.out.println("ingrese cantidad de dólares a convertir \n-> ");

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

                case 3:
                    System.out.println("DÓLAR A REAL BRASILERO--------------");
                    System.out.println("ingrese cantidad de dólares a convertir \n-> ");

                    moneda = lectura.nextDouble();
                    while(moneda < 0 ) { // Mientras ingrese valor negativo, vuelve a pedir ingreso correcto

                        System.out.println("Incorrecto! por favor ingrese valor mayor a cero");
                        moneda = lectura.nextDouble();

                    }
                    System.out.println(consulta.buscaDivisas("USD","BRL",moneda));

                    break;

                case 4:
                    System.out.println("REAL BRASILERO A DÓLAR--------------");
                    System.out.println("ingrese cantidad de Reales a convertir \n-> ");

                    moneda = lectura.nextDouble();
                    while(moneda < 0 ) { // Mientras ingrese valor negativo, vuelve a pedir ingreso correcto

                        System.out.println("Incorrecto! por favor ingrese valor mayor a cero");
                        moneda = lectura.nextDouble();

                    }
                    System.out.println(consulta.buscaDivisas("BRL","USD",moneda));

                    break;

                case 5:
                    System.out.println("DÓLAR A PESO COLOMBIANO--------------");
                    System.out.println("ingrese cantidad de Dólares a convertir \n-> ");

                    moneda = lectura.nextDouble();
                    while(moneda < 0 ) { // Mientras ingrese valor negativo, vuelve a pedir ingreso correcto

                        System.out.println("Incorrecto! por favor ingrese valor mayor a cero");
                        moneda = lectura.nextDouble();

                    }
                    System.out.println(consulta.buscaDivisas("USD","COP",moneda));

                    break;

                case 6:

                    System.out.println("PESO COLOMBIANO A DÓLAR--------------");
                    System.out.println("ingrese cantidad de pesos colombianos a convertir \n-> ");

                    moneda = lectura.nextDouble();
                    while(moneda < 0 ) { // Mientras ingrese valor negativo, vuelve a pedir ingreso correcto

                        System.out.println("Incorrecto! por favor ingrese valor mayor a cero");
                        moneda = lectura.nextDouble();

                    }
                    System.out.println(consulta.buscaDivisas("COP","USD",moneda));

                    break;

                case 9:
                    System.out.println("---------------------------------------------------------------");
                    System.out.println("--------------SALIDA | JEO CONVERSOR DE MONEDAS---------------");
                    System.out.println("---------------------------------------------------------------");
                    menu=false;
                    break;

            }





        }

    }
}

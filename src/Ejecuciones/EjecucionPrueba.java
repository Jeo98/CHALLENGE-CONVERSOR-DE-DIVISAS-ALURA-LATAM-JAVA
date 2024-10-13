package Ejecuciones;
import Conversion.ConsultaAPI;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import java.io.IOException;
import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.FileWriter;


public class EjecucionPrueba {
    public static void main(String[] args) throws IOException {

        double moneda;
        Scanner lectura = new Scanner(System.in);
        boolean menu=true;
        int  opcion;

        ConsultaAPI consulta = new ConsultaAPI();
        Gson gson = new GsonBuilder().
                setFieldNamingPolicy(FieldNamingPolicy.
                        UPPER_CAMEL_CASE).setPrettyPrinting() // para que se vea más pretty
                .create(); // para no tener problema entre mayusculas y minusculas

        while(menu){
            try{
                System.out.println(consulta.menu()); //muestro menu
                opcion = lectura.nextInt();
                while (opcion < 1 || (opcion > 6 && opcion != 9)) {
                    System.out.println("Error, ingrese opción válida: ");
                    opcion = lectura.nextInt();
                }
            }catch (InputMismatchException  e ) { //en caso de que ingrese un tipo de dato incorrecto
                System.out.println("Error: dato ingresado no valido. INGRESE OPCION CORRECTA: ");
                lectura.next();//limpio buffer
                opcion = lectura.nextInt();
            }
            FileWriter escrituraArchivotxt = new FileWriter("Historial conversiones.txt",true);
            FileWriter escrituraArchivo = new FileWriter("HistorialConversiones.json",true); //creo el archivo donde voy a escribir
            LocalDateTime ahora = LocalDateTime.now();
            String hora = "Hora: " + ahora.getHour() + " : " + ahora.getMinute();
            String fecha = ahora.getDayOfMonth() + "/"+ahora.getMonthValue()+"/"+ahora.getYear();
            String consulta1; //guarda la informacion de la consulta

            switch(opcion) {
                    case 1 :
                        try {
                        System.out.println("DÓLAR A PESO ARGERTINO--------------");
                        System.out.println("ingrese cantidad de dólares a convertir \n-> ");
                        moneda = lectura.nextDouble();
                        while (moneda < 0) { // Mientras ingrese valor negativo, vuelve a pedir ingreso correcto

                            System.out.println("Incorrecto! por favor ingrese valor mayor a cero");
                            moneda = lectura.nextDouble();

                        }
                        }catch (InputMismatchException  e ) { //en caso de que ingrese un tipo de dato incorrecto
                            System.out.println("Error: dato ingresado no valido. INGRESE OPCION CORRECTA: ");
                            lectura.next();//limpio buffer
                            moneda = lectura.nextDouble();
                        }
                        consulta1 = consulta.buscaDivisas("USD", "ARS", moneda).toString();
                        System.out.println(consulta1);

                        escrituraArchivotxt.write(fecha+"--"+hora + "\nCantidad a cambiar: $" + moneda +", " +  consulta1 + "\n\n");
                        escrituraArchivo.write(gson.toJson(fecha+"--"+hora + "\nCantidad a cambiar: $" + moneda +", " +  consulta1 + "\n\n"));
                        escrituraArchivotxt.close();
                        escrituraArchivo.close();

 //retorno funcion que realiza la conversion

                    break;

                case 2:
                    try {
                        System.out.println("PESO ARGERTINO A DÓLAR--------------");
                        System.out.println("ingrese cantidad de pesos argentinos a convertir en dólares: ");
                        moneda = lectura.nextDouble();
                        while (moneda <= 0) { // Mientras ingrese valor negativo, vuelve a pedir ingreso correcto

                            System.out.println("Incorrecto! por favor ingrese valor mayor a cero");
                            moneda = lectura.nextDouble();

                        }
                    }catch (InputMismatchException  e ) { //en caso de que ingrese un tipo de dato incorrecto
                    System.out.println("Error: dato ingresado no valido. INGRESE OPCION CORRECTA: ");
                    lectura.next();//limpio buffer
                        moneda = lectura.nextDouble();
                }
                    consulta1 = consulta.buscaDivisas("ARS", "USD", moneda).toString();
                    System.out.println(consulta1); //retorno funcion que realiza la conversion


                    escrituraArchivotxt.write(fecha+"--"+hora + "\nCantidad a cambiar: $" + moneda +", " +  consulta1 + "\n\n");
                    escrituraArchivo.write(gson.toJson(fecha+"--"+hora + "\nCantidad a cambiar: $" + moneda +", " +  consulta1 + "\n\n"));
                    escrituraArchivotxt.close();
                    escrituraArchivo.close();
                    break;

                case 3:
                    try {
                        System.out.println("DÓLAR A REAL BRASILERO--------------");
                        System.out.println("ingrese cantidad de dólares a convertir \n-> ");

                        moneda = lectura.nextDouble();
                        while (moneda < 0) { // Mientras ingrese valor negativo, vuelve a pedir ingreso correcto

                            System.out.println("Incorrecto! por favor ingrese valor mayor a cero");
                            moneda = lectura.nextDouble();

                        }
                    }
                    catch (InputMismatchException  e ) { //en caso de que ingrese un tipo de dato incorrecto
                        System.out.println("Error: dato ingresado no valido. INGRESE OPCION CORRECTA: ");
                        lectura.next();//limpio buffer
                        moneda = lectura.nextDouble();
                    }
                    consulta1=consulta.buscaDivisas("USD", "BRL", moneda).toString();
                    System.out.println(consulta1); //retorno funcion que realiza la conversion


                    escrituraArchivotxt.write(fecha+"--"+hora + "\nCantidad a cambiar: $" + moneda +", " +  consulta1 + "\n\n");
                    escrituraArchivo.write(gson.toJson(fecha+"--"+hora + "\nCantidad a cambiar: $" + moneda +", " +  consulta1 + "\n\n"));
                    escrituraArchivotxt.close();
                    escrituraArchivo.close();


                    break;

                case 4:
                    try {
                        System.out.println("REAL BRASILERO A DÓLAR--------------");
                        System.out.println("ingrese cantidad de Reales a convertir \n-> ");

                        moneda = lectura.nextDouble();
                        while (moneda < 0) { // Mientras ingrese valor negativo, vuelve a pedir ingreso correcto

                            System.out.println("Incorrecto! por favor ingrese valor mayor a cero");
                            moneda = lectura.nextDouble();

                        }
                    }
                    catch (InputMismatchException  e ) { //en caso de que ingrese un tipo de dato incorrecto
                        System.out.println("Error: dato ingresado no valido. INGRESE OPCION CORRECTA: ");
                        lectura.next();//limpio buffer
                        moneda = lectura.nextDouble();
                    }
                    consulta1 = consulta.buscaDivisas("BRL", "USD", moneda).toString();
                    System.out.println(consulta1);

                    escrituraArchivotxt.write(fecha+"--"+hora + "\nCantidad a cambiar: $" + moneda +", " +  consulta1 + "\n\n");
                    escrituraArchivo.write(gson.toJson(fecha+"--"+hora + "\nCantidad a cambiar: $" + moneda +", " +  consulta1 + "\n\n"));
                    escrituraArchivotxt.close();
                    escrituraArchivo.close();

                    break;

                case 5:
                    try {
                        System.out.println("DÓLAR A PESO COLOMBIANO--------------");
                        System.out.println("ingrese cantidad de Dólares a convertir \n-> ");

                        moneda = lectura.nextDouble();
                        while (moneda < 0) { // Mientras ingrese valor negativo, vuelve a pedir ingreso correcto

                            System.out.println("Incorrecto! por favor ingrese valor mayor a cero");
                            moneda = lectura.nextDouble();

                        }
                    }catch (InputMismatchException  e ) { //en caso de que ingrese un tipo de dato incorrecto
                        System.out.println("Error: dato ingresado no valido. INGRESE OPCION CORRECTA: ");
                        lectura.next();//limpio buffer
                        moneda = lectura.nextDouble();
                    }
                    consulta1 = consulta.buscaDivisas("USD", "COP", moneda).toString();
                    System.out.println(consulta1); //retorno funcion que realiza la conversion
                    escrituraArchivotxt.write(fecha+"--"+hora + "\nCantidad a cambiar: $" + moneda +", " +  consulta1 + "\n\n");
                    escrituraArchivo.write(gson.toJson(fecha+"--"+hora + "\nCantidad a cambiar: $" + moneda +", " +  consulta1 + "\n\n"));
                    escrituraArchivotxt.close();
                    escrituraArchivo.close();
                    break;

                case 6:
                    try {
                        System.out.println("PESO COLOMBIANO A DÓLAR--------------");
                        System.out.println("ingrese cantidad de pesos colombianos a convertir \n-> ");

                        moneda = lectura.nextDouble();
                        while (moneda < 0) { // Mientras ingrese valor negativo, vuelve a pedir ingreso correcto

                            System.out.println("Incorrecto! por favor ingrese valor mayor a cero");
                            moneda = lectura.nextDouble();

                        }
                    }catch (InputMismatchException  e ) { //en caso de que ingrese un tipo de dato incorrecto
                        System.out.println("Error: dato ingresado no valido. INGRESE OPCION CORRECTA: ");
                        lectura.next();//limpio buffer
                        moneda = lectura.nextDouble();
                    }

                    consulta1 = consulta.buscaDivisas("COP", "USD", moneda).toString();
                    System.out.println(consulta1); //retorno funcion que realiza la conversion
                    escrituraArchivotxt.write(fecha+"--"+hora + "\nCantidad a cambiar: $" + moneda +", " +  consulta1 + "\n\n");
                    escrituraArchivo.write(gson.toJson(fecha+"--"+hora + "\nCantidad a cambiar: $" + moneda +", " +  consulta1 + "\n\n"));
                    escrituraArchivotxt.close();
                    escrituraArchivo.close();

                    break;

                case 9:
                    System.out.println("---------------------------------------------------------------");
                    System.out.println("--------------SALIDA | JEO CONVERSOR DE MONEDAS---------------");

                        System.out.println("---------------------------------------------------------------");
                        menu = false;

                    break;
             }

        }

        lectura.close();
    }
}
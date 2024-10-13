package Conversion;

import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaAPI {

    private double valorMonedaOriginal=0.0; //moneda sin convertir
    private double valorMonedaConvertida=0.0;
    private String divisaACambiar;
    private String divisaARecibir;

    @Override
    public String toString() {
        return "Divisa a cambiar='" + divisaACambiar + '\'' +
                ", Divisa a recibir='" + divisaARecibir + '\'' +
                ", Valor de cambio= $ " + valorMonedaOriginal +" "+divisaARecibir+ " equivale a $1 " +divisaACambiar +
                ", total a recibir=$ " + valorMonedaConvertida + " " + divisaARecibir ;
    }

    public ConsultaAPI() {

    }


    public String getDivisaACambiar() {
        return divisaACambiar;
    }

    public void setDivisaACambiar(String divisaACambiar) {
        this.divisaACambiar = divisaACambiar;
    }

    public String getDivisaARecibir() {
        return divisaARecibir;
    }

    public void setDivisaARecibir(String divisaARecibir) {
        this.divisaARecibir = divisaARecibir;
    }

    public double getvalorMonedaOriginal() {
        return valorMonedaOriginal;
    }

    public void setvalorMonedaOriginal(double monedaOriginal) {
        this.valorMonedaOriginal = monedaOriginal;
    }

    public double getvalorMonedaConvertida() {
        return valorMonedaConvertida;
    }

    public void setvalorMonedaConvertida(double monedaConvertida) {
        this.valorMonedaConvertida = monedaConvertida;
    }

    public String menu(){

        return("-----------------------JEO CONVERSOR DE MONEDAS-------------------------"+
                "\n1- Dólar            ---> Peso Argentino"+
                "\n2- Peso Argentino   ---> Dólar"+
                "\n3- Dolar            ---> Real brasileño"+
                "\n4- Real brasileño   ---> Dolar"+
                "\n5- Dolar            ---> Peso Colombiano"+
                "\n6- Peso Colombiano  ---> Dolar"+
                "\n9- SALIR DE CONVERSOR");
    }

        public ConsultaAPI (Convert datoAPI){

            this.divisaACambiar=datoAPI.base_code();
            this.divisaARecibir= datoAPI.target_code();
            this.valorMonedaOriginal = datoAPI.conversion_rate();
            this.valorMonedaConvertida = datoAPI.conversion_result();

          }
    public ConsultaAPI buscaDivisas(String divisa1, String divisa2, double cantidad){
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/6cd67d834a49dbc3f25719d6/pair/"+divisa1+"/"+divisa2+"/"+cantidad);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = null;
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            Convert datosAPI = new Gson().fromJson(response.body(), Convert.class); //String json = response.body();
            ConsultaAPI resultadosConversion= new ConsultaAPI(datosAPI);
            return resultadosConversion;

        } catch (Exception e) {
            throw new RuntimeException("No se encontró divisa ingresada.");
        }


    }
}

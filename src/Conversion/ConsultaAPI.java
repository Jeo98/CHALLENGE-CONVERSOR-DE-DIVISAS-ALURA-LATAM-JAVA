package Conversion;


import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaAPI {



    public Convert buscaDivisas(String divisa1, String divisa2, double cantidad){
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/6cd67d834a49dbc3f25719d6/pair/"+divisa1+"/"+divisa2+"/"+cantidad);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = null;
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Convert.class);
        } catch (Exception e) {
            throw new RuntimeException("No se encontró divisa ingresada.");
        }

    }
}

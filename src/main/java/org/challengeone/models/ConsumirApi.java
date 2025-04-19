package org.challengeone.models;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import io.github.cdimascio.dotenv.Dotenv;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumirApi {
    private final Dotenv dotenv = Dotenv.load();
    private final String apiKey = dotenv.get("API_KEY");

    public double getDados(String MoedaDeOrigen, String MoedaParaConversao) {
        try {
            String url = "https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/" + MoedaDeOrigen + "/" + MoedaParaConversao;

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(new URI(url)).build();
            HttpResponse<String> response = client.send(request ,HttpResponse.BodyHandlers.ofString());

            Gson gson = new Gson();
            JsonObject respostaJson = gson.fromJson(response.body(), JsonObject.class);
            return respostaJson.get("conversion_rate").getAsDouble();
        } catch (Exception e) {
            throw new RuntimeException("Não foi possivel obter a cotação" + e);
        }
    }

    public void converter(String moeda, Double valor, Double cambio){
        System.out.print("Enter the amount to be converted: ");
        try {
            double quantia = valor;
            if (quantia <= 0) {
                System.out.println("\nInsira um valor maior que 0!\n");
                return;
            }
            double resultado = quantia * cambio;
            System.out.printf("\nValor Convertido: %.2f %s\n\n", resultado, moeda);
        } catch (Exception e) {
            System.out.println("\nValor Inválido!.\n");
        }
    }

}

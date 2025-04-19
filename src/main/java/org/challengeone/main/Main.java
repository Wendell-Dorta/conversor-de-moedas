package org.challengeone.main;

import io.github.cdimascio.dotenv.Dotenv;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.load();
        String apiKey = dotenv.get("API_KEY");

        // Setting URL
        String url_str = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/USD";
    }
}
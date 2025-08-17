package com.conversorChallenge.conversor.servicios;

import com.conversorChallenge.conversor.modelos.ApiResponse;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public final class ConsultarAPI {

    private static final String URL_API = "https://v6.exchangerate-api.com/v6/";
    private static final String API_KEY = "c683609c94e01622f57eca4b"; //write your API key here
    private static final String PAIR_PATH = "/pair";

    private ConsultarAPI() {}

    public static Double obtenerConversion(String firstCoin, String secondCoin, double amount)
            throws IOException, InterruptedException {
        URI uriConversion = URI.create(URL_API + API_KEY + PAIR_PATH +
                "/" + firstCoin + "/" + secondCoin + "/" + amount);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(uriConversion).GET().build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        Gson gson = new Gson();
        ApiResponse apiResponse = gson.fromJson(response.body(), ApiResponse.class);
        return apiResponse.conversion_result();
    }
}

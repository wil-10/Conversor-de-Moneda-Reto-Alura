package com.alura.conversor;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoneda {
    Moneda buscaMoneda(int m) {
        String s = "";
        if (m == 1 || m == 3 || m == 5) {
            s = "https://v6.exchangerate-api.com/v6/31883c60ffcafe95ab28b75c/latest/usd";
        } else if (m == 2) {
            s = "https://v6.exchangerate-api.com/v6/31883c60ffcafe95ab28b75c/latest/mxn";
        } else if (m == 4) {
            s = "https://v6.exchangerate-api.com/v6/31883c60ffcafe95ab28b75c/latest/crc";
        } else if (m == 6) {
            s = "https://v6.exchangerate-api.com/v6/31883c60ffcafe95ab28b75c/latest/cad";
        }
        URI direccion = URI.create(s);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        HttpResponse<String> response = null;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        //return new Gson().fromJson(response.body(), Moneda.class);
        JsonObject jsonObject = JsonParser.parseString(response.body()).getAsJsonObject();
        JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");

        double usd = conversionRates.get("USD").getAsDouble();
        double mxn = conversionRates.get("MXN").getAsDouble();
        double crc = conversionRates.get("CRC").getAsDouble();
        double cad = conversionRates.get("CAD").getAsDouble();

        return new Moneda(usd, mxn, crc, cad);

    }
}

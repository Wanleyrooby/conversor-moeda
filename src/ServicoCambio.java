import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ServicoCambio {

    public Double consultaTaxaDeCambio(String moedaOrigem, String moedaDestino) throws IOException, InterruptedException {
        String apiKey = "d8bd06f215b52d859e6443e2";
        URI endereco = URI.create("https://v6.exchangerate-api.com/v6/" + apiKey +"/latest/" + moedaOrigem);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(endereco)
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() != 200) {
            System.out.println(response.statusCode());
            throw new RuntimeException("Erro ao consultar a taxa de câmbio. Código HTTP: " + response.statusCode());
        }

        Gson gson = new Gson();
        TaxasDeCambio taxasDeCambio = gson.fromJson(response.body(), TaxasDeCambio.class);

        double taxa = taxasDeCambio.conversion_rates().get(moedaDestino);
        if (taxa == 0) {
            throw new RuntimeException("Moeda de destino não encontrada: " + moedaDestino);
        }
        return taxa;
    }

    public Double converteMoeda(String moedaOrigem, String moedaDestino, double valor) throws IOException, InterruptedException {
        double taxa = consultaTaxaDeCambio(moedaOrigem, moedaDestino);
        return taxa * valor;
    }
}

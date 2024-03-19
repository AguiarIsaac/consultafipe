package br.com.consultafipe.service;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.security.SecureRandom;

public class ConsumoApi {
    //está dessa forma por causa dos bloqueios da rede MIRANDA
    public String obterDados(String endereco) {
        try {
            // Configura SSLContext para ignorar a validação do certificado
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, new TrustManager[]{new X509TrustManager() {
                public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                    return null;
                }

                public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType) {
                }

                public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType) {
                }
            }}, new SecureRandom());

            // Configura o HttpClient com SSLContext personalizado
            HttpClient client = HttpClient.newBuilder()
                    .sslContext(sslContext)
                    .build();

            // Faz a solicitação HTTP
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endereco))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Retorna a resposta
            return response.body();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao obter dados da API: " + e.getMessage(), e);
        }
    }
}

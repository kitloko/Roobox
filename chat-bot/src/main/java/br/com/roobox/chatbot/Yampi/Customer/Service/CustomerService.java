package br.com.roobox.chatbot.Yampi.Customer.Service;

import br.com.roobox.chatbot.Utils.Utils;
import br.com.roobox.chatbot.Yampi.Entity.YampiEntity;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Optional;
import java.util.regex.Pattern;

@Service
public class CustomerService {

    private final WebClient webClient = WebClient.builder()
            .baseUrl("https://api.moorse.io/")
            .defaultHeader(MediaType.APPLICATION_JSON_VALUE)
            .defaultHeader("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtYXJjdXNyZWlzMTNAb3V0bG9vay5jb20iLCJpZENsaWVudCI6IjNjNzNjMjVlLTI3MTMtNGUzYS1hZTA2LTIyNGRkYzFmYjU2NiIsImNyZWF0ZWQiOjE2Mjc5OTc4NjYxMzYsInJvbGVzIjpbIlJPTEVfQVBJIiwiUk9MRV9EQVNIQk9BUkQiLCJST0xFX0RBU0hCT0FSRF9HUk9VUFMiLCJST0xFX0dST1VQUyIsIlJPTEVfSU5URUdSQVRJT05fVVNFUiIsIlJPTEVfVFJJQUwiLCJST0xFX1VTRVJTIiwiUk9MRV9XRUJIT09LIl0sImlkIjoxNjUsImV4cCI6MTY1OTUzMzg2Nn0.jdDx-CiSPdgZZ_28LvFX5qsBbY4TBej8ShY7fhvhJSbOlfmXeXtkqjfxf1SaqgJGEfix5qdd5QMVtAEok_sUPw")
            .build();

    private final String urlBase = "https://api.dooki.com.br/v2/";


    private JSONArray realizaRequisicao(YampiEntity yampi, String url) {
        Mono<String> response = webClient
                .get()
                .uri(urlBase + yampi.getAlias() + url)
                .header("User-Token", yampi.getToken())
                .header("User-Secret-Key", yampi.getSecretKey())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(String.class);

        return Optional.ofNullable(new JSONObject(response.block()).getJSONArray("data")).orElse(new JSONArray());
    }

    public JSONObject findClientesYampi(String cpfCliente, YampiEntity yampi) {

        cpfCliente = Utils.aplicaRegex(cpfCliente, Pattern.compile("\\d{11}"));
        if (Utils.aplicaRegex(cpfCliente, Pattern.compile("\\d{11}")).isEmpty())
            return new JSONObject();//RETORNA JSON VAZIO

        JSONArray cliente = realizaRequisicao(yampi, "/customers?search=cpf:" + cpfCliente);

        if (cliente.isEmpty())
            return new JSONObject();

        return cliente.getJSONObject(0);
    }

}

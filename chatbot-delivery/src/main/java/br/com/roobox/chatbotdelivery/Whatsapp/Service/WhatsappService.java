package br.com.roobox.chatbotdelivery.Whatsapp.Service;

import br.com.roobox.chatbotdelivery.Message.Entity.MessageEntity;
import br.com.roobox.chatbotdelivery.Whatsapp.Entity.Whatsapp;
import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WhatsappService {

    final WebClient webClient = WebClient.builder()
            .baseUrl("https://api.moorse.io/")
            .defaultHeader(MediaType.APPLICATION_JSON_VALUE)
            .defaultHeader("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtYXJjdXNyZWlzMTNAb3V0bG9vay5jb20iLCJpZENsaWVudCI6IjNjNzNjMjVlLTI3MTMtNGUzYS1hZTA2LTIyNGRkYzFmYjU2NiIsImNyZWF0ZWQiOjE2Mjc5OTc4NjYxMzYsInJvbGVzIjpbIlJPTEVfQVBJIiwiUk9MRV9EQVNIQk9BUkQiLCJST0xFX0RBU0hCT0FSRF9HUk9VUFMiLCJST0xFX0dST1VQUyIsIlJPTEVfSU5URUdSQVRJT05fVVNFUiIsIlJPTEVfVFJJQUwiLCJST0xFX1VTRVJTIiwiUk9MRV9XRUJIT09LIl0sImlkIjoxNjUsImV4cCI6MTY1OTUzMzg2Nn0.jdDx-CiSPdgZZ_28LvFX5qsBbY4TBej8ShY7fhvhJSbOlfmXeXtkqjfxf1SaqgJGEfix5qdd5QMVtAEok_sUPw")
            .build();


    public void sendMessage(MessageEntity message, String mensagem, Whatsapp Whatsapp) {

        Map<String, String> bodyValues = new HashMap();
        bodyValues.put("to", message.getFrom());
        bodyValues.put("body", mensagem);

        Mono<String> response = webClient
                .post()
                .uri("v2/whatsapp/{integration}/send-message", Whatsapp.getIntegration())
                .accept(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(bodyValues))
                .retrieve()
                .bodyToMono(String.class);

        JSONObject jsonArray = new JSONObject(response.block());
        jsonArray.getJSONObject("data").getString("message");

    }

    public void sendMessagePdf(String number, String pdf, String nomeArquivo, Whatsapp Whatsapp) {

        MultiValueMap<String, String> bodyValues = new LinkedMultiValueMap<>();
        bodyValues.add("to", "55" + number);
        bodyValues.add("body", pdf);
        bodyValues.add("filename", nomeArquivo + ".pdf");
        bodyValues.add("caption", "Pdf");

        Mono<String> response = webClient
                .post()
                .uri("v2/whatsapp/{integration}/send-file", Whatsapp.getIntegration())
                .accept(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromFormData(bodyValues))
                .retrieve()
                .bodyToMono(String.class);

        JSONObject jsonArray = new JSONObject(response.block());
    }

    public void sendMessageImage(String number, String pdf, String nomeArquivo, Whatsapp Whatsapp, String legenda) {

        MultiValueMap<String, String> bodyValues = new LinkedMultiValueMap<>();
        bodyValues.add("to", "55" + number);
        bodyValues.add("body", pdf);
        bodyValues.add("filename", nomeArquivo);
        bodyValues.add("caption", legenda);

        Mono<String> response = webClient
                .post()
                .uri("v2/whatsapp/{integration}/send-file", Whatsapp.getIntegration())
                .accept(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromFormData(bodyValues))
                .retrieve()
                .bodyToMono(String.class);

        JSONObject jsonArray = new JSONObject(response.block());
    }


}

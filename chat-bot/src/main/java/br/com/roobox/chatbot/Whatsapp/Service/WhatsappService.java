package br.com.roobox.chatbot.Whatsapp.Service;

import br.com.roobox.chatbot.Whatsapp.Entity.Whatsapp;
import br.com.roobox.chatbot.Yampi.ChatbotYampi.Entity.MessageEntity;
import com.google.gson.Gson;
import br.com.roobox.chatbot.Whatsapp.Entity.WhatsappInfo;
import br.com.roobox.chatbot.Whatsapp.Entity.WhatsappMessage;
import br.com.roobox.chatbot.Whatsapp.Entity.WhatsappMessageAmount;
import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

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

    public WhatsappInfo info(String whatsapp) {


        Mono<String> response = webClient
                .get()
                .uri("v2/whatsapp/{id}", whatsapp)
                .header("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtYXJjdXNyZWlzMTNAb3V0bG9vay5jb20iLCJpZENsaWVudCI6IjNjNzNjMjVlLTI3MTMtNGUzYS1hZTA2LTIyNGRkYzFmYjU2NiIsImNyZWF0ZWQiOjE2Mjc5OTc4NjYxMzYsInJvbGVzIjpbIlJPTEVfQVBJIiwiUk9MRV9EQVNIQk9BUkQiLCJST0xFX0RBU0hCT0FSRF9HUk9VUFMiLCJST0xFX0dST1VQUyIsIlJPTEVfSU5URUdSQVRJT05fVVNFUiIsIlJPTEVfVFJJQUwiLCJST0xFX1VTRVJTIiwiUk9MRV9XRUJIT09LIl0sImlkIjoxNjUsImV4cCI6MTY1OTUzMzg2Nn0.jdDx-CiSPdgZZ_28LvFX5qsBbY4TBej8ShY7fhvhJSbOlfmXeXtkqjfxf1SaqgJGEfix5qdd5QMVtAEok_sUPw")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(String.class);

        Mono<String> response1 = webClient
                .get()
                .uri("v2/whatsapp/{id}/credit", whatsapp)
                .header("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtYXJjdXNyZWlzMTNAb3V0bG9vay5jb20iLCJpZENsaWVudCI6IjNjNzNjMjVlLTI3MTMtNGUzYS1hZTA2LTIyNGRkYzFmYjU2NiIsImNyZWF0ZWQiOjE2Mjc5OTc4NjYxMzYsInJvbGVzIjpbIlJPTEVfQVBJIiwiUk9MRV9EQVNIQk9BUkQiLCJST0xFX0RBU0hCT0FSRF9HUk9VUFMiLCJST0xFX0dST1VQUyIsIlJPTEVfSU5URUdSQVRJT05fVVNFUiIsIlJPTEVfVFJJQUwiLCJST0xFX1VTRVJTIiwiUk9MRV9XRUJIT09LIl0sImlkIjoxNjUsImV4cCI6MTY1OTUzMzg2Nn0.jdDx-CiSPdgZZ_28LvFX5qsBbY4TBej8ShY7fhvhJSbOlfmXeXtkqjfxf1SaqgJGEfix5qdd5QMVtAEok_sUPw")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(String.class);

        LocalDate todaydate = LocalDate.now();
        System.out.println("Months first date in yyyy-mm-dd: " + todaydate.withDayOfMonth(1));
        System.out.println("Months last date in yyyy-mm-dd: " + todaydate.atStartOfDay());

        Mono<String> response2 = webClient
                .get()
                .uri(uriBuilder -> uriBuilder.path("v1/reports/total-messages")
                        .queryParam("beginDate", todaydate.withDayOfMonth(1))
                        .queryParam("endDate", todaydate.atStartOfDay().toLocalDate())
                        .build())
                .header("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtYXJjdXNyZWlzMTNAb3V0bG9vay5jb20iLCJpZENsaWVudCI6IjNjNzNjMjVlLTI3MTMtNGUzYS1hZTA2LTIyNGRkYzFmYjU2NiIsImNyZWF0ZWQiOjE2Mjc5OTc4NjYxMzYsInJvbGVzIjpbIlJPTEVfQVBJIiwiUk9MRV9EQVNIQk9BUkQiLCJST0xFX0RBU0hCT0FSRF9HUk9VUFMiLCJST0xFX0dST1VQUyIsIlJPTEVfSU5URUdSQVRJT05fVVNFUiIsIlJPTEVfVFJJQUwiLCJST0xFX1VTRVJTIiwiUk9MRV9XRUJIT09LIl0sImlkIjoxNjUsImV4cCI6MTY1OTUzMzg2Nn0.jdDx-CiSPdgZZ_28LvFX5qsBbY4TBej8ShY7fhvhJSbOlfmXeXtkqjfxf1SaqgJGEfix5qdd5QMVtAEok_sUPw")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(String.class);

        JSONObject jsonArray = new JSONObject(response.block());
        JSONObject jsonArray1 = new JSONObject(response1.block());
        JSONObject jsonArray2 = new JSONObject(response2.block());

        WhatsappInfo whatsappInfo = new Gson().fromJson(jsonArray.getJSONObject("data").toString(), WhatsappInfo.class);
        whatsappInfo.setBalance(jsonArray1.getJSONObject("data").getInt("balance"));
        whatsappInfo.setTotalMessageSent(jsonArray2.getJSONObject("data").getInt("totalMessageSent"));
        whatsappInfo.setTotalMessagesReceived(jsonArray2.getJSONObject("data").getInt("totalMessagesReceived"));
        whatsappInfo.setTotalContacts(jsonArray2.getJSONObject("data").getInt("totalContacts"));

        return whatsappInfo;
    }

    public WhatsappMessageAmount amount(List<WhatsappMessage> listAll, List<WhatsappMessage> listTop5) {
        WhatsappMessageAmount whatsappMessageAmount = new WhatsappMessageAmount();
        listAll.forEach(list -> {
            if (list.getEvent().equals("billet")) {
                whatsappMessageAmount.setAmountBillet(whatsappMessageAmount.getAmountBillet() + 1);
            } else if (list.getEvent().equals("card")) {
                whatsappMessageAmount.setAmountCard(whatsappMessageAmount.getAmountCard() + 1);
            } else if (list.getEvent().equals("cart")) {
                whatsappMessageAmount.setAmountCart(whatsappMessageAmount.getAmountCart() + 1);
            } else {
                whatsappMessageAmount.setAmountwithdrawal(whatsappMessageAmount.getAmountwithdrawal() + 1);
            }
        });

        whatsappMessageAmount.setTop5(listTop5);

        return whatsappMessageAmount;
    }

    public void sendMessageYampi(MessageEntity message, String mensagem, Whatsapp Whatsapp) {

        Map<String, String> bodyValues = new HashMap();
        bodyValues.put("to", "55" + message.getFrom());
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

    public void sendMessagePdfYampi(String number, String pdf, String nomeArquivo, Whatsapp Whatsapp) {

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


}

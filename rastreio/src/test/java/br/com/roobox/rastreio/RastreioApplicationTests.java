package br.com.roobox.rastreio;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@SpringBootTest
class RastreioApplicationTests {

	@Test
	void contextLoads() {
		Mono<String> response = WebClient
				.builder()
				.build()
				.get()
				.uri("https://proxyapp.correios.com.br/v1/sro-rastro/{rastreio}", "LB338557975HK")
				.accept(MediaType.APPLICATION_XML)
				.retrieve()
				.bodyToMono(String.class);



		JSONObject jsonObject = new JSONObject(response.block());

		JSONArray objetos = new JSONArray(jsonObject.getJSONArray("objeto").toString());
	}

}

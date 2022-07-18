package br.com.roobox.rastreio;

import br.com.roobox.rastreio.Entity.RastreioEntity;
import br.com.roobox.rastreio.Service.Rastreio;
import com.google.gson.Gson;
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
	void rastreioUnico() {
		Mono<String> response = WebClient
				.builder()
				.build()
				.get()
				.uri("https://proxyapp.correios.com.br/v1/sro-rastro/{rastreio}", "LB338557975HK")
				.retrieve()
				.bodyToMono(String.class);



		JSONObject jsonObject = new JSONObject(response.block());
		Gson gson = new Gson();

		RastreioEntity rastreio = gson.fromJson(String.valueOf(jsonObject), RastreioEntity.class);

		JSONArray objetos = new JSONArray(jsonObject.getJSONArray("objetos").toString());

	}

	@Test
	void rastreioMultiple() {
		String rastreios = "LB338557975HK";

		String xmlString = "<rastroObjeto>" +
				"    <usuario>{}</usuario>" +
				"    <senha>{}</senha>" +
				"    <tipo>L</tipo>" +
				"    <resultado>T</resultado>" +
				"    <objetos>" + rastreios + "</objetos>" +
				"    <lingua>101</lingua>" +
				"    <token>{}</token>" +
				"</rastroObjeto>";


		Mono<String> response = WebClient
				.builder()
				.build()
				.post()
				.uri("http://webservice.correios.com.br/service/rest/rastro/rastroMobile")
				.contentType(MediaType.APPLICATION_XML)
				.bodyValue(xmlString)
				.retrieve()
				.bodyToMono(String.class);

		JSONObject jsonObject = new JSONObject(response.block());

		JSONArray objetos = new JSONArray(jsonObject.getJSONArray("objeto").toString());
	}

}

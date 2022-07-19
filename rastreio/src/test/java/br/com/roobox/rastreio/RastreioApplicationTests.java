package br.com.roobox.rastreio;

import br.com.roobox.rastreio.Entity.Rastreio;
import br.com.roobox.rastreio.Repository.RastreioRepository;
import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@SpringBootTest
class RastreioApplicationTests {

    @Autowired
    RastreioRepository rastreioRepository;

    @Test
    void rastreioUnico() {
//		Mono<String> response = WebClient
//				.builder()
//				.build()
//				.get()
//				.uri("https://proxyapp.correios.com.br/v1/sro-rastro/{rastreio}", "LB338557975HK")
//				.retrieve()
//				.bodyToMono(String.class);
//
//
//
//		JSONObject jsonObject = new JSONObject(response.block());

        String json = "{\"objetos\":[{\"codObjeto\":\"LB338557975HK\",\"eventos\":[{\"codigo\":\"BDE\",\"descricao\":\"Objeto entregue ao destinatário\",\"dtHrCriado\":\"2022-05-31T14:26:30\",\"tipo\":\"01\",\"unidade\":{\"endereco\":{\"cidade\":\"GOIANIA\",\"uf\":\"GO\"},\"tipo\":\"Unidade de Distribuição\"},\"urlIcone\":\"/public-resources/img/smile.png\"},{\"codigo\":\"OEC\",\"descricao\":\"Objeto saiu para entrega ao destinatário\",\"dtHrCriado\":\"2022-05-31T11:26:58\",\"tipo\":\"01\",\"unidade\":{\"endereco\":{\"bairro\":\"SETOR CENTRAL\",\"cep\":\"74025972\",\"cidade\":\"GOIANIA\",\"logradouro\":\"RUA 4\",\"numero\":\"896\",\"uf\":\"GO\"},\"tipo\":\"Unidade de Distribuição\"},\"urlIcone\":\"/public-resources/img/pre-atendimento-cor.png\"},{\"codigo\":\"BDE\",\"descricao\":\"Objeto não entregue - carteiro não atendido\",\"detalhe\":\"Por favor, aguarde. Será realizada nova tentativa de entrega\",\"dtHrCriado\":\"2022-05-27T14:24:38\",\"tipo\":\"20\",\"unidade\":{\"endereco\":{\"cidade\":\"GOIANIA\",\"uf\":\"GO\"},\"tipo\":\"Unidade de Distribuição\"},\"urlIcone\":\"/public-resources/img/logistica-reversa-cor.png\"},{\"codigo\":\"OEC\",\"descricao\":\"Objeto saiu para entrega ao destinatário\",\"dtHrCriado\":\"2022-05-27T11:12:40\",\"tipo\":\"01\",\"unidade\":{\"endereco\":{\"bairro\":\"SETOR CENTRAL\",\"cep\":\"74025972\",\"cidade\":\"GOIANIA\",\"logradouro\":\"RUA 4\",\"numero\":\"896\",\"uf\":\"GO\"},\"tipo\":\"Unidade de Distribuição\"},\"urlIcone\":\"/public-resources/img/pre-atendimento-cor.png\"},{\"codigo\":\"EST\",\"descricao\":\"Favor desconsiderar a informação anterior\",\"detalhe\":\"Gentileza aguardar a próxima atualização\\r\\n\",\"dtHrCriado\":\"2022-05-26T16:36:44\",\"tipo\":\"01\",\"unidade\":{\"endereco\":{\"cidade\":\"GOIANIA\",\"uf\":\"GO\"},\"tipo\":\"Unidade de Distribuição\"},\"urlIcone\":\"/public-resources/img/balao-erro.png\"},{\"codigo\":\"RO\",\"descricao\":\"Objeto em trânsito - por favor aguarde\",\"dtHrCriado\":\"2022-05-24T13:25:15\",\"tipo\":\"01\",\"unidade\":{\"endereco\":{\"cidade\":\"APARECIDA DE GOIANIA\",\"uf\":\"GO\"},\"tipo\":\"Unidade de Tratamento\"},\"unidadeDestino\":{\"endereco\":{\"cidade\":\"GOIANIA\",\"uf\":\"GO\"},\"tipo\":\"Unidade de Distribuição\"},\"urlIcone\":\"/public-resources/img/caminhao-cor.png\"},{\"codigo\":\"RO\",\"descricao\":\"Objeto em trânsito - por favor aguarde\",\"dtHrCriado\":\"2022-05-20T15:27:36\",\"tipo\":\"01\",\"unidade\":{\"endereco\":{\"cidade\":\"CURITIBA\",\"uf\":\"PR\"},\"tipo\":\"Unidade de Tratamento\"},\"unidadeDestino\":{\"endereco\":{\"cidade\":\"APARECIDA DE GOIANIA\",\"uf\":\"GO\"},\"tipo\":\"Unidade de Tratamento\"},\"urlIcone\":\"/public-resources/img/caminhao-cor.png\"},{\"codigo\":\"PAR\",\"descricao\":\"Fiscalização aduaneira finalizada\",\"dtHrCriado\":\"2022-05-20T15:25:36\",\"tipo\":\"10\",\"unidade\":{\"endereco\":{\"cidade\":\"CURITIBA\",\"uf\":\"PR\"},\"tipo\":\"Unidade Operacional\"},\"urlIcone\":\"/public-resources/img/verificar-documento-cor.png\"},{\"codigo\":\"PAR\",\"descricao\":\"Objeto recebido pelos Correios do Brasil\",\"dtHrCriado\":\"2022-05-17T13:23:31\",\"tipo\":\"16\",\"unidade\":{\"endereco\":{\"cidade\":\"CURITIBA\",\"uf\":\"PR\"},\"tipo\":\"Unidade Operacional\"},\"urlIcone\":\"/public-resources/img/brazil.png\"},{\"codigo\":\"RO\",\"descricao\":\"Objeto em trânsito - por favor aguarde\",\"dtHrCriado\":\"2022-05-13T16:48:00\",\"tipo\":\"01\",\"unidade\":{\"codSro\":\"00344000\",\"endereco\":{},\"nome\":\"HONG KONG\",\"tipo\":\"País\"},\"unidadeDestino\":{\"codSro\":\"00500001\",\"endereco\":{\"uf\":\"BR\"},\"nome\":\"Unidade de Tratamento Internacional\",\"tipo\":\"País\"},\"urlIcone\":\"/public-resources/img/caminhao-cor.png\"},{\"codigo\":\"PO\",\"descricao\":\"Objeto postado\",\"dtHrCriado\":\"2022-05-13T14:10:00\",\"tipo\":\"01\",\"unidade\":{\"codSro\":\"00344000\",\"endereco\":{},\"nome\":\"HONG KONG\",\"tipo\":\"País\"},\"urlIcone\":\"/public-resources/img/agencia-cor.png\"}],\"modalidade\":\"V\",\"tipoPostal\":{\"categoria\":\"PRIME EXPRÈS\",\"descricao\":\"OBJETO INTERNACIONAL PRIME\",\"sigla\":\"LB\"},\"habilitaAutoDeclaracao\":false,\"permiteEncargoImportacao\":false,\"habilitaPercorridaCarteiro\":false,\"bloqueioObjeto\":false,\"possuiLocker\":false,\"habilitaLocker\":false,\"habilitaCrowdshipping\":false}],\"quantidade\":1,\"resultado\":\"Todos os Eventos\",\"versao\":\"2.1.3\"}";
        Gson gson = new Gson();

        Rastreio rastreio = gson.fromJson((json), Rastreio.class);


        rastreioRepository.save(rastreio);
//		JSONArray objetos = new JSONArray(json.getJSONArray("objetos").toString());

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

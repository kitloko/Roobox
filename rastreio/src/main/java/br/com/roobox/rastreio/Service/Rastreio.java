package br.com.roobox.rastreio.Service;

import br.com.roobox.rastreio.Entity.RastreioEntity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Rastreio {

//    private void rastrearPedido(CustomerEntity customer, YampiEntity yampi) {
//        StringBuilder mensagem = new StringBuilder();
//        JSONObject listaPedido = consultaPedidos(CPF, yampiModel);
//
//        //CONSULTA O RASTREIO DO PEDIDO
////        JSONObject rastreio = rastrearYampi(listaPedido);
//
//        RastreioEntity rastreioModel = new RastreioEntity();
//
//        for (int i = 0; i < listaPedido.getJSONObject("pedido").length(); i++) {
//            StringBuilder mensagemPedido = new StringBuilder();
//
//            try {
//                rastreioModel.setRastreio(listaPedido.getJSONObject("pedido").getJSONObject("0").getString("track_code"));
//                rastreioModel = new ConsultaRastreios().retornaRastreioProxyapp(rastreioModel);
//                if (rastreioModel.getEvento().equals("Sem informação de rastreio")) {
//
//                } else {
//                    if (rastreioModel.getEvento().equals("Objeto entregue ao destinatário")) {
//                        mensagemPedido.append("Seu pedido foi *entregue ao destinatário* ✅\n");
//                        mensagemPedido.append("\uD83D\uDCC5 No dia *" + rastreioModel.getData() + " " + rastreioModel.getHora() + " em " + rastreioModel.getCidade() + "*\n");
//                        mensagemPedido.append("\uD83D\uDCE6 O código de rastreio é: *" + rastreioModel.getRastreio() + "*\n\n");
//                    } else {
//                        if (new FlowRastreamento().verificaEstado(rastreioModel.getCidade())) {
//                            mensagemPedido.append("\uD83D\uDE9A Sua encomenda está em *" + rastreioModel.getCidade() + "*\n");
//                        } else {
//                            mensagemPedido.append("\uD83D\uDE9A Sua encomenda está em transito\n");
//                        }
//                        mensagemPedido.append("\uD83D\uDCC5 Ultima atualização *" + rastreioModel.getData() + " " + rastreioModel.getHora() + "*\n");
//                        mensagemPedido.append(rastreioModel.getEvento() + " \n");
//                        mensagemPedido.append("\uD83D\uDCE6 O código de rastreio é: *" + rastreioModel.getRastreio() + "*\n\n");
//                        mensagemPedido.append("⏰ " + previsaoEntrega(listaPedido, i) + "\n\n");
//                    }
//                }
//
//
////            rastreioCorreios(listaPedido.getJSONObject("pedido").getJSONObject(String.valueOf(i)).getString("track_code"), mensagemPedido);
//
//                if (mensagemPedido.toString().isEmpty())
//                    rastreioCainiao(listaPedido.getJSONObject("pedido").getJSONObject(String.valueOf(i)).getString("track_code"), mensagemPedido);
//
//                if (mensagemPedido.toString().isEmpty()) {
//                    JSONObject statusPedido = listaPedido.getJSONObject("pedido").getJSONObject(String.valueOf(i)).getJSONObject("status").getJSONObject("data");
//
//                    mensagemPedido.append("Seu pedido está: *" + statusPedido.getString("name") + "* \uD83D\uDE9A \n");
//                    mensagemPedido.append(statusPedido.getString("description") + "\n");
//                    mensagemPedido.append("\uD83D\uDCE6 O código de rastreio é: *" + listaPedido.getJSONObject("pedido").getJSONObject(String.valueOf(i)).getString("track_code") + "*\n");
////                    mensagemPedido.append("⏰ " + previsaoEntrega(listaPedido, i) + "\n\n");
//                }
//
//                mensagemPedido.append("Os itens do pedido pedido " + listaPedido.getJSONObject("pedido").getJSONObject(String.valueOf(i)).get("number").toString() + " são \n");
//                JSONObject produtosLista = listaPedido.getJSONObject("produto").getJSONObject(String.valueOf(listaPedido.getJSONObject("pedido").getJSONObject(String.valueOf(i)).get("number").toString()));
//                for (int j = 0; j < produtosLista.length(); j++) {
//                    mensagemPedido.append("\uD83D\uDD39️*" + produtosLista.getJSONObject(String.valueOf(j)).getInt("quantity") + " " + produtosLista.getJSONObject(String.valueOf(j)).getJSONObject("sku").getJSONObject("data").getString("title") + "*\n");
//                }
//                mensagemPedido.append("\n\n");
//            } catch (Exception e) {
//                mensagemPedido.append("*Verifiquei que está tudo certo com seu pedido!* \uD83D\uDE42 \n");
//                mensagemPedido.append("Ele está na *fase final* de processamento! \uD83D\uDCE6 \n");
//                mensagemPedido.append("Assim que o centro logístico liberar seu *código de rastreio*, iremos te informar *automaticamente por e-mail*, junto à todas as atualizações da entrega...\uD83D\uDE9A \n\n");
//
//                mensagemPedido.append("Os motivos dessa ocorrência pode ser:\n");
//                mensagemPedido.append("\uD83D\uDD39 Pode tratar de um pedido feito recentemente.\n");
//                mensagemPedido.append("\uD83D\uDD39 Atraso na postagem do pedido.\n");
//                mensagemPedido.append("\uD83D\uDD39 Acumulo de pedidos para ser processados.\n\n");
//
//                mensagemPedido.append("*Mas não se preocupe logo será postado*.\n\n");
//            }
//            mensagem.append(mensagemPedido);
//        }
//
//    }

    public RastreioEntity retornaRastreioProxyapp(String rastreio) throws ParseException {

        Mono<String> response = WebClient
                .builder()
                .build()
                .get()
                .uri("https://proxyapp.correios.com.br/v1/sro-rastro/{rastreio}", rastreio)
                .accept(MediaType.APPLICATION_XML)
                .retrieve()
                .bodyToMono(String.class);



        JSONObject jsonObject = new JSONObject(response.block());

        JSONArray objetos = new JSONArray(jsonObject.getJSONArray("objeto").toString());

//        try {
//            rastreioModel.setEvento(jsonResponse.getJSONArray("objetos").getJSONObject(0).getJSONArray("eventos").getJSONObject(0).getString("descricao"));
//            String[] dataHora = jsonResponse.getJSONArray("objetos").getJSONObject(0).getJSONArray("eventos").getJSONObject(0).getString("dtHrCriado").split("T");
//            Date data = new SimpleDateFormat("yyyy-MM-dd").parse(dataHora[0]);
//            rastreioModel.setData(new SimpleDateFormat("dd/MM/yyyy").format(data));
//            rastreioModel.setHora(dataHora[1]);
//            rastreioModel.setCidade(jsonResponse.getJSONArray("objetos").getJSONObject(0).getJSONArray("eventos").getJSONObject(0).getJSONObject("unidade").getJSONObject("endereco").getString("cidade"));
//            rastreioModel.setUf(jsonResponse.getJSONArray("objetos").getJSONObject(0).getJSONArray("eventos").getJSONObject(0).getJSONObject("unidade").getJSONObject("endereco").getString("uf"));
//
//        } catch (Exception e) {
//            rastreioModel.setEvento("Sem informação de rastreio");
//        }
//        rastreioModel.setTimeExec(new Utils().HoraFormatada(LocalDateTime.now()));
        return new RastreioEntity();
    }

    public void rastrioEmMassa(String rastreios) throws JSONException, SQLException {

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

        List<RastreioEntity> rastreioList = new ArrayList<>();
//        for (int i = 0; i < objetos.length(); i++) {
//            RastreioEntity rastreiosModel = new RastreioEntity();
//            rastreiosModel.setTrackCode(objetos.getJSONObject(i).getString("numero"));
//            try {
//                rastreiosModel.setDescription(objetos.getJSONObject(i).getJSONArray("evento").getJSONObject(0).getString("descricao"));
//                rastreiosModel.setDate(objetos.getJSONObject(i).getJSONArray("evento").getJSONObject(0).getString("data"));
//                rastreiosModel.setHour(objetos.getJSONObject(i).getJSONArray("evento").getJSONObject(0).getString("hora"));
//                rastreiosModel.setCity(objetos.getJSONObject(i).getJSONArray("evento").getJSONObject(0).getJSONObject("unidade").getString("cidade"));
//                rastreiosModel.setUf(objetos.getJSONObject(i).getJSONArray("evento").getJSONObject(0).getJSONObject("unidade").getString("uf"));
//            } catch (JSONException e) {
//                rastreiosModel.setTrackCode(objetos.getJSONObject(i).getString("numero"));
//                rastreiosModel.setDescription(objetos.getJSONObject(i).getString("categoria"));
//            }
//            rastreioList.add(rastreiosModel);
//
//
//        }


        System.out.println();

    }
}

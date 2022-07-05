package br.com.roobox.chatbot.Yampi.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import br.com.roobox.chatbot.Whatsapp.Entity.WhatsappConfigEntity;
import br.com.roobox.chatbot.Whatsapp.Repository.WhatsappConfigRepository;
import br.com.roobox.chatbot.Yampi.Cart.Service.CartService;
import br.com.roobox.chatbot.Yampi.Entity.WebhookEntity;
import br.com.roobox.chatbot.Yampi.Entity.YampiEntity;
import br.com.roobox.chatbot.Yampi.Repository.WebhookRepository;
import br.com.roobox.chatbot.Yampi.Repository.YampiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.io.IOException;
import java.text.ParseException;
import java.util.Optional;

@Service
public class WebhookService {

//    @Autowired
//    private YampiRepository yampiRepository;
//
//    @Autowired
//    private WhatsappConfigRepository whatsappConfigRepository;
//
//    @Autowired
//    private WebhookRepository webhookRepository;


//    private ResponseEntity<String> update(@RequestHeader("X-Yampi-Hmac-SHA256") String yampiHmac, @RequestBody String payload) throws ParseException, IOException {
//        ObjectMapper mapper = new ObjectMapper();
//        JsonNode rootNode = mapper.readTree(payload);
//
//        String alias = rootNode.get("merchant").get("alias").asText();
//        Optional<YampiEntity> yampiEntityOptional = yampiRepository.findByAlias(alias);
//        if (yampiEntityOptional.isPresent()) {
//            YampiEntity yampi = yampiEntityOptional.get();
//            WhatsappConfigEntity whatsappConfig = whatsappConfigRepository.findByYampiId(yampiEntity.getUser().getId());
//            WebhookEntity webhook = webhookRepository.findByYampiId(yampiEntity.getId());
//
//            String hmac = new Hmac_Sha256Service().validaHMAC(webhook.getChaveSecretaWebhook(), payload);
//
//            if (!hmac.equals(yampiHmac))
//                return new ResponseEntity<>(HttpStatus.NON_AUTHORITATIVE_INFORMATION);
//
//<<<<<<< HEAD
//            new CartService().abandonedCart(whatsappConfig.isCart(), rootNode);
//=======
//
//            if (rootNode.get("event").asText().equals("cart.reminder") || whatsappConfig.isCart()) {
//                new CartService().abandonedCart(rootNode, yampiEntity);
//                return new ResponseEntity<>(HttpStatus.CREATED);
//            }
//
//            OrdersEntity orders = new OrdersEntity();
//
//            if (!existePedido(jsonObject, yampiModel.getIdCliente(), clienteModel.getToken())) { //TODO TROCAR
//                try {
//                    new com.mr.RoboShopify.API.Database().insert(inserePedidos(jsonObject, whatsappModel, yampiModel, utils), "drop-pedidos", clienteModel.getToken()); //TODO TROCAR
//                } catch (Exception ignored) {
//                }
//>>>>>>> origin/development
//
//            new ResponseEntity<>(HttpStatus.OK);
//        } else {
//            new ResponseEntity<>(HttpStatus.NOT_FOUND);
//
//
//
////
//            if (!existePedido(jsonObject, yampiModel.getIdCliente(), clienteModel.getToken())) { //TODO TROCAR
//                try {
//                    new com.mr.RoboShopify.API.Database().insert(inserePedidos(jsonObject, whatsappModel, yampiModel, utils), "drop-pedidos", clienteModel.getToken()); //TODO TROCAR
//                } catch (Exception ignored) {
//                }
//
////////////////////////CARTÃO RECUSADO
//                switch (jsonObject.getString("event")) {
//                    case "transaction.payment.refused":
//                        new ApiYampi_Content().cartaoRecusado(whatsappModel, yampiModel, jsonObject);
//                        break;
////////////////////////CARTÃO RECUSADO
//
//
//                    case "order.created":
//                        System.out.println("TIPO da ordem: " + jsonObject.getJSONObject("resource").getJSONObject("search").getJSONObject("data").getString("payment_method"));
//                        System.out.println("Aprovado: " + jsonObject.getJSONObject("resource").getBoolean("authorized"));
//
////////////////////////// BOLETO
//                        if ((!jsonObject.getJSONObject("resource").getBoolean("authorized")) && (jsonObject.getJSONObject("resource").getJSONObject("search").getJSONObject("data").getString("payment_method").equals("billet"))) {
//                            new ApiYampi_Content().boleto(whatsappModel, yampiModel, jsonObject, clienteModel);
////////////////////////// BOLETO
//
//                        } else {
//////////////////////////CARTAO DE CREDITO
//                            if (jsonObject.getJSONObject("resource").getBoolean("authorized")) {
//                                jsonObject.getJSONObject("resource").getJSONObject("search").getJSONObject("data").getString("payment_method");
//                            }
//////////////////////////CARTAO DE CREDITO
//                        }
//                        if (jsonObject.getJSONObject("resource").getJSONObject("status").getJSONObject("data").getString("name").equals("Pagamento aprovado")) {
//                        }
//                        break;
//                    case "order.paid":
//                        //TODO
//                        break;
//                }
//            } else {
///////////////////////UPDATE PEDIDO/RASTREIO
//                if (jsonObject.getString("event").contains("updated")) {
/////////////////////////CANCELADO
//                    switch (jsonObject.getJSONObject("resource").getJSONObject("status").getJSONObject("data").getString("name")) {
//                        case "Cancelado":
//                            System.out.println(LocalDateTime.now() + " - Webhook recebido: Cancelado");
//                            new ApiYampi_Content().updatePedido(jsonObject, whatsappModel, yampiModel, clienteModel);
//                            break;
/////////////////////////CANCELADO
//
/////////////////////////PAGAMENTO APROVADO
//                        case "Pagamento aprovado":
//                            System.out.println(LocalDateTime.now() + " - Webhook recebido: Pagamento Aprovado");
//                            new ApiYampi_Content().updatePedido(jsonObject, whatsappModel, yampiModel, clienteModel);
//                            break;
/////////////////////////PAGAMENTO APROVADO
//
/////////////////////////EM TRANSPORTE
//                        case "Em transporte":
//                            System.out.println(LocalDateTime.now() + " - Webhook recebido: Em transporte");
//                            new ApiYampi_Content().updateRastreio(jsonObject, whatsappModel, yampiModel);
//                            break;
/////////////////////////ENTREGUE
//                        case "Entregue":
//                            System.out.println(LocalDateTime.now() + " - Webhook recebido: Entregue");
//                            new ApiYampi_Content().updateRastreio(jsonObject, whatsappModel, yampiModel);
//                            break;
//                    }
/////////////////////////ENTREGUE
//                }
//            }
//            return new ResponseEntity(HttpStatus.OK);
//
//        }
//
//        }
//        return null;
//    }
}

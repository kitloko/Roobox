package br.com.roobox.chatbot.Yampi.Service;

import br.com.roobox.chatbot.Yampi.ChatbotYampi.Entity.MessageEntity;
import br.com.roobox.chatbot.Yampi.Customer.Entity.CustomerEntity;
import br.com.roobox.chatbot.Yampi.Customer.Repository.CustomerRepository;
import br.com.roobox.chatbot.Yampi.Customer.Service.CustomerService;
import br.com.roobox.chatbot.Yampi.Entity.YampiEntity;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class YampiService {

    @Autowired
    CustomerRepository customerRepository;

    public void apiYampi(String opcao, MessageEntity mensagem, YampiEntity yampi) {

        CustomerEntity customer = consultaCPF(mensagem, yampi);
        if (customer.getCpf() == null)
            System.out.println();
        else {
            switch (opcao) {
                case "1":
                    return rastrearPedido(customer, yampi);
                break;
//            case "2":
//                return pedido(mensagem.getContent(), yampi);
//            break;
//            case "3":
//                return pedido(mensagem.getContent(), yampi);
//            break;
//            case "4":
//                return pedido(mensagem.getContent(), yampi);
//            break;
            }
        }
    }

    private void rastrearPedido(CustomerEntity customer, YampiEntity yampi) {
        StringBuilder mensagem = new StringBuilder();
        JSONObject listaPedido = consultaPedidos(CPF, yampiModel);

        //CONSULTA O RASTREIO DO PEDIDO
//        JSONObject rastreio = rastrearYampi(listaPedido);

        RastreioModel rastreioModel = new RastreioModel();

        for (int i = 0; i < listaPedido.getJSONObject("pedido").length(); i++) {
            StringBuilder mensagemPedido = new StringBuilder();

            try {
                rastreioModel.setRastreio(listaPedido.getJSONObject("pedido").getJSONObject("0").getString("track_code"));
                rastreioModel = new ConsultaRastreios().retornaRastreioProxyapp(rastreioModel);
                if (rastreioModel.getEvento().equals("Sem informação de rastreio")) {

                } else {
                    if (rastreioModel.getEvento().equals("Objeto entregue ao destinatário")) {
                        mensagemPedido.append("Seu pedido foi *entregue ao destinatário* ✅\n");
                        mensagemPedido.append("\uD83D\uDCC5 No dia *" + rastreioModel.getData() + " " + rastreioModel.getHora() + " em " + rastreioModel.getCidade() + "*\n");
                        mensagemPedido.append("\uD83D\uDCE6 O código de rastreio é: *" + rastreioModel.getRastreio() + "*\n\n");
                    } else {
                        if (new FlowRastreamento().verificaEstado(rastreioModel.getCidade())) {
                            mensagemPedido.append("\uD83D\uDE9A Sua encomenda está em *" + rastreioModel.getCidade() + "*\n");
                        } else {
                            mensagemPedido.append("\uD83D\uDE9A Sua encomenda está em transito\n");
                        }
                        mensagemPedido.append("\uD83D\uDCC5 Ultima atualização *" + rastreioModel.getData() + " " + rastreioModel.getHora() + "*\n");
                        mensagemPedido.append(rastreioModel.getEvento() + " \n");
                        mensagemPedido.append("\uD83D\uDCE6 O código de rastreio é: *" + rastreioModel.getRastreio() + "*\n\n");
                        mensagemPedido.append("⏰ " + previsaoEntrega(listaPedido, i) + "\n\n");
                    }
                }


//            rastreioCorreios(listaPedido.getJSONObject("pedido").getJSONObject(String.valueOf(i)).getString("track_code"), mensagemPedido);

                if (mensagemPedido.toString().isEmpty())
                    rastreioCainiao(listaPedido.getJSONObject("pedido").getJSONObject(String.valueOf(i)).getString("track_code"), mensagemPedido);

                if (mensagemPedido.toString().isEmpty()) {
                    JSONObject statusPedido = listaPedido.getJSONObject("pedido").getJSONObject(String.valueOf(i)).getJSONObject("status").getJSONObject("data");

                    mensagemPedido.append("Seu pedido está: *" + statusPedido.getString("name") + "* \uD83D\uDE9A \n");
                    mensagemPedido.append(statusPedido.getString("description") + "\n");
                    mensagemPedido.append("\uD83D\uDCE6 O código de rastreio é: *" + listaPedido.getJSONObject("pedido").getJSONObject(String.valueOf(i)).getString("track_code") + "*\n");
//                    mensagemPedido.append("⏰ " + previsaoEntrega(listaPedido, i) + "\n\n");
                }

                mensagemPedido.append("Os itens do pedido pedido " + listaPedido.getJSONObject("pedido").getJSONObject(String.valueOf(i)).get("number").toString() + " são \n");
                JSONObject produtosLista = listaPedido.getJSONObject("produto").getJSONObject(String.valueOf(listaPedido.getJSONObject("pedido").getJSONObject(String.valueOf(i)).get("number").toString()));
                for (int j = 0; j < produtosLista.length(); j++) {
                    mensagemPedido.append("\uD83D\uDD39️*" + produtosLista.getJSONObject(String.valueOf(j)).getInt("quantity") + " " + produtosLista.getJSONObject(String.valueOf(j)).getJSONObject("sku").getJSONObject("data").getString("title") + "*\n");
                }
                mensagemPedido.append("\n\n");
            } catch (Exception e) {
                mensagemPedido.append("*Verifiquei que está tudo certo com seu pedido!* \uD83D\uDE42 \n");
                mensagemPedido.append("Ele está na *fase final* de processamento! \uD83D\uDCE6 \n");
                mensagemPedido.append("Assim que o centro logístico liberar seu *código de rastreio*, iremos te informar *automaticamente por e-mail*, junto à todas as atualizações da entrega...\uD83D\uDE9A \n\n");

                mensagemPedido.append("Os motivos dessa ocorrência pode ser:\n");
                mensagemPedido.append("\uD83D\uDD39 Pode tratar de um pedido feito recentemente.\n");
                mensagemPedido.append("\uD83D\uDD39 Atraso na postagem do pedido.\n");
                mensagemPedido.append("\uD83D\uDD39 Acumulo de pedidos para ser processados.\n\n");

                mensagemPedido.append("*Mas não se preocupe logo será postado*.\n\n");
            }
            mensagem.append(mensagemPedido);
        }

    }

//    private StringBuilder pedido(String CPF, YampiModel yampiModel) {
//        StringBuilder mensagem = new StringBuilder();
//        JSONObject listaPedido = consultaPedidos(CPF, yampiModel);
//
//        for (int i = 0; i < listaPedido.getJSONObject("pedido").length(); i++) {
//            StringBuilder mensagemPedido = new StringBuilder();
//            mensagemPedido.append("Os itens do pedido pedido " + listaPedido.getJSONObject("pedido").getJSONObject(String.valueOf(i)).get("number").toString() + " são \n");
//            JSONObject produtosLista = listaPedido.getJSONObject("produto").getJSONObject(String.valueOf(listaPedido.getJSONObject("pedido").getJSONObject(String.valueOf(i)).get("number").toString()));
//
//            for (int j = 0; j < produtosLista.length(); j++) {
//                mensagemPedido.append("\uD83D\uDD39️*" + produtosLista.getJSONObject(String.valueOf(j)).getInt("quantity") + " " + produtosLista.getJSONObject(String.valueOf(j)).getJSONObject("sku").getJSONObject("data").getString("title") + "*\n");
//                mensagemPedido.append("\uD83D\uDCE6 O código de rastreio é: *" + listaPedido.getJSONObject("pedido").getJSONObject(String.valueOf(i)).getString("track_code") + "*\n");
//            }
//
//            mensagemPedido.append("\n\n");
//            mensagem.append(mensagemPedido);
//        }
//        return mensagem;
//    }
//
//    private void getBoleto(Message message, YampiModel yampiModel, WhatsappModel whatsappModel) {
//        StringBuilder mensagem = new StringBuilder();
//        JSONObject listaPedido = consultaPedidos(message.getContent(), yampiModel);
//
//        if (listaPedido.length() >= 3) {
//            JSONObject transactions = listaPedido.getJSONObject("pedido").getJSONObject("0").getJSONObject("transactions").getJSONArray("data").getJSONObject(0);
//
//            if (transactions.getJSONObject("payment").getJSONObject("data").getBoolean("is_credit_card")) {
//                mensagem.append("Esse pedido foi pago por cartão de crédito");
//                new ApiWhatsapp().sendMessage(message, mensagem, whatsappModel);
//
//            } else if (transactions.getJSONObject("payment").getJSONObject("data").getBoolean("is_pix")) {
//                mensagem.append("Esse pedido foi pago por Pix");
//                new ApiWhatsapp().sendMessage(message, mensagem, whatsappModel);
//
//            } else if (transactions.getString("status").equals("paid")) {
//                mensagem.append("Esse pedido já foi pago");
//                new ApiWhatsapp().sendMessage(message, mensagem, whatsappModel);
//
//            } else {
//
//                mensagem.append("Já separamos seu produto e estamos apenas aguardando a *confirmação do pagamento do boleto* para enviarmos o seu pedido \uD83D\uDCE6\n\n");
//
//                for (int i = 0; i < listaPedido.getJSONObject("pedido").length(); i++) {
//
//                    mensagem.append("Os itens do pedido pedido " + listaPedido.getJSONObject("pedido").getJSONObject(String.valueOf(i)).get("number").toString() + " são \n");
//                    JSONObject produtosLista = listaPedido.getJSONObject("produto").getJSONObject(String.valueOf(listaPedido.getJSONObject("pedido").getJSONObject(String.valueOf(i)).get("number").toString()));
//                    for (int j = 0; j < produtosLista.length(); j++) {
//                        mensagem.append("\uD83D\uDD39️*" + produtosLista.getJSONObject(String.valueOf(j)).getInt("quantity") + " " + produtosLista.getJSONObject(String.valueOf(j)).getJSONObject("sku").getJSONObject("data").getString("title") + "*\n");
//                    }
//                    mensagem.append("\n\n");
//                }
//
//                String codigo = transactions.getString("billet_barcode");
//                String url = transactions.getString("billet_url");
//                Double valor = transactions.getDouble("amount");
//
//                String data = transactions.getJSONObject("billet_date").getString("date");
//                Utils u = new Utils();
//                data = u.formataData(data);
//                data = data.split(" ")[0];
//
//                mensagem.append("\uD83E\uDDFE Boleto no valor de *R$ " + valor + "* com vencimento para *" + data + "*\n");
//                //mensagem.append("\uD83D\uDD17 *Link do boleto* " + url + "\n");
//                mensagem.append("\uD83D\uDC49 *Código de pagamento do boleto*: " + codigo);
//
//                new ApiWhatsapp().sendMessage(message, mensagem, whatsappModel);
//
//                String pdfBase64 = "";
//                pdfBase64 = new Utils().urlBoletoToBase64(url);
//                if (!pdfBase64.isEmpty())
//                    System.out.println();
//                new ApiWhatsapp().sendMessagePdf(message, pdfBase64, "BOLETO - " + listaPedido.getJSONObject("pedido").getJSONObject("0").getJSONObject("customer").getJSONObject("data").getString("name"), whatsappModel);
//
//            }
//        } else {
//            mensagem.append("*Não encontramos o CPF em nossa loja*.\n\n\uD83D\uDC49\uD83C\uDFFB  Por favor, verifique se o CPF está digitado corretamente ou é o CPF utilizado na compra do pedido.");
//            new ApiWhatsapp().sendMessageYampi(message.getFrom(), mensagem, whatsappModel);
//        }
//
//    }
//
//    private StringBuilder retornaPedidosCliente(JSONObject json, YampiModel whatsappModel) {
//        JSONObject listaPedido = consultaPedidos(json.getString("response"), whatsappModel);
//        StringBuilder mensagemPedido = new StringBuilder();
//        for (int i = 0; i < listaPedido.getJSONObject("pedido").length(); i++) {
//            if (!(i == listaPedido.length())) {
//                mensagemPedido.append(listaPedido.getJSONObject("pedido").getJSONObject("0").get("number").toString());
//            } else {
//                mensagemPedido.append(listaPedido.getJSONObject("pedido").getJSONObject("0").get("number").toString()).append(",\n");
//            }
//        }
//        return mensagemPedido;
//    }

    private CustomerEntity consultaCPF(MessageEntity message, YampiEntity yampi) {
        String cpf = message.getContent().replace(".", "").replace("-", "").replace(" ", "");
        ;
        CustomerEntity customer = new CustomerEntity();
        customer = Optional.ofNullable(customerRepository.findByCpf(cpf)).orElse(customer);
        CustomerService customerService = new CustomerService();
        JSONObject clienteYampi = customerService.findClientesYampi(cpf, yampi);
        if (clienteYampi.isEmpty())
            return customer;
        customer.setCpf(cpf);
        customer.setEmail(clienteYampi.getString("email"));
        customer.setName("first_name");
        customer.setPhone(message.getContactUser().getNumber());
        customerRepository.save(customer);

        return customer;

    }
}

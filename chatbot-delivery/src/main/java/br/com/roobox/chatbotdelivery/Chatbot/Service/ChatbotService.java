package br.com.roobox.chatbotdelivery.Chatbot.Service;

import br.com.roobox.chatbotdelivery.Chatbot.Entity.ChatbotControllerEntity;
import br.com.roobox.chatbotdelivery.Chatbot.Entity.ChatbotMessageEntity;
import br.com.roobox.chatbotdelivery.Chatbot.Entity.ChatbotMessageModelsEntity;
import br.com.roobox.chatbotdelivery.Chatbot.Exceptions.StoreNotFoundException;
import br.com.roobox.chatbotdelivery.Chatbot.Exceptions.WhatsappNotFoundException;
import br.com.roobox.chatbotdelivery.Chatbot.Repository.ChatbotControllerRepository;
import br.com.roobox.chatbotdelivery.Chatbot.Repository.ChatbotMessageModelsRepository;
import br.com.roobox.chatbotdelivery.Chatbot.Repository.ChatbotMessageRepository;
import br.com.roobox.chatbotdelivery.Delivery.Entity.StoreEntity;
import br.com.roobox.chatbotdelivery.Delivery.Repository.StoreRepository;
import br.com.roobox.chatbotdelivery.Message.Entity.MessageEntity;
import br.com.roobox.chatbotdelivery.Whatsapp.Entity.Whatsapp;
import br.com.roobox.chatbotdelivery.Whatsapp.Repository.WhatsappRepository;
import br.com.roobox.chatbotdelivery.Whatsapp.Service.WhatsappService;
import com.google.gson.Gson;
import org.joda.time.DateTime;
import org.joda.time.Minutes;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.Instant;
import java.util.Optional;

@Service
@RequestMapping("/chatbot")
public class ChatbotService {

    @Autowired
    WhatsappRepository whatsappRepository;

    @Autowired
    ChatbotControllerRepository chatbotYampiControllerRepository;

    @Autowired
    StoreRepository storeRepository;

    @Autowired
    ChatbotMessageModelsRepository chatbotMessageModelsRepository;

    @Autowired
    WhatsappService whatsappService;

    @Autowired
    ChatbotMessageRepository chatbotMessageRepository;


    @PostMapping(path = "/whatsapp")
    @ResponseBody
    public ResponseEntity whatsapp(@RequestBody String json) throws Exception {
        MessageEntity message = new Gson().fromJson(json, MessageEntity.class);
        if (message.getStatus().equals("RESPONDIDA")) {
            controladorChatBot(message);
        }
        return new ResponseEntity(HttpStatus.OK);
    }

    public void controladorChatBot(MessageEntity message) {
        consultaCliente(message);
    }

    private void consultaCliente(MessageEntity message) {
        Whatsapp whatsapp = Optional.ofNullable(whatsappRepository.findByIntegration(message.getIntegrationId())).orElseThrow(() -> new WhatsappNotFoundException(message.getIntegrationId()));
        ChatbotControllerEntity controlChatBot = chatbotYampiControllerRepository.findByNumber(message.getContactUser().getNumber());
        ChatbotMessageModelsEntity chatbotYampiMessageModels;
        StoreEntity store = Optional.ofNullable(storeRepository.findById(whatsapp.getStore().getId())).orElseThrow(StoreNotFoundException::new);
        if (controlChatBot != null) {
            switch (controlChatBot.getSequence()) {
                case 1:
                    chatbotYampiMessageModels = Optional.ofNullable(getMessageModel(store, controlChatBot.getSequence())).orElse(getMessageModel(2, controlChatBot.getSequence()));
//                    whatsappService.sendMessageYampi(message, replaceText(chatbotYampiMessageModels.getText(), message, yampi), whatsapp);
                    chatbotMessageRepository.save(montaChatbotMessage(store, message, controlChatBot.getSequence()));
                    controlChatBot.setSequence(2);
                    controlChatBot.setResponse("Op????o escolhida");
                    break;
                case 2:
                    System.out.println("Valida CPF");
                    System.out.println("Consulta a op????o escolhida");
                    System.out.println("Retorna informa????es");
                    System.out.println("Pergunta se satisfaz");
                    controlChatBot.setSequence(3);
                    break;
                case 3:
                    System.out.println("Valida satisfa????o");
                    System.out.println("Se 1 ent??o agradece");
                    controlChatBot.setSequence(6);
                    System.out.println("Se 2 ent??o pede descri????o para enviar email");
                    controlChatBot.setSequence(4);
                    break;
                case 4:
                    System.out.println("Recebe Descri????o");
                    System.out.println("Encaminha e-mail");
                    System.out.println("Finaliza conversa");
                    controlChatBot.setSequence(6);
                    break;
                case 6:
                    System.out.println("Verifica ultima etapa");
                    if (validaHorario(controlChatBot.getUpdateAt()))
                        System.out.println("Fora do horario");
                    System.out.println("Valida o tempo da ultima conversa");
                    System.out.println("Se ok");
                    controlChatBot.setSequence(0);
                    System.out.println("Se n??o, explica o motivo");
                    controlChatBot.setSequence(6);
                    break;
                default:
                    chatbotYampiMessageModels = Optional.ofNullable(getMessageModel(store, 0)).orElse(getMessageModel(1, 0));
                    whatsappService.sendMessage(message, replaceText(chatbotYampiMessageModels.getText(), message, store), whatsapp);
                    controlChatBot.setSequence(1);
            }
            chatbotYampiControllerRepository.save(controlChatBot);
        } else {
            controlChatBot = new ChatbotControllerEntity();
            controlChatBot.setStore(store);
            controlChatBot.setNumber(message.getContactUser().getNumber());
            controlChatBot.setResponse(message.getContent());
            controlChatBot.setSequence(1);
            chatbotYampiControllerRepository.save(controlChatBot);

            chatbotYampiMessageModels = Optional.ofNullable(getMessageModel(store, 0)).orElse(getMessageModel(1, 0));
//            whatsappService.sendMessageYampi(message, replaceText(chatbotYampiMessageModels.getText(), message, yampi), whatsapp);
        }

    }


    private boolean validaHorario(Instant updateAt) {
        DateTimeFormatter format = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ssZ");
        org.joda.time.DateTime dateTime = format.parseDateTime(updateAt.toString());
        dateTime.getMinuteOfHour();
        DateTime dateTimeNow = new DateTime();
        int diferenca = Minutes.minutesBetween(dateTime, dateTimeNow).getMinutes();
        return diferenca >= 15;
    }

    private ChatbotMessageModelsEntity getMessageModel(StoreEntity store, int sequence) {
        return chatbotMessageModelsRepository.findByStoreIdAndSequence(store.getId(), sequence);
    }

    private ChatbotMessageModelsEntity getMessageModel(long id, int sequence) {
        return chatbotMessageModelsRepository.findByIdAndSequence(id, sequence);
    }

    private String replaceText(String text, MessageEntity message, StoreEntity store) {
        return text.replace("<nome_cliente>", message.getContactUser().getName())
//                .replace("<reorder_url>", pixModel.getReorderUrl())
//                .replace("<produtos>", pixModel.getNomeProduto().replace(",", "\n"))
                .replace("<nome_loja>", store.getShopName());
    }

    private ChatbotMessageEntity montaChatbotMessage(StoreEntity store, MessageEntity message, int sequence) {
        ChatbotMessageEntity chatbotMessage = new ChatbotMessageEntity();
        chatbotMessage.setMessage(message.getContent());
        chatbotMessage.setStore(store);
        chatbotMessage.setSequence(sequence);

        return chatbotMessage;
    }
}

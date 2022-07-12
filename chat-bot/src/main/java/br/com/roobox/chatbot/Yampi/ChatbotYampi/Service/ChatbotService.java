package br.com.roobox.chatbot.Yampi.ChatbotYampi.Service;

import br.com.roobox.chatbot.Whatsapp.Entity.Whatsapp;
import br.com.roobox.chatbot.Whatsapp.Repository.WhatsappRepository;
import br.com.roobox.chatbot.Whatsapp.Service.WhatsappService;
import br.com.roobox.chatbot.Yampi.ChatbotYampi.Entity.ChatbotMessageEntity;
import br.com.roobox.chatbot.Yampi.ChatbotYampi.Entity.ChatbotYampiControllerEntity;
import br.com.roobox.chatbot.Yampi.ChatbotYampi.Entity.ChatbotYampiMessageModelsEntity;
import br.com.roobox.chatbot.Yampi.ChatbotYampi.Entity.MessageEntity;
import br.com.roobox.chatbot.Yampi.ChatbotYampi.Exceptions.WhatsappNotFoundException;
import br.com.roobox.chatbot.Yampi.ChatbotYampi.Exceptions.YampiNotFoundException;
import br.com.roobox.chatbot.Yampi.ChatbotYampi.Repository.ChatbotMessageRepository;
import br.com.roobox.chatbot.Yampi.ChatbotYampi.Repository.ChatbotYampiControllerRepository;
import br.com.roobox.chatbot.Yampi.ChatbotYampi.Repository.ChatbotYampiMessageModelsRepository;
import br.com.roobox.chatbot.Yampi.Customer.Service.CustomerService;
import br.com.roobox.chatbot.Yampi.Entity.YampiEntity;
import br.com.roobox.chatbot.Yampi.Repository.YampiRepository;
import br.com.roobox.chatbot.Yampi.Service.YampiService;
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
    ChatbotYampiControllerRepository chatbotYampiControllerRepository;

    @Autowired
    YampiRepository yampiRepository;

    @Autowired
    ChatbotYampiMessageModelsRepository chatbotYampiMessageModelsRepository;

    @Autowired
    WhatsappService whatsappService;

    @Autowired
    ChatbotMessageRepository chatbotMessageRepository;

    @Autowired
    YampiService yampiService;


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
        ChatbotYampiControllerEntity controlChatBot = chatbotYampiControllerRepository.findByNumber(message.getContactUser().getNumber());
        ChatbotYampiMessageModelsEntity chatbotYampiMessageModels;
        YampiEntity yampi = Optional.ofNullable(yampiRepository.findById(whatsapp.getYampi().getId())).orElseThrow(YampiNotFoundException::new);
        if (controlChatBot != null) {
            switch (controlChatBot.getSequence()) {
                case 1:
                    chatbotYampiMessageModels = Optional.ofNullable(getMessageModel(yampi, controlChatBot.getSequence())).orElse(getMessageModel(2, controlChatBot.getSequence()));
//                    whatsappService.sendMessageYampi(message, replaceText(chatbotYampiMessageModels.getText(), message, yampi), whatsapp);
                    chatbotMessageRepository.save(montaChatbotMessage(yampi, message, controlChatBot.getSequence()));
                    controlChatBot.setSequence(2);
                    controlChatBot.setResponse("Opção escolhida");
                    break;
                case 2:
                    yampiService.apiYampi(controlChatBot.getResponse(),message,yampi);
                    System.out.println("Valida CPF");
                    System.out.println("Consulta a opção escolhida");
                    System.out.println("Retorna informações");
                    System.out.println("Pergunta se satisfaz");
                    controlChatBot.setSequence(3);
                    break;
                case 3:
                    System.out.println("Valida satisfação");
                    System.out.println("Se 1 então agradece");
                    controlChatBot.setSequence(6);
                    System.out.println("Se 2 então pede descrição para enviar email");
                    controlChatBot.setSequence(4);
                    break;
                case 4:
                    System.out.println("Recebe Descrição");
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
                    System.out.println("Se não, explica o motivo");
                    controlChatBot.setSequence(6);
                    break;
                default:
                    chatbotYampiMessageModels = Optional.ofNullable(getMessageModel(yampi, 0)).orElse(getMessageModel(1, 0));
                    whatsappService.sendMessageYampi(message, replaceText(chatbotYampiMessageModels.getText(), message, yampi), whatsapp);
                    controlChatBot.setSequence(1);
            }
            chatbotYampiControllerRepository.save(controlChatBot);
        } else {
            controlChatBot = new ChatbotYampiControllerEntity();
            controlChatBot.setYampi(yampi);
            controlChatBot.setNumber(message.getContactUser().getNumber());
            controlChatBot.setResponse(message.getContent());
            controlChatBot.setSequence(1);
            chatbotYampiControllerRepository.save(controlChatBot);

            chatbotYampiMessageModels = Optional.ofNullable(getMessageModel(yampi, 0)).orElse(getMessageModel(1, 0));
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

    private ChatbotYampiMessageModelsEntity getMessageModel(YampiEntity yampi, int sequence) {
        return chatbotYampiMessageModelsRepository.findByYampiIdAndSequence(yampi.getId(), sequence);
    }

    private ChatbotYampiMessageModelsEntity getMessageModel(long id, int sequence) {
        return chatbotYampiMessageModelsRepository.findByIdAndSequence(id, sequence);
    }

    private String replaceText(String text, MessageEntity message, YampiEntity yampi) {
        return text.replace("<nome_cliente>", message.getContactUser().getName())
//                .replace("<reorder_url>", pixModel.getReorderUrl())
//                .replace("<produtos>", pixModel.getNomeProduto().replace(",", "\n"))
                .replace("<nome_loja>", yampi.getShopName());
    }

    private ChatbotMessageEntity montaChatbotMessage(YampiEntity yampi, MessageEntity message, int sequence) {
        ChatbotMessageEntity chatbotMessage = new ChatbotMessageEntity();
        chatbotMessage.setMessage(message.getContent());
        chatbotMessage.setYampi(yampi);
        chatbotMessage.setSequence(sequence);

        return chatbotMessage;
    }
}

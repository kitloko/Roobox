package br.com.roobox.chatbot.Whatsapp.Entity;

import lombok.Data;

import java.util.List;

@Data
public class WhatsappMessageAmount {

    private int amountBillet;
    private int amountCart;
    private int amountCard;
    private int amountwithdrawal;

    private List<WhatsappMessage> top5;
}

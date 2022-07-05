package br.com.roobox.chatbot.Whatsapp.Entity;

import lombok.Data;

@Data
public class WhatsappInfo {
    private String id;
    private String name;
    private String accountName;
    private String accountDescription;
    private String device;
    private String model;
    private String battery;
    private String state;
    private String avatar;
    private int balance;
    private String billingType;
    private int totalMessageSent;
    private int totalMessagesReceived;
    private int totalContacts;
}

package br.com.roobox.chatbotdelivery.Message.Entity;

import lombok.Data;

@Data
public class MessageEntity {

    private String id;
    private String channel;
    private String type;
    private String status;
    private String to;
    private String from;
    private String answeredDate;
    private String creationDate;
    private String sendDate;
    private String readDate;
    private String receivedDate;
    private String content;
    private String idMessage;
    private String base64;
    private String fileName;
    private ContactUserEntity contactUser;
    private ContactBusinessEntity contactBusiness;
    private String urlFile;
    private String integrationId;

}
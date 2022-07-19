package br.com.roobox.chatbotdelivery.Message.Entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ContactBusinessEntity {

  private Long id;
  private String name;
  private String number;
  private LocalDateTime created;
  private LocalDateTime updated;
  private String profileImageUrl;
}
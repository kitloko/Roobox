package br.com.roobox.chatbotdelivery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ChatbotDeliveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChatbotDeliveryApplication.class, args);
    }

}

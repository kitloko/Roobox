package br.com.roobox.chatbotdelivery.Chatbot.Repository;

import br.com.roobox.chatbotdelivery.Chatbot.Entity.ChatbotControllerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public interface ChatbotControllerRepository extends JpaRepository<ChatbotControllerEntity, Long> {
    ChatbotControllerEntity findByNumber(String number);
}

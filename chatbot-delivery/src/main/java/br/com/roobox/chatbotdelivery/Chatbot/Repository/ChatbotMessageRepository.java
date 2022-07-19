package br.com.roobox.chatbotdelivery.Chatbot.Repository;

import br.com.roobox.chatbotdelivery.Chatbot.Entity.ChatbotMessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public interface ChatbotMessageRepository extends JpaRepository<ChatbotMessageEntity, Long> {
}

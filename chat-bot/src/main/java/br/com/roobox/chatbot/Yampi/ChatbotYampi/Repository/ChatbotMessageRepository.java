package br.com.roobox.chatbot.Yampi.ChatbotYampi.Repository;

import br.com.roobox.chatbot.Yampi.ChatbotYampi.Entity.ChatbotMessageEntity;
import br.com.roobox.chatbot.Yampi.ChatbotYampi.Entity.ChatbotYampiControllerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public interface ChatbotMessageRepository extends JpaRepository<ChatbotMessageEntity, Long> {
}

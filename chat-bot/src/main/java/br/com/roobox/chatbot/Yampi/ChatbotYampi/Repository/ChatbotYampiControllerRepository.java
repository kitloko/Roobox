package br.com.roobox.chatbot.Yampi.ChatbotYampi.Repository;

import br.com.roobox.chatbot.Yampi.ChatbotYampi.Entity.ChatbotYampiControllerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Repository
@Transactional
public interface ChatbotYampiControllerRepository extends JpaRepository<ChatbotYampiControllerEntity, Long> {
    ChatbotYampiControllerEntity findByNumber(String number);
}

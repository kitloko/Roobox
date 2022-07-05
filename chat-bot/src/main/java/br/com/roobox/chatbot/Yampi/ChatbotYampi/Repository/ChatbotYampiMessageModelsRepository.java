package br.com.roobox.chatbot.Yampi.ChatbotYampi.Repository;

import br.com.roobox.chatbot.Yampi.ChatbotYampi.Entity.ChatbotYampiControllerEntity;
import br.com.roobox.chatbot.Yampi.ChatbotYampi.Entity.ChatbotYampiMessageModelsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatbotYampiMessageModelsRepository extends JpaRepository<ChatbotYampiMessageModelsEntity, Long> {
    ChatbotYampiMessageModelsEntity findByIdAndSequence(long id, int sequence);

    ChatbotYampiMessageModelsEntity findByYampiIdAndSequence(long yampi_id, int sequence);
}

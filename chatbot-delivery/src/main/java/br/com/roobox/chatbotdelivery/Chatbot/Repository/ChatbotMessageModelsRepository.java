package br.com.roobox.chatbotdelivery.Chatbot.Repository;

import br.com.roobox.chatbotdelivery.Chatbot.Entity.ChatbotMessageModelsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatbotMessageModelsRepository extends JpaRepository<ChatbotMessageModelsEntity, Long> {
    ChatbotMessageModelsEntity findByIdAndSequence(long id, int sequence);

    ChatbotMessageModelsEntity findByStoreIdAndSequence(long yampi_id, int sequence);
}

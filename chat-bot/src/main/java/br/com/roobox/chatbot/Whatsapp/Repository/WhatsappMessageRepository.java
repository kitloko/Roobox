package br.com.roobox.chatbot.Whatsapp.Repository;

import br.com.roobox.chatbot.Whatsapp.Entity.WhatsappMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WhatsappMessageRepository extends JpaRepository<WhatsappMessage, Long> {

    List<WhatsappMessage> findByYampiId(long yampiId);
    List<WhatsappMessage> findTop5ByyampiId(long yampiId);
}


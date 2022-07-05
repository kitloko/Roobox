package br.com.roobox.chatbot.Whatsapp.Repository;

import br.com.roobox.chatbot.Whatsapp.Entity.WhatsappConfigEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WhatsappConfigRepository extends JpaRepository<WhatsappConfigEntity, Long> {

    WhatsappConfigEntity findByYampi(long yampiId);
}


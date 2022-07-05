package br.com.roobox.chatbot.Yampi.Repository;

import br.com.roobox.chatbot.Yampi.Entity.WebhookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WebhookRepository extends JpaRepository<WebhookEntity, Long>{
        WebhookEntity findByYampiId(long id);

}

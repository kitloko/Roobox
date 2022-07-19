package br.com.roobox.chatbotdelivery.Whatsapp.Repository;

import br.com.roobox.chatbotdelivery.Whatsapp.Entity.Whatsapp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WhatsappRepository extends JpaRepository<Whatsapp, Long> {

    Optional<Whatsapp> findByStoreId(long sotreId);
    Whatsapp findByIntegration(String integration);
}


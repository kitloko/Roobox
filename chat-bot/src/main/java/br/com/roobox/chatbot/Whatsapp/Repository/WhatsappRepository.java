package br.com.roobox.chatbot.Whatsapp.Repository;

import br.com.roobox.chatbot.Whatsapp.Entity.Whatsapp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WhatsappRepository extends JpaRepository<Whatsapp, Long> {

    Optional<Whatsapp> findByYampiId(long yampiId);
    Whatsapp findByIntegration(String integration);
}


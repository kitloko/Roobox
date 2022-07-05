package br.com.roobox.chatbot.Yampi.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.Instant;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "Yampi_Webhook")
public class WebhookEntity {

    @Id
    @Column(name = "yampi_webhook_id")
    private int id;

    @Column(name = "nome_webhook")
    private String nomeWebhook;

    @Column(name = "url_webhook")
    private String urlWebhook;

    @Column(name = "chave_secreta_webhook")
    private String chaveSecretaWebhook;

    @OneToOne
    @JoinColumn(name = "yampi_id")
    private YampiEntity yampi;

    @CreatedDate
    @Column(name = "create_at", nullable = false, updatable = false)
    private Instant createAt;

    @Column(name = "update_at", nullable = false)
    @LastModifiedDate
    private Instant updateAt;

}

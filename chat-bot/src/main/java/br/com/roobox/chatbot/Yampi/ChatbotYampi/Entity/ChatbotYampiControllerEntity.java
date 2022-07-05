package br.com.roobox.chatbot.Yampi.ChatbotYampi.Entity;

import br.com.roobox.chatbot.Yampi.Entity.YampiEntity;
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
@Table(name = "Chatbot_Yampi_Controller")
public class ChatbotYampiControllerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "chatbot_id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "yampi_id")
    private YampiEntity yampi;

    private String number;

    private int sequence;

    @Lob
    private String response;

    @CreatedDate
    @Column(name = "create_at", nullable = false, updatable = false)
    private Instant createAt;

    @Column(name = "update_at", nullable = false)
    @LastModifiedDate
    private Instant updateAt;
}

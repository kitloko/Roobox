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
@Table(name = "Chatbot_Yampi_Message_Models")
public class ChatbotYampiMessageModelsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "message_models_id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "yampi_id", nullable = true)
    private YampiEntity yampi;

    @Column(columnDefinition="text")
    private String text;

    private int sequence;

    @CreatedDate
    @Column(name = "create_at")
    private Instant createAt;

    @Column(name = "update_at")
    @LastModifiedDate
    private Instant updateAt;
}

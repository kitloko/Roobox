package br.com.roobox.chatbot.Yampi.ChatbotYampi.Entity;

import br.com.roobox.chatbot.Yampi.Entity.YampiEntity;
import lombok.*;
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
@Table(name = "Chatbot_Message")
public class ChatbotMessageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "chatbot_message_id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "yampi_id")
    private YampiEntity yampi;

    @Lob
    private String message;

    private int sequence;

    @CreatedDate
    @Column(name = "create_at")
    private Instant createAt;

    @Column(name = "update_at")
    @LastModifiedDate
    private Instant updateAt;
}

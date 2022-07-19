package br.com.roobox.chatbotdelivery.Chatbot.Entity;

import br.com.roobox.chatbotdelivery.Delivery.Entity.StoreEntity;
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
@Table(name = "Chatbot_Controller")
public class ChatbotControllerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "chatbot_id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "yampi_id")
    private StoreEntity store;

    private String number;

    private int sequence;

    @Lob
    private String response;

    @CreatedDate
    @Column(name = "create_at")
    private Instant createAt;

    @Column(name = "update_at")
    @LastModifiedDate
    private Instant updateAt;
}

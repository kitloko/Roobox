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
@Table(name = "Chatbot_Yampi_Message_Models")
public class ChatbotMessageModelsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "message_models_id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "id_sotre")
    private StoreEntity store;

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

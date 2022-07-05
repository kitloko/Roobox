package br.com.roobox.chatbot.Whatsapp.Entity;

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
@Table(name = "Whatsapp_Message")
public class WhatsappMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "message_id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "yampi_id")
    private YampiEntity yampi;

    private String number;

    @Lob
    @Column(name="name", length=512)
    private String name;

    private String text;

    private String orders;

    private String event;

    @CreatedDate
    @Column(name = "create_at", nullable = false, updatable = false)
    private Instant createAt;

    @Column(name = "update_at", nullable = false)
    @LastModifiedDate
    private Instant updateAt;
}

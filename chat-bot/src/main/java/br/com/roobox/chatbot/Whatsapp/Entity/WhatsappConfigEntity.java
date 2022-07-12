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
@Table(name = "Whatsapp_Config")
public class WhatsappConfigEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "config_id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "yampi_id")
    private YampiEntity yampi;


    private boolean billet;


    private boolean cart;


    private boolean card;


    private boolean withdrawal;

    @CreatedDate
    @Column(name = "create_at")
    private Instant createAt;

    @Column(name = "update_at")
    @LastModifiedDate
    private Instant updateAt;
}

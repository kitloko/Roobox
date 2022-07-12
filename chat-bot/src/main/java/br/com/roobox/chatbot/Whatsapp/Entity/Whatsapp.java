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
@Table(name = "Whatsapp")
public class Whatsapp {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "whatsapp_id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "yampi_id")
    private YampiEntity yampi;

    @Column(unique = true)
    private String number;

    private String credit;

    private String integration;

    @Column(columnDefinition="text")
    private String qrCode;

    private String name;

    private String description;

    @CreatedDate
    @Column(name = "create_at")
    private Instant createAt;

    @Column(name = "update_at")
    @LastModifiedDate
    private Instant updateAt;
}

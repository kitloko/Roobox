package br.com.roobox.rastreio.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "Rastreio")
public class RastreioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "rastreio_id")
    public String id;

    @Column(name = "track_code")
    @JsonProperty("codObjeto")
    public String trackCode;

    public int priority;

    @OneToMany
    @JsonProperty("eventos")
    public List<Eventos> event;

    @CreatedDate
    @Column(name = "create_at")
    private Instant createAt;

    @Column(name = "update_at")
    @LastModifiedDate
    private Instant updateAt;
}

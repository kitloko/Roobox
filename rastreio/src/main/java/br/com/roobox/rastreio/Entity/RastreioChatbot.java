package br.com.roobox.rastreio.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "Rastreio_Chatbot")
public class RastreioChatbot {

    private String codigo;
    private String evento;

    private String descricao;
    private String data;
    private String cidade;
    private String hora;
    private String status;
}

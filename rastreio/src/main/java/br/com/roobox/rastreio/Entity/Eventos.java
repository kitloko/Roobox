package br.com.roobox.rastreio.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "Eventos")
public class Eventos {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "eventos_id")
    public String id;

    @JsonProperty("uf")
    public String uf;
    @JsonProperty("cidade")
    public String city;
    @JsonProperty("numero")
    public String number;
    @JsonProperty("bairro")
    public String bairro;
    @JsonProperty("logradouro")
    public String rua;
    @JsonProperty("cep")
    public String cep;
    @JsonProperty("dtHrCriado")
    public String date;
    @JsonProperty("descricao")
    public String description;
}

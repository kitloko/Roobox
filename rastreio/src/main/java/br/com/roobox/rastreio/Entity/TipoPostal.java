
package br.com.roobox.rastreio.Entity;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@JsonPropertyOrder({
    "categoria",
    "descricao",
    "sigla"
})
@Generated("jsonschema2pojo")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "TipoPostal")
public class TipoPostal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tipo_id")
    private long id;

    @JsonProperty("categoria")
    private String categoria;
    @JsonProperty("descricao")
    private String descricao;
    @JsonProperty("sigla")
    private String sigla;
    

    @JsonProperty("categoria")
    public String getCategoria() {
        return categoria;
    }

    @JsonProperty("categoria")
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @JsonProperty("descricao")
    public String getDescricao() {
        return descricao;
    }

    @JsonProperty("descricao")
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @JsonProperty("sigla")
    public String getSigla() {
        return sigla;
    }

    @JsonProperty("sigla")
    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    

    

}

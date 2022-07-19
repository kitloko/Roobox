
package br.com.roobox.rastreio.Entity;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
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
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@JsonPropertyOrder({
    "objetos",
    "quantidade",
    "resultado",
    "versao"
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
@Table(name = "Rastreio")
public class Rastreio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "rastreio_id")
    private long id;

    @JsonProperty("objetos")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "objeto_id")
    @Builder.Default
    private List<Objeto> objetos = null;
    @JsonProperty("quantidade")
    private Integer quantidade;
    @JsonProperty("resultado")
    private String resultado;
    @JsonProperty("versao")
    private String versao;
    
    public int priority;
    @CreatedDate
    @Column(name = "create_at")
    private Instant createAt;

    @Column(name = "update_at")
    @LastModifiedDate
    private Instant updateAt;

    @JsonProperty("objetos")
    public List<Objeto> getObjetos() {
        return objetos;
    }

    @JsonProperty("objetos")
    public void setObjetos(List<Objeto> objetos) {
        this.objetos = objetos;
    }

    @JsonProperty("quantidade")
    public Integer getQuantidade() {
        return quantidade;
    }

    @JsonProperty("quantidade")
    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    @JsonProperty("resultado")
    public String getResultado() {
        return resultado;
    }

    @JsonProperty("resultado")
    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    @JsonProperty("versao")
    public String getVersao() {
        return versao;
    }

    @JsonProperty("versao")
    public void setVersao(String versao) {
        this.versao = versao;
    }

    

    

}

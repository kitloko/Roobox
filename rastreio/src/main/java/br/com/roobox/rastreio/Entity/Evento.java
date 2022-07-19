
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
import reactor.util.annotation.Nullable;


@JsonPropertyOrder({
        "codigo",
        "descricao",
        "dtHrCriado",
        "tipo",
        "unidade",
        "urlIcone",
        "detalhe",
        "unidadeDestino"
})
@Generated("jsonschema2pojo")
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "Evento")
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "evento_id")
    private long id;

    @JsonProperty("codigo")
    private String codigo;
    @JsonProperty("descricao")
    private String descricao;
    @JsonProperty("dtHrCriado")
    private String dtHrCriado;
    @JsonProperty("tipo")
    private String tipo;
    @JsonProperty("unidade")
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "unidade_id")
    private Unidade unidade;
    @JsonProperty("urlIcone")
    private String urlIcone;
    @JsonProperty("detalhe")
    private String detalhe;
    @JsonProperty("unidadeDestino")
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "unidade_destino_id", nullable = true)
    private UnidadeDestino unidadeDestino;


    @JsonProperty("codigo")
    public String getCodigo() {
        return codigo;
    }

    @JsonProperty("codigo")
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @JsonProperty("descricao")
    public String getDescricao() {
        return descricao;
    }

    @JsonProperty("descricao")
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @JsonProperty("dtHrCriado")
    public String getDtHrCriado() {
        return dtHrCriado;
    }

    @JsonProperty("dtHrCriado")
    public void setDtHrCriado(String dtHrCriado) {
        this.dtHrCriado = dtHrCriado;
    }

    @JsonProperty("tipo")
    public String getTipo() {
        return tipo;
    }

    @JsonProperty("tipo")
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @JsonProperty("unidade")
    public Unidade getUnidade() {
        return unidade;
    }

    @JsonProperty("unidade")
    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

    @JsonProperty("urlIcone")
    public String getUrlIcone() {
        return urlIcone;
    }

    @JsonProperty("urlIcone")
    public void setUrlIcone(String urlIcone) {
        this.urlIcone = urlIcone;
    }

    @JsonProperty("detalhe")
    public String getDetalhe() {
        return detalhe;
    }

    @JsonProperty("detalhe")
    public void setDetalhe(String detalhe) {
        this.detalhe = detalhe;
    }

    @JsonProperty("unidadeDestino")
    public UnidadeDestino getUnidadeDestino() {
        return unidadeDestino;
    }

    @JsonProperty("unidadeDestino")
    public void setUnidadeDestino(UnidadeDestino unidadeDestino) {
        this.unidadeDestino = unidadeDestino;
    }


}

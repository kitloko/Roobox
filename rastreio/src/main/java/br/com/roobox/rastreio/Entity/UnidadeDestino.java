
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
import org.hibernate.annotations.DynamicInsert;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@JsonPropertyOrder({
    "endereco",
    "tipo",
    "codSro",
    "nome"
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
@Table(name = "UnidadeDestino")
@DynamicInsert(true)
public class UnidadeDestino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "unidade_destino_id")
    private long id;

    @JsonProperty("endereco")
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "endereco1_id", nullable = true)
    private Endereco__1 endereco;
    @JsonProperty("tipo")
    private String tipo;
    @JsonProperty("codSro")
    private String codSro;
    @JsonProperty("nome")
    private String nome;
    

    @JsonProperty("endereco")
    public Endereco__1 getEndereco() {
        return endereco;
    }

    @JsonProperty("endereco")
    public void setEndereco(Endereco__1 endereco) {
        this.endereco = endereco;
    }

    @JsonProperty("tipo")
    public String getTipo() {
        return tipo;
    }

    @JsonProperty("tipo")
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @JsonProperty("codSro")
    public String getCodSro() {
        return codSro;
    }

    @JsonProperty("codSro")
    public void setCodSro(String codSro) {
        this.codSro = codSro;
    }

    @JsonProperty("nome")
    public String getNome() {
        return nome;
    }

    @JsonProperty("nome")
    public void setNome(String nome) {
        this.nome = nome;
    }

    

    

}

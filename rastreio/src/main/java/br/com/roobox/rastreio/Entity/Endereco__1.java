
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
    "cidade",
    "uf"
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
@Table(name = "Endereco__1")
@DynamicInsert(true)
public class Endereco__1 {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "endereco1_id")
    private long id;

    @JsonProperty("cidade")
    private String cidade;
    @JsonProperty("uf")
    private String uf;
    

    @JsonProperty("cidade")
    public String getCidade() {
        return cidade;
    }

    @JsonProperty("cidade")
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @JsonProperty("uf")
    public String getUf() {
        return uf;
    }

    @JsonProperty("uf")
    public void setUf(String uf) {
        this.uf = uf;
    }

    

    

}

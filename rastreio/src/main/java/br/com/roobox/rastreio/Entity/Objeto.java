
package br.com.roobox.rastreio.Entity;

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
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@JsonPropertyOrder({
    "codObjeto",
    "eventos",
    "modalidade",
    "tipoPostal",
    "habilitaAutoDeclaracao",
    "permiteEncargoImportacao",
    "habilitaPercorridaCarteiro",
    "bloqueioObjeto",
    "possuiLocker",
    "habilitaLocker",
    "habilitaCrowdshipping"
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
@Table(name = "Objeto")

public class Objeto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "objeto_id")
    private long id;

    @JsonProperty("codObjeto")
    private String codObjeto;
    @JsonProperty("eventos")
    @OneToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "evento_id")
    @Builder.Default
    private List<Evento> eventos = null;
    @JsonProperty("modalidade")
    private String modalidade;
    @JsonProperty("tipoPostal")
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo_id")
    private TipoPostal tipoPostal;
    @JsonProperty("habilitaAutoDeclaracao")
    private Boolean habilitaAutoDeclaracao;
    @JsonProperty("permiteEncargoImportacao")
    private Boolean permiteEncargoImportacao;
    @JsonProperty("habilitaPercorridaCarteiro")
    private Boolean habilitaPercorridaCarteiro;
    @JsonProperty("bloqueioObjeto")
    private Boolean bloqueioObjeto;
    @JsonProperty("possuiLocker")
    private Boolean possuiLocker;
    @JsonProperty("habilitaLocker")
    private Boolean habilitaLocker;
    @JsonProperty("habilitaCrowdshipping")
    private Boolean habilitaCrowdshipping;
    

    @JsonProperty("codObjeto")
    public String getCodObjeto() {
        return codObjeto;
    }

    @JsonProperty("codObjeto")
    public void setCodObjeto(String codObjeto) {
        this.codObjeto = codObjeto;
    }

    @JsonProperty("eventos")
    public List<Evento> getEventos() {
        return eventos;
    }

    @JsonProperty("eventos")
    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }

    @JsonProperty("modalidade")
    public String getModalidade() {
        return modalidade;
    }

    @JsonProperty("modalidade")
    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }

    @JsonProperty("tipoPostal")
    public TipoPostal getTipoPostal() {
        return tipoPostal;
    }

    @JsonProperty("tipoPostal")
    public void setTipoPostal(TipoPostal tipoPostal) {
        this.tipoPostal = tipoPostal;
    }

    @JsonProperty("habilitaAutoDeclaracao")
    public Boolean getHabilitaAutoDeclaracao() {
        return habilitaAutoDeclaracao;
    }

    @JsonProperty("habilitaAutoDeclaracao")
    public void setHabilitaAutoDeclaracao(Boolean habilitaAutoDeclaracao) {
        this.habilitaAutoDeclaracao = habilitaAutoDeclaracao;
    }

    @JsonProperty("permiteEncargoImportacao")
    public Boolean getPermiteEncargoImportacao() {
        return permiteEncargoImportacao;
    }

    @JsonProperty("permiteEncargoImportacao")
    public void setPermiteEncargoImportacao(Boolean permiteEncargoImportacao) {
        this.permiteEncargoImportacao = permiteEncargoImportacao;
    }

    @JsonProperty("habilitaPercorridaCarteiro")
    public Boolean getHabilitaPercorridaCarteiro() {
        return habilitaPercorridaCarteiro;
    }

    @JsonProperty("habilitaPercorridaCarteiro")
    public void setHabilitaPercorridaCarteiro(Boolean habilitaPercorridaCarteiro) {
        this.habilitaPercorridaCarteiro = habilitaPercorridaCarteiro;
    }

    @JsonProperty("bloqueioObjeto")
    public Boolean getBloqueioObjeto() {
        return bloqueioObjeto;
    }

    @JsonProperty("bloqueioObjeto")
    public void setBloqueioObjeto(Boolean bloqueioObjeto) {
        this.bloqueioObjeto = bloqueioObjeto;
    }

    @JsonProperty("possuiLocker")
    public Boolean getPossuiLocker() {
        return possuiLocker;
    }

    @JsonProperty("possuiLocker")
    public void setPossuiLocker(Boolean possuiLocker) {
        this.possuiLocker = possuiLocker;
    }

    @JsonProperty("habilitaLocker")
    public Boolean getHabilitaLocker() {
        return habilitaLocker;
    }

    @JsonProperty("habilitaLocker")
    public void setHabilitaLocker(Boolean habilitaLocker) {
        this.habilitaLocker = habilitaLocker;
    }

    @JsonProperty("habilitaCrowdshipping")
    public Boolean getHabilitaCrowdshipping() {
        return habilitaCrowdshipping;
    }

    @JsonProperty("habilitaCrowdshipping")
    public void setHabilitaCrowdshipping(Boolean habilitaCrowdshipping) {
        this.habilitaCrowdshipping = habilitaCrowdshipping;
    }

    

    

}

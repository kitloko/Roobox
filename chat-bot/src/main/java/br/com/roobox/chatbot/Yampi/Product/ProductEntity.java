package br.com.roobox.chatbot.Yampi.Product;

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
@Table(name = "Products")
public class ProductEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    private long id;


    private String cliente;


    private int customerId;


    private String nomeProduto;


    private String numeroPedido;


    private String idYampi;


    private String formaPagamento;


    private String status;


    private Double total;


    private String dataCriacao;


    private String imagemProduto;


    @CreatedDate
    @Column(name = "create_at", nullable = false, updatable = false)
    private Instant createAt;

    @Column(name = "update_at", nullable = false)
    @LastModifiedDate
    private Instant updateAt;

}



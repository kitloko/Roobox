package br.com.roobox.chatbot.Yampi.Cart.Entity;


import br.com.roobox.chatbot.Yampi.Customer.Entity.CustomerEntity;
import br.com.roobox.chatbot.Yampi.Entity.YampiEntity;
import br.com.roobox.chatbot.Yampi.Product.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.Instant;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "Yampi_Cart")
public class CartEntity {

    @Id
    @Column(name = "yampi_cart_id")
    private long id;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;

    @OneToMany
    @JoinColumn(name = "product_id")
    private Set<ProductEntity> products;

    @OneToOne
    @JoinColumn(name = "yampi_id")
    private YampiEntity yampi;

    @Column(name = "url_cart")
    private String urlCart;

    private int status;

    @CreatedDate
    @Column(name = "create_at", nullable = false, updatable = false)
    private Instant createAt;

    @Column(name = "update_at", nullable = false)
    @LastModifiedDate
    private Instant updateAt;

}

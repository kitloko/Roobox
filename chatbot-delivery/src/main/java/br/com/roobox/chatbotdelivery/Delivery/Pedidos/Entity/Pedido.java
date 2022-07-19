package br.com.roobox.chatbotdelivery.Delivery.Pedidos.Entity;

import br.com.roobox.chatbotdelivery.Delivery.Cliente.Entity.Pagamento;
import br.com.roobox.chatbotdelivery.Delivery.Cliente.Entity.Tipo;
import br.com.roobox.chatbotdelivery.Delivery.Entity.StoreEntity;
import br.com.roobox.chatbotdelivery.Delivery.Menu.Entity.Item;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "Pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_pedido", nullable = false)
    private Long id;

    @OneToOne
    @JoinColumn(name = "store_id")
    private StoreEntity store;

    @OneToMany
    @JoinColumn(name = "id_item")
    private List<Item> items;

    private Pagamento pagamento;
    private Tipo tipo;
    private String observacao;

}

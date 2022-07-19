package br.com.roobox.chatbotdelivery.Delivery.Menu.Entity;

import br.com.roobox.chatbotdelivery.Delivery.Entity.StoreEntity;
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
@Table(name = "Menu")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_menu", nullable = false)
    private Long id;

    @OneToOne
    @JoinColumn(name = "store_id")
    private StoreEntity store;

    @OneToMany
    @JoinColumn(name = "id_item")
    private List<Item> items;

}

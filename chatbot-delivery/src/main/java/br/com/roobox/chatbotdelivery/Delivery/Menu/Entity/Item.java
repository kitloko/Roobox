package br.com.roobox.chatbotdelivery.Delivery.Menu.Entity;

import br.com.roobox.chatbotdelivery.Whatsapp.Entity.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "Item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_item", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_menu")
    private Menu menu;

    private Integer number;
    private String name;
    private Double value;
    private Category category;

}

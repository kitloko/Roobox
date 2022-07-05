package br.com.roobox.chatbot.Yampi.Cart.Repository;

import br.com.roobox.chatbot.Yampi.Cart.Entity.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<CartEntity, Long> {
}

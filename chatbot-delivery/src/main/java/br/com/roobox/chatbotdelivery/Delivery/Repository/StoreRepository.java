package br.com.roobox.chatbotdelivery.Delivery.Repository;

import br.com.roobox.chatbotdelivery.Delivery.Entity.StoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StoreRepository extends JpaRepository<StoreEntity, Long> {
    StoreEntity findById(long id);
}

package br.com.roobox.chatbot.Yampi.Repository;

import br.com.roobox.chatbot.Yampi.Entity.YampiEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface YampiRepository extends JpaRepository<YampiEntity, Long>{
        YampiEntity findById(long id);
        Optional<YampiEntity> findByAlias(String alias);

}

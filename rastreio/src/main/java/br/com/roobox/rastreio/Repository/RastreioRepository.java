package br.com.roobox.rastreio.Repository;

import br.com.roobox.rastreio.Entity.Rastreio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RastreioRepository extends JpaRepository<Rastreio,Long> {
}

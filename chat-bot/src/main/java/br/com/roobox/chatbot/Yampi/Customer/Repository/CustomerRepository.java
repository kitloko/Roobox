package br.com.roobox.chatbot.Yampi.Customer.Repository;

import br.com.roobox.chatbot.Yampi.Customer.Entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity,Long> {
    CustomerEntity findByCpf (String cpf);
}

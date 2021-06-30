package tech.klok.kear.hub.infrastructure.persistence.repository.pagamento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tech.klok.kear.hub.domain.adesao.model.PagamentoModel;

@Repository
public interface PagamentosRepository extends JpaRepository<PagamentoModel, Long> {
    
}

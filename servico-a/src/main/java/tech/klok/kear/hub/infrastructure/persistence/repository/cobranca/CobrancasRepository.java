package tech.klok.kear.hub.infrastructure.persistence.repository.cobranca;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tech.klok.kear.hub.domain.adesao.model.CobrancaModel;

@Repository
public interface CobrancasRepository extends JpaRepository<CobrancaModel, Long> {
    
}

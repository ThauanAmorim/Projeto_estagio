package tech.klok.kear.hub.infrastructure.persistence.repository.adesao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tech.klok.kear.hub.domain.adesao.model.AdesaoModel;

@Repository
public interface AdesaoRepository extends JpaRepository<AdesaoModel, Long> {
    
}

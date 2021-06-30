package tech.klok.kear.hub.infrastructure.persistence.repository.produto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tech.klok.kear.hub.domain.adesao.model.ProdutoModel;

@Repository
public interface Produtorepository extends JpaRepository<ProdutoModel, Long> {
    
}

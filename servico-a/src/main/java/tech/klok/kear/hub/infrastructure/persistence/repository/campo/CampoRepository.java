package tech.klok.kear.hub.infrastructure.persistence.repository.campo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tech.klok.kear.hub.domain.adesao.model.CampoModel;

@Repository
public interface CampoRepository extends JpaRepository<CampoModel, Long> {
    @Query("SELECT u.listaCampos FROM ProdutoModel u where u.id = :idProduto")
    public List<CampoModel> findCamposProduto(@Param("idProduto") Long idProduto);
}

package tech.klok.kear.hub.application.adesao.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.klok.kear.hub.domain.adesao.model.ProdutoModel;
import tech.klok.kear.hub.infrastructure.persistence.repository.produto.Produtorepository;

@Service
public class ProdutoService {
    
    @Autowired
    private Produtorepository produtorepository;

    public ProdutoModel cadastrar(ProdutoModel produtoModel) {
        return produtorepository.save(produtoModel);
    }

    public ProdutoModel deletar(long id) throws Exception {
        try {
            ProdutoModel produto = buscarPorId(id);
            produtorepository.delete(produto);
            return produto;
        } catch (Exception e) {
            throw e;
        }
    }

    public List<ProdutoModel> listarTodos() {
        return produtorepository.findAll();
    }

    public ProdutoModel buscarPorId(Long id) throws Exception {
        Optional<ProdutoModel> opProduto = produtorepository.findById(id);

        if(opProduto == null) throw new Exception("Produto não existente com esse ID");
        return opProduto.get();
    }
}

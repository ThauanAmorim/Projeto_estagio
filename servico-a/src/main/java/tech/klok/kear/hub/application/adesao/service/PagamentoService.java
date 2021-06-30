package tech.klok.kear.hub.application.adesao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.klok.kear.hub.domain.adesao.model.CobrancaModel;
import tech.klok.kear.hub.domain.adesao.model.PagamentoModel;
import tech.klok.kear.hub.infrastructure.persistence.repository.cobranca.CobrancasRepository;
import tech.klok.kear.hub.infrastructure.persistence.repository.pagamento.PagamentosRepository;
import tech.klok.kear.hub.presentation.pagamento.dto.PagamentoDTO;

@Service
public class PagamentoService {
    @Autowired
    private CobrancasRepository cobrancasRepository;

    @Autowired
    private PagamentosRepository pagamentosRepository;

    public PagamentoModel salvarPagamento (PagamentoDTO pagamentoDTO) {
        Optional<CobrancaModel> cobrancasModel = cobrancasRepository.findById(pagamentoDTO.getIdCobranca());
        if (cobrancasModel == null) return null;

        PagamentoModel pagamentosModel = new PagamentoModel(pagamentoDTO);

        cobrancasModel.get().setPagamento(pagamentosModel);
        cobrancasRepository.save(cobrancasModel.get());
        return pagamentosModel;
    }

    public List<PagamentoModel> getAll() throws Exception {
        List<PagamentoModel> listaPagamentos = pagamentosRepository.findAll();
        if(listaPagamentos.isEmpty()) {
            throw new Exception("Lista vazia");
        }
        return listaPagamentos;
    }

    public PagamentoModel getbyId(Long id) throws Exception {
        Optional<PagamentoModel> pagamentoOp = pagamentosRepository.findById(id);

        if(pagamentoOp == null) {
            throw new Exception("Produto não existe com esse ID");
        }
        return pagamentoOp.get();
    }

    public String delete(Long id) throws Exception {
        try {
            PagamentoModel pagamento = getbyId(id);
            pagamentosRepository.delete(pagamento);
            return "Deletado com sucesso";
        } catch (Exception e) {
            throw e;
        }
    }
}

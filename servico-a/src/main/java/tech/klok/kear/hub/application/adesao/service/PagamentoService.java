package tech.klok.kear.hub.application.adesao.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tech.klok.kear.hub.domain.adesao.model.PagamentoModel;
import tech.klok.kear.hub.presentation.pagamento.dto.PagamentoDTO;

@Service
public class PagamentoService {

    private RestTemplate template = new RestTemplate();

    private String urlBase = "http://localhost:8081/api-servico-b/pagamento/";

    public PagamentoDTO salvarPagamento (PagamentoDTO pagamentoDTO) {
        return template.postForObject(urlBase, pagamentoDTO, PagamentoDTO.class);
    }

    public List<PagamentoModel> getAll() throws Exception {
        return template.getForObject(urlBase, List.class);
    }

    public PagamentoDTO getbyId(Long id) throws Exception {
        return template.getForObject(urlBase + id, PagamentoDTO.class);
    }

    public void delete(Long id) throws Exception {
        template.delete(urlBase + id);
    }
}

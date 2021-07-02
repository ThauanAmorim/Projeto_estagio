package tech.klok.kear.hub.application.adesao.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import tech.klok.kear.hub.domain.adesao.model.AdesaoModel;
import tech.klok.kear.hub.domain.adesao.model.CobrancaModel;
import tech.klok.kear.hub.infrastructure.persistence.repository.adesao.AdesaoRepository;
import tech.klok.kear.hub.presentation.cobranca.dto.CobrancaDTO;

@Service
public class CobrancaService {

    private RestTemplate template = new RestTemplate();

    public List<CobrancaDTO> listarTodos() {
        return template.getForObject("http://localhost:8081/api-servico-b/cobranca", List.class);
    }

    public List<CobrancaDTO> getAllCobrancasByIdAdesao(long id) {
        return template.getForObject("http://localhost:8081/api-servico-b/cobranca/" + id, List.class);
    }
}

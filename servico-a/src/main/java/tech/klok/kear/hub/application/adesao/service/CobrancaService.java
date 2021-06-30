package tech.klok.kear.hub.application.adesao.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.klok.kear.hub.domain.adesao.model.AdesaoModel;
import tech.klok.kear.hub.domain.adesao.model.CobrancaModel;
import tech.klok.kear.hub.infrastructure.persistence.repository.adesao.AdesaoRepository;
import tech.klok.kear.hub.presentation.cobranca.dto.CobrancaDTO;

@Service
public class CobrancaService {
    @Autowired
    private AdesaoRepository adesaoRepository;

    public AdesaoModel salvarCobranca (CobrancaDTO cobrancaDTO) {
        System.out.println(new Date(System.currentTimeMillis()));
        Optional<AdesaoModel> adesaoModel = adesaoRepository.findById(cobrancaDTO.getIdAdesao());

        if(adesaoModel == null) return null;

        CobrancaModel cobrancasModel = new CobrancaModel(cobrancaDTO);

        adesaoModel.get().addCobranca(cobrancasModel);

        return adesaoRepository.save(adesaoModel.get());
    }
}

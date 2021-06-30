package tech.klok.kear.hub.application.adesao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tech.klok.kear.hub.application.adesao.service.CobrancaService;
import tech.klok.kear.hub.domain.adesao.model.AdesaoModel;
import tech.klok.kear.hub.presentation.cobranca.dto.CobrancaDTO;

@RestController
@RequestMapping("/api/cobranca")
public class CobrancaController {
    @Autowired
    private CobrancaService cobrancaService;

    @PostMapping
    public AdesaoModel salvarCobranca (@RequestBody CobrancaDTO cobrancaDTO) {
        System.out.println(cobrancaDTO.getDataCobranca());
        return cobrancaService.salvarCobranca(cobrancaDTO);
    }
}

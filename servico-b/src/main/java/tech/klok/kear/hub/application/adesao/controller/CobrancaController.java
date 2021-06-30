package tech.klok.kear.hub.application.adesao.controller;

import com.rabbitmq.client.RpcClient.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tech.klok.kear.hub.application.adesao.service.CobrancaService;
import tech.klok.kear.hub.presentation.cobranca.dto.CobrancaDTO;

public class CobrancaController {
    @Autowired
    private CobrancaService cobrancaService;

    @PostMapping
    public void salvarCobranca (@RequestBody CobrancaDTO cobrancaDTO) {
        cobrancaService.salvarCobranca(cobrancaDTO);
    }
}

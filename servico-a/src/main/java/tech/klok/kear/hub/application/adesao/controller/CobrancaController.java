package tech.klok.kear.hub.application.adesao.controller;

import java.util.List;

import com.rabbitmq.client.RpcClient.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tech.klok.kear.hub.application.adesao.service.AdesaoService;
import tech.klok.kear.hub.application.adesao.service.CobrancaService;
import tech.klok.kear.hub.domain.adesao.model.AdesaoModel;
import tech.klok.kear.hub.presentation.cobranca.dto.CobrancaDTO;

@RestController
@RequestMapping("/api/cobranca")
public class CobrancaController {
    @Autowired
    private CobrancaService cobrancaService;

    @GetMapping
    public ResponseEntity<?> listarTodas() {
        try {
            List<CobrancaDTO> lista = cobrancaService.listarTodos();
            return ResponseEntity.status(HttpStatus.OK).body(lista);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(cobrancaService.getAllCobrancasByIdAdesao(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}

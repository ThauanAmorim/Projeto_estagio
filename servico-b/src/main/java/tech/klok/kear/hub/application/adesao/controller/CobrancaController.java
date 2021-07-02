package tech.klok.kear.hub.application.adesao.controller;

import java.util.List;

import com.rabbitmq.client.RpcClient.Response;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tech.klok.kear.hub.application.adesao.service.CobrancaService;
import tech.klok.kear.hub.domain.adesao.model.CobrancaModel;
import tech.klok.kear.hub.infrastructure.exceptions.NaoEncontradoException;
import tech.klok.kear.hub.infrastructure.rabbitMQ.MQConfig;
import tech.klok.kear.hub.presentation.cobranca.dto.CobrancaDTO;

@RestController
@RequestMapping("/api-servico-b/cobranca")
public class CobrancaController {
    @Autowired
    private CobrancaService cobrancaService;

    @RabbitListener(queues = {MQConfig.COBRANCA_QUEUE})
    public void salvarCobranca (CobrancaDTO cobrancaDTO) {
        CobrancaModel cobranca = new CobrancaModel(cobrancaDTO);
        try {
            cobrancaService.salvarCobranca(cobranca);
        } catch(Exception e) {
            return;
        }
    }

    @GetMapping
    public ResponseEntity<?> listarTodos() {
        try {
            List<CobrancaDTO> listaCobrancas = cobrancaService.listarTodos();
            return ResponseEntity.status(HttpStatus.OK).body(listaCobrancas);
        } catch (NaoEncontradoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAllCobrancasByIdAdesao(@PathVariable("id") Long id) {
        try {
            List<CobrancaModel> lista = cobrancaService.listarByAdesaoid(id);
            return ResponseEntity.status(HttpStatus.OK).body(lista);
            
        } catch (NaoEncontradoException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}

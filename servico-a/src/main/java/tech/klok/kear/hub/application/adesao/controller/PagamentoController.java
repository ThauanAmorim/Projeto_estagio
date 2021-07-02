package tech.klok.kear.hub.application.adesao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.klok.kear.hub.application.adesao.service.PagamentoService;
import tech.klok.kear.hub.domain.adesao.model.PagamentoModel;
import tech.klok.kear.hub.presentation.pagamento.dto.PagamentoDTO;

@RestController
@RequestMapping("/api/pagamento")
public class PagamentoController {
    
    @Autowired
    private PagamentoService pagamentoService;

    @PostMapping
    public ResponseEntity<?> salvarPagamento(@RequestBody PagamentoDTO pagamentoDTO) {
        try {
            PagamentoDTO pagamento = pagamentoService.salvarPagamento(pagamentoDTO);
            return ResponseEntity.status(HttpStatus.OK).body(pagamento);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getbyId(@PathVariable("id") Long id) {
        try {
            PagamentoDTO pagamento = pagamentoService.getbyId(id);
            return ResponseEntity.status(HttpStatus.OK).body(pagamento);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(pagamentoService.getAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        try {
            pagamentoService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(e.getMessage());
        }
    }
}

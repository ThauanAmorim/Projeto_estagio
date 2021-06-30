package tech.klok.kear.hub.application.adesao.controller;

import java.util.List;

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

import tech.klok.kear.hub.application.adesao.service.ProdutoService;
import tech.klok.kear.hub.domain.adesao.model.ProdutoModel;
import tech.klok.kear.hub.presentation.produto.dto.ProdutoDTO;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {
    
    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody ProdutoDTO produtoDTO) {
        ProdutoModel produtoModel = new ProdutoModel(produtoDTO);

        try {
            produtoModel = produtoService.cadastrar(produtoModel);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body(produtoModel);
    }

    @GetMapping
    public ResponseEntity<?> buscarTodos() {
        try {
            List<ProdutoModel> lista = produtoService.listarTodos();
    
            return ResponseEntity.status(HttpStatus.OK).body(lista);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarTodos(@PathVariable("id") Long id) {
        try {
            ProdutoModel produto = produtoService.buscarPorId(id);

            return ResponseEntity.status(HttpStatus.OK).body(produto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable("id") Long id) {
        try {
            produtoService.deletar(id);

            return ResponseEntity.status(HttpStatus.OK).body("Deletado com sucesso");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}

package tech.klok.kear.hub.application.adesao.controller;

import java.security.Principal;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tech.klok.kear.hub.application.adesao.service.AdesaoService;
import tech.klok.kear.hub.domain.adesao.model.AdesaoModel;
import tech.klok.kear.hub.infrastructure.exceptions.NaoEncontradoException;
import tech.klok.kear.hub.presentation.adesao.dto.AdesaoDTO;

@RestController
@RequestMapping("/api/adesoes")
public class AdesaoController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AdesaoService adesaoService;
    
    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody AdesaoDTO accessionDTO, Principal principal) {
        AdesaoModel adesaoModel = paraAdesaoModel(accessionDTO);
        try {
            AdesaoModel adesao = adesaoService.salvar(adesaoModel, accessionDTO.getIdProduto(), accessionDTO.getRespostas(), principal);
            AdesaoDTO dto = paraAdesaoDTO(adesao);
            return ResponseEntity.status(HttpStatus.OK).body(dto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> buscarTodos() {
        try {
            List<AdesaoModel> lista = adesaoService.buscarTodos();
            return ResponseEntity.status(HttpStatus.OK).body(lista);
        } catch (NaoEncontradoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable("id") Long id) {
        try {
            AdesaoModel adesao = adesaoService.buscarPorId(id);
            return ResponseEntity.status(HttpStatus.OK).body(adesao);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        try {
            AdesaoModel adesao = adesaoService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body(adesao);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.OK).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable("id") Long adesaoId, @RequestBody AdesaoDTO adesaoDTO) {
        AdesaoModel adesaoModel = paraAdesaoModel(adesaoDTO);
        try {
            adesaoModel = adesaoService.atualizar(adesaoId, adesaoModel);
            AdesaoDTO dto = paraAdesaoDTO(adesaoModel);
            return ResponseEntity.status(HttpStatus.OK).body(dto);
        } catch (NaoEncontradoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    private AdesaoModel paraAdesaoModel(AdesaoDTO dto) {
        return modelMapper.map(dto, AdesaoModel.class);
    }

    private AdesaoDTO paraAdesaoDTO(AdesaoModel adesaoModel) {
        return modelMapper.map(adesaoModel, AdesaoDTO.class);
    }
}

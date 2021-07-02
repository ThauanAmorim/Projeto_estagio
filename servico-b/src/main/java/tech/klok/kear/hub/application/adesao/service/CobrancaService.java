package tech.klok.kear.hub.application.adesao.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.klok.kear.hub.domain.adesao.model.CobrancaModel;
import tech.klok.kear.hub.infrastructure.exceptions.NaoEncontradoException;
import tech.klok.kear.hub.infrastructure.persistence.repository.cobranca.CobrancasRepository;
import tech.klok.kear.hub.presentation.cobranca.dto.CobrancaDTO;

@Service
public class CobrancaService {

    @Autowired
    CobrancasRepository cobrancasRepository;

    public void salvarCobranca (CobrancaModel cobranca) {
        cobrancasRepository.save(cobranca);
    }

    public List<CobrancaDTO> listarTodos() throws NaoEncontradoException {
        List<CobrancaModel> lista = cobrancasRepository.findAll();

        if(lista.isEmpty()) throw new NaoEncontradoException();

        List<CobrancaDTO> listaDTO = new ArrayList<>();

        for(CobrancaModel cobranca : lista) {
            CobrancaDTO dto = new CobrancaDTO(cobranca);
            listaDTO.add(dto);
        }
        return listaDTO;
    }

    public List<CobrancaModel> listarByAdesaoid(long id) throws NaoEncontradoException {
        try {
            List<CobrancaDTO> listaTodos = listarTodos();
            List<CobrancaModel> listaId = new ArrayList<>();

            for(CobrancaDTO cobrancaDto : listaTodos) {
                CobrancaModel cobranca = new CobrancaModel(cobrancaDto);
                if(cobranca.getIdAdesao() == id) {
                    listaId.add(cobranca);
                }
            }
            return listaId;
        } catch (NaoEncontradoException e) {
            throw e;
        }
    }
}

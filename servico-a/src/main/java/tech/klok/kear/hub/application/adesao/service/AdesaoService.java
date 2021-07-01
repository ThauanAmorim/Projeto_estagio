package tech.klok.kear.hub.application.adesao.service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import tech.klok.kear.hub.domain.adesao.model.AdesaoModel;
import tech.klok.kear.hub.domain.adesao.model.CampoModel;
import tech.klok.kear.hub.domain.adesao.model.ProdutoModel;
import tech.klok.kear.hub.domain.adesao.model.RespostaModel;
import tech.klok.kear.hub.domain.adesao.model.UserModel;
import tech.klok.kear.hub.infrastructure.exceptions.NaoEncontradoException;
import tech.klok.kear.hub.infrastructure.persistence.repository.adesao.AdesaoRepository;
import tech.klok.kear.hub.infrastructure.persistence.repository.campo.CampoRepository;
import tech.klok.kear.hub.infrastructure.persistence.repository.produto.Produtorepository;
import tech.klok.kear.hub.infrastructure.persistence.repository.user.UserRepository;
import tech.klok.kear.hub.presentation.adesao.dto.AdesaoDTO;
import tech.klok.kear.hub.presentation.resposta.RespostaDTO;

@Service
public class AdesaoService {
    
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private Produtorepository produtorepository;
    @Autowired
    private CampoRepository campoRepository;
    @Autowired
    private AdesaoRepository adesaoRepository;

    private List<CampoModel> listaCampos;

    public AdesaoModel salvar(AdesaoModel adesaoModel, long produtoID, List<RespostaDTO> respostasNaoConvertida, Principal principal) throws Exception {
        String username = principal.getName();
        
        Optional<UserModel> userOp = userRepository.findByUsername(username);

        Optional<ProdutoModel> produtoOp = produtorepository.findById(produtoID);

        if(userOp.isEmpty()) throw new Exception("User não existe");
        if(produtoOp.isEmpty()) throw new Exception("Produto não existe com esse ID");
        validadeCamposObrigatorios(produtoID, respostasNaoConvertida);
        validateCampoInexistente(respostasNaoConvertida);

        UserModel user = userOp.get();
        ProdutoModel produto = produtoOp.get();

        converterIdEmCampo(adesaoModel, respostasNaoConvertida);

        adesaoModel.setProduto(produto);
        user.addAdesao(adesaoModel);
        userRepository.save(user);

        return adesaoModel;
    }

    public List<AdesaoModel> buscarTodos() throws NaoEncontradoException {
        List<AdesaoModel> lista = adesaoRepository.findAll();

        if(lista.isEmpty()) throw new NaoEncontradoException("Lista vazia");

        return lista;
    }

    public AdesaoModel buscarPorId(Long id) throws Exception {
        Optional<AdesaoModel> adesaoOp = adesaoRepository.findById(id);

        if(adesaoOp.isEmpty()) throw new Exception("Adesao não existente com esse id");

        return adesaoOp.get();
    }

    public AdesaoModel delete(Long id) throws Exception {
        AdesaoModel adesao = buscarPorId(id);

        adesaoRepository.delete(adesao);
        return adesao;
    }

    public AdesaoModel atualizar(Long adesaoId, AdesaoModel adesao) throws NaoEncontradoException {
        Optional<AdesaoModel> adesaoRecuperado = adesaoRepository.findById(adesaoId);

        if(adesaoRecuperado.isEmpty()) throw new NaoEncontradoException();

        BeanUtils.copyProperties(adesao, adesaoRecuperado.get());
        return adesaoRepository.save(adesaoRecuperado.get());
    }
    
    private void converterIdEmCampo(AdesaoModel adesao, List<RespostaDTO> respostas) {
        for(RespostaDTO resposta : respostas) {
            CampoModel campo = campoRepository.findById(resposta.getIdCampo()).get();
            RespostaModel respostaConvertida = new RespostaModel(resposta);
            respostaConvertida.setCampo(campo);
            
            adesao.addResposta(respostaConvertida);
        }
    }

    private void validadeCamposObrigatorios(Long id, List<RespostaDTO> respostas) throws Exception {
        listaCampos = campoRepository.findCamposProduto(id);
        List<Long> idCamposRespostaList = new ArrayList<>();

        for(RespostaDTO resposta : respostas) {
            idCamposRespostaList.add(resposta.getIdCampo());
        }

        for(CampoModel campo : listaCampos) {
            if(campo.isObrigatorio() && !idCamposRespostaList.contains(campo.getId())) {
                throw new Exception("Atributo " + campo.getNome() + " é obrigatorio");
            }
        }
    }

    private void validateCampoInexistente(List<RespostaDTO> respostas) throws Exception {
        List<Long> camposId = new ArrayList<>();

        for(CampoModel campo : listaCampos) {
            camposId.add(campo.getId());
        }

        for(RespostaDTO resposta : respostas) {
            if(!camposId.contains(resposta.getIdCampo())) {
                throw new Exception("Campo do id " + resposta.getIdCampo() + " não existe!");
            }
        }
    }
}

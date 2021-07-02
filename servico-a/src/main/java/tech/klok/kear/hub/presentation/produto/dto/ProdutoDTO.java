package tech.klok.kear.hub.presentation.produto.dto;

import java.util.List;

import tech.klok.kear.hub.domain.adesao.model.CampoModel;

public class ProdutoDTO {

    private Long id;
    private String nome;
    private List<CampoModel> listaCampos;

    public ProdutoDTO() {
    }

    public ProdutoDTO(Long id, String nome, List<CampoModel> listaCampos) {
        this.id = id;
        this.nome = nome;
        this.listaCampos = listaCampos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<CampoModel> getListaCampos() {
        return listaCampos;
    }

    public void setListaCampos(List<CampoModel> listaCampos) {
        this.listaCampos = listaCampos;
    }
    
}

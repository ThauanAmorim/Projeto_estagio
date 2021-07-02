package tech.klok.kear.hub.domain.adesao.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import tech.klok.kear.hub.presentation.produto.dto.ProdutoDTO;

@Entity
@Table(name = "T_PRODUTO")
public class ProdutoModel implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NOME")
    private String nome;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "PRODUTO_ID_FK")
    private List<CampoModel> listaCampos = new ArrayList<>();

    public ProdutoModel() {
    }

    public ProdutoModel(Long id, String nome, List<CampoModel> listaCampos) {
        this.id = id;
        this.nome = nome;
        this.listaCampos = listaCampos;
    }

    public ProdutoModel (ProdutoDTO produtoDTO) {
        this.nome = produtoDTO.getNome();
        this.listaCampos = produtoDTO.getListaCampos();
    }

    public boolean addCampo(CampoModel campoModel) {
        if(!this.listaCampos.contains(campoModel)) {
            this.listaCampos.add(campoModel);
            return true;
        }
        return false;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
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

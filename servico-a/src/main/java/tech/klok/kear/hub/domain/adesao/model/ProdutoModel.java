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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tech.klok.kear.hub.presentation.produto.dto.ProdutoDTO;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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

    public boolean addCampo(CampoModel campoModel) {
        if(!this.listaCampos.contains(campoModel)) {
            this.listaCampos.add(campoModel);
            return true;
        }
        return false;
    }

    public ProdutoModel (ProdutoDTO produtoDTO) {
        this.nome = produtoDTO.getNome();
        this.listaCampos = produtoDTO.getListaCampos();
    }
}

package tech.klok.kear.hub.domain.adesao.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tech.klok.kear.hub.domain.adesao.model.enums.AdesaoEnum;
import tech.klok.kear.hub.presentation.adesao.dto.AdesaoDTO;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "T_ADESAO")
public class AdesaoModel implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "STATUS_ADESAO")
    private Enum statusAdesao = AdesaoEnum.ATIVO;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PRODUTO_ID_FK")
    private ProdutoModel produto;
    
    @Column(name = "DATA_AQUISICAO")
    private Date dataAquisicao;
    
    @Column(name = "DIA_VENCIMENTO")
    private int diaVencimento;
    
    @Column(name = "NUMERO_PARCELAS")
    private int numeroParcelas;
    
    @Column(name = "VALOR")
    private float valor;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "ADESAO_RESPOSTA_ID_FK")
    private List<RespostaModel> listaRespostas = new ArrayList<>();
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "ADESAO_COBRANCA_ID_FK")
    private List<CobrancaModel> listaCobrancas = new ArrayList<>();
    
    public AdesaoModel(AdesaoDTO adesaoDTO) {
        this.diaVencimento = adesaoDTO.getDiaVencimento();
        this.numeroParcelas = adesaoDTO.getNumeroParcelas();
        this.valor = adesaoDTO.getValor();
        this.dataAquisicao = new Date(System.currentTimeMillis());
    }

    public boolean addCobranca (CobrancaModel cobrancasModel) {
        if (!listaCobrancas.contains(cobrancasModel)) {
            listaCobrancas.add(cobrancasModel);
            return true;
        }
        return false;
    }

    public boolean addResposta(RespostaModel respostaModel) {
        if(!listaRespostas.contains(respostaModel)) {
            this.listaRespostas.add(respostaModel);
            return true;
        }
        return false;
    }
}

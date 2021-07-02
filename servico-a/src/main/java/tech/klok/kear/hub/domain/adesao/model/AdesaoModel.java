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
import javax.persistence.Transient;

import tech.klok.kear.hub.domain.adesao.model.enums.AdesaoEnum;
import tech.klok.kear.hub.presentation.adesao.dto.AdesaoDTO;

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
    
    @Column(name = "DIA_COBRANCA")
    private int diaCobranca;
    
    @Column(name = "NUMERO_PARCELAS")
    private int numeroParcelas;
    
    @Column(name = "VALOR")
    private float valor;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "ADESAO_RESPOSTA_ID_FK")
    private List<RespostaModel> listaRespostas = new ArrayList<>();
    
    @Transient
    private List<CobrancaModel> listaCobrancas = new ArrayList<>();
    
    public AdesaoModel() {
    }

    public AdesaoModel(Long id, Enum statusAdesao, ProdutoModel produto, Date dataAquisicao, int diaVencimento,
            int numeroParcelas, float valor, List<RespostaModel> listaRespostas, List<CobrancaModel> listaCobrancas) {
        this.id = id;
        this.statusAdesao = statusAdesao;
        this.produto = produto;
        this.dataAquisicao = dataAquisicao;
        this.diaCobranca = diaVencimento;
        this.numeroParcelas = numeroParcelas;
        this.valor = valor;
        this.listaRespostas = listaRespostas;
        this.listaCobrancas = listaCobrancas;
    }

    public AdesaoModel(AdesaoDTO adesaoDTO) {
        this.diaCobranca = adesaoDTO.getDiaCobranca();
        this.numeroParcelas = adesaoDTO.getNumeroParcelas();
        this.valor = adesaoDTO.getValor();
        this.dataAquisicao = new Date(System.currentTimeMillis());
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

    public Enum getStatusAdesao() {
        return statusAdesao;
    }

    public void setStatusAdesao(Enum statusAdesao) {
        this.statusAdesao = statusAdesao;
    }

    public ProdutoModel getProduto() {
        return produto;
    }

    public void setProduto(ProdutoModel produto) {
        this.produto = produto;
    }

    public Date getDataAquisicao() {
        return dataAquisicao;
    }

    public void setDataAquisicao(Date dataAquisicao) {
        this.dataAquisicao = dataAquisicao;
    }

    public int getDiaCobranca() {
        return diaCobranca;
    }

    public void setDiaCobranca(int diaCobranca) {
        this.diaCobranca = diaCobranca;
    }

    public int getNumeroParcelas() {
        return numeroParcelas;
    }

    public void setNumeroParcelas(int numeroParcelas) {
        this.numeroParcelas = numeroParcelas;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public List<RespostaModel> getListaRespostas() {
        return listaRespostas;
    }

    public void setListaRespostas(List<RespostaModel> listaRespostas) {
        this.listaRespostas = listaRespostas;
    }

    public List<CobrancaModel> getListaCobrancas() {
        return listaCobrancas;
    }

    public void setListaCobrancas(List<CobrancaModel> listaCobrancas) {
        this.listaCobrancas = listaCobrancas;
    }

    // public boolean addCobranca (CobrancaModel cobrancasModel) {
    //     if(listaCobrancas == null) this.listaCobrancas = new ArrayList<>();
    //     if (!listaCobrancas.contains(cobrancasModel)) {
    //         listaCobrancas.add(cobrancasModel);
    //         return true;
    //     }
    //     return false;
    // }

    public boolean addResposta(RespostaModel respostaModel) {
        if(listaRespostas == null) this.listaRespostas = new ArrayList<>();
        if(!listaRespostas.contains(respostaModel)) {
            this.listaRespostas.add(respostaModel);
            return true;
        }
        return false;
    }
}

package tech.klok.kear.hub.domain.adesao.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import tech.klok.kear.hub.domain.adesao.model.enums.CobrancaEnum;
import tech.klok.kear.hub.presentation.cobranca.dto.CobrancaDTO;

@Entity
@Table(name = "T_COBRANCA")
public class CobrancaModel implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ID_ADESAO_FK")
    private Long idAdesao;

    @Column(name = "DATA_COBRANCA")
    private Date dataCobranca;
    
    @Column(name = "STATUS_COBRANCA")
    private CobrancaEnum status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PAGAMENTO_ID_FK")
    private PagamentoModel pagamento;

    @Column(name = "VALOR")
    private float valor;
    
    public CobrancaModel() {
    }

    public CobrancaModel(Long id, Long idAdesao, Date dataCobranca, CobrancaEnum status, PagamentoModel pagamento,
            float valor) {
        this.id = id;
        this.idAdesao = idAdesao;
        this.dataCobranca = dataCobranca;
        this.status = status;
        this.pagamento = pagamento;
        this.valor = valor;
    }

    public CobrancaModel (CobrancaDTO cobrancaDTO) {
        this.dataCobranca = cobrancaDTO.getDataCobranca();
        this.valor = cobrancaDTO.getValor();
        this.idAdesao = cobrancaDTO.getIdAdesao();
        this.status = cobrancaDTO.getStatus() == 0? CobrancaEnum.PENDENTE : CobrancaEnum.PAGA;
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

    public Long getIdAdesao() {
        return idAdesao;
    }

    public void setIdAdesao(Long idAdesao) {
        this.idAdesao = idAdesao;
    }

    public Date getDataCobranca() {
        return dataCobranca;
    }

    public void setDataCobranca(Date dataCobranca) {
        this.dataCobranca = dataCobranca;
    }

    public CobrancaEnum getStatus() {
        return status;
    }

    public void setStatus(CobrancaEnum status) {
        this.status = status;
    }

    public PagamentoModel getPagamento() {
        return pagamento;
    }

    public void setPagamento(PagamentoModel pagamento) {
        this.pagamento = pagamento;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
    
}

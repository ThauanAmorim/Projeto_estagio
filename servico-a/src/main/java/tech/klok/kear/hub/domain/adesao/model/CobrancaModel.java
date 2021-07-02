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

public class CobrancaModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date dataCobranca;
    
    private CobrancaEnum status;

    private PagamentoModel pagamento;

    private float valor;
    
    public CobrancaModel() {
    }

    public CobrancaModel(Long id, Date dataCobranca, CobrancaEnum status, PagamentoModel pagamento, float valor) {
        this.id = id;
        this.dataCobranca = dataCobranca;
        this.status = status;
        this.pagamento = pagamento;
        this.valor = valor;
    }

    public CobrancaModel (CobrancaDTO cobrancaDTO) {
        this.dataCobranca = cobrancaDTO.getDataCobranca();
        this.valor = cobrancaDTO.getValor();
        this.status = cobrancaDTO.getStatusId() == 0 ? CobrancaEnum.PENDENTE : CobrancaEnum.PAGA;
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

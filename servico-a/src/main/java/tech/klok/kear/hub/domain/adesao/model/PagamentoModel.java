package tech.klok.kear.hub.domain.adesao.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import tech.klok.kear.hub.presentation.pagamento.dto.PagamentoDTO;

public class PagamentoModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Date dataPagamento;

    public PagamentoModel() {
    }

    public PagamentoModel(Long id, Date dataPagamento) {
        this.id = id;
        this.dataPagamento = dataPagamento;
    }

    public PagamentoModel (PagamentoDTO pagamentoDTO) {
        this.dataPagamento = pagamentoDTO.getDataPagamento();
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

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    
}
 
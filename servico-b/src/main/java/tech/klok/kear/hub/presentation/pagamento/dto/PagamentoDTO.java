package tech.klok.kear.hub.presentation.pagamento.dto;

import java.util.Date;

public class PagamentoDTO {
    private Long idCobranca;
    private Date dataPagamento;
    
    public PagamentoDTO() {
    }

    public PagamentoDTO(Long idCobranca, Date dataPagamento) {
        this.idCobranca = idCobranca;
        this.dataPagamento = dataPagamento;
    }

    public Long getIdCobranca() {
        return idCobranca;
    }

    public void setIdCobranca(Long idCobranca) {
        this.idCobranca = idCobranca;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }
    
}

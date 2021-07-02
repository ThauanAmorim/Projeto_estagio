package tech.klok.kear.hub.presentation.cobranca.dto;

import java.util.Date;

import tech.klok.kear.hub.domain.adesao.model.enums.CobrancaEnum;

public class CobrancaDTO {
    private Long idAdesao;
    private Date dataCobranca;
    private float valor;
    private int statusId;

    public CobrancaDTO() {
    }

    public CobrancaDTO(Long idAdesao, Date dataCobranca, float valor, int statusId) {
        this.idAdesao = idAdesao;
        this.dataCobranca = dataCobranca;
        this.valor = valor;
        this.statusId = statusId;
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

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

}

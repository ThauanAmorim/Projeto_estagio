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

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tech.klok.kear.hub.domain.adesao.model.enums.CobrancaEnum;
import tech.klok.kear.hub.presentation.cobranca.dto.CobrancaDTO;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "T_COBRANCA")
public class CobrancaModel implements Serializable {
    private static final long serialVersionUID = 1L;
    
    public CobrancaModel (CobrancaDTO cobrancaDTO) {
        this.dataCobranca = cobrancaDTO.getDataCobranca();
        this.valor = cobrancaDTO.getValor();
    }

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
}

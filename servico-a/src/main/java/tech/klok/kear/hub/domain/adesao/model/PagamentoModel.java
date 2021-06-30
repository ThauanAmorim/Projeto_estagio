package tech.klok.kear.hub.domain.adesao.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tech.klok.kear.hub.presentation.pagamento.dto.PagamentoDTO;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "T_PAGAMENTO")
public class PagamentoModel implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "DATA_PAGAMENTO")
    private Date dataPagamento;

    public PagamentoModel (PagamentoDTO pagamentoDTO) {
        this.dataPagamento = pagamentoDTO.getDataPagamento();
    }
}
 
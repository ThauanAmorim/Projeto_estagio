package tech.klok.kear.hub.presentation.cobranca.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CobrancaDTO {
    private Long idAdesao;
    private Date dataCobranca;
    private float valor;
}

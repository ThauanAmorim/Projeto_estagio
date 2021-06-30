package tech.klok.kear.hub.presentation.adesao.dto;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tech.klok.kear.hub.presentation.resposta.RespostaDTO;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AdesaoDTO {

    private Long idProduto;

    private int diaVencimento;

    private int numeroParcelas;

    private float valor;

    List<RespostaDTO> respostas;
}

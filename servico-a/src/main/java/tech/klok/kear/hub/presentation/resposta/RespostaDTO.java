package tech.klok.kear.hub.presentation.resposta;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RespostaDTO {
    private Long idCampo;
    private String valor;
}

package tech.klok.kear.hub.presentation.campo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CampoDTO {
    
    private Long id;
    private String nome;
    private boolean obrigatorio;
}

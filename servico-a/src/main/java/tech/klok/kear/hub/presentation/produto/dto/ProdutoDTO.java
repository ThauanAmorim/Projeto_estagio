package tech.klok.kear.hub.presentation.produto.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tech.klok.kear.hub.domain.adesao.model.CampoModel;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProdutoDTO {

    private Long id;
    private String nome;
    private List<CampoModel> listaCampos;
}

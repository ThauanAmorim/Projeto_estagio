package tech.klok.kear.hub.presentation.user.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.stereotype.Repository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tech.klok.kear.hub.domain.adesao.model.enums.Genero;
import tech.klok.kear.hub.domain.adesao.model.enums.EstadoCivil;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDTO {
    private Long id;

    private String CPF;
    
    private Enum genero;
    
    private Enum estadoCivil;
    
    private String username;

    private String senha;
    
    public void setGenero(int id) {
        for(Genero gender : Genero.values()) {
            if(gender.getId() == id) {
                this.genero = gender;
            }
        }
    }

    public void setEstadoCivil(int id) {
        for(EstadoCivil marital : EstadoCivil.values()) {
            if(marital.getId() == id) {
                this.estadoCivil = marital;
            }
        }
    }
}

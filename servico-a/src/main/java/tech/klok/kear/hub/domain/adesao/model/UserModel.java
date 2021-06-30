package tech.klok.kear.hub.domain.adesao.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tech.klok.kear.hub.domain.adesao.model.enums.Genero;
import tech.klok.kear.hub.domain.adesao.model.enums.EstadoCivil;
import tech.klok.kear.hub.presentation.user.dto.UserDTO;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Builder
@Entity
@Table(name = "T_USER")
public class UserModel implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "CPF")
    private String CPF;
    
    @Column(name = "GENERO")
    private Enum genero;
    
    @Column(name = "ESTADO_CIVIL")
    private Enum estadoCivil;
    
    @Column(name = "USERNAME")
    private String username;
    
    @Column(name = "SENHA")
    private String senha;
    
    @Column(name = "DATA_REGISTRO")
    private Date dataRegistro;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID_FK")
    private List<AdesaoModel> listaAdesoes = new ArrayList<>();
    
    public UserModel(UserDTO userDto) {
        this.CPF = userDto.getCPF();
        this.genero = userDto.getGenero();
        this.estadoCivil = userDto.getEstadoCivil();
        this.username = userDto.getUsername();
        this.senha = userDto.getSenha();
        this.dataRegistro = new Date(System.currentTimeMillis());
    }

    public boolean addAdesao (AdesaoModel adesaoModel) {
        if (!listaAdesoes.contains(adesaoModel)) {
            listaAdesoes.add(adesaoModel);
            return true;
        }
        return false;
    }
    
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

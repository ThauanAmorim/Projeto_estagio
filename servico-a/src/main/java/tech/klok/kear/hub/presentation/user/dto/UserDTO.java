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
import tech.klok.kear.hub.domain.adesao.model.enums.Genero;
import tech.klok.kear.hub.domain.adesao.model.enums.EstadoCivil;

public class UserDTO {
    private Long id;

    private String CPF;
    
    private Enum genero;
    
    private Enum estadoCivil;
    
    private String username;

    private String senha;
    
    public UserDTO() {
    }

    public UserDTO(Long id, String cPF, Enum genero, Enum estadoCivil, String username, String senha) {
        this.id = id;
        CPF = cPF;
        this.genero = genero;
        this.estadoCivil = estadoCivil;
        this.username = username;
        this.senha = senha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String cPF) {
        CPF = cPF;
    }

    public Enum getGenero() {
        return genero;
    }

    public void setGenero(int id) {
        for(Genero gender : Genero.values()) {
            if(gender.getId() == id) {
                this.genero = gender;
            }
        }
    }

    public Enum getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(int id) {
        for(EstadoCivil marital : EstadoCivil.values()) {
            if(marital.getId() == id) {
                this.estadoCivil = marital;
            }
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}

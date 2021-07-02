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
import tech.klok.kear.hub.domain.adesao.model.enums.Genero;
import tech.klok.kear.hub.domain.adesao.model.enums.EstadoCivil;
import tech.klok.kear.hub.presentation.user.dto.UserDTO;

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
    
    public UserModel() {
    }

    public UserModel(Long id, String cPF, Enum genero, Enum estadoCivil, String username, String senha,
            Date dataRegistro, List<AdesaoModel> listaAdesoes) {
        this.id = id;
        CPF = cPF;
        this.genero = genero;
        this.estadoCivil = estadoCivil;
        this.username = username;
        this.senha = senha;
        this.dataRegistro = dataRegistro;
        this.listaAdesoes = listaAdesoes;
    }

    public UserModel(UserDTO userDto) {
        this.CPF = userDto.getCPF();
        this.genero = userDto.getGenero();
        this.estadoCivil = userDto.getEstadoCivil();
        this.username = userDto.getUsername();
        this.senha = userDto.getSenha();
        this.dataRegistro = new Date(System.currentTimeMillis());
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
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

    public Date getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(Date dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public List<AdesaoModel> getListaAdesoes() {
        return listaAdesoes;
    }

    public void setListaAdesoes(List<AdesaoModel> listaAdesoes) {
        this.listaAdesoes = listaAdesoes;
    }

    public boolean addAdesao (AdesaoModel adesaoModel) {
        if (!listaAdesoes.contains(adesaoModel)) {
            listaAdesoes.add(adesaoModel);
            return true;
        }
        return false;
    }
}

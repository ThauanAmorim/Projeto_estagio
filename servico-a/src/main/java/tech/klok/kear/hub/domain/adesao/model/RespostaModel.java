package tech.klok.kear.hub.domain.adesao.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import tech.klok.kear.hub.presentation.resposta.RespostaDTO;

@Entity
@Table(name = "T_RESPOSTA")
public class RespostaModel implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CAMPO_ID_FK")
    private CampoModel campo;
    
    @Column(name = "VALOR")
    private String valor;

    public RespostaModel() {
    }

    public RespostaModel(Long id, CampoModel campo, String valor) {
        this.id = id;
        this.campo = campo;
        this.valor = valor;
    }

    public RespostaModel(RespostaDTO dto) {
        this.valor = dto.getValor();
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

    public CampoModel getCampo() {
        return campo;
    }

    public void setCampo(CampoModel campo) {
        this.campo = campo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
    
}

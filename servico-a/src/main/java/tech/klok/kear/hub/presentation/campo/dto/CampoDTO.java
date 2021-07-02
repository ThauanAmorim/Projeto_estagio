package tech.klok.kear.hub.presentation.campo.dto;

public class CampoDTO {
    
    private Long id;
    private String nome;
    private boolean obrigatorio;

    public CampoDTO() {
    }

    public CampoDTO(Long id, String nome, boolean obrigatorio) {
        this.id = id;
        this.nome = nome;
        this.obrigatorio = obrigatorio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isObrigatorio() {
        return obrigatorio;
    }

    public void setObrigatorio(boolean obrigatorio) {
        this.obrigatorio = obrigatorio;
    }
    
}

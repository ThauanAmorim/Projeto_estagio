package tech.klok.kear.hub.presentation.resposta;

public class RespostaDTO {
    private Long idCampo;
    private String valor;

    public RespostaDTO() {
    }

    public RespostaDTO(Long idCampo, String valor) {
        this.idCampo = idCampo;
        this.valor = valor;
    }

    public Long getIdCampo() {
        return idCampo;
    }

    public void setIdCampo(Long idCampo) {
        this.idCampo = idCampo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

}

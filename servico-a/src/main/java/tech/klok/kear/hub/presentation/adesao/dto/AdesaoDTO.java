package tech.klok.kear.hub.presentation.adesao.dto;
import java.util.List;
import tech.klok.kear.hub.presentation.resposta.RespostaDTO;

public class AdesaoDTO {

    private Long idProduto;

    private int diaCobranca;

    private int numeroParcelas;

    private float valor;

    List<RespostaDTO> respostas;

    public AdesaoDTO() {
    }

    public AdesaoDTO(Long idProduto, int diaVencimento, int numeroParcelas, float valor, List<RespostaDTO> respostas) {
        this.idProduto = idProduto;
        this.diaCobranca = diaVencimento;
        this.numeroParcelas = numeroParcelas;
        this.valor = valor;
        this.respostas = respostas;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public int getDiaCobranca() {
        return diaCobranca;
    }

    public void setDiaCobranca(int diaCobranca) {
        this.diaCobranca = diaCobranca;
    }

    public int getNumeroParcelas() {
        return numeroParcelas;
    }

    public void setNumeroParcelas(int numeroParcelas) {
        this.numeroParcelas = numeroParcelas;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public List<RespostaDTO> getRespostas() {
        return respostas;
    }

    public void setRespostas(List<RespostaDTO> respostas) {
        this.respostas = respostas;
    }

    
}

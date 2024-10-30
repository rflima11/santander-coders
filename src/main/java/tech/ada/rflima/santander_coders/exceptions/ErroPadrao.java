package tech.ada.rflima.santander_coders.exceptions;

import java.time.LocalDateTime;

public class ErroPadrao {

    private String codigoErro;
    private LocalDateTime dataHora;
    private String mensagem;

    public ErroPadrao() {
        this.dataHora = LocalDateTime.now();
    }

    public String getCodigoErro() {
        return codigoErro;
    }

    public void setCodigoErro(String codigoErro) {
        this.codigoErro = codigoErro;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}

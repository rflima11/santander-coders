package tech.ada.rflima.santander_coders.model;

import jakarta.persistence.*;


@Entity
@Table(name = "ENDERECO")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "CEP", nullable = false)
    private String cep;
    @Column(name = "LOGRADOURO", nullable = false)
    private String logradouro;
    @Column(name = "COMPLEMENTO")
    private String complemento;
    @Column(name = "BAIRRO", nullable = false)
    private String bairro;
    @Column(name = "ESTADO", nullable = false)
    private String estado;
    @Column(name = "REGIAO", nullable = false)
    private String regiao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }
}

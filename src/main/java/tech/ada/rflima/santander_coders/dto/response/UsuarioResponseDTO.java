package tech.ada.rflima.santander_coders.dto.response;

public class UsuarioResponseDTO {

    private String nome;
    private Integer idade;
    private String cpf;
    private EnderecoDTO endereco;

    public UsuarioResponseDTO(String nome,
                              Integer idade,
                              String cpf,
                              EnderecoDTO endereco) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.endereco = endereco;
    }

    public UsuarioResponseDTO() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public EnderecoDTO getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoDTO endereco) {
        this.endereco = endereco;
    }
}

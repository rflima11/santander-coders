package tech.ada.rflima.santander_coders.dto.request;

import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.br.CPF;

public record CriarUsuarioDTO(
        @NotBlank(message = "nome não pode ser nulo ou branco")
        @Size(min = 3, message = "nome não pode ter menos que três caracteres")
        String nome,
        @Positive(message = "Idade deve possui um valor maior que 0")
        Integer idade,
        @Email(message = "Email não está no formato correto")
        String email,
        @CPF(message = "CPF não está no formato correto")
        String cpf,
        @NotBlank(message = "CEP deve ser informado")
        @Size(min = 8, max = 8, message = "CEP deve conter oito caracteres")
        @Pattern(regexp = "^\\d+$")
        String cep
) {}

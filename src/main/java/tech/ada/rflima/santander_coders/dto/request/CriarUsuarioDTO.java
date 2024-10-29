package tech.ada.rflima.santander_coders.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
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
        String cpf
) {}

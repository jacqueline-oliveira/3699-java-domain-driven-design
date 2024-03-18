package br.com.alura.codechella.vendas.aplicacao.usuario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DadosCadastroUsuario(
         @NotBlank(message = "O cpf é obrigatório!")
         String cpf,
         @NotBlank(message = "O nome é obrigatório!")
         String nome,
         @NotNull(message = "A data de nascimento é obrigatória!")
         LocalDate nascimento,
         @NotBlank(message = "O e-mail é obrigatório!")
         String email
) {
}

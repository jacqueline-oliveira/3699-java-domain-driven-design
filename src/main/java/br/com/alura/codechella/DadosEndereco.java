package br.com.alura.codechella;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record DadosEndereco(
        @NotBlank(message = "O cep é obrigatório!")
        String cep,
        @Positive(message = "O número do endereço é obrigatório!")
        Integer numero,
        String complemento
) {
}

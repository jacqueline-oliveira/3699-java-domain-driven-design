package br.com.alura.codechella;

import jakarta.validation.constraints.NotNull;

public record DadosCadastroIngresso(
        @NotNull(message = "O código do ingresso é obrigatório!")
        Integer codigo,
        @NotNull(message = "O id do tipo é obrigatório!")
        Long tipo_id
) {
}

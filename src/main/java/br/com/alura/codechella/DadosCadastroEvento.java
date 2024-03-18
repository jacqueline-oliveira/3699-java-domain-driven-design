package br.com.alura.codechella;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;

public record DadosCadastroEvento(
        @NotNull(message = "A categoria do evento é obrigatória!")
        Categoria categoria,
        @NotBlank(message = "A descrição do evento é obrigatória!")
        String descricao,
        @NotNull(message = "O endereço do evento é obrigatório!")
        @Valid
        DadosEndereco endereco,
        @NotNull(message = "Data do evento é obrigatória!")
        @Future(message = "Data do evento deve ser uma data futura!")
        LocalDateTime data,
        @NotNull(message = "Pelo menos um tipo de ingresso deve ser informado!")
        @Valid
        List<DadosCadastroTipoIngresso> tipoIngressos

) {
}

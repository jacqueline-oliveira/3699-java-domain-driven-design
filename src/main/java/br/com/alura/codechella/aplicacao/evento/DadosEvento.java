package br.com.alura.codechella.aplicacao.evento;

import br.com.alura.codechella.dominio.evento.Categoria;
import br.com.alura.codechella.aplicacao.ingresso.DadosCadastroTipoIngresso;

import java.time.LocalDateTime;
import java.util.List;

public record DadosEvento(
        Long id,
        Categoria categoria,
        String descricao,
        DadosEndereco endereco,
        LocalDateTime data,
        List<DadosCadastroTipoIngresso> tipoIngressos
) {
}

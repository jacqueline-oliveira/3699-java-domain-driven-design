package br.com.alura.codechella.vendas.aplicacao.evento;

import br.com.alura.codechella.vendas.dominio.evento.Categoria;
import br.com.alura.codechella.vendas.aplicacao.ingresso.DadosCadastroTipoIngresso;

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

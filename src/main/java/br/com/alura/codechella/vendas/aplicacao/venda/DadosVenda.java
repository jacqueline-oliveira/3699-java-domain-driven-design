package br.com.alura.codechella.vendas.aplicacao.venda;

import br.com.alura.codechella.vendas.aplicacao.ingresso.DadosTipoIngresso;
import br.com.alura.codechella.vendas.aplicacao.usuario.DadosUsuario;

import java.util.List;

public record DadosVenda(
        Long id,
        DadosUsuario usuario,
        List<DadosTipoIngresso> ingressos
) {
}

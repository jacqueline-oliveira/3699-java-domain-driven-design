package br.com.alura.codechella.aplicacao.venda;

import br.com.alura.codechella.aplicacao.ingresso.DadosTipoIngresso;
import br.com.alura.codechella.aplicacao.usuario.DadosUsuario;

import java.util.List;

public record DadosVenda(
        Long id,
        DadosUsuario usuario,
        List<DadosTipoIngresso> ingressos
) {
}

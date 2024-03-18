package br.com.alura.codechella.vendas.aplicacao.ingresso;

import br.com.alura.codechella.vendas.dominio.ingresso.Definicao;
import br.com.alura.codechella.vendas.dominio.ingresso.Setor;

public record DadosTipoIngresso(
        Integer codigo,
        Setor,
        Definicao definicao
) {
}

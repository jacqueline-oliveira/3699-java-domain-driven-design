package br.com.alura.codechella.aplicacao.ingresso;

import br.com.alura.codechella.dominio.ingresso.Definicao;
import br.com.alura.codechella.dominio.ingresso.Setor;

public record DadosTipoIngresso(
        Integer codigo,
        Setor,
        Definicao definicao
) {
}

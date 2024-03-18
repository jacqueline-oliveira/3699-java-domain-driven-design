package br.com.alura.codechella.vendas.aplicacao.evento;

import br.com.alura.codechella.vendas.dominio.evento.Evento;

public interface RepositorioDeEvento {
    Evento buscarEventoPorCidade(String cep);
}

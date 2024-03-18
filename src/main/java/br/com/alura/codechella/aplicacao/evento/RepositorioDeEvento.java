package br.com.alura.codechella.aplicacao.evento;

import br.com.alura.codechella.dominio.evento.Evento;

public interface RepositorioDeEvento {
    Evento buscarEventoPorCidade(String cep);
}

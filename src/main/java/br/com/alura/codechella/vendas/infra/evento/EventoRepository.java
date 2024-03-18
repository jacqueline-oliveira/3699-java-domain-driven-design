package br.com.alura.codechella.vendas.infra.evento;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepository extends JpaRepository<Evento, Long> {

}

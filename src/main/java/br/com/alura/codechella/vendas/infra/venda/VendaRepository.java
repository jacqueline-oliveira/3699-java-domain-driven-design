package br.com.alura.codechella.vendas.infra.venda;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VendaRepository extends JpaRepository<Venda, Long> {
}

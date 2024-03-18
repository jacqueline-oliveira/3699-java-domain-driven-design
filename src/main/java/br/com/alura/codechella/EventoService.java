package br.com.alura.codechella;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventoService {

    @Autowired
    private EventoRepository repository;

    public DadosEvento cadastrarEvento(DadosCadastroEvento dadosCadastro) {
        var evento = new Evento(dadosCadastro);
        repository.save(evento);
        return converteDados(evento);
    }

    public List<DadosEvento> listarTodos() {
        List<Evento> eventos = repository.findAll();
        return eventos.stream()
                .map(e -> converteDados(e))
                .collect(Collectors.toList());
    }

    private DadosEvento converteDados(Evento evento) {
        List<DadosCadastroTipoIngresso> dadosIngressos = evento.getTipoIngressos().stream()
                .map(i -> new DadosCadastroTipoIngresso(i.getSetor(), i.getDefinicao(),
                        i.getValor(), i.getTotalDisponivel()))
                .collect(Collectors.toList());

        return new DadosEvento(evento.getId(), evento.getCategoria(),
                evento.getDescricao(), new DadosEndereco(evento.getEndereco().getCep(),
                evento.getEndereco().getNumero(), evento.getEndereco().getComplemento()),
                evento.getData(), dadosIngressos);

    }
}

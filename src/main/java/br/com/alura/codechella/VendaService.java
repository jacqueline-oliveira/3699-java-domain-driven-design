package br.com.alura.codechella;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VendaService {

    @Autowired
    private VendaRepository repository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TipoRepository tipoRepository;

    public DadosVenda cadastrarVenda(DadosCadastroVenda dadosVenda) {
        Usuario usuario = usuarioRepository.findById(dadosVenda.usuario_id())
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));

        Venda venda = new Venda();
        venda.setUsuario(usuario);

        List<Ingresso> ingressos = new ArrayList<>();
        dadosVenda.ingressos().stream()
                .forEach(i -> {
                    Tipo tipo = tipoRepository.findById(i.tipo_id())
                            .orElseThrow(() -> new IllegalArgumentException("Tipo de ingresso não encontrado"));
                    Ingresso ingresso = new Ingresso(i.codigo(), tipo);
                    ingressos.add(ingresso);
                });
        venda.setIngressos(ingressos);
        repository.save(venda);
        return converteDados(venda);
    }

    public List<DadosVenda> listarTodas() {
        return repository.findAll().stream()
                .map(v -> converteDados(v))
                .collect(Collectors.toList());
    }

    private DadosVenda converteDados(Venda venda) {
        List<DadosTipoIngresso> ingressos =
                venda.getIngressos().stream()
                        .map(i -> new DadosTipoIngresso(i.getCodigo(),
                                i.getTipo().getSetor(), i.getTipo().getDefinicao()))
                        .collect(Collectors.toList());


        return new DadosVenda(venda.getId(),
                new DadosUsuario(venda.getUsuario().getId(),
                        venda.getUsuario().getCpf(),
                        venda.getUsuario().getNome(),
                        venda.getUsuario().getNascimento(),
                        venda.getUsuario().getEmail()),
                ingressos);
    }
}

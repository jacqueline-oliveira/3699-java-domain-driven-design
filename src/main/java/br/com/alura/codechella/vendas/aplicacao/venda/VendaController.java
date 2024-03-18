package br.com.alura.codechella.vendas.aplicacao.venda;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("vendas")
public class VendaController {

    @Autowired
    private VendaService service;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroVenda dadosVenda, UriComponentsBuilder uriBuilder) {
        DadosVenda venda = service.cadastrarVenda(dadosVenda);
        var uri = uriBuilder.path("/vendas/{id}").buildAndExpand(venda.id()).toUri();

        return ResponseEntity.created(uri).body(venda);
    }

    @GetMapping
    public ResponseEntity<List<DadosVenda>> listar() {
        return ResponseEntity.ok(service.listarTodas());
    }

}

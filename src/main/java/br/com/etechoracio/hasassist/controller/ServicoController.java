package br.com.etechoracio.hasassist.controller;

import br.com.etechoracio.hasassist.entity.Equipamento;
import br.com.etechoracio.hasassist.entity.Servico;
import br.com.etechoracio.hasassist.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servicos")
public class ServicoController {

    @Autowired
    private ServicoRepository repository;

    @GetMapping
    public List<Servico> recuperarTudo() {
        return repository.findAll();
    }

    @PostMapping
    public Servico inserir(@RequestBody Servico body) {
        return repository.save(body);
    }

    @GetMapping("/{id}")
    public Servico buscaId(@PathVariable Long id){
        var recupId = repository.findById(id);
        if ((recupId.isEmpty())){
            return null;
        }
        return recupId.get();
    }

    @PutMapping("/{id}")
    public Servico atualizar(@PathVariable Long id, @RequestBody Servico body) {
        var att = repository.findById(id);
        if (att.isEmpty()){
            return null;
        }
        var atualizado = repository.save(body);
        return atualizado;
    }

    @DeleteMapping("/{id}")
    public Servico excluirId(@PathVariable Long id){
        var exc = repository.findById(id);
        if (exc.isEmpty()) {
            return null;
        }
        repository.deleteById(id);
        return exc.get();
    }

}

package br.com.etechoracio.hasassist.controller;

import br.com.etechoracio.hasassist.entity.Equipamento;
import br.com.etechoracio.hasassist.repository.EquipamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/equipamentos")
public class EquipamentoController {
    @Autowired
    private EquipamentoRepository reposity;

    @GetMapping
    public List<Equipamento> listarTodos() {
        return reposity.findAll();
    }

    @PostMapping
    public Equipamento inserir(@RequestBody Equipamento body){
        return reposity.save(body);
    }

    @GetMapping("/{id}")
    public Equipamento buscarPorId(@PathVariable Long id){
        var existe = reposity.findById(id);
        if(existe.isEmpty()){
            return null;
        }
        return existe.get();
    }

    @PutMapping("/{id}")
    public Equipamento atualizar(@PathVariable Long id, @RequestBody Equipamento body){
        var att = reposity.findById(id);
        if (att.isEmpty()) {
            return null;
        }
        var atualizado = reposity.save(body);
        return atualizado;
    }

}

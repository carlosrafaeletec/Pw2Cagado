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

    @GetMapping
    public List<Equipamento> listar(@PathVariable Long id){
        return reposity.findById(id);
    }
}

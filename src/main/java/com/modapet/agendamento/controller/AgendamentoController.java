package com.modapet.agendamento.controller;

import com.modapet.agendamento.model.Agendamento;
import com.modapet.agendamento.repository.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agendamentos")
public class AgendamentoController {

    @Autowired
    private AgendamentoRepository repository;

    @GetMapping
    public List<Agendamento> listar() {
        return repository.findAll();
    }

    @PostMapping
    public Agendamento salvar(@RequestBody Agendamento agendamento) {
        return repository.save(agendamento);
    }

    @GetMapping("/{id}")
    public Agendamento buscarPorId(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Agendamento atualizar(@PathVariable Long id, @RequestBody Agendamento novoAgendamento) {
        return repository.findById(id)
                .map(agendamento -> {
                    agendamento.setNomeDono(novoAgendamento.getNomeDono());
                    agendamento.setNomePet(novoAgendamento.getNomePet());
                    agendamento.setTipoServico(novoAgendamento.getTipoServico());
                    agendamento.setDataHora(novoAgendamento.getDataHora());
                    agendamento.setObservacoes(novoAgendamento.getObservacoes());
                    return repository.save(agendamento);
                }).orElse(null);
    }
}
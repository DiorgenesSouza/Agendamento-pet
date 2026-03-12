package com.modapet.agendamento.repository;

import com.modapet.agendamento.model.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
    // Aqui o Spring já te dá todos os métodos: save(), findAll(), deleteById(), etc.
}
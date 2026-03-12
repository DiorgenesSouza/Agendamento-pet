package com.modapet.agendamento.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeDono;
    private String nomePet;
    private String tipoServico; // Ex: Banho, Tosa, Combo
    private LocalDateTime dataHora;
    private String observacoes;
}
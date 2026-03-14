package com.modapet.agendamento.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("nome_dono")
    private String nomeDono;

    @JsonProperty("nome_pet")
    private String nomePet;

    @JsonProperty("tipo_servico")
    private String tipoServico;

    private String observacoes;

    @JsonProperty("data_hora")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm") // Removi o :ss para ser mais flexível
    private LocalDateTime dataHora;
}
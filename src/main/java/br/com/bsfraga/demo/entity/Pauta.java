package br.com.bsfraga.demo.entity;

import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;


@Builder
@With
@AllArgsConstructor
@NoArgsConstructor
@EntityScan
@Data
@Document(collection = "pauta")
public class Pauta {
    @Id
    private String id;
    private String nome;
    private String descricao;
    private Long tempoDuracao;
    private String resultado;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataEncerramento;
}

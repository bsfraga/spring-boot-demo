package br.com.bsfraga.demo.dto;

import lombok.Builder;
import lombok.Value;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

import java.time.LocalDateTime;

@Value
@With
@Jacksonized
@Builder
public class PautaDTO {

    private String id;
    private String nome;
    private String descricao;
    private Long tempoDuracao;
    private String resultado;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataEncerramento;

}

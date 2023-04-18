package br.com.bsfraga.demo.dto;

import lombok.Builder;
import lombok.Value;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

@Value
@With
@Jacksonized
@Builder
public class PautaCreateDTO {

    private String nome;
    private String descricao;
    private Long tempoDuracao;

}

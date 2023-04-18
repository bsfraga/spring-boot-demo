package br.com.bsfraga.demo.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "voto")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Voto {
    private String associadoId;
    private String pautaId;
    private boolean voto;

}

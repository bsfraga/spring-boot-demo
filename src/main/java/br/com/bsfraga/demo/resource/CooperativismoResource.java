package br.com.bsfraga.demo.resource;

import br.com.bsfraga.demo.dto.PautaCreateDTO;
import br.com.bsfraga.demo.dto.PautaDTO;
import br.com.bsfraga.demo.entity.Pauta;
import br.com.bsfraga.demo.service.CooperativismoService;
import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cooperativismo")
@RequiredArgsConstructor
@Validated
public class CooperativismoResource {

    private final CooperativismoService cooperativismoService;

    @PostMapping("/abrir-pauta")
    public Pauta abrirPauta(PautaCreateDTO pauta) {
        return cooperativismoService.criarPauta(pauta);
    }


}

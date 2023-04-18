package br.com.bsfraga.demo.service;

import br.com.bsfraga.demo.dto.PautaCreateDTO;
import br.com.bsfraga.demo.entity.Pauta;
import br.com.bsfraga.demo.entity.Voto;
import br.com.bsfraga.demo.repository.PautaRepository;
import br.com.bsfraga.demo.repository.VotoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CooperativismoService {
    @Autowired
    private PautaRepository pautaRepository;

    @Autowired
    private VotoRepository votoRepository;

    public Pauta criarPauta(PautaCreateDTO pauta) {
        return pautaRepository.save(Pauta.builder()
                .nome(pauta.getNome())
                .descricao(pauta.getDescricao())
                .dataCriacao(LocalDateTime.now())
                .build());
    }

    public Pauta abrirSessaoDeVotacao(String pautaId, Long duracaoEmMinutos) {
        Pauta pauta = pautaRepository.findById(pautaId).orElseThrow(() -> new IllegalArgumentException("Pauta não encontrada"));
        pauta.setTempoDuracao(duracaoEmMinutos);
        pautaRepository.save(pauta);
        return pauta;
    }

    public Voto votar(String associadoId, String pautaId, boolean voto) {
        List<Voto> votos = votoRepository.findByAssociadoIdAndPautaId(associadoId, pautaId);
        if (!votos.isEmpty()) {
            throw new IllegalArgumentException("Associado já votou nesta pauta");
        }
        Pauta pauta = pautaRepository.findById(pautaId).orElseThrow(() -> new IllegalArgumentException("Pauta não encontrada"));
        if (pauta.getTempoDuracao() != null && LocalDateTime.now().isAfter(pauta.getDataCriacao().plusMinutes(pauta.getTempoDuracao()))) {
            throw new IllegalArgumentException("Sessão de votação encerrada");
        }

        return votoRepository.save(Voto.builder()
                .associadoId(associadoId)
                .pautaId(pautaId)
                .voto(voto)
                .build());
    }

    public boolean contabilizarVotos(String pautaId) {
        Pauta pauta = pautaRepository.findById(pautaId).orElseThrow(() -> new IllegalArgumentException("Pauta não encontrada"));
        List<Voto> votos = votoRepository.findAllByPautaId(pautaId);
        int votosSim = 0;
        int votosNao = 0;
        for (Voto voto : votos) {
            if (voto.isVoto()) {
                votosSim++;
            } else {
                votosNao++;
            }
        }
        pauta.setResultado(votosSim > votosNao ? "Aprovado" : "Reprovado");
        pautaRepository.save(pauta);
        return votosSim > votosNao;
    }
}
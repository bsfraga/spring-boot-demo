package br.com.bsfraga.demo.repository;

import br.com.bsfraga.demo.entity.Voto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VotoRepository extends MongoRepository<Voto, String> {
    List<Voto> findByAssociadoIdAndPautaId(String associadoId, String pautaId);

    List<Voto> findAllByPautaId(String pautaId);

}
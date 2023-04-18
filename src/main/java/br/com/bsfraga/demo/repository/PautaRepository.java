package br.com.bsfraga.demo.repository;

import br.com.bsfraga.demo.entity.Pauta;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PautaRepository extends MongoRepository<Pauta, String> {
}

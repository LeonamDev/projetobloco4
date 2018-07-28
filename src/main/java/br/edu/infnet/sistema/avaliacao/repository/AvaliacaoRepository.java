package br.edu.infnet.sistema.avaliacao.repository;

import br.edu.infnet.sistema.avaliacao.model.Avaliacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {
}
package br.edu.infnet.sistema.avaliacao.repository;

import br.edu.infnet.sistema.avaliacao.model.Resposta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RespostaRepository extends JpaRepository<Resposta, Long> {
}
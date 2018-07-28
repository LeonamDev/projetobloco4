package br.edu.infnet.sistema.avaliacao.repository;

import br.edu.infnet.sistema.avaliacao.model.Questionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionarioRepository extends JpaRepository<Questionario, Long> {
}
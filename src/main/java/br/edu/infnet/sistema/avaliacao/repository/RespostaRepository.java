package br.edu.infnet.sistema.avaliacao.repository;

import br.edu.infnet.sistema.avaliacao.model.Resposta;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RespostaRepository extends JpaRepository<Resposta, Long> {
    
    @Query("SELECT r FROM Resposta r WHERE r.avaliacao.id = :idAvaliacao")
    List<Resposta> findByIdAvaliacao(@Param("idAvaliacao") Long idAvaliacao);
}
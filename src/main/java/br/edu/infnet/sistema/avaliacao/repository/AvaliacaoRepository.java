package br.edu.infnet.sistema.avaliacao.repository;

import br.edu.infnet.sistema.avaliacao.model.Avaliacao;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {

    @Query(value = "SELECT distinct(av.id) from aluno as al INNER JOIN turma as t "
            + "on t.id = al.turma_id INNER JOIN avaliacao as av on av.turma_id = t.id"
            + " where al.id in (?1)", nativeQuery = true)
    List<Long> findBySentEvaluation(List<Long> alunosIDs);

    @Transactional
    @Modifying
    @Query(value = "UPDATE avaliacao set enviado = 1 where id in (?1)", nativeQuery = true)
    public void setEnviadoEqualTrue(List<Long> avaliacaoIDs);
    
    @Transactional
    @Modifying
    @Query(value = "UPDATE avaliacao set enviada_pro_coordenador = 1 where id in (?1)", nativeQuery = true)
    public void setEnviadoProCoordenadorEqualTrue(List<Long> avaliacaoIDs);
    
    @Query(value = "SELECT id from avaliacao where termino_avaliacao < ?1 and "
            + "enviada_pro_coordenador = 0", nativeQuery = true)
    List<Object> findByValuationPeriodEnded(LocalDateTime dateTime);

}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.infnet.sistema.avaliacao.repository;

import br.edu.infnet.sistema.avaliacao.model.Aluno;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author leonam
 */
@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    @Query(value = "SELECT p.*, e.id as id_email, e.link_avaliacao, e.texto FROM pessoa p INNER JOIN aluno as al on al.id = p.id "
            + "INNER JOIN turma as t ON t.id = al.turma_id INNER JOIN avaliacao as av "
            + "ON av.turma_id = t.id INNER JOIN email_abertura as e ON e.id = av.email_abertura_id "
            + "WHERE av.enviado = 0 and av.inicio_avaliacao <= ?1", nativeQuery = true)
    List<Object[]> findByMissingEvaluation(java.sql.Timestamp currentDateTime);
   
}

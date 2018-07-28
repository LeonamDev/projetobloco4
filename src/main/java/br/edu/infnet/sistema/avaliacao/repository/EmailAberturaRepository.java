package br.edu.infnet.sistema.avaliacao.repository;

import br.edu.infnet.sistema.avaliacao.model.EmailAbertura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailAberturaRepository extends JpaRepository<EmailAbertura, Long> {
}
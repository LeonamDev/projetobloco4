package br.edu.infnet.sistema.avaliacao.service;

import br.edu.infnet.sistema.avaliacao.model.Turma;
import br.edu.infnet.sistema.avaliacao.repository.TurmaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author luis
 */
@Service
public class TurmaService {
    
    @Autowired
    private TurmaRepository turmaRepository;
    
    public Optional<Turma> findById(Long id) {

        return turmaRepository.findById(id);
    }

    public List<Turma> findAll() {

        return turmaRepository.findAll();
    }

    public void save(Turma avaliacao) {
        turmaRepository.save(avaliacao);

    }

    public void remove(Long id) {
        turmaRepository.deleteById(id);
    }
}
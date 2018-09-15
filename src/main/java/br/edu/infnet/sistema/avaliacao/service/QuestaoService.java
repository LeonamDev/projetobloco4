package br.edu.infnet.sistema.avaliacao.service;

import br.edu.infnet.sistema.avaliacao.model.Questao;
import br.edu.infnet.sistema.avaliacao.repository.QuestaoRepository;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestaoService implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Autowired
    private QuestaoRepository questaoRepository;
    
    public Optional<Questao> findById(Long id) {

        return questaoRepository.findById(id);

    }

    public List<Questao> findAll() {

        return questaoRepository.findAll();

    }

    public void save(Questao questao) {
        questaoRepository.save(questao);

    }

    public void remove(Long id) {
        questaoRepository.deleteById(id);
    }

}

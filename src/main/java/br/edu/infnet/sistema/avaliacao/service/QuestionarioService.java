package br.edu.infnet.sistema.avaliacao.service;


import br.edu.infnet.sistema.avaliacao.model.Questionario;
import br.edu.infnet.sistema.avaliacao.repository.QuestionarioRepository;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionarioService implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Autowired
    private QuestionarioRepository questionarioRepository;

    public Optional<Questionario> findById(Long id) {

        return questionarioRepository.findById(id);

    }

    public List<Questionario> findAll() {

        return questionarioRepository.findAll();

    }

    public void save(Questionario questionario) {
        questionarioRepository.save(questionario);

    }

    public void remove(Long id) {
        questionarioRepository.deleteById(id);
    }
    
}

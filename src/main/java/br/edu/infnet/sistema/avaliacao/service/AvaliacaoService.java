package br.edu.infnet.sistema.avaliacao.service;

import br.edu.infnet.sistema.avaliacao.model.Avaliacao;
import br.edu.infnet.sistema.avaliacao.repository.AvaliacaoRepository;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AvaliacaoService  implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    public Optional<Avaliacao> findById(Long id) {

        return avaliacaoRepository.findById(id);

    }

    public List<Avaliacao> findAll() {

        return avaliacaoRepository.findAll();

    }

    public void save(Avaliacao avaliacao) {
        avaliacaoRepository.save(avaliacao);

    }

    public void remove(Long id) {
        avaliacaoRepository.deleteById(id);
    }

    
}

package br.edu.infnet.sistema.avaliacao.service;

import br.edu.infnet.sistema.avaliacao.model.Resposta;
import br.edu.infnet.sistema.avaliacao.repository.RespostaRepository;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RespostaService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    private RespostaRepository respostaRepository;

    public Optional<Resposta> findById(Long id) {

        return respostaRepository.findById(id);

    }
    
    public List<Resposta> findByIdAvaliacao(Long id) {

        return respostaRepository.findByIdAvaliacao(id);
    }
      
    public List<Resposta> findAll() {

        return respostaRepository.findAll();

    }

    public void save(Resposta resposta) {
        respostaRepository.save(resposta);

    }

    public void remove(Long id) {
        respostaRepository.deleteById(id);
    }
    
}

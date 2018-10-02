package br.edu.infnet.sistema.avaliacao.service;

import br.edu.infnet.sistema.avaliacao.AvaliacaoTools;
import br.edu.infnet.sistema.avaliacao.model.Avaliacao;
import br.edu.infnet.sistema.avaliacao.model.EmailAbertura;
import br.edu.infnet.sistema.avaliacao.model.Pessoa;
import br.edu.infnet.sistema.avaliacao.repository.AvaliacaoRepository;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DesenvolvedorJava
 */
@Service
public class AvaliacaoService {

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;
        
    public void setEnviadoEqualTrue(Map<Pessoa, EmailAbertura> alunos) {
        List<Long> alunosIDs = new ArrayList<>();
        if (alunos.size() > 0) {
            alunos.forEach((k, v) -> {
                alunosIDs.add(k.getId());
            });
            List<Long> avaliacoesIDs = avaliacaoRepository.findBySentEvaluation(alunosIDs);
            avaliacaoRepository.setEnviadoEqualTrue(avaliacoesIDs);
        }
    }

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
    
    public Boolean hasExpired(Long id){
        Optional<Avaliacao> avaliacao = avaliacaoRepository.findById(id);
        return avaliacao.get().getTerminoAvaliacao().isBefore(AvaliacaoTools.getCurrentTime().toLocalDateTime());  
    }

    
    
}
package br.edu.infnet.sistema.avaliacao.service;

import br.edu.infnet.sistema.avaliacao.model.Aluno;
import br.edu.infnet.sistema.avaliacao.model.Pessoa;
import br.edu.infnet.sistema.avaliacao.repository.AvaliacaoRepository;
import java.util.List;
import java.util.stream.Collectors;
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

    public void setEnviadoEqualTrue(List<Pessoa> alunos) {
        if (alunos.size() > 0) {
            List<Long> alunosIDs = alunos.stream()
                    .map(f -> f.getId())
                    .collect(Collectors.toList());
            
            List<Long> avaliacoesIDs = avaliacaoRepository.findBySentEvaluation(alunosIDs);
            avaliacaoRepository.setEnviadoEqualTrue(avaliacoesIDs);
        }
    }

}

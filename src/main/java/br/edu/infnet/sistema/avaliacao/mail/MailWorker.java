/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.infnet.sistema.avaliacao.mail;

import br.edu.infnet.sistema.avaliacao.AvaliacaoTools;
import br.edu.infnet.sistema.avaliacao.model.EmailAbertura;
import br.edu.infnet.sistema.avaliacao.model.Pessoa;
import br.edu.infnet.sistema.avaliacao.service.AlunoService;
import br.edu.infnet.sistema.avaliacao.service.AvaliacaoService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 *
 * @author leonam
 */
@Component    //Replaced the @ComponentScan annotation
@EnableScheduling
public class MailWorker {

    @Autowired
    private MailService mailService;

    @Autowired
    private AlunoService alunoService;

    @Autowired
    private AvaliacaoService avaliacaoService;

    @Scheduled(fixedRate = 60000)
    public void reportCurrentTime() {
       Map<Pessoa,EmailAbertura> alunos = alunoService.findByMissingEvaluation(AvaliacaoTools
                .getCurrentTime());
       mailService.sendNotification(alunos);
       avaliacaoService.setEnviadoEqualTrue(alunos);
    }

}

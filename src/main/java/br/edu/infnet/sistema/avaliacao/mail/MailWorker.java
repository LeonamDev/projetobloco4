/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.infnet.sistema.avaliacao.mail;

/**
 *
 * @author leonam
 */
import br.edu.infnet.sistema.avaliacao.AvaliacaoTools;
import br.edu.infnet.sistema.avaliacao.model.Pessoa;
import br.edu.infnet.sistema.avaliacao.service.AlunoService;
import br.edu.infnet.sistema.avaliacao.service.AvaliacaoService;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

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
        List<Pessoa> alunos = alunoService.findByMissingEvaluation(AvaliacaoTools.getCurrentTime());

        alunos.stream().forEach(f -> {
            mailService.sendNotification(f);
        });

        avaliacaoService.setEnviadoEqualTrue(alunos);

    }

}

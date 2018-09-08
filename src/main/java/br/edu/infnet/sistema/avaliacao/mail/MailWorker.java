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
import br.edu.infnet.sistema.avaliacao.model.Aluno;
import br.edu.infnet.sistema.avaliacao.model.Pessoa;
import br.edu.infnet.sistema.avaliacao.repository.AlunoRepository;
import br.edu.infnet.sistema.avaliacao.service.AlunoService;
import java.util.ArrayList;
import java.util.List;
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

    List<Pessoa> alunos = new ArrayList<>();

    @Scheduled(fixedRate = 60000)
    public void reportCurrentTime() {
        java.sql.Timestamp currentDateTime = AvaliacaoTools.getCurrentTime();
        List<Pessoa> alunos = alunoService.findByMissingEvaluation(currentDateTime);

        alunos.stream().forEach(f -> {
            mailService.sendNotification(f);
        });
    }

}

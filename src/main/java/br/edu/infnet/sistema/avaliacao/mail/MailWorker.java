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
import br.edu.infnet.sistema.avaliacao.model.Aluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component    //Replaced the @ComponentScan annotation
@EnableScheduling
public class MailWorker {

    @Autowired
    private MailService mailService;
  
    @Scheduled(fixedRate = 1000)
    public void reportCurrentTime() {
        System.err.println("TESTEEE, FOI!");
        Aluno aluno = new Aluno();
        aluno.setEmail("sistemadeavaliacaoinfnet@gmail.com");
        mailService.sendNotification(aluno, "link");

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.infnet.sistema.avaliacao.mail;

import br.edu.infnet.sistema.avaliacao.AvaliacaoTools;
import br.edu.infnet.sistema.avaliacao.model.Aluno;
import br.edu.infnet.sistema.avaliacao.model.Pessoa;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 *
 * @author leonam
 */
@Service
public class MailService {
    
   private JavaMailSender javaMailSender;

    /**
     *
     * @param javaMailSender
     */
    @Autowired
    public MailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }
    
    /**
     *
     * @param alunos
     */
    public void sendNotification(List<Pessoa> alunos){
        alunos.stream().forEach(f -> {
            SimpleMailMessage mail = new SimpleMailMessage();
            mail.setTo(f.getEmail());
            mail.setSubject("Avaliacao");
            mail.setText("Por favor, clique no link para realizar a avaliacao: " 
                    + "http://localhost:8084/avaliacao/questionario?al=" + 
                    AvaliacaoTools.encrypt(f.getId()));
            javaMailSender.send(mail);
        });
    }   
    
}

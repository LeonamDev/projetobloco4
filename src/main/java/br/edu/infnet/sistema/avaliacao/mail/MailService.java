/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.infnet.sistema.avaliacao.mail;

import br.edu.infnet.sistema.avaliacao.AvaliacaoTools;
import br.edu.infnet.sistema.avaliacao.model.Aluno;
import br.edu.infnet.sistema.avaliacao.model.EmailAbertura;
import br.edu.infnet.sistema.avaliacao.model.Pessoa;
import java.util.List;
import java.util.Map;
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
    public void sendNotification(Map<Pessoa,EmailAbertura> alunos){
        alunos.forEach((k,v) -> {
            SimpleMailMessage mail = new SimpleMailMessage();
            mail.setTo(k.getEmail());
            mail.setSubject("Avaliacao");
            mail.setText("Prazado(a) " + k.getNome() 
                    + "," + "\n" 
                    + v.getTexto() +": "
                    + v.getLinkAvaliacao() +"?al="
                    + AvaliacaoTools.encrypt(k.getId())
                    + "&av=" + AvaliacaoTools.encrypt(v.getId()));
            javaMailSender.send(mail);
        });
    }   
    
}

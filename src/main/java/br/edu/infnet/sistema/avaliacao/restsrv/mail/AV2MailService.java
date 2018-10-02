/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.infnet.sistema.avaliacao.restsrv.mail;

import br.edu.infnet.sistema.avaliacao.AvaliacaoTools;
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
public class AV2MailService {
    
   private JavaMailSender javaMailSender;

    /**
     *
     * @param javaMailSender
     */
    @Autowired
    public AV2MailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }
    
    /**
     *
     * @param avaliacoesIds
     */
    public void sendNotification(List<Long> avaliacoesIds){
        avaliacoesIds.forEach(f -> {
            SimpleMailMessage mail = new SimpleMailMessage();
            mail.setTo("sistemadeavaliacaoinfnet@gmail.com");
            mail.setSubject("Resultado da Avaliacao");
            mail.setText("Prazado(a) Coordenador"  
                    + "," + "\n" 
                    + "Segue o link contendo as respostas dos alunos: "
                    + "http://localhost:8084/getAvaliacao/" + AvaliacaoTools.encrypt(f)
              );
            javaMailSender.send(mail);
        });
    }   
    
}

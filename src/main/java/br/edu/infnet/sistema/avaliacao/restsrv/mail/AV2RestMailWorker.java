/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.infnet.sistema.avaliacao.restsrv.mail;

import br.edu.infnet.sistema.avaliacao.service.AlunoService;
import br.edu.infnet.sistema.avaliacao.service.AvaliacaoService;
import java.util.List;
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
public class AV2RestMailWorker {

    @Autowired
    private AV2MailService mailService;

    @Autowired
    private AvaliacaoService avaliacaoService;

    @Scheduled(fixedRate = 60000)
    public void reportCurrentTime() {
       List<Long> avaliacoesIds = avaliacaoService.findByValuationPeriodEnded();
       mailService.sendNotification(avaliacoesIds);
       avaliacaoService.setEnviadaProCoordenadorEqualTrue(avaliacoesIds);
    }

}

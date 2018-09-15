/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.infnet.sistema.avaliacao.service;

import br.edu.infnet.sistema.avaliacao.model.EmailAbertura;
import br.edu.infnet.sistema.avaliacao.model.Pessoa;
import br.edu.infnet.sistema.avaliacao.repository.AlunoRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author leonam
 */
@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public Map<Pessoa,EmailAbertura> findByMissingEvaluation(java.sql.Timestamp currentDateTime) {
        List<Object[]> pessoas = alunoRepository.findByMissingEvaluation(currentDateTime);
        Map<Pessoa,EmailAbertura> alunosMap = new HashMap<>();

        pessoas.stream().forEach(f -> {
            Pessoa pessoa = new Pessoa();
            pessoa.setId(Long.valueOf(f[0].toString()));
            pessoa.setCpf((String) f[1]);
            pessoa.setEmail((String) f[2]);
            pessoa.setGenero((String) f[3]);
            pessoa.setNome((String) f[4]);
            
            EmailAbertura emailAbertura = new EmailAbertura();
            emailAbertura.setLinkAvaliacao((String) f[5]);
            emailAbertura.setTexto((String) f[6]);
            
            alunosMap.put(pessoa, emailAbertura);
            
        });
        return alunosMap;
    }

}

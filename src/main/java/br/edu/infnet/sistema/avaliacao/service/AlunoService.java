/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.infnet.sistema.avaliacao.service;

import br.edu.infnet.sistema.avaliacao.model.Pessoa;
import br.edu.infnet.sistema.avaliacao.repository.AlunoRepository;
import java.util.ArrayList;
import java.util.List;
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

    public List<Pessoa> findByMissingEvaluation(java.sql.Timestamp currentDateTime) {
        List<Pessoa> alunos = new ArrayList<>();
        List<Object[]> pessoas = alunoRepository.findByMissingEvaluation(currentDateTime);

        pessoas.stream().forEach(f -> {
            Pessoa pessoa = new Pessoa();
            pessoa.setId(Long.valueOf(f[0].toString()));
            pessoa.setCpf((String) f[1]);
            pessoa.setEmail((String) f[2]);
            pessoa.setGenero((String) f[3]);
            pessoa.setNome((String) f[4]);
            alunos.add(pessoa);
        });
        return alunos;
    }

}

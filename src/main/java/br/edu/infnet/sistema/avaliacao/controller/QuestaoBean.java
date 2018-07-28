package br.edu.infnet.sistema.avaliacao.controller;

import br.edu.infnet.sistema.avaliacao.model.Questao;
import br.edu.infnet.sistema.avaliacao.service.QuestaoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QuestaoBean {
    
    @Autowired
    private QuestaoService questaoService;
    private Questao questao;
    private List<Questao> questoes;
    
    public String retornaIndex() {
        return "/index.xhtml";
    }
    
    public QuestaoService getQuestaoService() {
        return questaoService;
    }

    public void setQuestaoService(QuestaoService questaoService) {
        this.questaoService = questaoService;
    }

    public Questao getQuestao() {
        return questao;
    }

    public void setQuestao(Questao questao) {
        this.questao = questao;
    }

    public List<Questao> getQuestoes() {
        return questoes;
    }

    public void setQuestoes(List<Questao> questoes) {
        this.questoes = questoes;
    }
}
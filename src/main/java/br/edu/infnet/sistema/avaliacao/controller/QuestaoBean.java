package br.edu.infnet.sistema.avaliacao.controller;

import br.edu.infnet.sistema.avaliacao.AvaliacaoTools;
import br.edu.infnet.sistema.avaliacao.enuns.Categoria;
import br.edu.infnet.sistema.avaliacao.model.Questao;
import br.edu.infnet.sistema.avaliacao.service.QuestaoService;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QuestaoBean implements Serializable {
    
    private static final long serialVersionUID = 1L;

    Questao questao = new Questao();
    List<Questao> todasQuestoes = new ArrayList<>();

    @Autowired
    QuestaoService questaoService;

    public void consultar() {
        this.todasQuestoes = questaoService.findAll();

    }

    public void remover(Long id) {
        FacesContext context = FacesContext.getCurrentInstance();
        questaoService.remove(id);
        this.consultar();
        context.addMessage(null, new FacesMessage(
                "Questão removida com sucesso!"));

    }

    public String editar(Questao questao) {
        this.questao = questao;
        return "/questao/cadastraQuestao.xhtml";

    }

    public void salvar() {

        long id = questao.getId();
        FacesContext context = FacesContext.getCurrentInstance();
        questao.setDataCriacao(LocalDate.now());
        questaoService.save(this.questao);
        this.questao = new Questao();
        context.addMessage(null, new FacesMessage(
                "Questão cadastrada com sucesso!"));

    }

    public Questao getQuestao() {
        return questao;
    }

    public void setQuestao(Questao questao) {
        this.questao = questao;
    }

    public List<Questao> getTodasQuestoes() {
        return todasQuestoes;
    }

    public Categoria[] getCategorias() {
        return Categoria.values();
    }
    
}

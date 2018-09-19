package br.edu.infnet.sistema.avaliacao.controller;

import br.edu.infnet.sistema.avaliacao.model.Avaliacao;
import br.edu.infnet.sistema.avaliacao.model.EmailAbertura;
import br.edu.infnet.sistema.avaliacao.model.Questionario;
import br.edu.infnet.sistema.avaliacao.model.Turma;
import br.edu.infnet.sistema.avaliacao.service.AvaliacaoService;
import br.edu.infnet.sistema.avaliacao.service.EmailAberturaService;
import br.edu.infnet.sistema.avaliacao.service.QuestionarioService;
import br.edu.infnet.sistema.avaliacao.service.TurmaService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AvaliacaoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Avaliacao avaliacao = new Avaliacao();
    private List<Avaliacao> todasAvaliacoes  = new ArrayList<>();
    private List<Turma> todasTurmas = new ArrayList<>();
    private List<Questionario> todosQuestionarios = new ArrayList<>();
    private List<EmailAbertura> todosEmails = new ArrayList<>();

    @Autowired
    AvaliacaoService avaliacaoService;
    @Autowired
    TurmaService turmaService;
    @Autowired
    QuestionarioService questionarioService;
    @Autowired
    EmailAberturaService emailaberturaService;

    public void consultar() {
        this.todasAvaliacoes = avaliacaoService.findAll();

    }

    public void remover(Long id) {
        FacesContext context = FacesContext.getCurrentInstance();
        avaliacaoService.remove(id);
        consultar();
        context.addMessage(null, new FacesMessage(
                "Avaliação removida com sucesso!"));

    }

    public String editar(Avaliacao avaliacao) {
        prepararCadastro();
        this.avaliacao = avaliacao;
        return "cadastraAvaliacao.xhtml";

    }

    public void salvar() {

        FacesContext context = FacesContext.getCurrentInstance();
        avaliacaoService.save(this.avaliacao);
        context.addMessage(null, new FacesMessage(
                "Avaliacao cadastrada com sucesso!"));

    }
    
    public void prepararCadastro() {
        avaliacao = new Avaliacao();
        this.todasTurmas = turmaService.findAll();
        this.todosQuestionarios = questionarioService.findAll();
        this.todosEmails = emailaberturaService.findAll();
    }

    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }

    public List<Avaliacao> getTodasAvaliacoes() {
        return todasAvaliacoes;
    }

    public void setTodasAvaliacoes(List<Avaliacao> todasAvaliacoes) {
        this.todasAvaliacoes = todasAvaliacoes;
    }

    public List<Turma> getTodasTurmas() {
        return todasTurmas;
    }

    public void setTodasTurmas(List<Turma> todasTurmas) {
        this.todasTurmas = todasTurmas;
    }

    public List<Questionario> getTodosQuestionarios() {
        return todosQuestionarios;
    }

    public void setTodosQuestionarios(List<Questionario> todosQuestionarios) {
        this.todosQuestionarios = todosQuestionarios;
    }

    public List<EmailAbertura> getTodosEmails() {
        return todosEmails;
    }

    public void setTodosEmails(List<EmailAbertura> todosEmails) {
        this.todosEmails = todosEmails;
    }

    public AvaliacaoService getAvaliacaoService() {
        return avaliacaoService;
    }

    public void setAvaliacaoService(AvaliacaoService avaliacaoService) {
        this.avaliacaoService = avaliacaoService;
    }

    public TurmaService getTurmaService() {
        return turmaService;
    }

    public void setTurmaService(TurmaService turmaService) {
        this.turmaService = turmaService;
    }

    public QuestionarioService getQuestionarioService() {
        return questionarioService;
    }

    public void setQuestionarioService(QuestionarioService questionarioService) {
        this.questionarioService = questionarioService;
    }

    public EmailAberturaService getEmailaberturaService() {
        return emailaberturaService;
    }

    public void setEmailaberturaService(EmailAberturaService emailaberturaService) {
        this.emailaberturaService = emailaberturaService;
    }
}
package br.edu.infnet.sistema.avaliacao.controller;

import br.edu.infnet.sistema.avaliacao.model.Questao;
import br.edu.infnet.sistema.avaliacao.model.Questionario;
import br.edu.infnet.sistema.avaliacao.service.QuestionarioService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QuestionarioBean implements Serializable {

    private static final long serialVersionUID = 1L;
    
    Questionario questionario = new Questionario();
    List<Questionario> todosQuestionarios = new ArrayList<>();
    List<Questao> todasQuestoesQuestionario = new ArrayList<>();

    @Autowired
    QuestionarioService questionarioService;

    public void consultar() {
        this.todosQuestionarios = questionarioService.findAll();
    }

    public void remover(Long id) {
        FacesContext context = FacesContext.getCurrentInstance();
        questionarioService.remove(id);
        consultar();
        context.addMessage(null, new FacesMessage(
                "Questionario removido com sucesso!"));

    }

    public String editar(Questionario questionario) {
        prepararCadastro();
        this.questionario = questionario;
        return "/questionario/cadastraQuestionario.xhtml";

    }

    public void salvar() {

        long id = questionario.getId();
        FacesContext context = FacesContext.getCurrentInstance();
        
        if ((questionario.getIdentificador() == null) || (questionario.getIdentificador().equals(""))){
            context.addMessage(null, new FacesMessage(
                "Campo Identificador do Questionário é de preenchimento obrigatorio."));
        } else {
            questionarioService.save(this.questionario);
            this.questionario = new Questionario();
            context.addMessage(null, new FacesMessage(
                 "Questionáio cadastrado com sucesso!"));
        }        
    }

    public void prepararCadastro() {
        questionario = new Questionario();
        this.todosQuestionarios = questionarioService.findAll();
    }
    
    public String consultarQuestoesQuestionario (Questionario questionario) {
        this.todasQuestoesQuestionario = this.questionario.getQuestoes();
        return "consultarQuestoesQuestionario.xhtml";
    
    }
    
    public Questionario getQuestionario() {
        return questionario;
    }

    public void setCliente(Questionario questionario) {
        this.questionario = questionario;
    }

    public List<Questionario> getTodosQuestionarios() {
        return todosQuestionarios;
    }

    public List<Questao> getTodasQuestoesQuestionario() {
        return todasQuestoesQuestionario;
    }

    public String voltar() {
        this.consultar();
        return "/questionario/consultaQuestionarios.xhtml";
    }
    
}

package br.edu.infnet.sistema.avaliacao.controller;

import br.edu.infnet.sistema.avaliacao.model.EmailAbertura;
import br.edu.infnet.sistema.avaliacao.model.Questao;
import br.edu.infnet.sistema.avaliacao.service.EmailAberturaService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmailAberturaBean implements Serializable {
    
    private static final long serialVersionUID = 1L;

    EmailAbertura emailAbertura = new EmailAbertura();
    List<EmailAbertura> todosEmailsAbertura = new ArrayList<>();

    @Autowired
    EmailAberturaService emailAberturaService;

    public void consultar() {
        this.todosEmailsAbertura = emailAberturaService.findAll();

    }

    public void remover(Long id) {
        FacesContext context = FacesContext.getCurrentInstance();
        emailAberturaService.remove(id);
        consultar();
        context.addMessage(null, new FacesMessage(
                "EmailAbertura removido com sucesso!"));

    }

    public String editar(EmailAbertura emailAbertura) {
        this.emailAbertura = emailAbertura;
        return "CadastraEmailAbertura.xhtml";

    }

    public void salvar() {

        FacesContext context = FacesContext.getCurrentInstance();
        emailAberturaService.save(this.emailAbertura);
        this.emailAbertura = new EmailAbertura();
        context.addMessage(null, new FacesMessage(
                "Questão cadastrada com sucesso!"));

    }

    public EmailAbertura getEmailAbertura() {
        return emailAbertura;
    }

    public void setEmailAbertura(EmailAbertura emailAbertura) {
        this.emailAbertura = emailAbertura;
    }

    public List<EmailAbertura> getTodosEmailsAbertura() {
        return todosEmailsAbertura;
    }
   
}
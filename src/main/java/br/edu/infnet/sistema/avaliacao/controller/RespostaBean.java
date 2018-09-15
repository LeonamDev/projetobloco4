package br.edu.infnet.sistema.avaliacao.controller;

import br.edu.infnet.sistema.avaliacao.model.Resposta;
import br.edu.infnet.sistema.avaliacao.service.RespostaService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RespostaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    Resposta resposta = new Resposta();
    List<Resposta> todasRespostas = new ArrayList<>();

    @Autowired
    RespostaService respostaService;

    public void consultar() {
        this.todasRespostas = respostaService.findAll();

    }

    public void remover(Long id) {
        FacesContext context = FacesContext.getCurrentInstance();
        respostaService.remove(id);
        consultar();
        context.addMessage(null, new FacesMessage(
                "Cliente removido com sucesso!"));

    }

    public String editar(Resposta resposta) {
        this.resposta = resposta;
        return "CadastraResposta.xhtml";

    }

    public void salvar() {

        FacesContext context = FacesContext.getCurrentInstance();
        respostaService.save(this.resposta);
        this.resposta = new Resposta();
        context.addMessage(null, new FacesMessage(
                "Resposta cadastrado com sucesso!"));

    }

    public Resposta getResposta() {
        return resposta;
    }

    public void setAvaliacao(Resposta resposta) {
        this.resposta = resposta;
    }

    public List<Resposta> getTodasRespostas() {
        return todasRespostas;
    }

}

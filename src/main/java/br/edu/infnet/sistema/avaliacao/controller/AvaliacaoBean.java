package br.edu.infnet.sistema.avaliacao.controller;

import br.edu.infnet.sistema.avaliacao.model.Avaliacao;
import br.edu.infnet.sistema.avaliacao.service.AvaliacaoService;
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

    Avaliacao avaliacao = new Avaliacao();
    List<Avaliacao> todasAvaliacoes  = new ArrayList<>();

    @Autowired
    AvaliacaoService avaliacaoService;

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
        this.avaliacao = avaliacao;
        return "CadastraAvaliacao.xhtml";

    }

    public void salvar() {

        FacesContext context = FacesContext.getCurrentInstance();
        avaliacaoService.save(this.avaliacao);
        context.addMessage(null, new FacesMessage(
                "Avaliacao cadastrada com sucesso!"));

    }

    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    public void setCliente(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }

    public List<Avaliacao> getTodasAvaliacoes() {
        return todasAvaliacoes;
    }

    
}

package br.edu.infnet.sistema.avaliacao.controller;

import br.edu.infnet.sistema.avaliacao.model.Avaliacao;
import br.edu.infnet.sistema.avaliacao.model.Resposta;
import br.edu.infnet.sistema.avaliacao.service.AvaliacaoService;
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

    Avaliacao avaliacao = new Avaliacao();
    Resposta resposta = new Resposta();
    List<Resposta> todasRespostas = new ArrayList<>();

    @Autowired
    RespostaService respostaService;
    @Autowired
    AvaliacaoService avaliacaoService;

    public void salvar() {
        FacesContext context = FacesContext.getCurrentInstance();
        respostaService.save(this.resposta);
        this.resposta = new Resposta();
        context.addMessage(null, new FacesMessage(
                "Resposta cadastrado com sucesso!"));
    }
    
    public void prepararCadastro(Long idAvaliacao) {
        avaliacao = avaliacaoService.findById(idAvaliacao).get();
    }

    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }

    public Resposta getResposta() {
        return resposta;
    }

    public void setResposta(Resposta resposta) {
        this.resposta = resposta;
    }

    public List<Resposta> getTodasRespostas() {
        return todasRespostas;
    }

    public void setTodasRespostas(List<Resposta> todasRespostas) {
        this.todasRespostas = todasRespostas;
    }

    public RespostaService getRespostaService() {
        return respostaService;
    }

    public void setRespostaService(RespostaService respostaService) {
        this.respostaService = respostaService;
    }
}
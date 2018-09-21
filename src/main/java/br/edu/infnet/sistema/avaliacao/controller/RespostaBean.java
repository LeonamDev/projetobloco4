package br.edu.infnet.sistema.avaliacao.controller;

import br.edu.infnet.sistema.avaliacao.AvaliacaoTools;
import br.edu.infnet.sistema.avaliacao.enuns.Categoria;
import br.edu.infnet.sistema.avaliacao.model.Aluno;
import br.edu.infnet.sistema.avaliacao.model.Avaliacao;
import br.edu.infnet.sistema.avaliacao.model.Questao;
import br.edu.infnet.sistema.avaliacao.model.Resposta;
import br.edu.infnet.sistema.avaliacao.service.AlunoService;
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
    Aluno aluno = new Aluno();
    List<Resposta> todasRespostas = new ArrayList<>();
    List<Questao> questoesGeral = new ArrayList<>();
    List<Questao> questoesProfessor = new ArrayList<>();
    List<Questao> questoesConteudo = new ArrayList<>();

    @Autowired
    RespostaService respostaService;
    @Autowired
    AvaliacaoService avaliacaoService;
    @Autowired
    AlunoService alunoService;

    public void salvar() {
        FacesContext context = FacesContext.getCurrentInstance();
        respostaService.save(this.resposta);
        this.resposta = new Resposta();
        context.addMessage(null, new FacesMessage(
                "Resposta cadastrado com sucesso!"));
    }
    
    public void prepararCadastro(String idAluno, String idAvaliacao) {        
        aluno = alunoService.findById(AvaliacaoTools.decrypt(idAluno)).get();
        avaliacao = avaliacaoService.findById(AvaliacaoTools.decrypt(idAvaliacao)).get();
        
        questoesGeral = selecionaQuestoes(Categoria.AVALIACAO_GERAL_POS_GRADUACAO);
        questoesProfessor = selecionaQuestoes(Categoria.AVALIACAO_PROFESSOR_MODULO);
        questoesConteudo = selecionaQuestoes(Categoria.AVALIACAO_CONTEUDO_INFRA_ESTRUTUTA_MODULO);
    }
    
    private List<Questao> selecionaQuestoes(Categoria cat) {
        List<Questao> questoes = new ArrayList<>();
        
        for(Questao q : avaliacao.getQuestionario().getQuestoes()) {
            if(q.getCategoria() == cat) {
                questoes.add(q);
            }
        }
        
        return questoes;
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

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public List<Resposta> getTodasRespostas() {
        return todasRespostas;
    }

    public void setTodasRespostas(List<Resposta> todasRespostas) {
        this.todasRespostas = todasRespostas;
    }

    public List<Questao> getQuestoesGeral() {
        return questoesGeral;
    }

    public void setQuestoesGeral(List<Questao> questoesGeral) {
        this.questoesGeral = questoesGeral;
    }

    public List<Questao> getQuestoesProfessor() {
        return questoesProfessor;
    }

    public void setQuestoesProfessor(List<Questao> questoesProfessor) {
        this.questoesProfessor = questoesProfessor;
    }

    public List<Questao> getQuestoesConteudo() {
        return questoesConteudo;
    }

    public void setQuestoesConteudo(List<Questao> questoesConteudo) {
        this.questoesConteudo = questoesConteudo;
    }

    public RespostaService getRespostaService() {
        return respostaService;
    }

    public void setRespostaService(RespostaService respostaService) {
        this.respostaService = respostaService;
    }

    public AvaliacaoService getAvaliacaoService() {
        return avaliacaoService;
    }

    public void setAvaliacaoService(AvaliacaoService avaliacaoService) {
        this.avaliacaoService = avaliacaoService;
    }

    public AlunoService getAlunoService() {
        return alunoService;
    }

    public void setAlunoService(AlunoService alunoService) {
        this.alunoService = alunoService;
    }
}
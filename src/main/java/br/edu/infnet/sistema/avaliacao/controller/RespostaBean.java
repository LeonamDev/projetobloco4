package br.edu.infnet.sistema.avaliacao.controller;

import br.edu.infnet.sistema.avaliacao.AvaliacaoTools;
import br.edu.infnet.sistema.avaliacao.enuns.Categoria;
import br.edu.infnet.sistema.avaliacao.enuns.GrauConformidadeLikert;
import br.edu.infnet.sistema.avaliacao.model.Aluno;
import br.edu.infnet.sistema.avaliacao.model.Avaliacao;
import br.edu.infnet.sistema.avaliacao.model.Questao;
import br.edu.infnet.sistema.avaliacao.model.Resposta;
import br.edu.infnet.sistema.avaliacao.service.AlunoService;
import br.edu.infnet.sistema.avaliacao.service.AvaliacaoService;
import br.edu.infnet.sistema.avaliacao.service.RespostaService;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RespostaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    Avaliacao avaliacao = new Avaliacao();
    Resposta resposta = new Resposta();
    Aluno aluno = new Aluno();
    List<Resposta> todasRespostas = new ArrayList<>();
    List<Resposta> questoesRepostaGeral = new ArrayList<>();
    List<Resposta> questoesRepostaProfessor = new ArrayList<>();
    List<Resposta> questoesRepostaConteudo = new ArrayList<>();
    boolean avaliacaoSemReposta = true;
    String respostasForm = "";

    @Autowired
    RespostaService respostaService;
    @Autowired
    AvaliacaoService avaliacaoService;
    @Autowired
    AlunoService alunoService;

    public void salvar() {
        FacesContext context = FacesContext.getCurrentInstance();
        
        for(Resposta resposta : todasRespostas) {
            respostaService.save(resposta);
        }
        
        avaliacaoSemReposta = false;
        
        context.addMessage(null, new FacesMessage(
                "Resposta cadastrada com sucesso!"));
    }
    
    public void prepararCadastro(String idAluno, String idAvaliacao) {   
        Long alunoID = AvaliacaoTools.decrypt(idAluno);
        Long avaliacaoID = AvaliacaoTools.decrypt(idAvaliacao); 
        
        if (alunoService.StudentAlreadyAnswered(alunoID,avaliacaoID) || avaliacaoService.hasExpired(avaliacaoID)){
            try { 
                FacesContext.getCurrentInstance()
                        .getExternalContext().redirect("notfound.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(RespostaBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{   
            aluno = alunoService.findById(alunoID).get();
            avaliacao = avaliacaoService.findById(avaliacaoID).get();
            questoesRepostaGeral = selecionaQuestoesReposta(Categoria.AVALIACAO_GERAL_POS_GRADUACAO);
            questoesRepostaProfessor = selecionaQuestoesReposta(Categoria.AVALIACAO_PROFESSOR_MODULO);
            questoesRepostaConteudo = selecionaQuestoesReposta(Categoria.AVALIACAO_CONTEUDO_INFRA_ESTRUTUTA_MODULO);
        }
    }
    
    private List<Resposta> selecionaQuestoesReposta(Categoria cat) {
        List<Resposta> questoesResposta = new ArrayList<>();
        Resposta resp;
        
        for(Questao q : avaliacao.getQuestionario().getQuestoes()) {
            if(q.getCategoria() == cat) {
                resp = new Resposta();
                resp.setQuestao(q);
                resp.setAluno(aluno);
                resp.setAvaliacao(avaliacao);
                questoesResposta.add(resp);
                todasRespostas.add(resp);
            }
        }
        
        if(questoesResposta.isEmpty()) {
            return null;
        }
        else {
            return questoesResposta;
        }
    }
    
    public void insereRepostaListener(AjaxBehaviorEvent event) {
        System.out.println(respostasForm);
        
        if(!respostasForm.equals("")) {
            String[] result = respostasForm.split(";");
            Long idQuestao = new Long(result[0]);
            Integer valueReposta = new Integer(result[1]);
            
            for(Resposta resposta : todasRespostas) {
                if(resposta.getQuestao().getId() == idQuestao) {
                    resposta.setGrauConformidade(GrauConformidadeLikert.valueOf(valueReposta).get());
                }
            }
        }
        
        respostasForm = "";
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

    public List<Resposta> getQuestoesRepostaGeral() {
        return questoesRepostaGeral;
    }

    public void setQuestoesRepostaGeral(List<Resposta> questoesRepostaGeral) {
        this.questoesRepostaGeral = questoesRepostaGeral;
    }

    public List<Resposta> getQuestoesRepostaProfessor() {
        return questoesRepostaProfessor;
    }

    public void setQuestoesRepostaProfessor(List<Resposta> questoesRepostaProfessor) {
        this.questoesRepostaProfessor = questoesRepostaProfessor;
    }

    public List<Resposta> getQuestoesRepostaConteudo() {
        return questoesRepostaConteudo;
    }

    public void setQuestoesRepostaConteudo(List<Resposta> questoesRepostaConteudo) {
        this.questoesRepostaConteudo = questoesRepostaConteudo;
    }

    public boolean isAvaliacaoSemReposta() {
        return avaliacaoSemReposta;
    }

    public void setAvaliacaoSemReposta(boolean avaliacaoSemReposta) {
        this.avaliacaoSemReposta = avaliacaoSemReposta;
    }
    
    public String getRespostasForm() {
        return respostasForm;
    }

    public void setRespostasForm(String respostasForm) {
        this.respostasForm = respostasForm;
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
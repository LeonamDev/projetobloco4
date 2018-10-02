package br.edu.infnet.sistema.avaliacao.restsrv;

import br.edu.infnet.sistema.avaliacao.enuns.Categoria;
import br.edu.infnet.sistema.avaliacao.enuns.GrauConformidadeLikert;

/**
 * @author luis
 */
public class RespostaAvaliacao {
    
    private Categoria categoriaQuestao;
    private String descricaoQuestao;
    private GrauConformidadeLikert grauConformidadeResposta;

    public RespostaAvaliacao() {
    }

    public RespostaAvaliacao(Categoria categoriaQuestao, String descricaoQuestao, GrauConformidadeLikert grauConformidadeResposta) {
        this.categoriaQuestao = categoriaQuestao;
        this.descricaoQuestao = descricaoQuestao;
        this.grauConformidadeResposta = grauConformidadeResposta;
    }

    public Categoria getCategoriaQuestao() {
        return categoriaQuestao;
    }

    public void setCategoriaQuestao(Categoria categoriaQuestao) {
        this.categoriaQuestao = categoriaQuestao;
    }

    public String getDescricaoQuestao() {
        return descricaoQuestao;
    }

    public void setDescricaoQuestao(String descricaoQuestao) {
        this.descricaoQuestao = descricaoQuestao;
    }

    public GrauConformidadeLikert getGrauConformidadeResposta() {
        return grauConformidadeResposta;
    }

    public void setGrauConformidadeResposta(GrauConformidadeLikert grauConformidadeResposta) {
        this.grauConformidadeResposta = grauConformidadeResposta;
    }
}
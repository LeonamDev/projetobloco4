package br.edu.infnet.sistema.avaliacao.restsrv;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author luis
 */
public class RestSrvResponse {
    
    private String codigoAvaliacao;
    private String objetivoAvaliacao;
    private LocalDateTime inicioAvaliacao;
    private LocalDateTime terminoAvaliacao;
    private String observacoes;
    private String codigoModulo;
    private String nomeModulo;
    private String codigoBloco;
    private String nomeBloco;
    private String codigoCurso;
    private String nomeCurso;
    private List<RespostaAvaliacao> respostas;

    public RestSrvResponse() {
    }

    public RestSrvResponse(String codigoAvaliacao, String objetivoAvaliacao, LocalDateTime inicioAvaliacao, LocalDateTime terminoAvaliacao, 
            String observacoes, String codigoModulo, String nomeModulo, String codigoBloco, String nomeBloco, String codigoCurso, String nomeCurso, 
            List<RespostaAvaliacao> respostas) {
        this.codigoAvaliacao = codigoAvaliacao;
        this.objetivoAvaliacao = objetivoAvaliacao;
        this.inicioAvaliacao = inicioAvaliacao;
        this.terminoAvaliacao = terminoAvaliacao;
        this.observacoes = observacoes;
        this.codigoModulo = codigoModulo;
        this.nomeModulo = nomeModulo;
        this.codigoBloco = codigoBloco;
        this.nomeBloco = nomeBloco;
        this.codigoCurso = codigoCurso;
        this.nomeCurso = nomeCurso;
        this.respostas = respostas;
    }

    public String getCodigoAvaliacao() {
        return codigoAvaliacao;
    }

    public void setCodigoAvaliacao(String codigoAvaliacao) {
        this.codigoAvaliacao = codigoAvaliacao;
    }

    public String getObjetivoAvaliacao() {
        return objetivoAvaliacao;
    }

    public void setObjetivoAvaliacao(String objetivoAvaliacao) {
        this.objetivoAvaliacao = objetivoAvaliacao;
    }

    public LocalDateTime getInicioAvaliacao() {
        return inicioAvaliacao;
    }

    public void setInicioAvaliacao(LocalDateTime inicioAvaliacao) {
        this.inicioAvaliacao = inicioAvaliacao;
    }

    public LocalDateTime getTerminoAvaliacao() {
        return terminoAvaliacao;
    }

    public void setTerminoAvaliacao(LocalDateTime terminoAvaliacao) {
        this.terminoAvaliacao = terminoAvaliacao;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getCodigoModulo() {
        return codigoModulo;
    }

    public void setCodigoModulo(String codigoModulo) {
        this.codigoModulo = codigoModulo;
    }

    public String getNomeModulo() {
        return nomeModulo;
    }

    public void setNomeModulo(String nomeModulo) {
        this.nomeModulo = nomeModulo;
    }

    public String getCodigoBloco() {
        return codigoBloco;
    }

    public void setCodigoBloco(String codigoBloco) {
        this.codigoBloco = codigoBloco;
    }

    public String getNomeBloco() {
        return nomeBloco;
    }

    public void setNomeBloco(String nomeBloco) {
        this.nomeBloco = nomeBloco;
    }

    public String getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(String codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public List<RespostaAvaliacao> getRespostas() {
        return respostas;
    }

    public void setRespostas(List<RespostaAvaliacao> respostas) {
        this.respostas = respostas;
    }
}
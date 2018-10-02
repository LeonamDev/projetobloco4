package br.edu.infnet.sistema.avaliacao.model;

import br.edu.infnet.sistema.avaliacao.enuns.Categoria;
import java.time.LocalDate;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "questao")
public class Questao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(name="descricao", nullable=false)
    private String descricaoQuestao;
    
    @Column(name="categoria")
    @Enumerated(EnumType.STRING)

    private Categoria categoria;
    @Column(name="data_criacao")
    private LocalDate dataCriacao;

    public Questao() {

    }

    public Questao(long id, String descricaoQuestao, Categoria categoria, LocalDate dataCriacao) {
        this.id = id;
        this.descricaoQuestao = descricaoQuestao;
        this.categoria = categoria;
        this.dataCriacao = dataCriacao;
    }   
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescricaoQuestao() {
        return descricaoQuestao;
    }

    public void setDescricaoQuestao(String descricaoQuestao) {
        this.descricaoQuestao = descricaoQuestao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
}
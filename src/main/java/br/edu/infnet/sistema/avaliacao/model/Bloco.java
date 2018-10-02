package br.edu.infnet.sistema.avaliacao.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bloco")
public class Bloco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(name="codigo", nullable=false)
    private String codigoBloco;
    
    @Column(name="nome", nullable=false)
    private String nomeBloco;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    public Bloco() {

    }

    public Bloco(long id, String codigoBloco, String nomeBloco) {
        super();
        this.id = id;
        this.codigoBloco = codigoBloco;
        this.nomeBloco = nomeBloco;        
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
    
    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
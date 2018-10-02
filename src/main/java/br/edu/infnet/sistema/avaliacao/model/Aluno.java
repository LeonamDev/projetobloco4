package br.edu.infnet.sistema.avaliacao.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "aluno")
public class Aluno extends Pessoa {
    
    @Column(length=8)
    private String matricula;
    
    @ManyToOne
    @JoinColumn(name = "turma_id")
    private Turma turma;

    public Aluno() {
    }

    public Aluno(String matricula, Turma turma, List<Resposta> respostas, long id, String nome, String cpf, String email) {
        super(id, nome, cpf, email);
        this.matricula = matricula;
        this.turma = turma;
    }
    
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }
}
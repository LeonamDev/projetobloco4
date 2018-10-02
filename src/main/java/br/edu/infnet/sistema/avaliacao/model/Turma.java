package br.edu.infnet.sistema.avaliacao.model;

import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "turma")
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;    

    @Column(name="periodo_inicio", nullable=false)
    private LocalDate periodoInicio;
    
    @Column(name="periodo_fim", nullable=false)
    private LocalDate periodoFim;
    
    @ManyToOne
    @JoinColumn(name = "modulo_id")
    private Modulo modulo;
    
    @ManyToOne
    @JoinColumn (name="professor_titular_id")
    private Professor professor;
    
    public Turma() {

    }

    public Turma(long id, LocalDate periodoInicio, LocalDate periodoFim, Modulo modulo, Professor professor) {
        this.id = id;
        this.periodoInicio = periodoInicio;
        this.periodoFim = periodoFim;
        this.modulo = modulo;
        this.professor = professor;
    }      
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getPeriodoInicio() {
        return periodoInicio;
    }

    public void setPeriodoInicio(LocalDate periodoInicio) {
        this.periodoInicio = periodoInicio;
    }

    public LocalDate getPeriodoFim() {
        return periodoFim;
    }

    public void setPeriodoFim(LocalDate periodoFim) {
        this.periodoFim = periodoFim;
    }
    
    public Modulo getModulo() {
        return modulo;
    }

    public void setModulo(Modulo modulo) {
        this.modulo = modulo;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Turma other = (Turma) obj;
        return Objects.equals(this.id, other.id);
    }
}
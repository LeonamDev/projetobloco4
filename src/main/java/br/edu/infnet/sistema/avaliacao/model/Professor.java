package br.edu.infnet.sistema.avaliacao.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "professor")
public class Professor extends Pessoa {
    
    private String codigoCadastro;

    public Professor() {
    }

    public Professor(String codigoCadastro, long id, String nome, String cpf, String email) {
        super(id, nome, cpf, email);
        this.codigoCadastro = codigoCadastro;
    }
    
    public String getCodigoCadastro() {
        return codigoCadastro;
    }

    public void setCodigoCadastro(String codigoCadastro) {
        this.codigoCadastro = codigoCadastro;
    }
}
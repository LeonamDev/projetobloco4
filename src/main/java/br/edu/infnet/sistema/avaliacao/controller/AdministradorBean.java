package br.edu.infnet.sistema.avaliacao.controller;

import br.edu.infnet.sistema.avaliacao.model.Administrador;
import br.edu.infnet.sistema.avaliacao.service.AdministradorService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdministradorBean implements Serializable {

    private static final long serialVersionUID = 1L;

    Administrador administrador = new Administrador();
    List<Administrador> todosAdministradores = new ArrayList<>();

    @Autowired
    AdministradorService administradorService;

    public void consultar() {
        this.todosAdministradores = administradorService.findAll();

    }

    public void remover(Long id) {
        FacesContext context = FacesContext.getCurrentInstance();
        administradorService.remove(id);
        consultar();
        context.addMessage(null, new FacesMessage(
                "Administrador removido com sucesso!"));

    }

    public String editar(Administrador administrador) {
        this.administrador = administrador;
        return "CadastraAdministrador.xhtml";

    }

    public void salvar() {

        FacesContext context = FacesContext.getCurrentInstance();
        administradorService.save(this.administrador);
        this.administrador = new Administrador();
        context.addMessage(null, new FacesMessage(
                "Administrador cadastrado com sucesso!"));

    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public List<Administrador> getTodosAdministradores() {
        return todosAdministradores;
    }
    
}

package br.edu.infnet.sistema.avaliacao.controller;

import br.edu.infnet.sistema.avaliacao.enuns.Categoria;
import org.springframework.stereotype.Component;

/**
 * @author luis
 */
@Component
public class EnumController {

    public Categoria[] getRoleStatuses() {
        return Categoria.values();
    }
}

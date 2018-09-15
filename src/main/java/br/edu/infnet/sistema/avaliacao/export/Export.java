/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.infnet.sistema.avaliacao.export;

import br.edu.infnet.sistema.avaliacao.service.QuestaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Everton Freitas
 */
@Controller
public class Export {

@Autowired
QuestaoService questaoService;

/**
 * Handle request to download an Excel document
 */
@RequestMapping(value = "/download", method = RequestMethod.GET)
public String download(Model model) {
    model.addAttribute("questoes", questaoService.findAll());
    return "";
}
}

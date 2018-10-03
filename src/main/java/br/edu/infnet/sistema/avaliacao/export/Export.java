/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.infnet.sistema.avaliacao.export;

import br.edu.infnet.sistema.avaliacao.model.Resposta;
import br.edu.infnet.sistema.avaliacao.service.RespostaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Everton Freitas
 */
//@RequestMapping(value = "/avaliacao/download", method = RequestMethod.GET)
@Controller
public class Export {

    @Autowired
    RespostaService respostaService;

    /**
     * Handle request to download an Excel document
     */
    @RequestMapping(value = "/avaliacao/download", method = RequestMethod.GET)
    public String download(Model model) {
        model.addAttribute("respostas", respostaService.findAll());
        return "";
    }

    @RequestMapping(value = "/avaliacao/download2", method = RequestMethod.GET)
    public String download(@RequestParam(value = "id", required = false) Long id, Model model) {
        
        List<Resposta> respostas = respostaService.findByIdAvaliacao(id);
        
        if(!respostas.isEmpty()) {
            model.addAttribute("respostas", respostas);
        }
        return "";
    }
}
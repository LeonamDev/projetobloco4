package br.edu.infnet.sistema.avaliacao.restsrv;

import br.edu.infnet.sistema.avaliacao.AvaliacaoTools;
import br.edu.infnet.sistema.avaliacao.model.Resposta;
import br.edu.infnet.sistema.avaliacao.service.AvaliacaoService;
import br.edu.infnet.sistema.avaliacao.service.RespostaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author luis
 */
@RestController
public class RestSrvController {
    
    @Autowired
    AvaliacaoService avaliacaoService;
    
    @Autowired
    RespostaService respostaService;

    @RequestMapping(value = "/getAvaliacao/{av}", method = RequestMethod.GET)
    public List<Resposta> getAvaliacao(@PathVariable String av) {
        return respostaService.findByIdAvaliacao(AvaliacaoTools.decrypt(av));
    }
}

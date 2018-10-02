package br.edu.infnet.sistema.avaliacao.restsrv;

import br.edu.infnet.sistema.avaliacao.AvaliacaoTools;
import br.edu.infnet.sistema.avaliacao.model.Avaliacao;
import br.edu.infnet.sistema.avaliacao.model.Resposta;
import br.edu.infnet.sistema.avaliacao.service.AvaliacaoService;
import br.edu.infnet.sistema.avaliacao.service.RespostaService;
import java.util.ArrayList;
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
    public RestSrvResponse getAvaliacao(@PathVariable String av) {
        return montaResposta(av);
    }
    
    private RestSrvResponse montaResposta(String idAvaliacao) {
        RestSrvResponse response = null;

        Long id = AvaliacaoTools.decrypt(idAvaliacao);
        Avaliacao avaliacao = avaliacaoService.findById(id).get();
        List<Resposta> respostas = respostaService.findByIdAvaliacao(id);

        if (avaliacao != null) {
            if (respostas != null) {
                List<RespostaAvaliacao> respostasAvaliacao = new ArrayList<>();

                for (Resposta resp : respostas) {
                    respostasAvaliacao.add(new RespostaAvaliacao(resp.getQuestao().getCategoria(),
                            resp.getQuestao().getDescricaoQuestao(), resp.getGrauConformidade()));
                }
                
                response = new RestSrvResponse(avaliacao.getCodigoAvaliacao(), avaliacao.getObjetivoAvaliacao(), avaliacao.getInicioAvaliacao(), 
                        avaliacao.getTerminoAvaliacao(), avaliacao.getObservacoes(), avaliacao.getTurma().getModulo().getCodigoModulo(), 
                        avaliacao.getTurma().getModulo().getNomeModulo(), avaliacao.getTurma().getModulo().getBloco().getCodigoBloco(), 
                        avaliacao.getTurma().getModulo().getBloco().getNomeBloco(), avaliacao.getTurma().getModulo().getBloco().getCurso().getCodigoCurso(), 
                        avaliacao.getTurma().getModulo().getBloco().getCurso().getNomeCurso(), respostasAvaliacao);
            }
        }
        return response;
    }
}

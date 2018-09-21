package br.edu.infnet.sistema.avaliacao.converter;

import br.edu.infnet.sistema.avaliacao.enuns.GrauConformidadeLikert;
import br.edu.infnet.sistema.avaliacao.model.Resposta;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import org.springframework.stereotype.Component;

/**
 * @author luis
 */
@Component
public class RespostaConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        Resposta retorno = null;

        if (value != null && !"".equals(value)) {
            
            retorno = new Resposta();
            retorno.setGrauConformidade(GrauConformidadeLikert.valueOf(Integer.valueOf(value)).get());
        }
        return retorno;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object value) {
        if (value != null) {
            return Long.toString(((Resposta) value).getId());
        }
        return null;
    }
}
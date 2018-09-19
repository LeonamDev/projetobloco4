package br.edu.infnet.sistema.avaliacao.converter;

import br.edu.infnet.sistema.avaliacao.model.Questionario;
import br.edu.infnet.sistema.avaliacao.service.QuestionarioService;
import java.util.Optional;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author luis
 */
@Component
public class QuestionarioConverter implements Converter {
    @Autowired
    QuestionarioService questionarioService;
    
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
         Optional<Questionario> retorno = null;

        if (value != null && !"".equals(value)) {

            retorno = questionarioService.findById(new Long(value));

        }
        return retorno.orElse(null);
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object value) {
        if (value != null) {
            return Long.toString(((Questionario) value).getId());
        }
        return null;
    }
}

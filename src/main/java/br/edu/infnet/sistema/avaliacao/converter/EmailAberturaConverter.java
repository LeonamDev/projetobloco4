package br.edu.infnet.sistema.avaliacao.converter;

import br.edu.infnet.sistema.avaliacao.model.EmailAbertura;
import br.edu.infnet.sistema.avaliacao.service.EmailAberturaService;
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
public class EmailAberturaConverter implements Converter {
    
    @Autowired
    EmailAberturaService emailAberturaService;
    
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
         Optional<EmailAbertura> retorno = null;

        if (value != null && !"".equals(value)) {

            retorno = emailAberturaService.findById(new Long(value));

        }
        return retorno.orElse(null);
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object value) {
        if (value != null) {
            return Long.toString(((EmailAbertura) value).getId());
        }
        return null;
    }
}

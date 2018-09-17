package br.edu.infnet.sistema.avaliacao.converter;

import br.edu.infnet.sistema.avaliacao.model.Turma;
import br.edu.infnet.sistema.avaliacao.service.TurmaService;
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
public class TurmaConverter implements Converter {

    @Autowired
    TurmaService turmaService;
    
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
         Optional<Turma> retorno = null;

        if (value != null && !"".equals(value)) {

            retorno = turmaService.findById(new Long(value));

        }
        return retorno.orElse(null);
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object value) {
        if (value != null) {
            return Long.toString(((Turma) value).getId());
        }
        return null;
    }
    
}
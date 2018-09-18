package br.edu.infnet.sistema.avaliacao.converter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import org.springframework.stereotype.Component;

/**
 * @author luis
 */
@Component
public class LocalDateTimeConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(value, formatter);

        return dateTime;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {

        LocalDateTime dateValue = (LocalDateTime) value;
        return dateValue.format(DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm"));
    }
}

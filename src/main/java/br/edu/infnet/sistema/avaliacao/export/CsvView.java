/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.infnet.sistema.avaliacao.export;

import br.edu.infnet.sistema.avaliacao.model.Questao;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;



/**
 *
 * @author Everton Freitas
 */
public class CsvView extends AbstractCsvView  {
@Override
protected void buildCsvDocument(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {

    response.setHeader("Content-Disposition", "attachment; filename=\"my-csv-file.csv\"");

    List<Questao> questoes = (List<Questao>) model.get("questoes");
    //String[] header = {"Firstname","LastName","LastName","JobTitle","Company","Address","City","Country", "PhoneNumber"};
    String[] header = {"descricaoQuestao","id"};
    ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(),
            CsvPreference.STANDARD_PREFERENCE);

    csvWriter.writeHeader(header);

    for(Questao questao : questoes){
        csvWriter.write(questao, header);
    }
    csvWriter.close();


}
}

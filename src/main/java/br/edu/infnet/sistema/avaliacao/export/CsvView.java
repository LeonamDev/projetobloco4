/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.infnet.sistema.avaliacao.export;

import br.edu.infnet.sistema.avaliacao.model.Csv;
import br.edu.infnet.sistema.avaliacao.model.Resposta;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
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
    
    private String idAvaliacao;
    private String matricula, dados1;
    private int x,z;
    
@Override
protected void buildCsvDocument(Map<String, Object> model, HttpServletRequest request, HttpServletResponse
            response) throws Exception {
   
    response.setHeader("Content-Disposition", "attachment; filename=\"my-csv-file.csv\"");

    List<Resposta> respostas = (List<Resposta>) model.get("respostas");
    List<String> header = new ArrayList<String>();
    List<Csv> dados = new ArrayList<Csv>();
    
    x = 0; 
    z = 1;
    int n = respostas.size();
    header.add("CodAvalição, Matrícula, Nome");

    for (int i=0; i<n; i=x) {

        matricula = respostas.get(i).getAluno().getMatricula();
        dados1 = respostas.get(i).getAvaliacao().getCodigoAvaliacao() + ", " +
                matricula + ", " +
                respostas.get(i).getAluno().getNome();
        
        while (x < n && matricula == respostas.get(x).getAluno().getMatricula()) {

            if (z == 1){        
                    header.add(respostas.get(x).getQuestao().getDescricaoQuestao());
            }

            dados1 = dados1 + ", " + respostas.get(x).getGrauConformidade();
            x++;    
        }
        
        z = 2;
        dados.add(new Csv(dados1));
     
    }
    
    String[] nameMapping = new String[]{"csv"};

    ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(),
            CsvPreference.STANDARD_PREFERENCE);

    String Header = header.stream().collect(Collectors.joining(","));
    
    csvWriter.writeHeader(Header);

    for(Csv c : dados){
                csvWriter.write(c, nameMapping );
    }
    
    csvWriter.close();

}
}

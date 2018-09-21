/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.infnet.sistema.avaliacao.export;

import br.edu.infnet.sistema.avaliacao.model.Csv;
import br.edu.infnet.sistema.avaliacao.model.Resposta;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;
import org.supercsv.cellprocessor.ParseInt;
import org.supercsv.cellprocessor.constraint.UniqueHashCode;
import org.supercsv.cellprocessor.ift.CellProcessor;
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
    //List<String> dados = new ArrayList<String>();
    List<Csv> dados = new ArrayList<Csv>();
    //header.add("id");
    //dados.add(String.valueOf(respostas.get(0).getAvaliacao().getId()));
    //dados.add(get);
    
    x = 0; 
    z = 1;
    int n = respostas.size();
    header.add("CodAvalição, Matrícula, Nome");
    
   
    
    for (int i=0; i<n; i=x) {
        //idAvaliacao = respostas.get(i).getAvaliacao().getId();
        matricula = respostas.get(i).getAluno().getMatricula();
        System.out.println(matricula);
        dados1 = respostas.get(i).getAvaliacao().getCodigoAvaliacao() + ", " +
                matricula + ", " +
                respostas.get(i).getAluno().getNome();
        //while (x < n && idAvaliacao == respostas.get(x).getAvaliacao().getId()) {
        
        while (x < n && matricula == respostas.get(x).getAluno().getMatricula()) {
            //System.out.println(dados1);
                    //System.out.printf("Posição %d- %s\n", i, respostas.get(i).getQuestao());
            if (z == 1){        
                    header.add(respostas.get(x).getQuestao().getDescricaoQuestao());
            }
                    //System.out.printf("Posição %d- %s\n", i, respostas.get(i).getGrauConformidade());
                    //dados.add(String.valueOf(respostas.get(i).getAvaliacao()));
            
            //dados.add(respostas.get(x).getGrauConformidade().toString());
            dados1 = dados1 + ", " + respostas.get(x).getGrauConformidade();
            x++;    
        }
        z = 2;
        dados.add(new Csv(dados1));
     
        
    }
    
    
//    String CSV = dados.stream().collect(Collectors.joining(","));
//    List<Csv> csv = new ArrayList<Csv>();
//    csv.add(new Csv(CSV));

    
    
    //List<Csv> list = new ArrayList<Csv>();
    //Csv csv1 = new Csv();
    //csv1.setCsv(String.valueOf(dados));
    //list.add(csv1);
    

            List<Object> bob = Arrays.asList(new Object[] { "2", "Bob", "Down",
                new GregorianCalendar(1919, Calendar.FEBRUARY, 25).getTime()});
    
    //String[] header = {"Firstname","LastName","LastName","JobTitle","Company","Address","City","Country", "PhoneNumber"};
    //System.out.println("resostas " + respostas.get(1).getQuestao());
    System.out.println("header " + header);
    System.out.println("dados " + dados);
    System.out.println("bob " + bob);
    //System.out.println("csv " + csv.get(0).getCsv().toString());

    String[] nameMapping = new String[]{"csv"};
    String[] header_old = {"avaliacao", "questao", "grauConformidade"};
    System.out.println("header_old " + Arrays.toString(header_old));

    
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

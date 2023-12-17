package cs2013;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author edeyson gomes
 * Este programa lê o arquivo Bok_CS2013.txt que contém os dados do Computer Science Curricula 2013.
 * O arquivo é não estruturado e foi transformado manualmente.
 * Este "parser" foi programado especificamente para recuperar seu conteúdo.
 * 
 *  Assume-se que os itens a extrair são assim localizados:
 *  
 *  1. Linha que incia com '{' armazena a Knowledge Area (KA) e sua respectiva sigla entre parêntesis. Por exemplo:
 *  		{Algorithms and Complexity (AL)}
 *  			KA = 'Algorithms and Complexity'
 *  			KACode = AL
 *  2. Todo o conteúdo que estiver entre a linha identificada em 1 e uma ocorrência de KACode + '/' é extraído
 *  		como descrição da Knowledge Area.
 *  		Por exemplo, 'AL/Basic Analysis' delimita a primeira descrição no arquivo.
 *  3. Ao encontrar uma ocorrência KACode + '/', o que sucede o '/' é a Knowledge Unit (KU)
 *  		Assim, tem-se KU = 'Basic Analysis' na primeira ocorrência.
 *  4. O conteúdo a seguir é classificado com base em linhas rotuladas por 'Topics:', 'Learning Outcomes:', '[Core-Tier1]' e
 *  		'[Core-Tier2]', '[Elective]' e servirá para instanciar um Topic ou um LearningOutcome.
 *  
 */
public class BoKCS2013Parser {
	
	private String inputFileName  = "D:\\studies\\pibic-af\\JenaKSA-main\\src\\BoK_CS2013.txt";	
	private ArrayList<KnowledgeArea> knowledgeAreas = new ArrayList<KnowledgeArea>();
	private KnowledgeArea knowledgeArea = new KnowledgeArea(); 
	private KnowledgeUnit knowledgeUnit = new KnowledgeUnit();	
	
	/**
	 * Retorna um ArrayList com todas as Knowledge Areas do BoK CS 2013
	 * @return
	 */
    public ArrayList<KnowledgeArea> getBoKCS2013() {
    	String tipo = "";
        Topic subTopic = null;
        Topic subSubTopic = null;        
        boolean isTopic = false, isLO = false;
        
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName))) {
            String line;
            String KA = "";
            String KACode = "";
            String KU = "";
            String KADescription = "";
            Topic topic = null;
            LearningOutcome lo = null;
            String descrição = "";
            String mastery = "";
            
            while ((line = reader.readLine()) != null) {
            	line = line.trim();
                if (line.startsWith("{")) {
                	isTopic = false;
                	isLO = false;
                    int start = line.indexOf("{") + 1;
                    int end = line.indexOf("(");
                    KA = line.substring(start, end);
                    KACode = line.substring(line.indexOf("(") + 1, line.indexOf(")"));
                    KADescription = "";
                    StringBuilder sb = new StringBuilder();

                    while ((line = reader.readLine().trim()) != null) {
                        if (line.startsWith(KACode + "/")) {
                        	KU = line.substring(line.indexOf("/") + 1);
                            break;
                        } else {
                            sb.append(line).append("\n");
                        }
                    }
                    KADescription = sb.toString().trim();
                    
                    knowledgeArea = new KnowledgeArea(KACode, KA);
                    knowledgeArea.setDescription(KADescription);
                    knowledgeAreas.add(knowledgeArea);
                    
                    knowledgeUnit = new KnowledgeUnit(KU);
                    knowledgeArea.addKnowledgeUnit(knowledgeUnit);
                    
                    //System.out.println("KA: (" + KACode + ") " + KA);
                    //System.out.println("KU: " + KU );
                    
                } 
                else if(line.startsWith(KACode + "/")) {
                  	KU = line.substring(line.indexOf("/") + 1);
                    knowledgeUnit = new KnowledgeUnit(KU);
                    knowledgeArea.addKnowledgeUnit(knowledgeUnit);                  	
                    //System.out.println("KU: " + KU );                  	
                }
                else if (line.toUpperCase().startsWith("TOPICS:")) {
                	isTopic = true;
                	isLO = false;
                	//System.out.println("is Topic");
                	line = "";
                	tipo = "";
                } else if (line.toUpperCase().startsWith("LEARNING OUTCOMES:")) {
                	isTopic = false;
                	isLO = true;
                	//System.out.println("is LO");
                	line = "";
                	tipo = "";
                }
                
                if (isTopic && ! line.isEmpty()) {
                    if (line.toUpperCase().startsWith("[CORE-TIER1]")) 
                   	   tipo = "[Core-Tier1]";
                    else if (line.toUpperCase().startsWith("[CORE-TIER2]")) 
                       	tipo = "[Core-Tier2]";
                    else if (line.toUpperCase().startsWith("[ELECTIVE]")) 
                       	tipo = "[Elective]";                    
                    else if (line.startsWith("--")) { 
                		subSubTopic = new Topic(tipo, line.substring(2).trim());
                		subTopic.addSubtopic(subSubTopic);
                        //System.out.println(">> " + subSubTopic); 
                    }
                	else if (line.startsWith("-")) {
                		subTopic = new Topic(tipo, line.substring(1).trim());
                        topic.addSubtopic(subTopic);
                        //System.out.println("> " + subTopic);                		
               		
                    } else {                  
                    	topic = new Topic(tipo, line);
                    	knowledgeUnit.addTopic(topic);
                    	//System.out.println(topic);
                    }
                }
                
                if (isLO && !line.isEmpty()) {
                    if (line.startsWith("[Core-Tier1]")) 
                    	   tipo = "[Core-Tier1]";
                    else if (line.startsWith("[Core-Tier2]")) 
                        	tipo = "[Core-Tier2]";
                    else {
	                    Pattern pattern = Pattern.compile("\\[(.*?)\\]");
	                    Matcher matcher = pattern.matcher(line);
	
	                    if (matcher.find()) {
	                        mastery = matcher.group(1);
	                    }
	
	                    descrição = line.replaceAll("\\[.*?\\]", "").trim();
	                    lo = new LearningOutcome(tipo, descrição, mastery);
	                    knowledgeUnit.addtLearningOutcome(lo);
	                    //System.out.println(lo);
                     }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return knowledgeAreas;
    }

}

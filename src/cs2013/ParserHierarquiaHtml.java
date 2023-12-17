package cs2013;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Gera o arquivo a ser lido por FileToHTMLList
 * @author edeys
 *
 */
public class ParserHierarquiaHtml {
	public static void main(String[] args) {
		BoKCS2013Parser bok2013 = new BoKCS2013Parser();
		ArrayList<KnowledgeArea> areas = bok2013.getBoKCS2013();
		ArrayList<KnowledgeUnit> units;
		ArrayList<Topic> topics, topicsN1, topicsN2;
		String outputFile = "BOK2013Hierarquia.txt"; 
		
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
    		for (KnowledgeArea knowledgeArea : areas) {
                writer.write("1" + knowledgeArea.getName());
                writer.newLine();
    			units = knowledgeArea.getKnowledgeUnits();
    			for (KnowledgeUnit knowledgeUnit : units) {
    				writer.write("2" + knowledgeUnit.getName());
    				writer.newLine();
    				topics = knowledgeUnit.getTopics();
    				topics.sort(null);
    				for (Topic topic : topics) {
    					writer.write("3" + topic.getDescricao());
    					writer.newLine();
    					topicsN1 = topic.getSubtopic();
    					topicsN1.sort(null);
    					for (Topic topicN1 : topicsN1) {
    						writer.write("4" + topicN1.getDescricao());
    						writer.newLine();
    						topicsN2 = topicN1.getSubtopic();
    						topicsN2.sort(null);
    						for (Topic topicN2 : topicsN2) {
    							writer.write("5" + topicN2.getDescricao());
    							writer.newLine();
    						}
    					}
    					
    				}
    			}
    		}

            writer.close();

        } catch (IOException e) {
            System.err.println("Erro ao processar o arquivo: " + e.getMessage());
        }		

        System.out.println("FIM!!!!");
	}


}

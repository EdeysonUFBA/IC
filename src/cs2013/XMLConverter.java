package cs2013;

import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XMLConverter {
	public static Document convertToXML(List<KnowledgeArea> knowledgeAreas) throws ParserConfigurationException {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

        Document doc = docBuilder.newDocument();
        Element rootElement = doc.createElement("CompetencyAreas");
        doc.appendChild(rootElement);

        for (KnowledgeArea knowledgeArea: knowledgeAreas) {
            Element areaElement = doc.createElement("CompetencyArea");
            areaElement.setAttribute("name", knowledgeArea.getName());
            rootElement.appendChild(areaElement);

            for (KnowledgeUnit unit : knowledgeArea.getKnowledgeUnits()) {
                Element unitElement = doc.createElement("KnowledgeUnit");
                unitElement.setAttribute("name", unit.getName());
                areaElement.appendChild(unitElement);

                for (Topic topic : unit.getTopics()) {
                    Element topicElement = doc.createElement("Topic");
                    topicElement.setAttribute("description", topic.getDescricao());
                    unitElement.appendChild(topicElement);

                 
                    addSubtopics(doc, topicElement, topic.getSubtopic());
                }
            }
        }

        return doc;
    }

    private static void addSubtopics(Document doc, Element parentElement, List<Topic> subtopics) {
        for (Topic subtopic : subtopics) {
            Element subtopicElement = doc.createElement("Subtopic");
            subtopicElement.setAttribute("description", subtopic.getDescricao());
            parentElement.appendChild(subtopicElement);

           
            addSubtopics(doc, subtopicElement, subtopic.getSubtopic());
        }
    }
}



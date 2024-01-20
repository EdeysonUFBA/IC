package cs2013;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.util.List;

public class XMLConverter {

    public static Document convertToXML(List<KnowledgeArea> knowledgeAreas) throws ParserConfigurationException {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

        Document doc = docBuilder.newDocument();
        Element rootElement = doc.createElement("KnowledgeAreas");
        doc.appendChild(rootElement);

        for (KnowledgeArea knowledgeArea : knowledgeAreas) {
            Element areaElement = doc.createElement("KnowledgeArea");
            areaElement.setAttribute("name", knowledgeArea.getName());
            rootElement.appendChild(areaElement);

            for (KnowledgeUnit unit : knowledgeArea.getKnowledgeUnits()) {
                Element unitElement = doc.createElement("KnowledgeUnit");
                unitElement.setAttribute("name", unit.getName());
                unitElement.setAttribute("area", knowledgeArea.getName());  // Adiciona o atributo "area"
                areaElement.appendChild(unitElement);

                addSuperTopicsAndTopics(doc, unitElement, unit.getTopics());
            }
        }

        return doc;
    }

    private static void addSuperTopicsAndTopics(Document doc, Element parentElement, List<Topic> topics) {
        for (Topic topic : topics) {
            if (topic.getSubtopic().isEmpty()) {
                // If there are no subtopics, the current topic is a regular topic
                Element topicElement = doc.createElement("Topic");
                topicElement.setAttribute("description", topic.getDescricao());
                parentElement.appendChild(topicElement);
            } else {
                // If there are subtopics, the current topic is a super topic
                Element superTopicElement = doc.createElement("SuperTopic");
                superTopicElement.setAttribute("description", topic.getDescricao());
                parentElement.appendChild(superTopicElement);
    
                // Add subtopics recursively
                addSubtopics(doc, superTopicElement, topic.getSubtopic());
            }
        }
    }
    
    private static void addSubtopics(Document doc, Element parentElement, List<Topic> subtopics) {
        for (Topic subtopic : subtopics) {
            // Subtopics are always regular topics
            Element topicElement = doc.createElement("Topic");
            topicElement.setAttribute("description", subtopic.getDescricao());
            parentElement.appendChild(topicElement);
    
            // Recursively add subtopics if any
            if (!subtopic.getSubtopic().isEmpty()) {
                addSubtopics(doc, topicElement, subtopic.getSubtopic());
            }
        }
    }
}    
package cso;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

import org.apache.jena.rdf.model.*;
import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.util.FileManager;
import org.apache.jena.vocabulary.*;

/**
 * 
	Parser Jena to read the acm_ccs2012.xml file and create an RDF model.
	It should be noted that the acm_ccs2012.xml file contains information in RDF/XML.
 */

public class CSOParser {
	final String inputFileName  = "CSO.3.3.owl";
	Model model = ModelFactory.createDefaultModel();
	public HashMap<String, Topic> mapaCSO = new HashMap<String, Topic>();

	public CSOParser() {
		model.read(inputFileName, "RDF/XML");
		readStatements();
	}
	
	public HashMap<String, Topic> getMapaCSO() {
		return mapaCSO;
	}

	public void showHash() {
		//System.out.println("\n\n -------------   HASH ------------------ ");
		for (String key : mapaCSO.keySet()) {
			Topic value = mapaCSO.get(key);
			System.out.println("key: " + key );
		}
	}
	
	public ArrayList<Topic> getFirstLevelNodes() {
		ArrayList firstLevelNodes = new ArrayList<Topic>();
		for (String key : mapaCSO.keySet()) {
			Topic topic = mapaCSO.get(key);
			if (topic.getSubTopicOf().size() == 0)
				firstLevelNodes.add(topic);
		}
		return firstLevelNodes;
	}
	
	public void readStatements() {
		Topic topic, subTopic, contributed, equivalent;
		
		StmtIterator it = model.listStatements();
		while(it.hasNext()) {
			Statement tripla      = it.nextStatement();
			Resource  subjectResource   = tripla.getSubject();
			Property  predicateProperty = tripla.getPredicate();
			RDFNode   objectRDFNode    = tripla.getObject();

			//String subject = clearSuffix(subjectResource.toString(), '/');
			String subject = subjectResource.toString();			
			String predicate = predicateProperty.getLocalName().toString();
			String object;

			System.out.println("\nSubject: " + subject);
			System.out.println("Predicado: " + predicate);

			if (objectRDFNode instanceof Resource) {
				object = objectRDFNode.asResource().toString();	
			} else {
				object = objectRDFNode.toString();
			}	

			//object = clearSuffix(object, '/');	
			//object = clearSuffix(object, '#');			
			if (predicate.trim().equals("prefLabel"))
				object = object.substring(0, object.length()-3);

			System.out.println("Object: " + object);	

			if (!mapaCSO.containsKey(subject)) {
				topic = new Topic(subject);
				mapaCSO.put(subject, topic);
			}
			else
				topic = mapaCSO.get(subject);

			switch (predicate) {
			case "superTopicOf":
				if (!mapaCSO.containsKey(object)) {
					subTopic = new Topic(object);
					mapaCSO.put(object, topic);
				}
				else
					subTopic = mapaCSO.get(object);
				
				topic.addSuperTopicOf(subTopic);
				subTopic.addSubTopicOf(topic);
				break;

			case "contributesTo": 
				if (!mapaCSO.containsKey(object)) {
					contributed = new Topic(object);
					mapaCSO.put(object, contributed);
				}
				else
					contributed = mapaCSO.get(object);				
				topic.addContributesTo(contributed);
				break;
				
			case "preferentialEquivalent": 
				if (!mapaCSO.containsKey(object)) {
					equivalent = new Topic(object);
					mapaCSO.put(object, equivalent);
				}
				else
					equivalent = mapaCSO.get(object);				
				topic.addPreferentialEquivalent(equivalent);
				break;
				
			case "relatedEquivalent": 
				if (!mapaCSO.containsKey(object)) {
					equivalent = new Topic(object);
					mapaCSO.put(object, equivalent);
				}
				else
					equivalent = mapaCSO.get(object);				
				topic.addRelatedEquivalent(equivalent);
				break;				

			case "label":
				topic.setLabel(object);
				break;

			case "type":
				topic.setType(object);
				break;

			case "sameAs":
				topic.addSameAs(object);	
				break;

			case "relatedLink":
				topic.addRelatedLink(object);
				break;

			default:
				System.out.println("-------------- no match");					
			}
		}
	}

	public void readProperties() {
		ResIterator iter = model.listSubjectsWithProperty(SKOS.prefLabel);
		while (iter.hasNext()) {
			Resource r = iter.nextResource();
			System.out.println(r.toString());
		}
	}

	private String clearSuffix(String s, char suffixDelimiter) {
		int pos = s.lastIndexOf(suffixDelimiter);

		if (pos > 0) {
			s = s.substring(pos+1);
		}
		return s;
	}
}

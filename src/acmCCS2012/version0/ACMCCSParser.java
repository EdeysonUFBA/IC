package acmCCS2012.version0;

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

public class ACMCCSParser {
	final String inputFileName  = "acm_ccs2012.xml";
	Model model = ModelFactory.createDefaultModel();
	public HashMap<String, ACMCCSConcept> mapaCCS = new HashMap<String, ACMCCSConcept>();

	public ACMCCSParser() {
		model.read(inputFileName, "RDF/XML");
		readStatements();
	}
	
	public HashMap<String, ACMCCSConcept> getMapaCCS() {
		return mapaCCS;
	}

	public void showHash() {
		System.out.println("\n\n -------------   HASH ------------------ ");
		for (String key : mapaCCS.keySet()) {
			ACMCCSConcept value = mapaCCS.get(key);
			System.out.println("key: " + key + " value: " + value);
		}
	}
	
	public ArrayList<ACMCCSConcept> getFirstLevelNodes() {
		ArrayList firstLevelNodes = new ArrayList<ACMCCSConcept>();
		for (String key : mapaCCS.keySet()) {
			ACMCCSConcept value = mapaCCS.get(key);
			if (value.getPerfLabel() != null && value.getBroader() == null)
				firstLevelNodes.add(value);
		}
		return firstLevelNodes;
	}
	
	public void readStatements() {
		ACMCCSConcept item;
		
		StmtIterator it = model.listStatements();
		while(it.hasNext()) {
			Statement tripla      = it.nextStatement();
			Resource  subjectResource   = tripla.getSubject();
			Property  predicateProperty = tripla.getPredicate();
			RDFNode   objectRDFNode    = tripla.getObject();

			String subject = clearSuffix(subjectResource.toString(), '/');
			String predicate = predicateProperty.getLocalName().toString();
			String object;

			//System.out.println("\nSubject: " + subject);
			//System.out.println("Predicado: " + predicate);

			if (objectRDFNode instanceof Resource) {
				object = objectRDFNode.asResource().toString();	
			} else {
				object = objectRDFNode.toString();
			}	

			object = clearSuffix(object, '/');	
			object = clearSuffix(object, '#');			
			if (predicate.trim().equals("prefLabel"))
				object = object.substring(0, object.length()-3);

			//System.out.println("Object: " + object);	

			if (!mapaCCS.containsKey(subject)) {
				item = new ACMCCSConcept(subject);
				mapaCCS.put(subject, item);
			}
			else
				item = mapaCCS.get(subject);

			switch (predicate) {
			case "narrower":
				item.addNarrower(object);
				break;

			case "prefLabel": 
				item.setPerfLabel(object);
				break;

			case "type":
				item.setType(object);
				break;

			case "hasTopConcept":
				item.setHasTopConcept(object);
				break;

			case "topConceptOf":
				item.setTopConceptOf(object);	
				break;

			case "broader":
				item.setBroader(object);
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

package testesJena;

import java.io.InputStream;

import org.apache.jena.rdf.model.*;
import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.util.FileManager;
import org.apache.jena.vocabulary.*;

public class ReadingACM_CCS {
	static final String inputFileName  = "acm_ccs2012_s.xml";
	static Model model = ModelFactory.createDefaultModel();
	
	public static void main (String args[]) {
		model.read(inputFileName, "RDF/XML");
		model.setNsPrefix("", "file:///C:/Projetos/EduKnow/JenaKSA/");

	    readStatements();   
	}		

	public static void readStatements() {
		System.out.println("\n----  DADOS DO MODELO  ------------");		
		StmtIterator it = model.listStatements();
		while(it.hasNext()) {
			Statement tripla      = it.nextStatement();
			Resource  subject   = tripla.getSubject();
			Property  predicate = tripla.getPredicate();
			RDFNode   object    = tripla.getObject();

			System.out.println("\nSubject: " + subject.toString());
			System.out.println("Predicado: " + predicate.getLocalName().toString());
			if (object instanceof Resource) {
				System.out.println("ObjectR: " + object.asResource().toString() );				
			} else {
				System.out.println("Object: " + object.toString() );
			}		    
		}
	}
	public static void readProperties() {
		ResIterator iter = model.listSubjectsWithProperty(SKOS.prefLabel);
		while (iter.hasNext()) {
			Resource r = iter.nextResource();
			System.out.println(r.toString());
		}
	}
}

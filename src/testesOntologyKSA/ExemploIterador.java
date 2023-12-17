package testesOntologyKSA;

import org.apache.jena.rdf.model.*;
import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.vocabulary.*;

//https://jena.apache.org/tutorials/rdf_api.html


public class ExemploIterador {
	static final String pathDir = "C:\\Users\\edeys\\Meu Drive (edeysongomes@ufba.br)\\Doutorado\\Projetos\\Ontologia CHA\\";
	static final String inputFileName = pathDir + "CompetenciasKSA.ttl";
	static final String outputFileName = pathDir + "CompetenciasKSA-out.ttl";
	
	public static void main (String args[]) {
		Model model = ModelFactory.createDefaultModel();
		model.read(inputFileName);
		
		StmtIterator iter = model.listStatements();
	
		while(iter.hasNext()) {
		    Statement tripla    = iter.nextStatement();
		    Resource  subject   = tripla.getSubject();
		    Property  predicate = tripla.getPredicate();
		    RDFNode   object    = tripla.getObject();
		    
		    if (object instanceof Resource) {
		    	System.out.println("\nBlank node: " + object.toString());
		    }
		    else  {
		    	System.out.println("\nSubject: " + subject.toString());
		    	System.out.println("Predicado: " + predicate.toString());
		        System.out.println("Object: " + object.toString() );
		     }		    
		}
	}
}

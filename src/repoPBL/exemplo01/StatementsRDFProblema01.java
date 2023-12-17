package repoPBL.exemplo01;

import java.io.InputStream;

import org.apache.jena.rdf.model.*;
import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.util.FileManager;
import org.apache.jena.vocabulary.*;

public class StatementsRDFProblema01 {
	static final String inputFileName  = "C:\\Projetos\\EduKnow\\RepoPBL\\MaquinaSalgados\\Problema01Competencias.rdf";

	public static void main (String args[]) {
		Model model = ModelFactory.createDefaultModel();

        try {
	        model.read( inputFileName );
        }
        catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		StmtIterator iter = model.listStatements();

		while(iter.hasNext()) {
			Statement tripla      = iter.nextStatement();
			Resource  subject   = tripla.getSubject();
			Property  predicate = tripla.getPredicate();
			RDFNode   object    = tripla.getObject();

			System.out.println("\nSubject: " + subject.toString());
			System.out.println("Predicado: " + predicate.toString());
			if (object instanceof Resource) {
				System.out.println("Object: " + object.toString());
			} else {
				System.out.println("Object: " + object.toString() );
			}		    
		}	        
	}
}

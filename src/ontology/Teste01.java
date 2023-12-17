package ontology;

import java.util.Iterator;

import org.apache.jena.ontology.Individual;
import org.apache.jena.ontology.OntClass;
import org.apache.jena.ontology.OntDocumentManager;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;

public class Teste01 {
	static final String JENA = "C:\\Projetos\\apache-jena-4.4.0\\src-examples\\data\\";
	
	public static void main(String[] args) {

		String SOURCE = "http://www.eswc2006.org/technologies/ontology";
		String NS = SOURCE + "#";
		
		/**
		 * This will create an ontology model with the default settings, 
		 * which are set for maximum compatibility with the previous version of Jena. 
		 * These defaults are:
		 * 			OWL-Full language
		 * 			in-memory storage
		 * 			RDFS inference, which principally produces entailments from the sub-class and sub-property hierarchies.
		 */
		OntModel model = ModelFactory.createOntologyModel();
		//OntModel model = ModelFactory.createOntologyModel( OntModelSpec.OWL_DL_MEM );
		
		/**
		 *  OWL model that performs no reasoning at all can be created with 
		 *  ModelFactory.createOntologyModel( OntModelSpec.OWL_MEM );
		 */
		//

		
		OntDocumentManager docManager = model.getDocumentManager();
		docManager.addAltEntry( "http://www.eswc2006.org/technologies/ontology",
		                "file:" + JENA + "eswc-2006-09-21.rdf" );

		model.read( SOURCE, "RDF/XML" );
		
		// create the reasoning model using the base
		OntModel reasoning = ModelFactory.createOntologyModel( OntModelSpec.OWL_MEM_MICRO_RULE_INF, model );
		//OntModel reasoning = ModelFactory.createOntologyModel( OntModelSpec.OWL_DL_MEM_RULE_INF, model );

		// create a dummy paper for this example
		OntClass paper = model.getOntClass( NS + "Paper" );
		Individual p1 = model.createIndividual( NS + "paper1", paper );

		System.out.println("List the asserted types...");
		for (Iterator<Resource> i = p1.listRDFTypes(false); i.hasNext(); ) {
		    System.out.println( p1.getURI() + " is asserted in class " + i.next() );
		}

		System.out.println("\n\n");
		
		System.out.println("list the inferred types ...");
		p1 = reasoning.getIndividual( NS + "paper1" );
		for (Iterator<Resource> i = p1.listRDFTypes(false); i.hasNext(); ) {
		    System.out.println( p1.getURI() + " is inferred to be in class " + i.next() );
		}		

	}

}

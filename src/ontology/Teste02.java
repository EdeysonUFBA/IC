package ontology;

import java.util.Iterator;

import org.apache.jena.ontology.Individual;
import org.apache.jena.ontology.OntClass;
import org.apache.jena.ontology.OntDocumentManager;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;

public class Teste02 {

	static final String JENA = "C:\\Users\\edeys\\Meu Drive (edeysongomes@ufba.br)\\Doutorado\\Projetos\\Ontologia CHA\\";
	
	public static void main(String[] args) {

		String SOURCE = "http://www.semanticweb.org/edeyson/ontologies/2021/Competencias";
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
		docManager.addAltEntry( "http://www.semanticweb.org/edeyson/ontologies/2021/Competencias",
		                "file:" + JENA + "CompetenciasKSA.ttl" );

		model.read( SOURCE, "TTL" );
		
		// create the reasoning model using the base
		OntModel reasoning = ModelFactory.createOntologyModel( OntModelSpec.OWL_MEM_MICRO_RULE_INF, model );
		//OntModel reasoning = ModelFactory.createOntologyModel( OntModelSpec.OWL_DL_MEM_RULE_INF, model );

		// create a dummy paper for this example
		OntClass competence = model.getOntClass( NS + "AtomicCompetence" );
		Individual c1 = model.createIndividual( NS + "competence1", competence );

		System.out.println("List the asserted types...");
		for (Iterator<Resource> i = c1.listRDFTypes(false); i.hasNext(); ) {
		    System.out.println( c1.getURI() + " is asserted in class " + i.next() );
		}

		System.out.println("\n\n");
		
		System.out.println("list the inferred types ...");
		c1 = reasoning.getIndividual( NS + "competence1" );
		for (Iterator<Resource> i = c1.listRDFTypes(false); i.hasNext(); ) {
		    System.out.println( c1.getURI() + " is inferred to be in class " + i.next() );
		}		

	}
}

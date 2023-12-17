package testesJena;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.Statement;
import org.apache.jena.rdf.model.StmtIterator;
import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.vocabulary.VCARD;


public class ExemploIterador {
	public static void main (String args[]) {
		Model model = ModelFactory.createDefaultModel();

		Person lula = new Person("Luís", "Inácio", "http://somewhere/LuisInacio");
		insertPerson(model, lula);
		
		Person geraldo = new Person("Geraldo", "Alckmin", "http://somewhere/GeraldoAlckmin");
		insertPerson(model, geraldo);
		
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
		
		printModel(model);
	}

	private static void insertPerson(Model model, Person person) {
		Resource r  = 
				model.createResource(person.getUri())
				.addProperty(VCARD.FN, person.getFullName())
				.addProperty(VCARD.N, model.createResource()
						.addProperty(VCARD.Given, person.getFirstName())
						.addProperty(VCARD.Family, person.getFamilyName()));
	}
	
    private static void printModel(Model model) {
		System.out.println("------------------");
		System.out.println("Arquivo em RDF/XML:");
		System.out.println("------------------");		
		RDFDataMgr.write(System.out, model, Lang.RDFXML);
		
		System.out.println("\n------------------");
		System.out.println("Arquivo em TTL:");
		System.out.println("------------------");		
		RDFDataMgr.write(System.out, model, Lang.TTL);	 
    }	
}

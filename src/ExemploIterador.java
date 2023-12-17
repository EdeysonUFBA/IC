import org.apache.jena.rdf.model.*;
import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.vocabulary.*;

public class ExemploIterador {
	public static void main (String args[]) {
		Model model = ModelFactory.createDefaultModel();

		insereTriplas(model);
		
		System.out.println();
		RDFDataMgr.write(System.out, model, Lang.RDFXML);		
		
//		System.out.println();
//		RDFDataMgr.write(System.out, model, Lang.NTRIPLES);

		StmtIterator iter = model.listStatements();
		while(iter.hasNext()) {
		    Statement tripla      = iter.nextStatement();
		    Resource  subject   = tripla.getSubject();
		    Property  predicate = tripla.getPredicate();
		    RDFNode   object    = tripla.getObject();
		    
		    if (object instanceof Resource) {
		    	//System.out.println("\nBlank node: " + object.toString());
		    }
		    else
		    {
		    	System.out.println("\nSubject: " + subject.toString());
		    	System.out.println("Predicado: " + predicate.toString());
		         System.out.println("Object: " + object.toString() );
		     }		    
		}
	}

	private static void insereTriplas(Model model) {
		String personURI    = "http://somewhere/JohnSmith";
		String givenName    = "John";
		String familyName   = "Smith";
		String fullName     = givenName + " " + familyName;
		
		Resource johnSmith  = 
				model.createResource(personURI)
				.addProperty(VCARD.FN, fullName)
				.addProperty(VCARD.N, model.createResource()
						.addProperty(VCARD.Given, givenName)
						.addProperty(VCARD.Family, familyName));

		personURI    = "http://somewhere/LuisInacio";
		givenName    = "Luis";
		familyName   = "Inacio";
		fullName     = givenName + " " + familyName;

		Resource luisInacio  = 
				model.createResource(personURI)
				.addProperty(VCARD.FN, fullName)
				.addProperty(VCARD.N, model.createResource()
						.addProperty(VCARD.Given, givenName)
						.addProperty(VCARD.Family, familyName));		
	}
}

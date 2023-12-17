package testesJena;

import org.apache.jena.rdf.model.*;
import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.vocabulary.*;

//https://jena.apache.org/tutorials/rdf_api.html

public class ExemploRecurso2 {
	public static void main (String args[]) {
		Model model = ModelFactory.createDefaultModel();

		String personURI    = "http://somewhere/JohnSmith";
		String fullName     = "John Smith";

		Resource johnSmith  = 
				model.createResource(personURI)
					.addProperty(VCARD.FN, fullName);

		personURI    = "http://somewhere/LuisInacio";
		fullName     = "Luís Inácio";

		Resource luisInacio  = 
				model.createResource(personURI)
					.addProperty(VCARD.FN, fullName);
		
		printModel(model);
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

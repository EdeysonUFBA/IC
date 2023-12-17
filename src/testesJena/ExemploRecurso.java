package testesJena;

import org.apache.jena.rdf.model.*;
import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.vocabulary.*;

//https://jena.apache.org/tutorials/rdf_api.html

public class ExemploRecurso {
	public static void main (String args[]) {
		String personURI    = "http://somewhere/JohnSmith";
		String fullName     = "John Smith";

		//(http://.../JohnSmith)   -> vcard:FN  ->  ["John Smith"]

		//A Graph (Model) in Jena
		Model model = ModelFactory.createDefaultModel();

		Resource johnSmith  = model.createResource(personURI);
		johnSmith.addProperty(VCARD.FN, fullName);

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

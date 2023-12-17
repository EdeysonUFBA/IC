package testesJena;

import org.apache.jena.rdf.model.*;
import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.vocabulary.*;

//https://jena.apache.org/tutorials/rdf_api.html


public class ExemploRecurso3 {
	public static void main (String args[]) {
		Model model = ModelFactory.createDefaultModel();

		String personURI    = "http://somewhere/JohnSmith";
		String givenName    = "John";
		String familyName   = "Smith";
		String fullName     = givenName + " " + familyName;

		//(http://.../JohnSmith)   
		//		-> vcard:FN  ->  ["John Smith"]
		//		-> vcard:N  
		//				-> vcard:Given		->  ["John"]
		//				-> vcard:Family		->  ["Smith"]
		
		Resource johnSmith  = 
				model.createResource(personURI)
					.addProperty(VCARD.FN, fullName)
					.addProperty(VCARD.N, model.createResource()
							.addProperty(VCARD.Given, givenName)
							.addProperty(VCARD.Family, familyName));
							

		System.out.println("---------- MODELO EM RDF ------------");
		model.write(System.out);

		System.out.println("\n\n");		

		System.out.println("---------- MODELO EM TTL ------------");
		RDFDataMgr.write(System.out, model, Lang.TTL);
	}
}

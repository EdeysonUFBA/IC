package testesJena;

import org.apache.jena.rdf.model.*;
import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.vocabulary.*;

public class Teste01 {

	/**
	 * Construção de um RDF - VCard
	 * @param args
	 */

	public static void main (String args[]) {
		String personURI    = "http://somewhere/JohnSmith";
		String givenName    = "John";
		String familyName   = "Smith";
		String fullName     = givenName + " " + familyName;

		Model model = ModelFactory.createDefaultModel();

		Resource johnSmith
		= model.createResource(personURI)
		.addProperty(VCARD.FN, fullName)
		.addProperty(VCARD.N,
				model.createResource()
				.addProperty(VCARD.Given, givenName)
				.addProperty(VCARD.Family, familyName));

		StmtIterator iter = model.listStatements();

		while (iter.hasNext()) {
			Statement triple    = iter.nextStatement(); 
			Resource  subject   = triple.getSubject(); 
			Property  predicate = triple.getPredicate(); 
			RDFNode   object    = triple.getObject(); 

			System.out.print("\nSubject: " + subject.toString());
			System.out.print("\nPredicate: " + predicate.toString() + " ");
			if (object instanceof Resource) {
				System.out.print("\nResource: " + object.toString());
			} else {
				System.out.print("\nLiteral: \"" + object.toString() + "\"");
			}
			System.out.println(" .");
		}
		System.out.println("\n\n");
		model.write(System.out);

		System.out.println();
		RDFDataMgr.write(System.out, model, Lang.TURTLE);
	}
}	

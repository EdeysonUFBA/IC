package testesJena;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.ResIterator;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.VCARD;

public class Querying {
	static final String inputFileName = "vc-db-1.rdf";
	static final String johnSmithURI = "http://somewhere/JohnSmith";

	public static void main (String args[]) {
		Model model = ModelFactory.createDefaultModel();

		model.read(inputFileName);

		ResIterator iter = model.listSubjectsWithProperty(VCARD.FN);
		while (iter.hasNext()) {
			Resource r = iter.nextResource();
			String fullName = r.getRequiredProperty(VCARD.FN).getString();
			Resource N = (Resource) r.getRequiredProperty(VCARD.N).getObject();

			String givenName = N.getRequiredProperty(VCARD.Given).getString();
			String familyName = N.getRequiredProperty(VCARD.Family).getString();

			System.out.println("\nNome: " + fullName);
			System.out.println("Given: " + givenName);
			System.out.println("Family: " + familyName);
		}
	}
}

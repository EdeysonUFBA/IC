package testesJena;

import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.jena.rdf.model.*;
import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.util.FileManager;
import org.apache.jena.vocabulary.*;

public class Teste03 {
	static final String inputFileName = "vc-db-1.rdf";
	static final String johnSmithURI = "http://somewhere/JohnSmith";

	public static void main (String args[]) {
		// create an empty model
		Model model = ModelFactory.createDefaultModel();

		// use the FileManager to find the input file
		InputStream in = FileManager.get().open(inputFileName);
		if (in == null) {
			throw new IllegalArgumentException( "File: " + inputFileName + " not found");
		}

		// read the RDF/XML file
		model.read(new InputStreamReader(in), "");

		// retrieve the Adam Smith vcard resource from the model
		Resource vcard = model.getResource(johnSmithURI);

		// retrieve the value of the N property
		Resource name = (Resource) vcard.getRequiredProperty(VCARD.N)
				.getObject();
		// retrieve the given name property
		String fullName = vcard.getRequiredProperty(VCARD.FN)
				.getString();
		// add two nick name properties to vcard
		vcard.addProperty(VCARD.NICKNAME, "Smithy")
		.addProperty(VCARD.NICKNAME, "Adman");

		// set up the output
		System.out.println("The nicknames of \"" + fullName + "\" are:");
		// list the nicknames
		StmtIterator iter = vcard.listProperties(VCARD.NICKNAME);
		while (iter.hasNext()) {
			System.out.println("    " + iter.nextStatement().getObject()
					.toString());
		}
	}
}

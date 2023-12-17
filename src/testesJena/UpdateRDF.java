package testesJena;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import org.apache.jena.rdf.model.*;
import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.util.FileManager;
import org.apache.jena.vocabulary.*;

public class UpdateRDF {
	static final String inputFileName = "vc-db-1.rdf";
	static final String outputFileName = "vc-db-1-out.rdf";
	static final String johnSmithURI = "http://somewhere/JohnSmith";

	public static void main (String args[]) {
		Model model = ModelFactory.createDefaultModel();

		model.read(inputFileName);

		Resource vcard = model.getResource(johnSmithURI);

		Resource name = (Resource) vcard.getRequiredProperty(VCARD.N).getObject();
		
		String fullName = vcard.getRequiredProperty(VCARD.FN).getString();
		
		vcard.addProperty(VCARD.NICKNAME, "Smithy")
			 .addProperty(VCARD.NICKNAME, "Adman");

		System.out.println("The nicknames of \"" + fullName + "\" are:");
		StmtIterator iter = vcard.listProperties(VCARD.NICKNAME);
		while (iter.hasNext()) {
			System.out.println("    " + iter.nextStatement().getObject()
					.toString());
		}
		
		System.out.println("---------- MODELO EM RDF ------------");
		model.write(System.out);
		
		OutputStream os;
		try {
			os = new FileOutputStream(outputFileName);
			model.write(os);	
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

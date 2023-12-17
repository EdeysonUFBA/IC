package testesJena;

import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

import org.apache.jena.rdf.model.*;
import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.riot.RDFFormat;
import org.apache.jena.vocabulary.*;

//https://jena.apache.org/tutorials/rdf_api.html


public class ExemploIterador2 {
	public static void main (String args[]) {
		Model model = ModelFactory.createDefaultModel();

		Person lula = new Person("Luís", "Inácio", "http://somewhere/LuisInacio");
		insertPerson(model, lula);

		Person geraldo = new Person("Geraldo", "Alckmin", "http://somewhere/GeraldoAlckmin");
		insertPerson(model, geraldo);

		Resource zeCarioca  = 
				model.createResource("http://somewhere/ZeCarioca")
				.addProperty(VCARD.N, model.createResource()
						.addProperty(VCARD.Given, "José")
						.addProperty(VCARD.Family, "Carioca"));

		ResIterator iter = model.listSubjectsWithProperty(VCARD.FN);
		System.out.println("\n----  DADOS DO MODELO  ------------");
		while (iter.hasNext()) {
			Resource r = iter.nextResource();
			String fullName = r.getRequiredProperty(VCARD.FN).getString();

			Resource N = (Resource) r.getRequiredProperty(VCARD.N).getObject();
			String givenName = N.getRequiredProperty(VCARD.Given).getString();
			String familyName = N.getRequiredProperty(VCARD.Family).getString();

			System.out.println("\tNome: " + fullName);
			System.out.println("\tGiven: " + givenName);
			System.out.println("\tFamily: " + familyName);
			System.out.println();

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

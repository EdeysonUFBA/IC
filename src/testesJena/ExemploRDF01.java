package testesJena;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.Statement;
import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFDataMgr;

public class ExemploRDF01 {

	public static void main(String[] args) {
		 
		Model model = ModelFactory.createDefaultModel(); 
		String ns = new String("http://www.exemplo.com.br/exemplo#"); 
		
		Resource joao = model.createResource(ns + "Joao"); 
		Resource maria = model.createResource(ns + "Maria"); 
		
		Property temIrmao = model.createProperty(ns, "temIrmão"); 
		maria.addProperty(temIrmao, joao); 

		Property temIrma = model.createProperty(ns, "temIrmã"); 
		Statement sentencaIrma = model.createStatement(joao, temIrma, maria); 
		
		model.add(sentencaIrma);

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

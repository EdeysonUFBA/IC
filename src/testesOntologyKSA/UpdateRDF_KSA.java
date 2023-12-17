package testesOntologyKSA;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import org.apache.jena.ontology.OntClass;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.rdf.model.*;
import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.util.FileManager;
import org.apache.jena.vocabulary.*;

public class UpdateRDF_KSA {
	static final String pathDir = "C:\\Users\\edeys\\Meu Drive (edeysongomes@ufba.br)\\Doutorado\\Projetos\\Ontologia CHA\\";
	static final String inputFileName = pathDir + "CompetenciasKSA.ttl";
	static final String outputFileName = pathDir + "CompetenciasKSA-out.ttl";

	static String uri = "http://www.semanticweb.org/edeyson/ontologies/2021/Competencias#";
	
	public static void main (String args[]) {
		OntModel model = ModelFactory.createOntologyModel();
		//model.setNsPrefix("comp", "http://www.semanticweb.org/edeyson/ontologies/2021/Competencias#"); 		

		model.read(inputFileName);

		OntClass attitude = model.getOntClass(uri + "Attitude");
		System.out.println("Classe: " + attitude.getLocalName());
		System.out.println("\tURI: " + attitude.getURI());
		System.out.println("\tComment: " + attitude.getComment("en"));
		
		attitude.addComment("Teste de comentário com acentuação!", "pt");
		System.out.println("\tCommentário: " + attitude.getComment("pt"));		
		
		//Resource comment = (Resource) attitude.getRequiredProperty(RDFS.comment).getObject();
		
		//System.out.println("Descrição da Atitude: \n\t" + comment);
		
		System.out.println("---------- MODELO EM RDF ------------");
		//RDFDataMgr.write(System.out, model, Lang.TTL);
		
		OutputStream os;
		try {
			os = new FileOutputStream(outputFileName);
			RDFDataMgr.write(os, model, Lang.TTL);
			//model.write(os);	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
}

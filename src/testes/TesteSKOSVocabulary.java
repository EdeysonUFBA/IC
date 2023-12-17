package testes;

import org.apache.jena.rdf.model.Property;
import org.apache.jena.vocabulary.SKOS;

public class TesteSKOSVocabulary {

	public static void main(String[] args) {
		Property prefLabel;
		
		prefLabel = SKOS.prefLabel;
		System.out.println(prefLabel.getLocalName());
	}

}

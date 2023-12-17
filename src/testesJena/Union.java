package testesJena;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.ResIterator;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.RDF;
import org.apache.jena.vocabulary.VCARD;

/** Exemplo de uni�o entre RDFs */

public class Union {
    static final String inputFileName1 = "vc-db-3.rdf";    
    static final String inputFileName2 = "vc-db-4.rdf";
    
    public static void main (String args[]) {
        Model model1 = ModelFactory.createDefaultModel();
        Model model2 = ModelFactory.createDefaultModel();

        model1.read(inputFileName1);
		model2.read(inputFileName2) ; 		
        
        System.out.println("Conte�do do RDF 1:");
        model1.write(System.out);
        System.out.println("\n\nConte�do do RDF 2:");
        model2.write(System.out);        
        
        
        Model model = model1.union(model2);

		ResIterator iter = model.listSubjectsWithProperty(VCARD.FN);
		while (iter.hasNext()) {
			Resource r = iter.nextResource();
			String fullName = r.getRequiredProperty(VCARD.FN).getString();
			
			Resource N = (Resource) r.getRequiredProperty(VCARD.N).getObject();
			String givenName = N.getRequiredProperty(VCARD.Given).getString();
			String familyName = N.getRequiredProperty(VCARD.Family).getString();

			Resource EM = (Resource) r.getRequiredProperty(VCARD.EMAIL).getObject();
			String email = EM.getRequiredProperty(RDF.value).getString();
					
			System.out.println("\n----  DADOS DA UNI�O  -------------");
			System.out.println("\tNome: " + fullName);
			System.out.println("\tGiven: " + givenName);
			System.out.println("\tFamily: " + familyName);
			System.out.println("\te-mail: " + email);			
			System.out.println("-------------------------------------");
		}
		
		System.out.println();
        System.out.println("\n\nConte�do do RDF ap�s a Uni�o:");		
        model.write(System.out, "RDF/XML-ABBREV");
        System.out.println();
    }
}

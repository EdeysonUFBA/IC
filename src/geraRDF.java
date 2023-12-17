import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.Statement;
import org.apache.jena.rdf.model.StmtIterator;
import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.vocabulary.DC;
import org.apache.jena.vocabulary.VCARD;

import vocabulary.LOM;

public class geraRDF {
	static Model model = ModelFactory.createDefaultModel();
	public static void main (String args[]) {


		insereTriplas();
		
		System.out.println("\n\n");
		model.write(System.out);
		
//		System.out.println();
//		RDFDataMgr.write(System.out, model, Lang.NTRIPLES);

/*		StmtIterator iter = model.listStatements();
		while(iter.hasNext()) {
		    Statement tripla      = iter.nextStatement();
		    Resource  subject   = tripla.getSubject();
		    Property  predicate = tripla.getPredicate();
		    RDFNode   object    = tripla.getObject();
		    
		    if (object instanceof Resource) {
		    	//System.out.println("\nBlank node: " + object.toString());
		    }
		    else
		    {
		    	System.out.println("\nSubject: " + subject.toString());
		    	System.out.println("Predicado: " + predicate.toString());
		        System.out.println("Object: " + object.toString() );
		     }		    
		}
*/		
	}

	private static void insereTriplas() {
/**
 *  <rdf:Description rdf:about="https://github.com/EdeysonUFBA/EduKnow/tree/main/RepoPBL/MaquinaSalgados/Problema01.md">
    <rdf:type rdf:resource="http://ltsc.ieee.org/rdf/lomv1p0/lom#LearningObject"/>
    <lom:OtherPlatformRequirements>Editor de texto</lom:OtherPlatformRequirements>
    <lom:aggregationLevel rdf:resource="http://ltsc.ieee.org/rdf/lomv1p0/vocabulary#AggregationLevel-1"/>
    <lom:copyrightAndOtherRestrictions>yes</lom:copyrightAndOtherRestrictions>
    <lom:cost>no</lom:cost>
    <lom:keyword>PBL</lom:keyword>
    <lom:keyword>Autômato Finito</lom:keyword>
    <lom:keyword>Expressão Regular</lom:keyword>
    <lom:metaMetadataLanguage>pt</lom:metaMetadataLanguage>
    <lom:structure rdf:resource="http://ltsc.ieee.org/rdf/lomv1p0/vocabulary#Structure-atomic"/>
 */     
		
		if ( model.getNsPrefixURI("lom") == null )
		    model.setNsPrefix("lom", LOM.getURI() ) ;
		
		String pblURI = "https://github.com/EdeysonUFBA/EduKnow/tree/main/RepoPBL/MaquinaSalgados/Problema01.md";
		String lomOtherPlatformRequirements = "Editor de Texto";
	    String aggregationLevel = "http://ltsc.ieee.org/rdf/lomv1p0/vocabulary#AggregationLevel-1";		
		
		Resource tarefaPBL = model.createResource(pblURI)
				.addProperty(LOM.otherPlatformRequirements, lomOtherPlatformRequirements)
				.addProperty(LOM.aggregationLevel, aggregationLevel)
				.addProperty(DC.title, "Problema 1: A máquina de vender refrigerantes e salgados.");
		
		addAutores();
	}

	private static void addAutores() {
		String personURI    = "http://somewhere/JohnSmith";
		String givenName    = "John";
		String familyName   = "Smith";
		String fullName     = givenName + " " + familyName;
		
		Resource johnSmith  = 
				model.createResource(personURI)
				.addProperty(VCARD.FN, fullName)
				.addProperty(VCARD.N, model.createResource()
						.addProperty(VCARD.Given, givenName)
						.addProperty(VCARD.Family, familyName));

		personURI    = "http://somewhere/LuisInacio";
		givenName    = "Luis";
		familyName   = "Inacio";
		fullName     = givenName + " " + familyName;

		Resource luisInacio  = 
				model.createResource(personURI)
				.addProperty(VCARD.FN, fullName)
				.addProperty(VCARD.N, model.createResource()
						.addProperty(VCARD.Given, givenName)
						.addProperty(VCARD.Family, familyName));		
	}
}

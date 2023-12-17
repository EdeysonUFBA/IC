package repoPBL.exemplo01;

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
import org.apache.jena.vocabulary.RDF;
import org.apache.jena.vocabulary.VCARD;

import vocabulary.CHA;
import vocabulary.LOM;

public class WriteRDFProblema01Head {

	public static void main (String args[]) {    
		Model model = ModelFactory.createDefaultModel();

		String resourceURI = "https://github.com/EdeysonUFBA/EduKnow/tree/main/RepoPBL/MaquinaSalgados/Problema01.md";

		// create the resource
		Resource resourceMD = model.createResource(resourceURI);

		addProperties(resourceMD);		
		//printCompetences(resourceMD);
		//printCreators(resourceMD);
		
		printModel(model);

	}

	private static void addProperties(Resource resourceMD) {
		System.out.println("\n--------------- LOM/DC Properties --------------");
		
		resourceMD.addProperty(RDF.type, LOM.learningObject);

		String otherPlatformRequirements = "Editor de texto";
		resourceMD.addProperty(LOM.otherPlatformRequirements, otherPlatformRequirements);
		
/*

		StmtIterator iter = resourceMD.listProperties(LOM.keyword);
		while (iter.hasNext()) {
			String keyword = iter.nextStatement().getObject()
					.toString();
			System.out.println("LOM keyword: " +  keyword);
		}	
		
		String aggregationLevel = ((Resource)resourceMD.getPropertyResourceValue(LOM.aggregationLevel)).toString();
		System.out.println("LOM aggregationLevel: " +  aggregationLevel);
		
		String copyrightAndOtherRestrictions = resourceMD.getRequiredProperty(LOM.copyrightAndOtherRestrictions).getString();
		System.out.println("LOM copyrightAndOtherRestrictions: " +  copyrightAndOtherRestrictions);

		String cost = resourceMD.getRequiredProperty(LOM.cost).getString();
		System.out.println("LOM cost: " +  cost);

		String metaMetadataLanguage = resourceMD.getRequiredProperty(LOM.metaMetadataLanguage).getString();
		System.out.println("LOM metaMetadataLanguage: " +  metaMetadataLanguage);

		String structure =  ((Resource) resourceMD.getPropertyResourceValue(LOM.structure)).toString();
		System.out.println("LOM structure: " +  structure);

		String language = resourceMD.getRequiredProperty(DC.language).getString();
		System.out.println("DC language: " +  language);
		
		String rights = resourceMD.getRequiredProperty(DC.rights).getString();
		System.out.println("DC rights: " +  rights);	    

		String title = resourceMD.getRequiredProperty(DC.title).getString();		
		System.out.println("DC title: " +  title);	    	
*/	
	}	

	private static void printCompetences(Resource resourceMD) { 
		//Print KSA Competence URI
		System.out.println("\n--------------- Competences URI --------------");
		StmtIterator iter = resourceMD.listProperties(CHA.taskAchievesCompetence);
		while (iter.hasNext()) {
			String competenceURI = iter.nextStatement().getObject()
					.toString();
			System.out.println("competenceURI: " +  competenceURI);
		}	
	}

	private static void printCreators(Resource resourceMD) {
		System.out.println("\n--------------- Creators --------------");
		StmtIterator resIterator = resourceMD.listProperties(DC.creator);
		while (resIterator.hasNext()) {
			Resource r = (Resource) resIterator.nextStatement().getObject();
			//Resource creator = (Resource) r.getRequiredProperty(VCARD.FN);				
			String creatorName = r.getRequiredProperty(VCARD.FN).getString();			
			System.out.println(creatorName);
		}	

	}
	
	private static void printAllStatements(Model model) {

		StmtIterator iter = model.listStatements();

		while(iter.hasNext()) {
			Statement tripla      = iter.nextStatement();
			Resource  subject   = tripla.getSubject();
			Property  predicate = tripla.getPredicate();
			RDFNode   object    = tripla.getObject();

			System.out.println("\nSubject: " + subject.toString());
			System.out.println("Predicado: " + predicate.toString());
			if (object instanceof Resource) {
				System.out.println("Object: " + object.toString());
			} else {
				System.out.println("Object: " + object.toString() );
			}		    
		}
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

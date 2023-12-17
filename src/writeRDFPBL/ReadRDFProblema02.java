package writeRDFPBL;

import java.util.ArrayList;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.ResIterator;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.Statement;
import org.apache.jena.rdf.model.StmtIterator;
import org.apache.jena.vocabulary.DC;
import org.apache.jena.vocabulary.DC_11;
import org.apache.jena.vocabulary.RDF;
import org.apache.jena.vocabulary.RDFS;
import org.apache.jena.vocabulary.VCARD;

import vocabulary.CHA;
import vocabulary.LOM;

public class ReadRDFProblema02 {
	static final String inputFileName  = "Problema02Competencias.rdf.xml";
	static final ArrayList<String> competenceArray = new ArrayList<String>();
	static final ArrayList<String> knowledgeSkillArray = new ArrayList<String>();
	static final ArrayList<String> knowledgeArray = new ArrayList<String>();	

	public static void main (String args[]) {    
		Model model = ModelFactory.createDefaultModel();

		try {
			model.read( inputFileName );
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}

		//printAllStatements(model);
		
		Resource resourceMD = model.getResource("https://github.com/EdeysonUFBA/EduKnow/tree/main/RepoPBL/MaquinaSalgados/Problema01.md");

		printProperties(resourceMD);		
		printCreators(resourceMD);
		printCompetences(resourceMD);
		printCompetenceDescription(model);
		printKnowledgeSkillDescription(model);		
	}
	
	private static void printProperties(Resource resourceMD) {
		System.out.println("\n--------------- LOM/DC Properties --------------");
		
		String type = ((Resource)resourceMD.getPropertyResourceValue(RDF.type)).toString();
		System.out.println("LOM type: " +  type);
		
		String otherPlatformRequirements = resourceMD.getRequiredProperty(LOM.otherPlatformRequirements).getString();
		System.out.println("LOM otherPlatformRequirements: " +  otherPlatformRequirements);

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
	
	}

	private static void printCompetences(Resource resourceMD) { 
		//Print KSA Competence URI
		System.out.println("\n--------------- Competences URI --------------");
		StmtIterator iter = resourceMD.listProperties(CHA.taskAchievesCompetence);
		while (iter.hasNext()) {
			String competenceURI = iter.nextStatement().getObject()
					.toString();
			System.out.println("competenceURI: " +  competenceURI);
			competenceArray.add(competenceURI);
		}	
	}

	private static void printCompetenceDescription(Model model) { 
		System.out.println("\n--------------- Competence Description --------------");
		for (String competenceURI : competenceArray) {
			System.out.println("\nCompetence URI: " + competenceURI);
			
			Resource competence = model.getResource(competenceURI);
			String type = ((Resource)competence.getPropertyResourceValue(RDF.type)).toString();
			System.out.println("\ttype: " +  type);	
			
			StmtIterator resIterator = competence.listProperties(CHA.hasKnowledgeSkill);
			while (resIterator.hasNext()) {
				String knowledgeSkill = ((Resource) resIterator.nextStatement().getObject()).toString();
				System.out.println("\tKnowledgeSkill: " + knowledgeSkill);
				knowledgeSkillArray.add(knowledgeSkill);
			}	
			
			resIterator = competence.listProperties(CHA.hasAttitude);
			while (resIterator.hasNext()) {
				String competenceHasAttitude = ((Resource) resIterator.nextStatement().getObject()).toString();
				System.out.println("\tAttitude: " + competenceHasAttitude);
			}	
			
			String label = competence.getProperty(RDFS.label).getString();
			System.out.println("\tLabel: " +  label);
		}
	}
	
	private static void printKnowledgeSkillDescription(Model model) { 
		System.out.println("\n--------------- KnowledgeSkill Description --------------");
		for (String knowledgeSkillURI : knowledgeSkillArray) {
			System.out.println("\nKnowledgeSkill URI: " + knowledgeSkillURI);
			
			Resource knowledgeSkill = model.getResource(knowledgeSkillURI);
			String type = ((Resource)knowledgeSkill.getPropertyResourceValue(RDF.type)).toString();
			System.out.println("\ttype: " +  type);	
			
			String knowledge = ((Resource) knowledgeSkill.getProperty(CHA.hasKnowledge).getObject()).toString();
			System.out.println("\tKnowledge: " +  knowledge);			
			
			String skill = ((Resource)knowledgeSkill.getProperty(CHA.hasSkill).getObject()).toString();
			System.out.println("\tSkill: " +  skill);			

			String label = knowledgeSkill.getProperty(RDFS.label).getString();
			System.out.println("\tLabel: " +  label);
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
}

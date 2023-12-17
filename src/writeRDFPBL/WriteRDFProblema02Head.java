package writeRDFPBL;

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
import org.apache.jena.vocabulary.RDFS;
import org.apache.jena.vocabulary.VCARD;

import vocabulary.LOM;
import vocabulary.LOMC;
import vocabulary.*;

public class WriteRDFProblema02Head {
    static String lomvoc = "http://ltsc.ieee.org/rdf/lomv1p0/vocabulary#";
	static String resourceURI = "https://github.com/EdeysonUFBA/EduKnow/tree/main/RepoPBL/MaquinaSalgados/Problema01.md";
	
	public static void main (String args[]) {    
		Model model = ModelFactory.createDefaultModel();

		model.setNsPrefix("lom", LOM.NS);
		model.setNsPrefix("lomc", LOMC.NS);		
		
		// create the resource
		Resource resourceMD = model.createResource(resourceURI);
		resourceURI = resourceURI +"#";
		
		//addProperties(model, resourceMD);
		addCompetência(model, resourceMD);
		printModel(model);
		

	}

	private static void addProperties(Model model, Resource resourceMD) {
		System.out.println("\n--------------- LOM/DC Properties --------------");
		
		String otherPlatformRequirements = "Editor de texto";
		resourceMD.addProperty(LOM.otherPlatformRequirements, otherPlatformRequirements);

		String keyword = "Autômato Finito";
		resourceMD.addProperty(LOM.keyword, keyword);
		
		keyword = "PBL";
		resourceMD.addProperty(LOM.keyword, keyword);
		
		keyword = "Expressão Regular";
		resourceMD.addProperty(LOM.keyword, keyword);		
		
		String copyrightAndOtherRestrictions = "yes";
		resourceMD.addProperty(LOM.copyrightAndOtherRestrictions, copyrightAndOtherRestrictions);	
		
		String cost = "no";
		resourceMD.addProperty(LOM.cost, cost);				

		String metaMetadataLanguage = "pt";
		resourceMD.addProperty(LOM.metaMetadataLanguage, metaMetadataLanguage);				
	
		String language = "pt";
		resourceMD.addProperty(DC.language, language);	
		
		String rights = "http://creativecommons.org/licenses/by-nc-nd/3.0/";
		resourceMD.addProperty(DC.rights, rights);	
		
		String title = "Problema 1: A máquina de vender refrigerantes e salgados.";
		resourceMD.addProperty(DC.title, title);		

		resourceMD.addProperty(RDF.type, model.createResource(LOM.NS + "learningObject"));
		resourceMD.addProperty(model.createProperty(LOM.NS, "aggregationLevel"), model.createResource(lomvoc + "AggregationLeve-l"));

	    Resource author = model.createResource()
	            .addProperty(model.createProperty(VCARD.uri, "FN"), "Laís Salvador")
	            .addProperty(model.createProperty(VCARD.uri, "ORG"), "http://www.ufba.br")
	            .addProperty(model.createProperty(VCARD.uri, "EMAIL"), "laisns@ufba.br");
	    resourceMD.addProperty(model.createProperty(DC.NS, "creator"), author);		
	}	

	
	private static void addCompetência(Model model, Resource resourceMD) {
		String competenceURI = "Create_Written_Communication";
		
	    resourceMD.addProperty(LOMC.educationalCompetency,	model.createResource(resourceURI + competenceURI));
		
		// Cria competência atômica	    
		Resource atomicComp = model.createResource(resourceURI + "Create_Written_Communication");
		//Resource atomicComp = model.createResource(resourceURI + "Create_Written_Communication");		
		model.addLiteral(atomicComp, RDF.type, model.createResource(LOMC.NS + "AtomicCompetence"));
		
   		// Cria propriedade "hasKnowledgeSkill" e associa com KnowledgeSkill
		Resource knowledgeSkill = model.createResource(resourceURI + "Written_Communication_x_Create");
		//Resource knowledgeSkill = model.createResource();
		//model.addLiteral(knowledgeSkill, RDF.type, model.createResource(LOMC.NS + "KnowledgeSkill"));
		atomicComp.addProperty(model.createProperty(LOMC.NS, "hasKnowledgeSkill"), knowledgeSkill);
		atomicComp.addProperty(model.createProperty(RDFS.uri, "label"), "Create x Written Communication", "en");	
		
		Resource disposition = model.createResource(LOMC.NS + "Colaborativo");
		atomicComp.addProperty(model.createProperty(LOMC.NS, "hasDisposition"), disposition);
		disposition = model.createResource(LOMC.NS + "Inventivo");
		atomicComp.addProperty(model.createProperty(LOMC.NS, "hasDisposition"), disposition);
		disposition = model.createResource(LOMC.NS + "Investigativo");
		atomicComp.addProperty(model.createProperty(LOMC.NS, "hasDisposition"), disposition);
		disposition = model.createResource(LOMC.NS + "Proativo");
		atomicComp.addProperty(model.createProperty(LOMC.NS, "hasDisposition"), disposition);
		disposition = model.createResource(LOMC.NS + "Responsável");
		atomicComp.addProperty(model.createProperty(LOMC.NS, "hasDisposition"), disposition);
		

		// Cria propriedade "hasKnowledge" e associa com um label em inglês
		Resource knowledge = model.createResource(FPK.NS + "Written_Communication");
		knowledgeSkill.addProperty(model.createProperty(RDFS.uri, "label"), "Knowledge x Skill : Create Written Communication", "en");
		knowledgeSkill.addProperty(model.createProperty(LOMC.NS, "hasKnowledge"), knowledge);

		// Associa skill com a competência
		knowledgeSkill.addProperty(model.createProperty(LOMC.NS, "hasSkill"), model.createResource("http://www.semanticweb.org/edeyson/ontologies/2021/Competencias#Creating"));


		
	    //competenceURI = "Desenvolver_soluções_de_problemas_usando_Autômatos";
	    //resourceMD.addProperty(LOMC.taskAchievesCompetence,	model.createResource(resourceURI + competenceURI));

	    //competenceURI = "Testar_autômatos";
	    //resourceMD.addProperty(LOMC.taskAchievesCompetence,	model.createResource(resourceURI + competenceURI));

	    //competenceURI = "Determinar_Expressões_Regulares_que_representam_autômatos";
        //resourceMD.addProperty(LOMC.taskAchievesCompetence,	model.createResource(resourceURI + competenceURI));
	}	
	
	

	
    private static void printModel(Model model) {
		System.out.println("------------------");
		System.out.println("Arquivo em RDF/XML:");
		System.out.println("------------------");		
		RDFDataMgr.write(System.out, model, Lang.RDFXML);
		
		//System.out.println("\n------------------");
		//System.out.println("Arquivo em TTL:");
		//System.out.println("------------------");		
		//RDFDataMgr.write(System.out, model, Lang.TTL);	 
    }
}

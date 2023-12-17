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


public class WriteRDFCasoIMC {
    static String lomvoc = "http://ltsc.ieee.org/rdf/lomv1p0/vocabulary#";
	static String resourceURI = "https://eduknow.org/IMC.md";
	
	
	public static void main (String args[]) {    
		Model model = ModelFactory.createDefaultModel();

		model.setNsPrefix("lom", LOM.NS);
		model.setNsPrefix("lomc", LOMC.NS);		
		model.setNsPrefix("fpk", FPK.NS);
		model.setNsPrefix("cc2012", CCS2012.NS);			
		
		// create the resource
		Resource resourceMD = model.createResource(resourceURI);
		resourceURI = resourceURI +"#";
		
		Task task = new Task();
		
		task.setType("learningObject");
		task.setOtherPlatformRequirements("Editor de texto");
		task.setAggregationLevel(lomvoc + "AggregationLeve-l");
		task.setCopyright("http://creativecommons.org/licenses/by-nc-nd/3.0/");
		task.setCost("no");
		task.addKeyword("PBL");
		task.addKeyword("Autômato Finito");
		task.addKeyword("Expressão Regular");	
		task.setMetaMetadataLanguage("pt");
		task.setStructure(lomvoc + "Structure-atomic");
		task.setLanguage("pt");

		task.setTitle("Problema : Índice de Massa Corporal.");

		task.addAuthor(new Author("Laís Salvador", "http://www.ufba.br", "laisns@ufba.br") );
		task.addAuthor(new Author("Luiz Gavaza", "http://www.ufba.br", "gavaza@gmail.com") );
		task.addAuthor(new Author("Edeyson Gomes", "http://www.ufba.br", "edeysongomes@ufba.br") );		
		task.addAuthor(new Author("Jéssica Santana", "http://www.ufba.br", "jessicasantana@ufba.br") );		
		task.setCreationDate("2022/09/21");
		
	 	task.setEducationalContext("higher education");
	   	task.setLearningResourceType("problem statement");  
	   	task.setEducationalDescription("Competency Description"); 
        
		addProperties(model, resourceMD, task);
		
		Competency c = new Competency();
		c.setStatement("Escrever, em grupo, um relatório técnico");
		c.setStatementLanguage("pt");
		c.addDisposition(new Disposition("Colaborativo"));
		c.addDisposition(new Disposition("Meticuloso"));
		c.addDisposition(new Disposition("Responsável"));
		c.setUri("C4");
		
		Knowledge k = new Knowledge("Written Communication", "", FPK.NS);
		Skill skill = new Skill("Creating");
		KnowledgeSkill ks = new KnowledgeSkill(k, skill);
		ks.setUri("C4KS01");
		c.addKnowledgeSkill(ks);
		
		addCompetência(model, resourceMD, c);
		
		c = new Competency();
		c.setStatement("Desenvolver, em grupo, uma interface simples para interação com usuários.");
		c.setStatementLanguage("pt");
		c.addDisposition(new Disposition("Colaborativo"));
		c.addDisposition(new Disposition("Meticuloso"));
		c.addDisposition(new Disposition("Inventivo"));
		c.addDisposition(new Disposition("Responsável"));
		c.setUri("Cb");
		
		k = new Knowledge("Human computer interaction", "10003120.10003121", CCS2012.NS);
		skill = new Skill("Applying");
		ks = new KnowledgeSkill(k, skill);
		ks.setUri("CbKS01");		
		c.addKnowledgeSkill(ks);
		
		addCompetência(model, resourceMD, c);

		
		c = new Competency();
		c.setStatement("Codificar, em grupo, uma tarefa simples numa linguagem de programação.");
		c.setStatementLanguage("pt");
		c.addDisposition(new Disposition("Colaborativo"));
		c.addDisposition(new Disposition("Meticuloso"));
		c.addDisposition(new Disposition("Responsável"));		
		c.addDisposition(new Disposition("Proativo"));
		c.addDisposition(new Disposition("Inventivo"));
		c.setUri("Ca");
		
		k = new Knowledge("General programming languages", "10011007.10011006.10011008", CCS2012.NS);
		skill = new Skill("Applying");
		ks = new KnowledgeSkill(k, skill);
		ks.setUri("CaKS01");		
		c.addKnowledgeSkill(ks);
		
		
		k = new Knowledge("Programming logic", "10003752.10003790.10003806", CCS2012.NS);
		skill = new Skill("Applying");
		ks = new KnowledgeSkill(k, skill);
		ks.setUri("CaKS02");		
		c.addKnowledgeSkill(ks);		
		
		k = new Knowledge("Requirements analysis", "10011007.10011074.10011075.10011076", CCS2012.NS);
		skill = new Skill("Understanding");
		ks = new KnowledgeSkill(k, skill);
		ks.setUri("CaKS03");		
		c.addKnowledgeSkill(ks);
		
		k = new Knowledge("Mathematics and Statistics", "", FPK.NS);
		skill = new Skill("Applying");
		ks = new KnowledgeSkill(k, skill);
		ks.setUri("CaKS04");
		c.addKnowledgeSkill(ks);
		
		k = new Knowledge("Analytical and Critical Thinking", "", FPK.NS);
		skill = new Skill("Applying");
		ks = new KnowledgeSkill(k, skill);
		ks.setUri("CaKS05");
		c.addKnowledgeSkill(ks);		
		
		addCompetência(model, resourceMD, c);
		
		
		printModel(model);
		

	}

	private static void addProperties(Model model, Resource resourceMD, Task task) {
		//System.out.println("\n--------------- LOM/DC Properties --------------");

		resourceMD.addProperty(RDF.type, model.createResource(LOM.NS + task.getType()));
		resourceMD.addProperty(LOM.otherPlatformRequirements, task.getOtherPlatformRequirements());
		resourceMD.addProperty(model.createProperty(LOM.NS, "aggregationLevel"), model.createResource(task.getAggregationLevel()));
		resourceMD.addProperty(LOM.copyrightAndOtherRestrictions, task.getOtherPlatformRequirements());	
		resourceMD.addProperty(LOM.cost, task.getCost());				
		
		for (String keyword : task.getKeywords()) {
			resourceMD.addProperty(LOM.keyword, keyword);			
		}
		
		resourceMD.addProperty(LOM.metaMetadataLanguage, task.getMetaMetadataLanguage());	
		resourceMD.addProperty(model.createProperty(LOM.NS, "structure"), model.createResource(task.getStructure()));		
		resourceMD.addProperty(DC.language, task.getLanguage());	
		resourceMD.addProperty(DC.rights, task.getCopyright());	
		resourceMD.addProperty(DC.title, task.getTitle());		

		for (Author autor : task.getAuthors()) {
			Resource author = model.createResource()
	            .addProperty(model.createProperty(VCARD.uri, "FN"), autor.getFullName())
	            .addProperty(model.createProperty(VCARD.uri, "ORG"), autor.getOrganization())
	            .addProperty(model.createProperty(VCARD.uri, "EMAIL"), autor.getEmail());
		    resourceMD.addProperty(model.createProperty(DC.NS, "creator"), author);
		}
		resourceMD.addProperty(DC.date, task.getCreationDate());	
		
		for (String contributor : task.getContributors()) {
			resourceMD.addProperty(DC.contributor, contributor);
		}

		resourceMD.addProperty(LOM.educationalDescription, task.getEducationalDescription());	
		resourceMD.addProperty(LOM.educationalContext, task.getEducationalContext());
		resourceMD.addProperty(LOM.learningResourceType, task.getLearningResourceType());		

	}	

	private static void addCompetência(Model model, Resource resourceMD, Competency competence) {
		
	    resourceMD.addProperty(LOMC.educationalCompetency,	model.createResource(resourceURI + competence.getUri()));
		
		// Cria competência atômica	    
		Resource atomicComp = model.createResource(resourceURI + competence.getUri());
		atomicComp.addProperty(model.createProperty(LOMC.competenceStatement.toString()), competence.getStatement(), competence.getStatementLanguage());
		model.addLiteral(atomicComp, RDF.type, model.createResource(LOMC.AtomicCompetence.toString()));

		//Crias as propriedades Disposition
		Resource disposition;
		for (Disposition d: competence.getDispositions()) {
			disposition = model.createResource(LOMC.NS + d.getName());
			atomicComp.addProperty(model.createProperty(LOMC.NS, "hasDisposition"), disposition);		
		}

		Resource knowledgeSkill;
		for (KnowledgeSkill ks : competence.getPairsKnowledgeSkill()) {
			knowledgeSkill = model.createResource(resourceURI + ks.getUri());
			//knowledgeSkill = model.createResource();
			atomicComp.addProperty(model.createProperty(LOMC.hasKnowledgeSkill.toString()), knowledgeSkill);
	
			// Cria propriedade "hasKnowledge" e associa com um label em inglês
			Resource knowledge = model.createResource()
		            .addProperty(model.createProperty(ks.getKnowledge().getURI(), "label"), ks.getKnowledge().getLabel());
			if (ks.getKnowledge().getCategory() != "")
				knowledge.addProperty(model.createProperty(ks.getKnowledge().getURI(), "category"), ks.getKnowledge().getCategory());

			knowledgeSkill.addProperty(model.createProperty(LOMC.hasKnowledge.toString()), knowledge);
	
			// Associa skill com a competência
			knowledgeSkill.addProperty(model.createProperty(LOMC.hasSkill.toString()), 
					model.createResource(LOMC.NS + ks.getSkill().getLabel()));

		}
		
	    //competenceURI = "Desenvolver_soluções_de_problemas_usando_Autômatos";
	    //resourceMD.addProperty(LOMC.taskAchievesCompetence,	model.createResource(resourceURI + competenceURI));

	    //competenceURI = "Testar_autômatos";
	    //resourceMD.addProperty(LOMC.taskAchievesCompetence,	model.createResource(resourceURI + competenceURI));

	    //competenceURI = "Determinar_Expressões_Regulares_que_representam_autômatos";
        //resourceMD.addProperty(LOMC.taskAchievesCompetence,	model.createResource(resourceURI + competenceURI));
	}	
	
	private static void addCompetência(Model model, Resource resourceMD) {
		String competenceURI = "Create_Written_Communication";
		
	    resourceMD.addProperty(LOMC.educationalCompetency,	model.createResource(resourceURI + competenceURI));
		
		// Cria competência atômica	    
		Resource atomicComp = model.createResource(resourceURI + "Create_Written_Communication");
		atomicComp.addProperty(model.createProperty(LOMC.competenceStatement.toString()), "Criar relatório técnico", "pt");
		model.addLiteral(atomicComp, RDF.type, model.createResource(LOMC.AtomicCompetence.toString()));

		//Crias as propriedades Disposition
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
		
   		// Cria propriedade "hasKnowledgeSkill" e associa com KnowledgeSkill
		//Resource knowledgeSkill = model.createResource(resourceURI + "Written_Communication_x_Create");
		Resource knowledgeSkill = model.createResource();		
		atomicComp.addProperty(model.createProperty(LOMC.hasKnowledgeSkill.toString()), knowledgeSkill);

		// Cria propriedade "hasKnowledge" e associa com um label em inglês
		Resource knowledge = model.createResource()
	            .addProperty(model.createProperty(FPK.NS, "label"), "Written Communication");
		
//		knowledgeSkill.addProperty(model.createProperty(RDFS.uri, "label"), "Knowledge x Skill : Create Written Communication", "en");
		knowledgeSkill.addProperty(model.createProperty(LOMC.hasKnowledge.toString()), knowledge);

		// Associa skill com a competência
		knowledgeSkill.addProperty(model.createProperty(LOMC.hasSkill.toString()), 
				model.createResource(LOMC.NS + "Creating"));


		
	    //competenceURI = "Desenvolver_soluções_de_problemas_usando_Autômatos";
	    //resourceMD.addProperty(LOMC.taskAchievesCompetence,	model.createResource(resourceURI + competenceURI));

	    //competenceURI = "Testar_autômatos";
	    //resourceMD.addProperty(LOMC.taskAchievesCompetence,	model.createResource(resourceURI + competenceURI));

	    //competenceURI = "Determinar_Expressões_Regulares_que_representam_autômatos";
        //resourceMD.addProperty(LOMC.taskAchievesCompetence,	model.createResource(resourceURI + competenceURI));
	}	
	
	

	
    private static void printModel(Model model) {
		//System.out.println("------------------");
		//System.out.println("Arquivo em RDF/XML:");
		//System.out.println("------------------");		
		RDFDataMgr.write(System.out, model, Lang.RDFXML);
		
		//System.out.println("\n------------------");
		//System.out.println("Arquivo em TTL:");
		//System.out.println("------------------");		
		//RDFDataMgr.write(System.out, model, Lang.TTL);	 
    }
}

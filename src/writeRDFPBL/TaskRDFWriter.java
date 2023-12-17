package writeRDFPBL;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.DC;
import org.apache.jena.vocabulary.RDF;
import org.apache.jena.vocabulary.VCARD;

import vocabulary.CCS2012;
import vocabulary.FPK;
import vocabulary.LOM;
import vocabulary.LOMC;

public class TaskRDFWriter {
	private String resourceURI;
	private Model model;
	private Resource resourceMD;
	private Task task;

	public TaskRDFWriter(Task task, String resourceURI) {
		this.resourceURI = resourceURI;
		this.task = task;
		createRDFModel();
	}
	
	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
		createRDFModel();		
	}
	
	public Model getModel() {
		return model;
	}

	private void createRDFModel() {
		model = ModelFactory.createDefaultModel();
		model.setNsPrefix("lom", LOM.NS);
		model.setNsPrefix("lomc", LOMC.NS);		
		model.setNsPrefix("fpk", FPK.NS);
		model.setNsPrefix("cc2012", CCS2012.NS);		
		
		resourceMD = model.createResource(resourceURI);	
		resourceURI = resourceURI +"#";			
		

		addProperties(task);	
		for (Competency competency : task.getCompetencies()) {
			addCompetency(competency);
		}
	}

	private void addProperties(Task task) {
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
	
	private void addCompetency(Competency competence) {
		
	    resourceMD.addProperty(LOMC.educationalCompetency,	model.createResource(resourceURI + competence.getUri()));
		
		// Cria competência atômica	    
		Resource atomicComp = model.createResource(resourceURI + competence.getUri());
		atomicComp.addProperty(model.createProperty(LOMC.competenceStatement.toString()), competence.getStatement(), competence.getStatementLanguage());
		model.addLiteral(atomicComp, RDF.type, model.createResource(competence.getType().toString()));

		//Crias as propriedades Disposition
		Resource disposition;
		for (Disposition d: competence.getDispositions()) {
			disposition = model.createResource(LOMC.NS + d.getName());
			atomicComp.addProperty(model.createProperty(LOMC.NS, LOMC.hasDisposition.getLocalName()), disposition);		
		}

		Resource knowledgeSkill;
		for (KnowledgeSkill ks : competence.getPairsKnowledgeSkill()) {
			knowledgeSkill = model.createResource(resourceURI + ks.getUri());
			//knowledgeSkill = model.createResource();
			atomicComp.addProperty(model.createProperty(LOMC.hasKnowledgeSkill.toString()), knowledgeSkill);
	
			// Cria propriedade "hasKnowledge" e associa com um label em inglês
			//Resource knowledge = model.createResource()
		    //        .addProperty(model.createProperty(ks.getKnowledge().getURI(), "label"), ks.getKnowledge().getLabel());
			Resource knowledge = model.createResource(ks.getKnowledge().getURI() + ks.getKnowledge().getLabel());

			//if (ks.getKnowledge().getCategory() != "")
			//	knowledge.addProperty(model.createProperty(ks.getKnowledge().getURI(), "category"), ks.getKnowledge().getCategory());

			knowledgeSkill.addProperty(model.createProperty(LOMC.hasKnowledge.toString()), knowledge);
	
			// Associa skill com a competência
			knowledgeSkill.addProperty(model.createProperty(LOMC.hasSkill.toString()), 
					model.createResource(LOMC.NS + ks.getSkill().getLabel()));

		}
	}		
}

package writeRDFPBL;

import java.util.ArrayList;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.ResIterator;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.ResourceFactory;
import org.apache.jena.rdf.model.Statement;
import org.apache.jena.rdf.model.StmtIterator;
import org.apache.jena.vocabulary.DC;
import org.apache.jena.vocabulary.DC_11;
import org.apache.jena.vocabulary.RDF;
import org.apache.jena.vocabulary.RDFS;
import org.apache.jena.vocabulary.VCARD;

import vocabulary.CCS2012;
import vocabulary.CHA;
import vocabulary.LOM;
import vocabulary.LOMC;
import vocabulary.FPK;

public class TaskRDFReader {
	
	private String resourceURI = "https://eduknow.org/IMC.md";
	private Model model;
	private Resource resourceMD;
	private Task task;
	
	private String inputFileName  = "PBL.xml";
	
	ArrayList<String> competenceArray = new ArrayList<String>();
	ArrayList<String> knowledgeSkillArray = new ArrayList<String>();
	ArrayList<String> knowledgeArray = new ArrayList<String>();	

	public TaskRDFReader() {    
		model = ModelFactory.createDefaultModel();
	}

	public Task readTask(String inputFileName) {
		this.inputFileName = inputFileName;
		return readTask();
	}
	
	public Task readTask() {
		try {
			model.read( inputFileName );
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}

		task = new Task();
		
		resourceMD = model.getResource(resourceURI);

		readProperties();		
		readCreators();
		readCompetences();	
		
		return task;
	}
	
	public Task getTask() {
		return task;
	}


	public void setTask(Task task) {
		this.task = task;
	}


	private void readProperties() {
		String title = resourceMD.getRequiredProperty(DC.title).getString();		
		task.setTitle(title);	
		
		String type = ((Resource)resourceMD.getPropertyResourceValue(RDF.type)).getLocalName();
		task.setType(type);

		String otherPlatformRequirements = resourceMD.getRequiredProperty(LOM.otherPlatformRequirements).getString();
		task.setOtherPlatformRequirements(otherPlatformRequirements);

		String aggregationLevel = ((Resource)resourceMD.getPropertyResourceValue(LOM.aggregationLevel)).toString();
		task.setAggregationLevel(aggregationLevel);
		
		String rights = resourceMD.getRequiredProperty(DC.rights).getString();
		task.setCopyright(rights);		
		
		String cost = resourceMD.getRequiredProperty(LOM.cost).getString();
		task.setCost(cost);
		
		StmtIterator iter = resourceMD.listProperties(LOM.keyword);
		while (iter.hasNext()) {
			String keyword = iter.nextStatement().getObject().toString();
			task.addKeyword(keyword);
		}	

		String metaMetadataLanguage = resourceMD.getRequiredProperty(LOM.metaMetadataLanguage).getString();
		task.setMetaMetadataLanguage(metaMetadataLanguage);

		String structure =  ((Resource) resourceMD.getPropertyResourceValue(LOM.structure)).toString();
		task.setStructure(structure);

		String language = resourceMD.getRequiredProperty(DC.language).getString();
		task.setLanguage(language);
		
//		String copyrightAndOtherRestrictions = resourceMD.getRequiredProperty(LOM.copyrightAndOtherRestrictions).getString();

		String created = resourceMD.getRequiredProperty(DC.date).getString();		
		task.setCreationDate(created);	  

		String educationalContext = resourceMD.getRequiredProperty(LOM.educationalContext).getString();		
		task.setEducationalContext(educationalContext);

		String educationalDescription = resourceMD.getRequiredProperty(LOM.educationalDescription).getString();		
		task.setEducationalDescription(educationalDescription);	

		String learningResourceType = resourceMD.getRequiredProperty(LOM.learningResourceType).getString();		
		task.setLearningResourceType(learningResourceType);	
	}

	private void readCompetences() { 
		Knowledge knowledge = new Knowledge("", "");
		
		StmtIterator iter = resourceMD.listProperties(LOMC.educationalCompetency);
		while (iter.hasNext()) {
			String competenceURI = iter.nextStatement().getObject().toString();
			Competency competency = new Competency();
			competency.setUri(competenceURI);
			
			Resource competenceResource = model.getResource(competenceURI);
			Resource type = competenceResource.getPropertyResourceValue(RDF.type);
			competency.setType(type);
			competency.setStatement(competenceResource.getRequiredProperty(LOMC.competenceStatement).getString());
			competency.setStatementLanguage(competenceResource.getRequiredProperty(LOMC.competenceStatement).getLanguage());
			
			StmtIterator resIterator = competenceResource.listProperties(LOMC.hasKnowledgeSkill);
			while (resIterator.hasNext()) {
				String knowledgeSkillURI = ((Resource) resIterator.nextStatement().getObject()).toString();
				Resource knowledgeSkillResource = model.getResource(knowledgeSkillURI);
				
				Resource knowledgeResource = (Resource) knowledgeSkillResource.getProperty(LOMC.hasKnowledge).getObject();
				try {
					String knowledgeLabel = knowledgeResource.getRequiredProperty(CCS2012.label).getString();
					String knowledgeCategory = knowledgeResource.getRequiredProperty(CCS2012.category).getString();
					knowledge = new Knowledge(knowledgeLabel, knowledgeCategory);
				}catch (Exception e) {
					try {
						String knowledgeLabel = knowledgeResource.getRequiredProperty(FPK.label).getString();
						knowledge = new Knowledge(knowledgeLabel, "");
					}
					catch (Exception e2) {
						System.out.println(e2);				}
				}

				String skillResource = ((Resource)knowledgeSkillResource.getProperty(LOMC.hasSkill).getObject()).toString();
				Skill skill = new Skill(skillResource);
				KnowledgeSkill knowledgeSkill = new KnowledgeSkill(knowledge, skill);
				competency.addKnowledgeSkill(knowledgeSkill);
			}	

			resIterator = competenceResource.listProperties(LOMC.hasDisposition);
			while (resIterator.hasNext()) {
				String competenceHasDisposition = ((Resource) resIterator.nextStatement().getObject()).toString();
				Disposition disposition = new Disposition(competenceHasDisposition);
				competency.addDisposition(disposition);
			}			
			task.addCompetency(competency);
		}	
	}


	private void readCreators() {
		
		StmtIterator resIterator = resourceMD.listProperties(DC.creator);
		while (resIterator.hasNext()) {
			Resource r = (Resource) resIterator.nextStatement().getObject();
			
			String creatorName = r.getRequiredProperty(VCARD.FN).getString();			
			String creatorORG = r.getRequiredProperty(VCARD.ORG).getString();				
			String creatorEmail = r.getRequiredProperty(VCARD.EMAIL).getString();				
			Author author = new Author(creatorName, creatorORG, creatorEmail);
			task.addAuthor(author);
		}	

		StmtIterator iter = resourceMD.listProperties(DC.contributor);
		while (iter.hasNext()) {
			String contributor = iter.nextStatement().getObject().toString();
			task.addContributor(contributor);
		}			

	}


}

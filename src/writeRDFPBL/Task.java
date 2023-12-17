package writeRDFPBL;

import java.util.ArrayList;

import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.DC;
import org.apache.jena.vocabulary.RDF;
import org.apache.jena.vocabulary.VCARD;

import vocabulary.LOM;

public class Task {
	/**
	 * LOM and DC Properties
	 */
	private String otherPlatformRequirements;
	private String copyrightAndOtherRestrictions;
	private String cost;
	private String metaMetadataLanguage;
	private String language;	
	private String copyright;
	private String title;
	private String type;
	private String aggregationLevel;
	private String structure;	
	private String creationDate;
   	private String educationalContext;
   	private String learningResourceType;  
   	private String educationalDescription;

	private ArrayList<Author> authors = new ArrayList<Author>();
	private ArrayList<String> contributors = new ArrayList<String>();
	private ArrayList<String> keywords = new ArrayList<String>();
	
	/**
	 * LOMC Properties
	 */
	private ArrayList<Competency> competencies = new ArrayList<Competency>();
	
	public String getStructure() {
		return structure;
	}

	public void setStructure(String structure) {
		this.structure = structure;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getOtherPlatformRequirements() {
		return otherPlatformRequirements;
	}
	
	public void setOtherPlatformRequirements(String otherPlatformRequirements) {
		this.otherPlatformRequirements = otherPlatformRequirements;
	}
	
	public ArrayList<String> getKeywords() {
		return keywords;
	}
	
	public void setKeywords(ArrayList<String> keywords) {
		this.keywords = keywords;
	}
	
	public void addKeyword(String keyword) {
		keywords.add(keyword);
	}
	
	public void removeKeyword(String keyword) {
		keywords.remove(keyword);
	}
	
	public String getCopyrightAndOtherRestrictions() {
		return copyrightAndOtherRestrictions;
	}
	
	public void setCopyrightAndOtherRestrictions(String copyrightAndOtherRestrictions) {
		this.copyrightAndOtherRestrictions = copyrightAndOtherRestrictions;
	}
	
	public String getCost() {
		return cost;
	}
	
	public void setCost(String cost) {
		this.cost = cost;
	}
	
	public String getMetaMetadataLanguage() {
		return metaMetadataLanguage;
	}
	
	public void setMetaMetadataLanguage(String metaMetadataLanguage) {
		this.metaMetadataLanguage = metaMetadataLanguage;
	}
	
	public String getLanguage() {
		return language;
	}
	
	public void setLanguage(String language) {
		this.language = language;
	}
	
	public String getCopyright() {
		return copyright;
	}
	
	public void setCopyright(String rights) {
		this.copyright = rights;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getAggregationLevel() {
		return aggregationLevel;
	}
	
	public void setAggregationLevel(String aggregationLevel) {
		this.aggregationLevel = aggregationLevel;
	}
	
	public ArrayList<Author> getAuthors() {
		return authors;
	}
	
	public void setAuthors(ArrayList<Author> authors) {
		this.authors = authors;
	}
	
	public void addAuthor(Author author) {
		authors.add(author);
	}

	public void removeAuthor(Author author) {
		authors.remove(author);
	}
	
	public ArrayList<String> getContributors() {
		return contributors;
	}
	
	public void setContributors(ArrayList<String> contributors) {
		this.contributors = contributors;
	}
	
	public void addContributor(String contributor) {
		contributors.add(contributor);
	}
	
	public String getCreationDate() {
		return creationDate;
	}
	
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	
	public String getEducationalContext() {
		return educationalContext;
	}
	
	public void setEducationalContext(String educationalContext) {
		this.educationalContext = educationalContext;
	}
	
	public String getLearningResourceType() {
		return learningResourceType;
	}
	
	public void setLearningResourceType(String learningResourceType) {
		this.learningResourceType = learningResourceType;
	}
	
	public String getEducationalDescription() {
		return educationalDescription;
	}
	
	public void setEducationalDescription(String educationalDescription) {
		this.educationalDescription = educationalDescription;
	}

	public ArrayList<Competency> getCompetencies() {
		return competencies;
	}

	public void setCompetencies(ArrayList<Competency> competencies) {
		this.competencies = competencies;
	}
	
	public void addCompetency(Competency competency) {
		competencies.add(competency);
	}
	
	public void removeCompetency(Competency competency) {
		competencies.remove(competency);
	}
	
}

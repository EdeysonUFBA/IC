package competence;

import java.util.ArrayList;

import ieee.rcd.Definition;
import ieee.rcd.LangString;
import ieee.rcd.LongIdentifierType;
import ieee.rcd.Metadata;

public abstract class Competence {
	private LongIdentifierType identifier;  //Mandatory		1..1
	private ArrayList<LangString> title = new ArrayList<LangString>();	//Mandatory	1..1
	private ArrayList<LangString>  description = new ArrayList<LangString>();  	//Optional	0..1
	private ArrayList<Definition> definition = new ArrayList<Definition>();	//Optional	0..n
	private Metadata metadata;	//Optional	0..1
	
	public Competence(LongIdentifierType identifier, ArrayList<LangString> titleBag) {
		super();
		this.identifier = identifier;
		this.title = titleBag;
	}
	
	public Competence(LongIdentifierType identifier, LangString title) {
		super();
		this.identifier = identifier;
		this.title.add(title);
	}

	public LongIdentifierType getIdentifier() {
		return identifier;
	}

	public void setIdentifier(LongIdentifierType identifier) {
		this.identifier = identifier;
	}

	public ArrayList<LangString> getTitle() {
		return title;
	}

	public void setTitle(ArrayList<LangString> title) {
		this.title = title;
	}

	public void addTitle(LangString title) {
		this.title.add(title);		
	}
	
	public void removeTitle(LangString title) {
		this.title.remove(title);		
	}
	
	public ArrayList<LangString> getDescription() {
		return description;
	}

	public void setDescription(ArrayList<LangString> description) {
		this.description = description;
	}
	
	public void addDescription(LangString description) {
		this.description.add(description);
	}
	
	public void removeDescription(LangString description) {
		this.description.remove(description);
	}
		
	public ArrayList<Definition> getDefinition() {
		return definition;
	}

	public void setDefinition(ArrayList<Definition> definition) {
		this.definition = definition;
	}

	public void addDefinition(Definition definition) {
		this.definition.add(definition);
	}
	
	public void removeDefinition(Definition definition) {
		this.definition.remove(definition);
	}
	
	public Metadata getMetadata() {
		return metadata;
	}

	public void setMetadata(Metadata metadata) {
		this.metadata = metadata;
	}	
}

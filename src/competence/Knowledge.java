package competence;

import java.util.ArrayList;

import ieee.rcd.LangString;
import ieee.rcd.LongIdentifierType;

public class Knowledge {
	private LongIdentifierType iri;
	private LangString label;
	private String category;
	
	
	public Knowledge(LangString label) {
		super();
		this.label = label;
	}	
	
	public Knowledge(LongIdentifierType iri, LangString name) {
		super();
		this.iri = iri;
		this.label = name;
	}
	
	public Knowledge(LongIdentifierType iri, LangString label, String category) {
		super();
		this.iri = iri;
		this.label = label;
		this.category = category;
	}

	public LongIdentifierType getIri() {
		return iri;
	}

	public void setIri(LongIdentifierType iri) {
		this.iri = iri;
	}

	public LangString getName() {
		return label;
	}

	public void setName(LangString name) {
		this.label = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}
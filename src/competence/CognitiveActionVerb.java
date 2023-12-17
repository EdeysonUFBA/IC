package competence;

import ieee.rcd.LangString;

public class CognitiveActionVerb {
	private LangString name;
	private LangString description;
	
	public CognitiveActionVerb(LangString name, LangString description) {
		super();
		this.name = name;
		this.description = description;
	}

	public LangString getName() {
		return name;
	}

	public void setName(LangString name) {
		this.name = name;
	}

	public LangString getDescription() {
		return description;
	}

	public void setDescription(LangString description) {
		this.description = description;
	}
	
	
}

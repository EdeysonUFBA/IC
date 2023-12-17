package competence;

import ieee.rcd.LangString;

public abstract class Skill {
	private int level;
	private LangString description;
	private LangString name;
	
	public Skill(int level, LangString description, LangString name) {
		super();
		this.level = level;
		this.description = description;
		this.name = name;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public LangString getDescription() {
		return description;
	}

	public void setDescription(LangString description) {
		this.description = description;
	}

	public LangString getName() {
		return name;
	}

	public void setName(LangString name) {
		this.name = name;
	}
	
	
}

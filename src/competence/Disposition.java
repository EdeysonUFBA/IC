package competence;

import ieee.rcd.LangString;

public class Disposition {
	private LangString name;

	public Disposition(LangString name) {
		super();
		this.name = name;
	}

	public LangString getName() {
		return name;
	}

	public void setName(LangString name) {
		this.name = name;
	}
}

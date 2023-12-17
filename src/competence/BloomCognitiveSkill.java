package competence;

import java.util.ArrayList;

import ieee.rcd.LangString;

public abstract class BloomCognitiveSkill extends Skill {
	public ArrayList<CognitiveActionVerb> actionVerbs = new ArrayList<CognitiveActionVerb>();

	public BloomCognitiveSkill(int level, LangString description, LangString name) {
		super(level, description, name);
	}
	
	public BloomCognitiveSkill(int level, LangString description, LangString name,
			ArrayList<CognitiveActionVerb> actionVerbs) {
		super(level, description, name);
		this.actionVerbs = actionVerbs;
	}

	public ArrayList<CognitiveActionVerb> getActionVerbs() {
		return actionVerbs;
	}

	public void setActionVerbs(ArrayList<CognitiveActionVerb> actionVerbs) {
		this.actionVerbs = actionVerbs;
	}
	
	public void addActionVerb(CognitiveActionVerb actionVerb) {
		this.actionVerbs.add(actionVerb);
	}
	
	public void removeActionVerb(CognitiveActionVerb actionVerb) {
		this.actionVerbs.remove(actionVerb);
	}	
}

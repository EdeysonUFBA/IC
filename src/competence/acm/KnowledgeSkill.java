package competence.acm;

import competence.Knowledge;
import competence.Skill;

public class KnowledgeSkill {
	private Knowledge knowledge;
	private Skill skill;
	
	public KnowledgeSkill(Knowledge knowledge, Skill skill) {
		super();
		this.knowledge = knowledge;
		this.skill = skill;
	}

	public Knowledge getKnowledge() {
		return knowledge;
	}

	public void setKnowledge(Knowledge knowledge) {
		this.knowledge = knowledge;
	}

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}
	
	
}

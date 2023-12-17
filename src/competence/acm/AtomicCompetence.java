package competence.acm;

import java.util.ArrayList;

import competence.Competence;
import ieee.rcd.LangString;
import ieee.rcd.LongIdentifierType;

public class AtomicCompetence extends ACMCompetence {
	private ArrayList<KnowledgeSkill> knowledgeSkills = new ArrayList<KnowledgeSkill>();
	
	public AtomicCompetence(LongIdentifierType identifier, ArrayList<LangString> titleBag) {
		super(identifier, titleBag);
	}

	public AtomicCompetence(LongIdentifierType identifier, LangString title) {
		super(identifier, title);
	}	
	
	public ArrayList<KnowledgeSkill> getKnowledgeSkills() {
		return knowledgeSkills;
	}

	public void setKnowledgeSkilla(ArrayList<KnowledgeSkill> knowledgeSkills) {
		this.knowledgeSkills = knowledgeSkills;
	}	
	
	public void addKnowledgeSkill(KnowledgeSkill knowledgeSkill) {
		this.knowledgeSkills.add(knowledgeSkill);
	}	

	public void removeKnowledgeSkill(KnowledgeSkill knowledgeSkill) {
		this.knowledgeSkills.remove(knowledgeSkill);
	}	
}

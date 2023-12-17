package writeRDFPBL;

public class KnowledgeSkill {
	private Knowledge knowledge;
	private Skill skill;
	private String label;
	private String uri;
	
	public KnowledgeSkill(Knowledge knowledge, Skill skill, String label) {
		super();
		this.knowledge = knowledge;
		this.skill = skill;
		this.label = label;
		setUri("KS_" + skill.getLabel() + "_" + knowledge.getLabel().replace(" ", "_"));
	}

	public KnowledgeSkill(Knowledge knowledge, Skill skill) {
		this(knowledge, skill, "");
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
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

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
	
}

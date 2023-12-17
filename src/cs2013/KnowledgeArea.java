package cs2013;

import java.util.ArrayList;

public class KnowledgeArea  implements Comparable<KnowledgeArea>{
	private String code;
	private String name;
	private String description;
	private ArrayList<KnowledgeUnit> knowledgeUnits = new ArrayList<KnowledgeUnit>();
	
	
	public KnowledgeArea() {
		super();
	}

	public KnowledgeArea(String code, String name) {
		super();
		this.name = name;
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public ArrayList<KnowledgeUnit> getKnowledgeUnits() {
		return knowledgeUnits;
	}

	public void setKnowledgeUnits(ArrayList<KnowledgeUnit> knowledgeUnits) {
		this.knowledgeUnits = knowledgeUnits;
	} 
	
	public void addKnowledgeUnit(KnowledgeUnit knowledgeUnit) {
		this.knowledgeUnits.add(knowledgeUnit);
	} 
	
	public void removeKnowledgeUnit(KnowledgeUnit knowledgeUnit) {
		this.knowledgeUnits.remove(knowledgeUnit);
	} 
	@Override
	public int compareTo(KnowledgeArea k) {
		return this.name.compareTo(k.getName());	
	}		
}

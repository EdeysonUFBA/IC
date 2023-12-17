package cs2013;

import java.util.ArrayList;

public class KnowledgeUnit implements Comparable<KnowledgeUnit>{
	private String name;
	private ArrayList<Topic> topics = new ArrayList<Topic>();
	private ArrayList<LearningOutcome> learningOutcomes = new ArrayList<LearningOutcome>();
	
	
	public KnowledgeUnit() {
		super();
	}

	public KnowledgeUnit(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Topic> getTopics() {
		return topics;
	}

	public void setTopics(ArrayList<Topic> topics) {
		this.topics = topics;
	}
	
	public void addTopic(Topic topic) {
		this.topics.add(topic);
	}	

	public ArrayList<LearningOutcome> getLearningOutcomes() {
		return learningOutcomes;
	}

	public void setLearningOutcomes(ArrayList<LearningOutcome> learningOutcomes) {
		this.learningOutcomes = learningOutcomes;
	}
	
	public void addtLearningOutcome(LearningOutcome learningOutcome) {
		this.learningOutcomes.add(learningOutcome);
	}
	
	@Override
	public int compareTo(KnowledgeUnit k) {
		return this.name.compareTo(k.getName());	
	}	
}

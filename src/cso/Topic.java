package cso;

import java.util.ArrayList;

public class Topic {
	/** We use this relation to indicate that the research output of one topic contributes to another. */
	private ArrayList<Topic> contributesTo = new ArrayList<Topic>();
	/**We use this relationship to declare that the subject topic need to use the label of the object topic for presentation purposes.*/
	private ArrayList<Topic> preferentialEquivalent = new ArrayList<Topic>();
	/** We use this relationship to identify that two potentially distinct research concepts are treated as equivalent in the context of the CSO. */
	private ArrayList<Topic> relatedEquivalent = new ArrayList<Topic>();
	/**We use this relation to indicate that a :Topic is a sub-area of another one. This is the inverse of :superTopicOf */
	private ArrayList<Topic> subTopicOf = new ArrayList<Topic>();
	/**We use this relation to indicate that a :Topic is a super-area of another one.*/
	private ArrayList<Topic> superTopicOf = new ArrayList<Topic>();
	
	private String description;
	private String label;
	private String type;
	private ArrayList<String> sameAs = new ArrayList<String>();
	private ArrayList<String> relatedLink = new ArrayList<String>();
	
	public Topic(String description) {
		super();
		this.description = description;
	}
		
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ArrayList<Topic> getContributesTo() {
		return contributesTo;
	}
	
	public void setContributesTo(ArrayList<Topic> contributesTo) {
		this.contributesTo = contributesTo;
	}
	
	public void addContributesTo(Topic contributesTo) {
		this.contributesTo.add(contributesTo);
	}
	
	public ArrayList<Topic> getPreferentialEquivalent() {
		return preferentialEquivalent;
	}
	
	public void setPreferentialEquivalent(ArrayList<Topic> preferentialEquivalent) {
		this.preferentialEquivalent = preferentialEquivalent;
	}
	
	public void addPreferentialEquivalent(Topic preferentialEquivalent) {
		this.preferentialEquivalent.add(preferentialEquivalent);
	}	
	
	public ArrayList<Topic> getRelatedEquivalent() {
		return relatedEquivalent;
	}
	
	public void setRelatedEquivalent(ArrayList<Topic> relatedEquivalent) {
		this.relatedEquivalent = relatedEquivalent;
	}
	
	public void addRelatedEquivalent(Topic relatedEquivalent) {
		this.relatedEquivalent.add(relatedEquivalent);
	}	
	
	public ArrayList<Topic> getSubTopicOf() {
		return subTopicOf;
	}
	
	public void setSubTopicOf(ArrayList<Topic> subTopicOf) {
		this.subTopicOf = subTopicOf;
	}
	
	public void addSubTopicOf(Topic topic) {
		this.subTopicOf.add(topic);
	}	
	
	public ArrayList<Topic> getSuperTopicOf() {
		return superTopicOf;
	}
	
	public void setSuperTopicOf(ArrayList<Topic> superTopicOf) {
		this.superTopicOf = superTopicOf;
	}
	
	public void addSuperTopicOf(Topic topic) {
		this.superTopicOf.add(topic);
	}
	
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public ArrayList<String> getSameAs() {
		return sameAs;
	}
	
	public void setSameAs(ArrayList<String> sameAs) {
		this.sameAs = sameAs;
	}
	
	public void addSameAs(String sameAs) {
		this.sameAs.add(sameAs);
	}
	
	public ArrayList<String> getRelatedLink() {
		return relatedLink;
	}
	
	public void setRelatedLink(ArrayList<String> relatedLink) {
		this.relatedLink = relatedLink;
	}
	
	public void addRelatedLink(String relatedLink) {
		this.relatedLink.add(relatedLink);
	}	
	
}

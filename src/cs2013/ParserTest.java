package cs2013;

import java.util.ArrayList;

public class ParserTest {

	public static void main(String[] args) {
		BoKCS2013Parser bok2013 = new BoKCS2013Parser();
		ArrayList<KnowledgeArea> areas = bok2013.getBoKCS2013();
		ArrayList<KnowledgeUnit> units;
		ArrayList<Topic> topics, topicsN1, topicsN2;
		
		for (KnowledgeArea knowledgeArea : areas) {
			System.out.println(knowledgeArea.getName());
			units = knowledgeArea.getKnowledgeUnits();
			for (KnowledgeUnit knowledgeUnit : units) {
				System.out.println("\t" + knowledgeUnit.getName());
				topics = knowledgeUnit.getTopics();
				topics.sort(null);
				for (Topic topic : topics) {
					System.out.println("\t\t" + topic.getDescricao());
					topicsN1 = topic.getSubtopic();
					topicsN1.sort(null);
					for (Topic topicN1 : topicsN1) {
						System.out.println("\t\t\t" + topicN1.getDescricao());
						topicsN2 = topicN1.getSubtopic();
						topicsN2.sort(null);
						for (Topic topicN2 : topicsN2) {
							System.out.println("\t\t\t\t" + topicN2.getDescricao());
						}
					}
					
				}
			}
		}

	}

}

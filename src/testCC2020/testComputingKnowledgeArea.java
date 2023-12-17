package testCC2020;

import java.util.ArrayList;
import java.util.Iterator;

import competence.Knowledge;

public class testComputingKnowledgeArea {

	public static void main(String[] args) {
		ComputingKnowledgeArea computingKnowledgeArea = new ComputingKnowledgeArea();
		ArrayList<Knowledge> computingKnowledgeAreas = computingKnowledgeArea.getComputingKnowledgeAreas();
		
		for (Iterator iterator = computingKnowledgeAreas.iterator(); iterator.hasNext();) {
			Knowledge knowledge = (Knowledge) iterator.next();
			System.out.println("Knowledge: " + knowledge.getName().getString());
/*			if (knowledge.getBroader() != null)
				System.out.println("\t Broader: " + knowledge.getBroader().getName().getString());
			if (knowledge.getNarrower().size() > 0)
				for (Iterator iterator2 = knowledge.getNarrower().iterator(); iterator2.hasNext();) {
					Knowledge narrower = (Knowledge) iterator2.next();
					System.out.println("\t \t Narrower: " + narrower.getName().getString());					
				}
*/				
		}
	}

}

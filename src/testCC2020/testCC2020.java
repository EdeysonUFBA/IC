package testCC2020;

import java.util.ArrayList;
import java.util.Iterator;

import competence.Knowledge;
import ieee.rcd.LangString;
import ieee.rcd.LongIdentifierType;

public class testCC2020 {
	static ArrayList<Knowledge> computingKnowledgeAreas = new ArrayList<Knowledge>();


	public static void main(String[] args) {
		defineComputingKnowledgeAreas();
		for (Iterator iterator = computingKnowledgeAreas.iterator(); iterator.hasNext();) {
			Knowledge knowledge = (Knowledge) iterator.next();
			System.out.println("Knowledge: " + knowledge.getName().getString());
//			if (knowledge.getBroader() != null)
//				System.out.println("\t Broader: " + knowledge.getBroader().getName().getString());
/*			if (knowledge.getNarrower().size() > 0)
				for (Iterator iterator2 = knowledge.getNarrower().iterator(); iterator2.hasNext();) {
					Knowledge narrower = (Knowledge) iterator2.next();
					System.out.println("\t \t Narrower: " + narrower.getName().getString());					
				}
*/				
		}
	}

	
	private static void defineComputingKnowledgeAreas() {
		LongIdentifierType iri;
		LangString name;
		
		iri = new LongIdentifierType("CC2020", "K(C-1)");
		name = new LangString("en", "Users and Organizations");		
		Knowledge knowledgeC1 = new Knowledge(iri, name);
		computingKnowledgeAreas.add(knowledgeC1);
		
		addComputingKnowledgeAreasNode(knowledgeC1, "K(C-1.1)", "Social Issues and Professional Practice");
		addComputingKnowledgeAreasNode(knowledgeC1, "K(C-1.2)", "Security Policy and Management");
		addComputingKnowledgeAreasNode(knowledgeC1, "K(C-1.3)", "IS Management and Leadership");
		addComputingKnowledgeAreasNode(knowledgeC1, "K(C-1.4)", "Enterprise Architecture");
		addComputingKnowledgeAreasNode(knowledgeC1, "K(C-1.5)", "Project Management");
		addComputingKnowledgeAreasNode(knowledgeC1, "K(C-1.6)", "User Experience Design");
	
		iri = new LongIdentifierType("CC2020", "K(C-2)");
		name = new LangString("en", "Systems Modeling");			
		Knowledge knowledgeC2 = new Knowledge(iri, name);
		computingKnowledgeAreas.add(knowledgeC2);	
		
		addComputingKnowledgeAreasNode(knowledgeC2, "K(C-2.1)", "Security Issues and Principles");
		addComputingKnowledgeAreasNode(knowledgeC2, "K(C-2.2)", "Systems Analysis and Design");
		addComputingKnowledgeAreasNode(knowledgeC2, "K(C-2.3)", "Requirements Analysis and Specification");
		addComputingKnowledgeAreasNode(knowledgeC2, "K(C-2.4)", "Data and Information Management");
		
		iri = new LongIdentifierType("CC2020", "K(C-3)");
		name = new LangString("en", "Systems Architecture and Infrastructure");			
		Knowledge knowledgeC3 = new Knowledge(iri, name);
		computingKnowledgeAreas.add(knowledgeC3);
		
		addComputingKnowledgeAreasNode(knowledgeC3, "K(C-3.1)", "Virtual Systems and Services");
		addComputingKnowledgeAreasNode(knowledgeC3, "K(C-3.2)", "Intelligent Systems (AI)");
		addComputingKnowledgeAreasNode(knowledgeC3, "K(C-3.3)", "Internet of Things");
		addComputingKnowledgeAreasNode(knowledgeC3, "K(C-3.4)", "Parallel and Distributed Computing");
		addComputingKnowledgeAreasNode(knowledgeC3, "K(C-3.5)", "Computer Networks");
		addComputingKnowledgeAreasNode(knowledgeC3, "K(C-3.6)", "Embedded Systems");		
		addComputingKnowledgeAreasNode(knowledgeC3, "K(C-3.7)", "Integrated Systems Technology");
		addComputingKnowledgeAreasNode(knowledgeC3, "K(C-3.8)", "Platform Technologies");
		addComputingKnowledgeAreasNode(knowledgeC3, "K(C-3.9)", "Security Technology and Implementation");		

		iri = new LongIdentifierType("CC2020", "K(C-4)");
		name = new LangString("en", "Software Development");			
		Knowledge knowledgeC4 = new Knowledge(iri, name);
		computingKnowledgeAreas.add(knowledgeC4);
		
		addComputingKnowledgeAreasNode(knowledgeC4, "K(C-4.1)", "Software Quality, Verification and Validation");
		addComputingKnowledgeAreasNode(knowledgeC4, "K(C-4.2)", "Software Process");
		addComputingKnowledgeAreasNode(knowledgeC4, "K(C-4.3)", "Software Modeling and Analysis");
		addComputingKnowledgeAreasNode(knowledgeC4, "K(C-4.4)", "Software Design");
		addComputingKnowledgeAreasNode(knowledgeC4, "K(C-4.5)", "Platform-Based Development");

		iri = new LongIdentifierType("CC2020", "K(C-5)");
		name = new LangString("en", "Software Fundamentals");			
		Knowledge knowledgeC5 = new Knowledge(iri, name);
		computingKnowledgeAreas.add(knowledgeC5);
		
		addComputingKnowledgeAreasNode(knowledgeC5, "K(C-5.1)", "Graphics and Visualization");
		addComputingKnowledgeAreasNode(knowledgeC5, "K(C-5.2)", "Operating Systems");
		addComputingKnowledgeAreasNode(knowledgeC5, "K(C-5.3)", "Data Structures, Algorithms and Complexity");
		addComputingKnowledgeAreasNode(knowledgeC5, "K(C-5.4)", "Programming Languages");
		addComputingKnowledgeAreasNode(knowledgeC5, "K(C-5.5)", "Programming Fundamentals");
		addComputingKnowledgeAreasNode(knowledgeC5, "K(C-5.6)", "Computing Systems Fundamentals");		

		iri = new LongIdentifierType("CC2020", "K(C-6)");
		name = new LangString("en", "Hardware");			
		Knowledge knowledgeC6 = new Knowledge(iri, name);
		computingKnowledgeAreas.add(knowledgeC6);
		
		addComputingKnowledgeAreasNode(knowledgeC6, "K(C-6.1)", "Architecture and Organization");
		addComputingKnowledgeAreasNode(knowledgeC6, "K(C-6.2)", "Digital Design");
		addComputingKnowledgeAreasNode(knowledgeC6, "K(C-6.3)", "Circuits and Electronics");
		addComputingKnowledgeAreasNode(knowledgeC6, "K(C-6.4)", "Signal Processing");
	}
	
	private static void addComputingKnowledgeAreasNode(Knowledge broader, String entry, String knowledgeName) {
		LongIdentifierType iri = new LongIdentifierType("CC2020", entry);
		LangString name = new LangString("en", knowledgeName);			
		Knowledge knowledge = new Knowledge(iri, name);
//		knowledge.setBroader(broader);
//		broader.addNarrower(knowledge);		
		computingKnowledgeAreas.add(knowledge);		
	}
	
}

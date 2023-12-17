package testCC2020;

import java.util.ArrayList;

import competence.Knowledge;
import ieee.rcd.LangString;
import ieee.rcd.LongIdentifierType;

public class ProfessionalFoundationalKnowledgeArea {
	private ArrayList<Knowledge> professionalFoundationalKnowledgeAreas = new ArrayList<Knowledge>();

	public ProfessionalFoundationalKnowledgeArea() {
		super();
		defineKnowledgeAreas();		
	}

	public ArrayList<Knowledge> getComputingKnowledgeAreas() {
		return professionalFoundationalKnowledgeAreas;
	}

	private void defineKnowledgeAreas() {
		LongIdentifierType iri;
		LangString name;
		
		iri = new LongIdentifierType("CC2020", "K(P-1)");
		name = new LangString("en", "Oral Communication e Preentation");		
		Knowledge knowledgeP1 = new Knowledge(iri, name);
		professionalFoundationalKnowledgeAreas.add(knowledgeP1);
		
		iri = new LongIdentifierType("CC2020", "K(P-2)");
		name = new LangString("en", "Written Communication");			
		Knowledge knowledgeP2 = new Knowledge(iri, name);
		professionalFoundationalKnowledgeAreas.add(knowledgeP2);	
		
		iri = new LongIdentifierType("CC2020", "K(P-3)");
		name = new LangString("en", "Problem Solving and Trouble-Shooting");			
		Knowledge knowledgeP3 = new Knowledge(iri, name);
		professionalFoundationalKnowledgeAreas.add(knowledgeP3);
		
		iri = new LongIdentifierType("CC2020", "K(P-4)");
		name = new LangString("en", "Project and Task Organization and Planning");			
		Knowledge knowledgeP4 = new Knowledge(iri, name);
		professionalFoundationalKnowledgeAreas.add(knowledgeP4);
		
		iri = new LongIdentifierType("CC2020", "K(P-5)");
		name = new LangString("en", "Collaboration and Teamwork");			
		Knowledge knowledgeP5 = new Knowledge(iri, name);
		professionalFoundationalKnowledgeAreas.add(knowledgeP5);
		
		iri = new LongIdentifierType("CC2020", "K(P-6)");
		name = new LangString("en", "Research and Self-Starter/Learner");			
		Knowledge knowledgeP6 = new Knowledge(iri, name);
		professionalFoundationalKnowledgeAreas.add(knowledgeP6);

		iri = new LongIdentifierType("CC2020", "K(P-7)");
		name = new LangString("en", "Multi-Task Priorization and Management");			
		Knowledge knowledgeP7 = new Knowledge(iri, name);
		professionalFoundationalKnowledgeAreas.add(knowledgeP7);

		iri = new LongIdentifierType("CC2020", "K(P-8)");
		name = new LangString("en", "Relasionship Management");			
		Knowledge knowledgeP8 = new Knowledge(iri, name);
		professionalFoundationalKnowledgeAreas.add(knowledgeP8);
		
		iri = new LongIdentifierType("CC2020", "K(P-9)");
		name = new LangString("en", "Analytical and Critical Thinking");			
		Knowledge knowledgeP9 = new Knowledge(iri, name);
		professionalFoundationalKnowledgeAreas.add(knowledgeP9);	

		iri = new LongIdentifierType("CC2020", "K(P-10)");
		name = new LangString("en", "Time Management");			
		Knowledge knowledgeP10 = new Knowledge(iri, name);
		professionalFoundationalKnowledgeAreas.add(knowledgeP10);	
		
		iri = new LongIdentifierType("CC2020", "K(P-11)");
		name = new LangString("en", "Quality Assurance / Control");			
		Knowledge knowledgeP11 = new Knowledge(iri, name);
		professionalFoundationalKnowledgeAreas.add(knowledgeP11);
		
		iri = new LongIdentifierType("CC2020", "K(P-12)");
		name = new LangString("en", "Mathematics and Statistics");			
		Knowledge knowledgeP12 = new Knowledge(iri, name);
		professionalFoundationalKnowledgeAreas.add(knowledgeP12);
		
		iri = new LongIdentifierType("CC2020", "K(P-13)");
		name = new LangString("en", "Ethical and Intercultural Perspectives");			
		Knowledge knowledgeP13 = new Knowledge(iri, name);
		professionalFoundationalKnowledgeAreas.add(knowledgeP13);		
	}
	

}

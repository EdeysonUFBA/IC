package competence.acm;

import java.util.ArrayList;

import competence.Competence;
import ieee.rcd.LangString;
import ieee.rcd.LongIdentifierType;

public class ComposedCompetence extends ACMCompetence {
	private ArrayList<AtomicCompetence> atomicCompetence = new ArrayList<AtomicCompetence>();
	
	public ComposedCompetence(LongIdentifierType identifier, ArrayList<LangString> titleBag) {
		super(identifier, titleBag);
	}

	public ComposedCompetence(LongIdentifierType identifier, LangString title) {
		super(identifier, title);
	}

	public ArrayList<AtomicCompetence> getAtomicCompetence() {
		return atomicCompetence;
	}

	public void setAtomicCompetence(ArrayList<AtomicCompetence> atomicCompetence) {
		this.atomicCompetence = atomicCompetence;
	}	
	
	public void addAtomicCompetence(AtomicCompetence atomicCompetence) {
		this.atomicCompetence.add(atomicCompetence);
	}
	
	public void removeAtomicCompetence(AtomicCompetence atomicCompetence) {
		this.atomicCompetence.remove(atomicCompetence);
	}	
}

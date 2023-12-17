package competence.acm;

import java.util.ArrayList;

import competence.Competence;
import competence.Disposition;
import ieee.rcd.LangString;
import ieee.rcd.LongIdentifierType;

public class ACMCompetence extends Competence {
	private ArrayList<Disposition> dispositions = new ArrayList<Disposition>();

	public ACMCompetence(LongIdentifierType identifier, ArrayList<LangString> titleBag) {
		super(identifier, titleBag);
	}

	public ACMCompetence(LongIdentifierType identifier, LangString title) {
		super(identifier, title);
	}

	public ACMCompetence(LongIdentifierType identifier, ArrayList<LangString> titleBag,
			ArrayList<Disposition> dispositions) {
		super(identifier, titleBag);
		this.dispositions = dispositions;
	}
	
	public ACMCompetence(LongIdentifierType identifier, ArrayList<LangString> titleBag,
			Disposition disposition) {
		super(identifier, titleBag);
		this.dispositions.add(disposition);
	}

	public ArrayList<Disposition> getDispositions() {
		return dispositions;
	}

	public void setDispositions(ArrayList<Disposition> dispositions) {
		this.dispositions = dispositions;
	}
	
	public void addDisposition(Disposition disposition) {
		this.dispositions.add(disposition);
	}	

	public void removeDisposition(Disposition disposition) {
		this.dispositions.remove(disposition);
	}	
}

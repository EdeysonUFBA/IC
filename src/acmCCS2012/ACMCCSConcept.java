package acmCCS2012;

import java.util.ArrayList;
/**
	An ACMCCSconcept represents a concept in the ACM CCS 2012 file.
	Each ACMCCSconcept is a SKOS element - Simple Knowledge Organization System.
 */
public class ACMCCSConcept {
	private String code;
	private String type;
	private String prefLabel;
	private ArrayList<String> narrower = new ArrayList<String>(); 
	private String broader;
	private String topConceptOf;
	private String hasTopConcept;
	
	
	public ACMCCSConcept(String code) {
		super();
		this.code = code;
	}

	public ACMCCSConcept(String code, String prefLabel) {
		super();
		this.code = code;
		this.prefLabel = prefLabel;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPerfLabel() {
		return prefLabel;
	}

	public void setPerfLabel(String perfLabel) {
		this.prefLabel = perfLabel;
	}

	public void addNarrower(String narrower) {
		this.narrower.add(narrower);
	}
	
	public ArrayList<String> getNarrower() {
		return narrower;
	}

	public void setNarrower(ArrayList<String> narrower) {
		this.narrower = narrower;
	}

	public String getBroader() {
		return broader;
	}

	public void setBroader(String broader) {
		this.broader = broader;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTopConceptOf() {
		return topConceptOf;
	}

	public void setTopConceptOf(String topConceptOf) {
		this.topConceptOf = topConceptOf;
	}

	public String getHasTopConcept() {
		return hasTopConcept;
	}

	public void setHasTopConcept(String hasTopConcept) {
		this.hasTopConcept = hasTopConcept;
	}
	
	public String toString() {
		return prefLabel;
		//return "Code: " + code + " Type: " + type + " Label: " + perfLabel + "\n Broader: " + broader +
		//		" Top: " + topConceptOf + " hasTop: " + hasTopConcept + "\n" +
		//		" Narrower: " + narrower;
	}
	
	
}

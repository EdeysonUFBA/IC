package writeRDFPBL;

import java.util.ArrayList;

import org.apache.jena.rdf.model.Resource;

public class Competency {
	private String title = "";
	private String statement = "";
	private String statementLanguage = "";
	
	private String uri = "";
	private Resource type;
	
	private ArrayList<Disposition> dispositions = new ArrayList<Disposition>();
	private ArrayList <KnowledgeSkill> pairsKnowledgeSkill = new ArrayList<KnowledgeSkill>();
	
	public Competency() {
		super();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStatement() {
		return statement;
	}

	public void setStatement(String statement) {
		this.statement = statement;
		//this.setUri(statement.replace(" ", "_"));		
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public ArrayList<Disposition> getDispositions() {
		return dispositions;
	}

	public void setDispositions(ArrayList<Disposition> dispositions) {
		this.dispositions = dispositions;
	}

	public void addDisposition (Disposition disposition) {
		this.dispositions.add(disposition);
	}
	
	public ArrayList<KnowledgeSkill> getPairsKnowledgeSkill() {
		return pairsKnowledgeSkill;
	}

	public void addKnowledgeSkill(KnowledgeSkill knowledgeSkill) {
		this.pairsKnowledgeSkill.add(knowledgeSkill);
	}

	
	public void setPairsKnowledgeSkill(ArrayList<KnowledgeSkill> pairsKnowledgeSkill) {
		this.pairsKnowledgeSkill = pairsKnowledgeSkill;
	}

	public String getStatementLanguage() {
		return statementLanguage;
	}

	public void setStatementLanguage(String statementLanguage) {
		this.statementLanguage = statementLanguage;
	}

	public Resource getType() {
		return type;
	}

	public void setType(Resource type) {
		this.type = type;
	}
	
	
	
}

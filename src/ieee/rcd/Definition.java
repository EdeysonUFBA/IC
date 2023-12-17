package ieee.rcd;

import java.util.ArrayList;

public class Definition {
	private String modelSource;
	private ArrayList<Statement> statement = new ArrayList<Statement>() ;	//1..n
	
	public Definition(String modelSource, ArrayList<Statement> statement) {
		super();
		this.modelSource = modelSource;
		this.statement = statement;
	}

	public Definition(ArrayList<Statement> statement) {
		super();
		this.statement = statement;
	}

	public Definition(Statement statement) {
		super();
		this.statement.add(statement);
	}

	public String getModelSource() {
		return modelSource;
	}

	public void setModelSource(String modelSource) {
		this.modelSource = modelSource;
	}

	public ArrayList<Statement> getStatement() {
		return statement;
	}

	public void setStatement(ArrayList<Statement> statement) {
		this.statement = statement;
	}
	
	public void addStatement(Statement statement) {
		this.statement.add(statement);
	}

	public void removeStatement(Statement statement) {
		this.statement.remove(statement);
	}
}

package ieee.rcd;

import java.util.ArrayList;

public class Statement {
	private LongIdentifierType id;	//0..1
	private String name;			//0..1
	private ArrayList<LangString> text = new ArrayList<LangString>();		//0..1
	private Vocabulary token;		//0..1
	
	public Statement(LongIdentifierType id, String name, ArrayList<LangString> text, Vocabulary token) {
		super();
		this.id = id;
		this.name = name;
		this.text = text;
		this.token = token;
	}

	public Statement(LongIdentifierType id) {
		super();
		this.id = id;
	}

	public Statement(String name) {
		super();
		this.name = name;
	}

	public Statement(ArrayList<LangString> text) {
		super();
		this.text = text;
	}

	public Statement(LangString text) {
		this.text.add(text);
	}
	
	public Statement(Vocabulary token) {
		super();
		this.token = token;
	}

	public LongIdentifierType getId() {
		return id;
	}

	public void setId(LongIdentifierType id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<LangString> getText() {
		return text;
	}

	public void setText(ArrayList<LangString> text) {
		this.text = text;
	}

	public void addText(LangString text) {
		this.text.add(text);		
	}
	
	public void removeText(LangString text) {
		this.text.remove(text);		
	}
	
	public Vocabulary getToken() {
		return token;
	}

	public void setToken(Vocabulary token) {
		this.token = token;
	}
	
	
	
}

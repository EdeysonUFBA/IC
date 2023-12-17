package ieee.rcd;

public class LangString {
	private String language;
	private String string;
	
	public LangString(String language, String string) {
		super();
		this.language = language;
		this.string = string;
	}
	
	public LangString(String string) {
		super();
		this.language = "en";
		this.string = string;
	}
	
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

	@Override
	public String toString() {
		return "LangString [language=" + language + ", string=" + string + "]";
	}
	
	
}

package ieee.rcd;

public class Vocabulary {
	private String source;
	private String value;
	
	public Vocabulary(String source, String value) {
		super();
		this.source = source;
		this.value = value;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
